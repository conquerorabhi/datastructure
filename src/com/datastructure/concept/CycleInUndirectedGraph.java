package com.datastructure.concept;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

/**
 * Created by asingh on 6/29/19.
 * In this implementaion example are shown how we can check cycle exist in a undirected graph.
 * To check Cycle we can use two approaches :
 * 1)-DFS(explore every vertices of graph and if we get already visited nodes as child then it confirms that cycle exist.
 * 2)-Disjoin Set
 */
public class CycleInUndirectedGraph {

    public boolean isCycleExist(Graph graph){
        Set<GraphNode> visitedSet = new HashSet<>();
        List<GraphNode> allVertices = new ArrayList<>();

        for(GraphNode node:allVertices){
            if(!visitedSet.contains(node)){

            }
        }
        return false;
    }

    public boolean dfsCycleExist(GraphNode graphNode, Set<GraphNode> visited,GraphNode parent){
        visited.add(graphNode);

        List<GraphNode> vertices = graphNode.getEdges();
        for(GraphNode gNode:vertices){

            if(visited.contains(gNode)){
                return true;
            }

            if(parent.getWeight()==graphNode.getWeight()){
                continue;
            }

            boolean isCycleExist = dfsCycleExist(gNode,visited,graphNode);
            if(isCycleExist){
                return true;
            }
        }
        return false;
    }




}
