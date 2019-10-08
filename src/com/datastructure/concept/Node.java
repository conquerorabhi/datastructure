package com.datastructure.concept;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asingh on 11/30/18.
 */
public class Node {
    public int val;
    int weight;
    int id;

    public List<Node> neighbors;
    ArrayList<Node> edges ;

    public Node(int val,List<Node> nList){
        this.val = val;
        this.neighbors = nList;
    }

    public Node(int weight){
        this.weight = weight;
        this.id = weight;
        this.edges = new ArrayList<Node>();
    }

    public Node(){
        this.weight = 0;
        this.edges = new ArrayList<Node>();
    }

    public void addEdge(Node ver){
        this.edges.add(ver);
    }

    public int getId(){
        return this.id;
    }

    public ArrayList<Node> getNeighbors(){
        return this.edges;
    }

    public int getWeight(){
        return this.weight;
    }

}
