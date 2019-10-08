package com.datastructure.concept;

import javax.swing.event.ListDataEvent;
import java.util.*;

/**
 * Created by asingh on 6/3/19.
 */
public class TestGraph {
    public static void main(String[] args){
        Graph graph = new Graph();
        graph.addEdges(0,1);
        graph.addEdges(0,5);
        graph.addEdges(0,4);
        graph.addEdges(1,3);
        graph.addEdges(1,4);
        graph.addEdges(2,1);
        graph.addEdges(3,4);
        graph.addEdges(3,2);

        Graph graphArDep = new Graph();
        graphArDep.addEdges(0,1);
        graphArDep.addEdges(0,2);
        graphArDep.addEdges(2,3);
        graphArDep.addEdges(2,4);
        graphArDep.addEdges(3,1);
        graphArDep.addEdges(3,5);
        graphArDep.addEdges(4,5);




        graph.printNode(graph);

        TestGraph test = new TestGraph();
        test.breadthFirstSearch(graph,0);
        System.out.println("Depth First Search Starting *********");
        test.depthFirstSearch(graph,0);

        System.out.println("Is Route Exist *********");
        System.out.println(test.isRouteExist(graph.getVertices(5),graph.getVertices(4)));

        test.findArrivalDepartureTime(graphArDep,0);

    }

    public void breadthFirstSearch(Graph g,int rootWeight){
        GraphNode gNode = g.getVertices(rootWeight);
        Queue<GraphNode> undiscoveredQueue = new LinkedList<GraphNode>();
        undiscoveredQueue.offer(gNode);
        HashSet<GraphNode> discoveredSet = new HashSet<GraphNode>();
        while(!undiscoveredQueue.isEmpty()){
            this.visitAndFindNeighborNode(undiscoveredQueue,discoveredSet);
        }
    }

    public void visitAndFindNeighborNode(Queue<GraphNode> undiscoveredQueue,HashSet<GraphNode> discoveredSet){
        GraphNode discoveryNode = undiscoveredQueue.poll();
        discoveredSet.add(discoveryNode);

        System.out.println("Discovered Vertieces : "+ discoveryNode.getWeight());
        List<GraphNode> edges = discoveryNode.getEdges();
        for(GraphNode vertices:edges){
            if(!discoveredSet.contains(vertices) && !undiscoveredQueue.contains(vertices)){
                undiscoveredQueue.offer(vertices);
            }
        }

    }

    public void depthFirstSearch(Graph g,int rootWeight){
        GraphNode gNode = g.getVertices(rootWeight);
        Set<GraphNode> visitedNode = new HashSet<>();
        visitNodes(visitedNode,gNode);
    }

    public void visitNodes(Set<GraphNode> visitedNode,GraphNode graphNode){
        if(!visitedNode.contains(graphNode)) {
            System.out.println("Visiting Node :"+graphNode.getWeight());
            visitedNode.add(graphNode);
            List<GraphNode> edges = graphNode.getEdges();
            for (GraphNode graphNode1 : edges) {
                visitNodes(visitedNode, graphNode1);
            }
        }
    }

    public boolean isRouteExist(GraphNode sourceNode,GraphNode targetNode){
        Queue<GraphNode> undiscoveredNodes = new LinkedList<GraphNode>();
        Set<GraphNode> discoveredNodes = new HashSet<GraphNode>();
        undiscoveredNodes.add(sourceNode);
        while(!undiscoveredNodes.isEmpty()){
            GraphNode matchFound = visitNode(undiscoveredNodes,discoveredNodes,targetNode);
            if(matchFound!=null){
                return true;
            }
        }
        return false;
    }

    private GraphNode visitNode(Queue<GraphNode> undiscoveredQueue,Set<GraphNode> discoveredSet,GraphNode targetNode){
        GraphNode visitNode = undiscoveredQueue.poll();
        if(visitNode.getWeight()==targetNode.getWeight()){
            return visitNode;
        }
        List<GraphNode> edges = visitNode.getEdges();
        for(GraphNode gNode:edges){
            if(!discoveredSet.contains(gNode) && !undiscoveredQueue.contains(gNode)){
                undiscoveredQueue.add(gNode);
            }
        }
        return null;
    }

    private HashMap<Integer,List<Integer>> findArrivalDepartureTime(Graph graph,int weight){

        Set<GraphNode> visited = new HashSet<>();
        HashMap<Integer,List<Integer>> arDepMap = new HashMap<>();
        GraphNode root = graph.getVertices(weight);
        List<Integer> time = new ArrayList<>();
        time.add(0);
        visitAndFindArrivalDeparture(arDepMap,root,visited,time);

        Set<Map.Entry<Integer,List<Integer>>> arDepEntry = arDepMap.entrySet();
        for(Map.Entry<Integer,List<Integer>> entry:arDepEntry){
            System.out.print("Vertices : "+entry.getKey() +" Arrival/Departure Time :"+entry.getValue());
        }
        return arDepMap;
    }

    private void visitAndFindArrivalDeparture(HashMap<Integer,List<Integer>> arDepMap,GraphNode graphNode,Set<GraphNode> visited,List<Integer> time){
        visited.add(graphNode);
        if(arDepMap.containsKey(graphNode.getWeight())){
            List<Integer> arriValDepTime = arDepMap.get(graphNode.getWeight());
            arriValDepTime.add(time.get(0));
            arDepMap.put(graphNode.getWeight(),arriValDepTime);
        }else{
            List<Integer> arriValDepTime = new ArrayList<>();
            arriValDepTime.add(time.get(0));
            arDepMap.put(graphNode.getWeight(),arriValDepTime);
        }

        List<GraphNode> edges = graphNode.getEdges();

        for(GraphNode gNode:edges){

            if(!visited.contains(gNode)) {
                time.set(0,time.get(0)+1);
                System.out.println("Time :"+time.get(0)+" Visiting : "+gNode.getWeight());
                visitAndFindArrivalDeparture(arDepMap, gNode, visited, time);
            }
            //time.set(0,time.get(0)+1);
        }
        List<Integer> depTime = arDepMap.get(graphNode.getWeight());
        time.set(0,time.get(0)+1);
        System.out.println("Timer : "+time.get(0));
        depTime.add(time.get(0));
        arDepMap.put(graphNode.getWeight(),depTime);
    }

}
