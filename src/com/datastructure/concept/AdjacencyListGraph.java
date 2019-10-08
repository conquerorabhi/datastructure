package com.datastructure.concept;

import java.util.ArrayList;

/**
 * Implementing AdjacencyListGraph in Java represented by Adjacency List (which is Arrays of ArrayList.
 */
public class AdjacencyListGraph {
    Node[] vertices ;

    public AdjacencyListGraph(int numberOfVertices){
        this.vertices = new Node[numberOfVertices];
    }

    public void addVertice(int index){
        Node ver = new Node(index);
        this.vertices[index] = ver;
    }
    public void addEdge(int sourceVertices,int destVertices){
        Node sourcever = this.vertices[sourceVertices];
        Node desVer = this.vertices[destVertices];
        sourcever.addEdge(desVer);
        this.vertices[sourceVertices] = sourcever;
    }

    public Node getVertice(int nodeId){
        return this.vertices[nodeId];
    }

    public void print(AdjacencyListGraph g){
        Node[] adjListArray = g.vertices;
        for(Node ver:adjListArray){
            if(ver!=null){
                System.out.println("Node : "+ver.getId());
                ArrayList<Node> edges = ver.edges;
                if(edges!=null && edges.size()>0){
                    for(Node edge :edges){
                        System.out.println("Vertecs :"+ver.getWeight()+" Has Edge with : "+edge.getWeight());
                    }
                }
            }
        }
    }
}
