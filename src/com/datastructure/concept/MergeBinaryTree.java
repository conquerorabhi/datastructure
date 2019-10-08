package com.datastructure.concept;

import apple.laf.JRSUIUtils;

/**
 * Created by asingh on 6/21/19.
 */
public class MergeBinaryTree {

    public TreeNode mergeBinaryTrees(TreeNode tree1,TreeNode tree2){
        if(tree1==null && tree2==null){
            return null;
        }else if(tree1==null && tree2!=null){
            return tree2;
        }else if(tree2==null && tree1!=null){
            return tree1;
        }

        tree1.val = tree1.val + tree2.val;
        tree1.left = mergeBinaryTrees(tree1.left,tree2.left);
        tree1.right = mergeBinaryTrees(tree1.right,tree2.right);
        return tree1;
    }
}
