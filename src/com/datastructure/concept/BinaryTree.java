package com.datastructure.concept;

import java.util.*;

/**
 * Created by asingh on 7/21/19.
 */
public class BinaryTree {

    int val;
    BinaryTree left;
    BinaryTree right;

    public BinaryTree(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public static void main(String[] args){
        BinaryTree root = new BinaryTree(8);
        BinaryTree rootLeft = new BinaryTree(10);
        BinaryTree rootRight = new BinaryTree(15);

        root.left = rootLeft;
        root.right = rootRight;

        BinaryTree root1 = new BinaryTree(8);
        BinaryTree rootLeft2 = new BinaryTree(25);
        BinaryTree rootRight2 = new BinaryTree(15);

        root1.left = rootLeft2;
        root1.right = rootRight2;

        System.out.println(root.isSameBinaryTree(root,root1));


        BinaryTree rootNEW = new BinaryTree(8);
        BinaryTree rootLeft1 = new BinaryTree(10);
        BinaryTree rootRight1 = new BinaryTree(10);

        //rootLeft1.left = new BinaryTree(25);
        rootRight1.right = new BinaryTree(27);

        rootNEW.left = rootLeft1;
        rootNEW.right = rootRight1;

        System.out.println(root.isSymmetricBinaryTree(rootNEW));
        root.leftView(rootNEW);

        BinaryTree viewRoot = new BinaryTree(1);
        BinaryTree l1 = new BinaryTree(2);
        BinaryTree r1 = new BinaryTree(3);
        BinaryTree l1Left = new BinaryTree(5);
        BinaryTree l1right = new BinaryTree(6);

        BinaryTree l1LeftLeft = new BinaryTree(7);
        BinaryTree l1LeftRight = new BinaryTree(8);
        l1Left.left = l1LeftLeft;
        l1Left.right = l1LeftRight;

        l1.left = l1Left;
        l1.right = l1right;
        viewRoot.left = l1;
        viewRoot.right = r1;

        rootLeft1.left = new BinaryTree(25);
        rootRight1.right = new BinaryTree(27);

        root.printBottomView(viewRoot);

        //root.createSumTree(viewRoot);
        root.transformToMirrorTree(viewRoot);

        root.diameterOfBinaryTree(viewRoot);

        root.isValidBST(viewRoot);

    }

    public boolean isSameBinaryTree(BinaryTree tree1,BinaryTree tree2){
        if(tree1==null && tree2!=null){
            return false;
        }else if(tree2==null && tree1==null){
            return false;
        }

        Queue<BinaryTree> undiscovered1 = new LinkedList<>();
        undiscovered1.offer(tree1);
        Queue<BinaryTree> undiscovered2 = new LinkedList<>();
        undiscovered2.offer(tree2);

        while(!undiscovered1.isEmpty() && !undiscovered2.isEmpty()){
            BinaryTree node1 = undiscovered1.poll();
            BinaryTree node2 = undiscovered2.poll();

            if(node1.val==node2.val){
                undiscovered1.offer(node1.left);
                undiscovered1.offer(node1.right);
                undiscovered2.offer(node2.left);
                undiscovered2.offer(node2.right);
            }else{
                return false;
            }
        }
        return true;
    }

    public boolean isSymmetricBinaryTree(BinaryTree root){
        if(root == null){
            return false;
        }else if(root!=null && root.left==null && root.right==null){
            return true;
        }else if(root!=null && root.left==null && root.right!=null){
            return false;
        }else if(root!=null && root.right==null && root.left!=null){
            return false;
        }

        Queue<BinaryTree> leftSubtreeUndiscovered = new LinkedList<>();
        Queue<BinaryTree> rightSubtreeUndiscovered = new LinkedList<>();

        leftSubtreeUndiscovered.offer(root.left);
        rightSubtreeUndiscovered.offer(root.right);

        while(!leftSubtreeUndiscovered.isEmpty() && !rightSubtreeUndiscovered.isEmpty()){
            BinaryTree leftNode = leftSubtreeUndiscovered.poll();
            BinaryTree rightNode = rightSubtreeUndiscovered.poll();

            if(leftNode!=null && rightNode!=null && leftNode.val!=rightNode.val){
                return false;
            }
            if(leftNode!=null) {
                leftSubtreeUndiscovered.offer(leftNode.left);
                leftSubtreeUndiscovered.offer(leftNode.right);
            }

            if(rightNode!=null) {
                rightSubtreeUndiscovered.offer(rightNode.right);
                rightSubtreeUndiscovered.offer(rightNode.left);
            }
        }

        return true;
    }

    public List<Integer> leftView(BinaryTree root){
        List<Integer> result = new ArrayList<>();
        if(root==null){
            return result;
        }

        Queue<BinaryTree> gLevel = new LinkedList<>();


        gLevel.offer(root);

        while (!gLevel.isEmpty()){
            boolean isElementAdded = false;
            Queue<BinaryTree> gLocal = new LinkedList<>();
            while(!gLevel.isEmpty()) {
                BinaryTree bNode = gLevel.poll();

                if (!isElementAdded && bNode!=null){
                    isElementAdded = true;
                    result.add(bNode.val);
                }
                if(bNode!=null && bNode.left!=null){
                    gLocal.offer(bNode.left);
                }

                if(bNode!=null && bNode.right!=null) {
                    gLocal.offer(bNode.right);
                }
            }
            gLevel = gLocal;

        }
        return result;

    }

    public void printBottomView(BinaryTree binTree){
        HashMap<Integer,Integer> viewMap = new HashMap<>();
        doDepthFirstSearch(binTree,viewMap,0);
        Set<Map.Entry<Integer,Integer>> viewSet = viewMap.entrySet();
        for(Map.Entry<Integer,Integer> entry:viewSet){
            System.out.println("Distance FRom root:"+entry.getKey()+" Value :"+entry.getValue());
        }
    }

    private void doDepthFirstSearch(BinaryTree binaryTree,HashMap viewMap,int distanceFromRoot){

        viewMap.put(distanceFromRoot,binaryTree.val);
        if(binaryTree.left!=null){
            doDepthFirstSearch(binaryTree.left,viewMap,distanceFromRoot-1);
        }

        if(binaryTree.right!=null){
            doDepthFirstSearch(binaryTree.right,viewMap,distanceFromRoot+1);
        }
    }

    public BinaryTree createSumTree(BinaryTree binaryTree){
        if(binaryTree == null){
            return binaryTree;
        }else if(binaryTree.left == null && binaryTree.right==null){
            return binaryTree;
        }

        traverseAndSum(binaryTree);

        return binaryTree;
    }

    private int traverseAndSum(BinaryTree node){
        if(node.left==null && node.right==null){
            return node.val;
        }

        int sum = 0;
        if(node.left!=null){
            sum = sum + traverseAndSum(node.left);
        }

        if(node.right!=null){
            sum = sum + traverseAndSum(node.right);
        }
        node.val = sum;
        return sum;
    }

    public BinaryTree transformToMirrorTree(BinaryTree root){

        if(root.left == null && root.right == null){
            return root;
        }

        BinaryTree left = root.left;
        BinaryTree right = root.right;
        if(left!=null){
            root.right = transformToMirrorTree(left);
        }else{
            root.right = null;
        }

        if(right!=null){
            root.left = transformToMirrorTree(right);
        }else{
            root.left = null;
        }
        return root;


    }

    public int diameterOfBinaryTree(BinaryTree node){

        if(node==null){
            return 0;
        }else if(node.left==null && node.right==null){
            return 0;
        }

        int leftSubtreeHeight = height(node.left);
        int rightSubtreeHeight = height(node.right);

        int diameter = leftSubtreeHeight+rightSubtreeHeight;
        int leftSubTreeDiameter = diameterOfBinaryTree(node.left);
        int rightSubTreeDiameter = diameterOfBinaryTree(node.right);

        int subtreeDiameter = Math.max(leftSubTreeDiameter,rightSubTreeDiameter);

        return Math.max(diameter,subtreeDiameter);

    }

    private int height(BinaryTree node){
        if(node==null){
            return 0;
        }
        return 1+Math.max(height(node.left),height(node.right));
    }

    public int depthOfTree(BinaryTree root){
        if(root == null){
            return 0;
        }

        return 1+Math.max(depthOfTree(root.left),depthOfTree(root.right));
    }

    public int widthOfBinaryTree(BinaryTree root){
        if(root == null){
            return 0;
        }

        int leftSubTreeHeight = height(root.left);
        int righSubTreeHeight = height(root.right);

        int width = leftSubTreeHeight+righSubTreeHeight;
        int leftSubtreeWidth = widthOfBinaryTree(root.left);
        int rightSubtreeWidth = widthOfBinaryTree(root.right);

        return Math.max(leftSubTreeHeight+righSubTreeHeight,Math.max(leftSubtreeWidth,rightSubtreeWidth));
    }

    public boolean isValidBST(BinaryTree root){
        if(root==null){
            return true;
        }else if(root.left==null && root.right==null){
            return true;
        }

        boolean isLeftSubtreeValid = isValidBST(root.left,Integer.MIN_VALUE,root.val);
        boolean isRightSubtreeValid = isValidBST(root.right,root.val,Integer.MAX_VALUE);

        return isLeftSubtreeValid && isRightSubtreeValid;
    }

    private boolean isValidBST(BinaryTree node,int min,int max){
        if(node==null){
            return true;
        }else if(node.val>max||node.val<min){
            return false;
        }

        boolean isLeftValid = isValidBST(node.left,min,node.val);
        boolean isRightValid = isValidBST(node.right,node.val,max);

        return isLeftValid && isRightValid;
    }

}
