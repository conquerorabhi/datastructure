package com.datastructure.concept;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
/**
 * Created by asingh on 6/27/19.
 * Topological sorting a graph G={u,v} means that in order u will always appear before v.
 * We can sort a Direct Acyclic graph in topological order by kohn's algorithm.
 *
 *
 *
 */
public class TopologicalSort {

    public void topologicalSort(Graph g){
        Set<GraphNode> visited = new HashSet<>();
        Stack<GraphNode> topOrder = new Stack<>();
        HashMap<Integer,GraphNode> vertices = g.graphNodes;
        Set<Map.Entry<Integer,GraphNode>> verset = vertices.entrySet();

        for(Map.Entry<Integer,GraphNode> entry:verset){
           visitAndExplore(entry.getValue(),visited,topOrder);
        }

        while(!topOrder.isEmpty()){
            GraphNode graphNode = topOrder.pop();
            System.out.println(graphNode.getWeight());
        }
    }

    public void visitAndExplore(GraphNode gNode,Set<GraphNode> visited,Stack<GraphNode> topOrder){
        if(!visited.contains(gNode)){
            visited.add(gNode);
            List<GraphNode> edges = gNode.getEdges();
            for(GraphNode graphNode:edges){
                visitAndExplore(graphNode,visited,topOrder);
            }
            topOrder.push(gNode);
        }
    }
}
