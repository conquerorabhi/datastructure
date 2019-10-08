package com.datastructure.concept;

/**
 * Created by asingh on 12/2/18.
 */
public class AdjacencyMatricesGraphConcepts {

    public static void main(String [] args){

        AdjacencyMatricesGraph adjMatGraph = new AdjacencyMatricesGraph();
        adjMatGraph.addVertices(0);
        adjMatGraph.addVertices(1);
        adjMatGraph.addVertices(2);
        adjMatGraph.addVertices(3);
        adjMatGraph.addVertices(4);
        adjMatGraph.addVertices(5);

        adjMatGraph.addEdge(0,1);
        adjMatGraph.addEdge(0,2);
        adjMatGraph.addEdge(1,3);
        adjMatGraph.addEdge(1,4);
        adjMatGraph.addEdge(2,5);

        adjMatGraph.print(adjMatGraph);
    }
}
