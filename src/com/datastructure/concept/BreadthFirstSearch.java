package com.datastructure.concept;

import java.util.*;

/**
 * Created by asingh on 12/2/18.
 */
public class BreadthFirstSearch {

    public void breadthFirstSearch(AdjacencyListGraph adjList,int root){
        Queue<Node> discoveryQueue = new LinkedList<Node>();
        HashSet<Integer> discovered = new HashSet<Integer>();
        Node startingVertex = adjList.vertices[root];
        discoveryQueue.offer(startingVertex);//This will add the vertex to the bottom of the queue

        while (discoveryQueue.size()!=0){
            visitVertice(discoveryQueue,discovered);
        }

        Iterator<Integer> iterator = discovered.iterator();
        System.out.println("********* Iterating Discovered Path *******");
        while (iterator.hasNext()){
            System.out.println("Node :"+iterator.next());
        }

    }

    private void visitVertice(Queue<Node> discoveryQueue, HashSet<Integer> discovered){
        Node discoveryVertix = discoveryQueue.poll();//This will retrieve and remove the top element from the front of the queue
        discovered.add(discoveryVertix.weight);
        ArrayList<Node> adjacentList = discoveryVertix.edges;
        Iterator<Node> itr = adjacentList.iterator();
        while (itr.hasNext()){
            Node ver = itr.next();
            if(!discovered.contains(ver.weight)){
                discoveryQueue.offer(ver);
            }
        }
    }
}
