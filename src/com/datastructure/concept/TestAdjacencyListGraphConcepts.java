package com.datastructure.concept;

/**
 * Created by asingh on 11/30/18.
 */
public class TestAdjacencyListGraphConcepts {

    public static void main(String[] args){
        AdjacencyListGraph testAdjacencyListGraph = new AdjacencyListGraph(10);
        testAdjacencyListGraph.addVertice(0);
        testAdjacencyListGraph.addVertice(1);
        testAdjacencyListGraph.addVertice(2);
        testAdjacencyListGraph.addVertice(3);
        testAdjacencyListGraph.addVertice(4);
        testAdjacencyListGraph.addVertice(5);

        testAdjacencyListGraph.addEdge(0,1);
        testAdjacencyListGraph.addEdge(0,2);
        testAdjacencyListGraph.addEdge(1,3);
        testAdjacencyListGraph.addEdge(2,4);
        testAdjacencyListGraph.addEdge(4,5);

        testAdjacencyListGraph.print(testAdjacencyListGraph);
        System.out.println("***** Starting Breadth First Search *****");
        BreadthFirstSearch bfs = new BreadthFirstSearch();
        bfs.breadthFirstSearch(testAdjacencyListGraph,0);
        System.out.println("***** Starting Depth First Search *****");
        DepthFirstSearch dfs = new DepthFirstSearch();
        dfs.depthFirstSearch(testAdjacencyListGraph,0);

    }
}
