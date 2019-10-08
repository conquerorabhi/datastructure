package com.datastructure.concept;

import java.util.Comparator;

/**
 * Created by asingh on 6/30/19.
 */
public class MinimumGraphEdgeComparator implements Comparator<MinimumGraphEdge> {


    @Override
    public int compare(MinimumGraphEdge o1, MinimumGraphEdge o2) {
        return o1.graphWeight-o2.graphWeight;//ascending order


    }
}
