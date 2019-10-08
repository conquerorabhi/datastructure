package com.datastructure.concept;

/**
 * Created by asingh on 12/2/18.
 */
public class AdjacencyMatricesGraph {
    Node[] vertices;
    int [] [] adjacencyMatrices ;
    int numberOfVertices = 0;
    public AdjacencyMatricesGraph(){
        this.vertices = new Node[6];
    }

    public void addEdge(int source, int destination){
        if(adjacencyMatrices==null){
            this.adjacencyMatrices = new int[this.numberOfVertices][this.numberOfVertices];
        }
        this.adjacencyMatrices [source][destination] = 1;
    }

    public void addVertices(int weight){
        Node ver = new Node(weight);
        this.vertices[weight] = ver;
        this.numberOfVertices++;
    }

    public void print(AdjacencyMatricesGraph adjMatGraph){
        for(int rows=0;rows<=this.numberOfVertices; rows++){
            for(int columns = 0; columns<=this.numberOfVertices;columns++){
                if(adjMatGraph.adjacencyMatrices[rows][columns]==1){
                    System.out.println("Vertics :" +rows + " Has Edge : "+columns);
                }
            }
        }
    }
}
