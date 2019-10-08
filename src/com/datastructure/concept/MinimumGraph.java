package com.datastructure.concept;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by asingh on 6/30/19.
 */
public class MinimumGraph {

    HashMap<Integer,MinimumGraphNode> graphNodes = new HashMap<>();
    List<MinimumGraphEdge> edges = new ArrayList<>();

    public void addEdge(int source,int desination,int weight){
        MinimumGraphNode  v1=null;
        MinimumGraphNode v2=null;
        if(graphNodes.containsKey(source)){
            v1 = graphNodes.get(source);
        }else{
            v1 = new MinimumGraphNode(source);
            this.graphNodes.put(source,v1);
        }
        if(graphNodes.containsKey(desination)){
            v2 = graphNodes.get(desination);
        }else{
            v2 = new MinimumGraphNode(desination);
            this.graphNodes.put(desination,v2);
        }

        this.edges.add(new MinimumGraphEdge(v1,v2,weight));
    }

    public HashMap<Integer, MinimumGraphNode> getGraphNodes() {
        return graphNodes;
    }

    public List<MinimumGraphEdge> getEdges() {
        return edges;
    }


}
