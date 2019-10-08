package com.datastructure.concept;

import java.util.*;

/**
 * Created by asingh on 6/30/19.
 * Find minimum Spanning tree by Kruskal's algorithm.
 */
public class MinimumSpanningTree {

    public static void main(String[] args){
        MinimumGraph minGraph = new MinimumGraph();
        minGraph.addEdge(1,2,2);
        minGraph.addEdge(2,3,3);
        minGraph.addEdge(3,4,4);

    }

    public List<MinimumGraphEdge> findMinimumSpanningTree(MinimumGraph graph){
        List<MinimumGraphEdge> spanningTree = new ArrayList<>();
        List<MinimumGraphEdge> graphEdges = graph.getEdges();
        HashMap<Integer,MinimumGraphNode> graphNodes = graph.graphNodes;
        MinimumGraphEdgeComparator edgeComparator = new MinimumGraphEdgeComparator();
        Collections.sort(graphEdges,edgeComparator);
        DisjointSet dis = new DisjointSet();
        Set<Map.Entry<Integer,MinimumGraphNode>> nodeSet = graphNodes.entrySet();
        for(Map.Entry<Integer,MinimumGraphNode> nodeEntry:nodeSet){
            dis.makeSet(nodeEntry.getKey());
        }

        for(MinimumGraphEdge edge:graphEdges){
            MinimumGraphNode node1 = edge.node1;
            MinimumGraphNode node2 = edge.node2;

            DisTreeNode parent1 = dis.findSet(node1.val);
            DisTreeNode parent2 = dis.findSet(node2.val);
            if(!(parent1.val==parent2.val)){
                spanningTree.add(edge);
                dis.unionSet(parent1.val,parent2.val);
            }
        }
        return spanningTree;
    }
}
