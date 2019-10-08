package com.datastructure.concept;

import java.util.ArrayList;

/**
 * Created by asingh on 6/3/19.
 */
public class GraphNode {

    private int weight;
    private ArrayList<GraphNode> edges;


    public GraphNode(int weight){
        this.weight = weight;
        edges = new ArrayList<GraphNode>();
    }

    public int getWeight() {
        return weight;
    }

    public void addEdge(GraphNode sourceVertices,GraphNode destinationVertices){
        sourceVertices.edges.add(destinationVertices);
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public ArrayList<GraphNode> getEdges() {
        return edges;
    }

    public void setEdges(ArrayList<GraphNode> edges) {
        this.edges = edges;
    }
}
