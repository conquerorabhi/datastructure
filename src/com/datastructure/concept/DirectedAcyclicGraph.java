package com.datastructure.concept;

import java.util.*;

/**
 * Created by asingh on 6/28/19.
 *
 * This programme is to find whether in the directed acyclic graph cycle exist or not.
 * Finding cycle in directed acyclic graph.
 *
 * To find cycle in Directed acyclic graph we will use three Sets
 * -UnExplored
 * -Explored
 * -InProgress
 * In first we will put each vertices of graph in unexplored set and then we will try to explore each vertices
 * if while exploring neighbor nodes are already in In-progress Set means that That Node is already being explored and there is some other route exist.
 * This means that cycle exist.
 *
 * Algorithm Steps:
 * Step 1- Initialize Three Sets Unexplored,Explored and In-progress Set.
 * Step 2- Iterate and put each vertices of graph in Unexplored set.
 * Step 3- Start a loop over unexplored set
 * Step 4- Pop out first unexplored Node.
 * Step 5- check if that node already exist in explored set.
 *          if exist then skip and continue.
 * Step 6- check if exploring node already exist in In-Progress set
 * Step 7- return true (cycle exist)
 * Step 8- Move current node to Inprogress set
 * Step 9- remove current node from Unexplored set.
 * Step 10- Find all neighbors of current node .
 * Step 11- Explore each its neighbors (repeate step 4 to Step 10)
 * Step 12 - End Loop remove current node from InProgress to Explored.
 */
public class DirectedAcyclicGraph {

    public boolean isThisGraphIsCyclic(Graph graph){
        Set<GraphNode> unExplored = new HashSet<>();
        Set<GraphNode> explored = new HashSet<>();
        Set<GraphNode> inProgress = new HashSet<>();

        HashMap<Integer,GraphNode> vertices = graph.graphNodes;
        Set<Map.Entry<Integer,GraphNode>> verSet = vertices.entrySet();
        for(Map.Entry<Integer,GraphNode> verEnt:verSet){
            unExplored.add(verEnt.getValue());
        }

        while(unExplored.size()>0){
            GraphNode gNode = unExplored.iterator().next();
            if(visitAndExplore(gNode,unExplored,explored,inProgress)){
                return true;
            }
        }

        return false;
    }

    private boolean visitAndExplore(GraphNode current,Set<GraphNode> unExplored,Set<GraphNode> explored,Set<GraphNode> inProgress){
        if(explored.contains(current)){
            return false;
        }

        if(inProgress.contains(current)){
            return true;
        }
        moveTo(current,unExplored,inProgress);
        List<GraphNode> neighbors = current.getEdges();

        for(GraphNode gNode: neighbors){
            return visitAndExplore(gNode,unExplored,explored,inProgress);
        }
        moveTo(current,inProgress,explored);
        return false;

    }

    private void moveTo(GraphNode gNode,Set<GraphNode> source,Set<GraphNode> target){
        source.remove(gNode);
        target.add(gNode);
    }


}
