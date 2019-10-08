package com.datastructure.concept;

/**
 * Created by asingh on 6/30/19.
 */
public class TreeEdge {

    TreeNode verticeV1;
    TreeNode verticeV2;
    public TreeEdge(TreeNode v1,TreeNode v2,int weight){
        this.verticeV1 = v1;
        this.verticeV2 = v2;
        this.weight = weight;
    }
    int weight;

}
