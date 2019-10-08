package com.datastructure.concept;

/**
 * Created by asingh on 6/30/19.
 */
public class MinimumGraphEdge {
    MinimumGraphNode node1;
    MinimumGraphNode node2;
    int graphWeight;

    public MinimumGraphEdge(MinimumGraphNode node1,MinimumGraphNode node2,int graphWeight){
        this.node1=node1;
        this.node2=node2;
        this.graphWeight = graphWeight;
    }
}
