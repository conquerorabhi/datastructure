package com.datastructure.concept;

import com.sun.javafx.geom.Edge;

import java.util.Comparator;

/**
 * Created by asingh on 6/30/19.
 */
public class EdgeComparator implements Comparator<TreeEdge> {

    @Override
    public int compare(TreeEdge v1,TreeEdge v2) {
        return v1.weight-v2.weight;
    }
}
