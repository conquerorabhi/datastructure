package com.datastructure.concept;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by asingh on 6/29/19.
 *
 * This is the implementation of union By rank and Path compression Algorithm
 * This algorithm is used to find cycle in undirected graph.
 *
 * It is also applied on tree data structure .
 * TreeNode{
 *     int value;
 *     int rank;
 *     TreeNode parent;
 * }
 *
 * This data structure supports three operations
 *  MakeSet //create a set and points parent as itself.
 *  findSet // finds the representative of set
 *  unionSet // joins two sets
 *
 *  UnionSet :
 *      while joining two sets .
 *      Step1- By findSet find parent of set1.
 *      Step2- By findSet find parent of set2.
 *      Step3- parent1 and parent2 is same do nothing and return.
 *      Step4- if parent1's rank == parent2's rank
 *              parent1.rank = parent1.rank+1;
 *              make parent1 parent of node2 as well;
 *      Step5- if parent1's rank>parent2's rank
 *             make parent1 parent of node2 as well.
 *      Step6- if parent2's rank>parent's rank
 *              make
 *
 * Use-case - Find if cycle exist in an undirected Graph
 * Step1- Create set for each graph node
 * Step2- go through every edge of the graph , Loop starts
 * Step3- findSet for each vertices of edge(v1,v2)
 * Step4- if representative of v1 and v2 is same then cycle exist return true.
 * Step5- else union(representative v1,representative v2)
 * Step6- Loop ends
 * Step7- return false - cycle does not exist.
 *
 *
 * Use-case : Finding Minimum Spanning Tree in weighted undirected graph.
 */
public class DisjointSet {

    HashMap<Integer,DisTreeNode> nodes = new HashMap<Integer,DisTreeNode>();

    public void makeSet(int value){
        DisTreeNode node = this.nodes.get(value);
        if(node==null){
            node = new DisTreeNode();
            node.val = value;
            node.parent = node;
            this.nodes.put(value,node);
        }
    }

    public DisTreeNode findSet(int value){
        DisTreeNode res = null;
        DisTreeNode node = this.nodes.get(value);

        if(node.val == value && node.parent == node){
            return node;
        }
        res = findNode(node.parent);
        return res;
    }

    private DisTreeNode findNode(DisTreeNode node){
        if(node.parent==node){
            return node;
        }
        DisTreeNode res = findNode(node.parent);
        return res;
    }

    public DisTreeNode unionSet(int source,int target){
        DisTreeNode rs = null;
        DisTreeNode node1 = this.nodes.get(source);
        DisTreeNode node2 = this.nodes.get(target);

        DisTreeNode parent1 = findSet(node1.val);
        DisTreeNode parent2 = findSet(node2.val);

        if(parent1.val == parent2.val){
            return parent1;
        }

        if(parent1.rank == parent2.rank){
            parent1.rank = parent1.rank+1;
            parent2.parent = parent1;
            rs = node1;
        }else if(parent1.rank>parent2.rank){
            parent2.parent = parent1;
            rs = node1;
        }else if(parent1.rank<parent2.rank){
            parent1.parent = parent2;
            rs = node2;
        }
        return rs;
    }

    public boolean isCycleExist(Graph g){
        DisjointSet dis = new DisjointSet();
        HashMap<Integer,GraphNode> vertices = g.graphNodes;
        Set<Map.Entry<Integer,GraphNode>> verSet = vertices.entrySet();
        for(Map.Entry<Integer,GraphNode> entry:verSet){
            dis.makeSet(entry.getKey());
        }

        for(Map.Entry<Integer,GraphNode> entry:verSet){
            boolean isCycleExist = isCycleExist(entry.getValue(),dis);
            if(isCycleExist){
                return true;
            }
        }
        return false;
    }

    public boolean isCycleExist(GraphNode g,DisjointSet dis){
        List<GraphNode> edges = g.getEdges();
        for(GraphNode gNode:edges){
            DisTreeNode node1 = dis.findSet(gNode.getWeight());
            DisTreeNode node2 = dis.findSet(g.getWeight());
            if(node1.val==node2.val){
                return true;
            }
            dis.unionSet(node1.val,node2.val);
        }
        return false;
    }


}
