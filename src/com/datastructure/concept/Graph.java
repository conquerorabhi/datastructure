package com.datastructure.concept;

import java.util.*;

/**
 * Created by asingh on 6/3/19.
 */
public class Graph {
    HashMap<Integer,GraphNode> graphNodes;

    public Graph(){
        graphNodes = new HashMap<>();
    }

    public void addVertices(int weight){
        if(graphNodes.containsKey(weight)){
            graphNodes.put(weight,new GraphNode(weight));
        }
    }

    public HashMap<Integer,GraphNode> getGraphNodes() {
        return graphNodes;
    }

    public GraphNode getVertices(int weight){
        return  graphNodes.get(weight);
    }

    public void addEdges(int source,int destination){
        GraphNode sourceVertices = null;
        GraphNode destVertices = null;
        if(graphNodes.containsKey(source)){
             sourceVertices = graphNodes.get(source);
        }else{
             sourceVertices = new GraphNode(source);
             graphNodes.put(source,sourceVertices);
        }

        if(graphNodes.containsKey(destination)){
            destVertices = graphNodes.get(destination);
        }else{
            destVertices = new GraphNode(destination);
            graphNodes.put(destination,destVertices);
        }

        sourceVertices.addEdge(sourceVertices,destVertices);
    }

    public void printNode(Graph g){
        HashMap<Integer,GraphNode> gNodes = g.getGraphNodes();
        Set<Map.Entry<Integer,GraphNode>> nodeSet = gNodes.entrySet();
        Iterator<Map.Entry<Integer,GraphNode>> entryIterator = nodeSet.iterator();
        while(entryIterator.hasNext()){
            Map.Entry<Integer,GraphNode> entry = entryIterator.next();
            if(entry!=null) {
                int weight = entry.getKey();
                System.out.println("Node : " + weight);
                ArrayList<GraphNode> nodeList = entry.getValue().getEdges();
                if (nodeList != null && nodeList.size() > 0) {
                    for (GraphNode graph : nodeList) {
                        System.out.println("Node : " + weight + " Edges : " + graph.getWeight());
                    }
                }
            }
        }

    }

}
