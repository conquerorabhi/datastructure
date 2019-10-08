package com.datastructure.concept;

import java.util.HashMap;
import java.util.Queue;
import java.util.Set;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by asingh on 7/19/19.
 */
public class GraphSol {

    public static void main(String[] args){
        Node root = new Node(10,new ArrayList<>());
        Node root1 = new Node(15,new ArrayList<>());
        Node root2 = new Node(20,new ArrayList<>());
        root.neighbors.add(root1);
        root.neighbors.add(root2);
        Node root3 = new Node(25,new ArrayList<>());
        Node root4 = new Node(30,new ArrayList<>());
        root1.neighbors.add(root3);
        root2.neighbors.add(root4);

        GraphSol sol = new GraphSol();
        sol.cloneGraph(root);
    }


    public Node cloneGraph(Node node) {
        long milliseconds = System.currentTimeMillis();
        if(node==null){
            return node;
        }
        HashMap<Integer,Node> nodeMap = new HashMap<>();

        Queue<Node> undiscovered = new LinkedList<Node>();
        Set<Node> discovered = new HashSet<>();
        undiscovered.offer(node);
        Node root = null;
        while(!undiscovered.isEmpty()){
            Node tNode = undiscovered.poll();
            if(!discovered.contains(tNode)){
                Node copyNode = null;
                if(nodeMap.size()==0){
                    copyNode = new Node(tNode.val,new ArrayList<>());
                    nodeMap.put(tNode.val,copyNode);
                    root = copyNode;
                }else if(nodeMap.containsKey(tNode.val)){
                    copyNode = nodeMap.get(tNode.val);
                    //root = copyNode;
                }else{
                    copyNode = new Node(tNode.val,new ArrayList<>());
                    nodeMap.put(tNode.val,copyNode);
                    //root = copyNode;
                }

                List<Node> neighbors = tNode.neighbors;

                for(Node nValue:neighbors){
                    undiscovered.add(nValue);
                    if(nodeMap.containsKey(nValue.val)){
                        (nodeMap.get(copyNode.val)).neighbors.add(nodeMap.get(nValue.val));
                    }else{
                        Node nNode = new Node(nValue.val,new ArrayList<>());
                        nodeMap.put(nValue.val,nNode);
                        (nodeMap.get(copyNode.val)).neighbors.add(nNode);
                    }

                }
                discovered.add(copyNode);
            }
        }
        System.out.println((System.currentTimeMillis()-milliseconds));
        return root;
    }
}
