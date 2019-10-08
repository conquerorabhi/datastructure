package com.datastructure.concept;

import apple.laf.JRSUIUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asingh on 1/8/19.
 */
public class VisitLeafNodes {

    public static void main(String[] args){
        TreeNode node = new TreeNode(1);
        TreeNode leftNode = new TreeNode(2);
        TreeNode rightNode = new TreeNode(3);
        TreeNode left1Node = new TreeNode(4);
        TreeNode right1Node = new TreeNode(5);
        node.right = rightNode;
        node.left = leftNode;
        leftNode.left = left1Node;
        leftNode.right = right1Node;
        VisitLeafNodes vNodes = new VisitLeafNodes();
        vNodes.preOrderTraversal(node);
        System.out.println("****************");
        vNodes.postOrderTraversal(node);
        System.out.println("****************");
        vNodes.inorderTraversal(node);
        System.out.println("****************");
        vNodes.identifyAndRemoveInPostOrderTraversal(node);

    }

    /**
     * Visit root node
     * visit Left Child
     * visit right child
     * @param node
     */
    public void preOrderTraversal(TreeNode node){

        if(node!=null) {
            int value = node.val;
            System.out.println(value);
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    public void postOrderTraversal(TreeNode node){
        if(node!=null){
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            int value = node.val;
            System.out.println(value);
        }
    }

    public void inorderTraversal(TreeNode node){
        if(node!=null){
            inorderTraversal(node.left);
            System.out.println(node.val);
            inorderTraversal(node.right);
        }
    }

    public void identifyLeafNode(TreeNode node){
        if(node!=null){
            if(node.left==null && node.right==null){
                System.out.println("Leaf Node : "+node.val);
            }else{
                identifyLeafNode(node.left);
                identifyLeafNode(node.right);
            }
        }
    }

    public void identifyLeafNodeAndRemoveLeaf(TreeNode node,List<List<Integer>> list){

        if(node!=null){
            if(node.left==null && node.right==null){
                List<Integer> leafNodes = new ArrayList<>();
                leafNodes.add(node.val);
                System.out.println("Leaf Node : "+node.val);
            }
        }else{
            identifyLeafNode(node.left);
            identifyLeafNode(node.right);
        }
    }

    public void identifyAndRemoveInPostOrderTraversal(TreeNode node){
        if(node!=null){
            if(node.left==null && node.right==null){
                System.out.println("Leaf Node : "+node.val);
                node = null;
            }else{
                identifyAndRemoveInPostOrderTraversal(node.left);
                identifyAndRemoveInPostOrderTraversal(node.right);
            }
        }
    }
}
