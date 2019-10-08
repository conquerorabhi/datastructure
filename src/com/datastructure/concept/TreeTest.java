package com.datastructure.concept;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by asingh on 6/7/19.
 */
public class TreeTest {

    public static void main(String[] args){
        TreeNode node8 = new TreeNode(8);
        TreeNode node4 = new TreeNode(4);
        TreeNode node1 = new TreeNode(1);
        TreeNode node5 = new TreeNode(5);
        TreeNode node10 = new TreeNode(10);
        TreeNode node7 = new TreeNode(7);
        TreeNode node20 = new TreeNode(20);
        TreeNode node3 = new TreeNode(3);

//        node4.left = node1;
//        node4.right = node5;
//
//        node10.left = node7;
//        node10.right = node20;
//
//        node8.left = node4;
//        node8.right = node10;
//
        TreeTest test = new TreeTest();
//        test.inorderTraversal(node8);
//        System.out.println("Preorder Traversal *******");
//        test.preorderTraversal(node8);
//        System.out.println("Post Order Traversal ******");
//        test.postorederTraversal(node8);
//        int[] input = {6,2,3,4,5};
//        TreeNode bst = test.buildMinimalBST(input);
//        test.preorderTraversal(bst);
//        System.out.println("Is this BST: "+test.validateBST(bst));

        TreeNode node00 = new TreeNode(0);
        node4.left = node7;
        node4.right = node8;
        node3.left= node4;
        node3.right = node5;
        node00.left = node3;

        System.out.println(test.getTreeDiameter(node00));

    }

    public int getTreeDiameter(TreeNode node){
        int dia1 = 0;
        int dia2 = 0;
        if(node.left!=null){
            dia1 = dia1 + 1;
            dia1 = traverseAndCalculate(node.left,dia1);
        }

        if(node.right!=null){
            dia2 = dia2 + 1;
            dia2 = traverseAndCalculate(node.right,dia2);
        }
        return dia1+dia2;
    }

    public int traverseAndCalculate(TreeNode node,int diameter){
        int dia1 = diameter;
        int dia2 = diameter;

        if(node.left!=null){
            dia1=dia1+1;
            dia1=traverseAndCalculate(node.left,dia1);
        }

        if(node.right!=null){
            dia2=dia2+1;
            dia2=traverseAndCalculate(node.right,dia2);
        }

        return Math.max(dia1,dia2);
    }

    public void inorderTraversal(TreeNode node){
        if(node!= null){
            inorderTraversal(node.left);
            System.out.println(node.val);
            inorderTraversal(node.right);
        }
    }

    public void preorderTraversal(TreeNode node){
        if(node!=null){
            System.out.println(node.val);
            preorderTraversal(node.left);
            preorderTraversal(node.right);
        }
    }

    public void postorederTraversal(TreeNode node){
        if(node!=null){
            postorederTraversal(node.left);
            postorederTraversal(node.right);
            System.out.println(node.val);
        }
    }

    public TreeNode buildMinimalBST(int[] input){//1,2,3,4,5

        int startingIndex = 0;//0
        int mid = input.length/2;
        if(input.length%2==0){
            mid = input.length/2;
        }else{
            mid = (input.length/2)+1;
        }

        TreeNode tNode = new TreeNode(input[mid-1]);
        if(startingIndex!=mid-1){
            tNode.left = buildMinimalBST(Arrays.copyOfRange(input,startingIndex,mid-1));
        }
        if(mid-1!=input.length-1){
            tNode.right = buildMinimalBST(Arrays.copyOfRange(input,mid,input.length));
        }

        return tNode;
    }

    public boolean validateBST(TreeNode rootNode){
        boolean isBST = false;
        if(rootNode != null){
            TreeNode leftChild = rootNode.left;
            TreeNode rightChild = rootNode.right;
            if(leftChild!=null){
                if(leftChild.val<=rootNode.val && (rootNode.right==null || (rootNode.right!=null && rootNode.right.val>rootNode.left.val))){
                    if(rootNode.left.left!=null) {
                        isBST = validateBST(rootNode.left);
                    }else {
                        isBST = true;
                    }
                    if(rootNode.right.right!=null) {
                        isBST = validateBST(rootNode.right);
                    }else {
                        isBST = true;
                    }

                }
            }else if (leftChild == null && rightChild!=null){
                if(rootNode.right.val>rootNode.val){
                    if(rootNode.right.right!=null) {
                        isBST = validateBST(rootNode.right);
                    }else{
                        isBST = true;
                    }
                }
            }

        }
        return isBST;
    }




}
