package com.datastructure.concept;

import java.util.*;

/**
 * Created by asingh on 6/21/19.
 */
public class BSTTree {

    int nodeValue;
    BSTTree leftChild;
    BSTTree rightChild;

    public static void main(String[] args) {
        BSTTree test = new BSTTree(10);
        test.insertNodeInBST(test, 5);
        test.insertNodeInBST(test, 15);
        test.insertNodeInBST(test, 3);
        test.insertNodeInBST(test, 7);
        test.insertNodeInBST(test, 18);

        test.deleteNodeFromBST(test,15);

        BSTTree newTree = new BSTTree(2);
        //newTree.insertNodeInBST(newTree,1);
        newTree.insertNodeInBST(newTree,3);
        //test search in BST
        //test.searchBST(test,15);
        //test.searchBSTRecursion(test,15);
        newTree.inorderSuccessor(newTree,new BSTTree(2));
        HashMap<String, Integer> sumMap = new HashMap<>();
        sumMap.put("LEFT", 0);
        sumMap.put("RIGHT", 0);
        test.findSumInBST(test.leftChild, 7, 15, sumMap, "LEFT");
        test.findSumInBST(test.rightChild, 7, 15, sumMap, "RIGHT");
        int sum = sumMap.get("LEFT") + sumMap.get("RIGHT") + test.nodeValue;

        HashMap<Integer, List<Integer>> levelValueMap = new HashMap<>();
        HashMap<Integer, Integer> searchMap = new HashMap<>();
        List<Integer> list = new ArrayList<Integer>();
        list.add(10);
        levelValueMap.put(0, list);
        test.findSumInBetweenInBST(test.leftChild, 7, 15, levelValueMap, searchMap, 1);
        test.findSumInBetweenInBST(test.rightChild, 15, 17, levelValueMap, searchMap, -1);
        Set<Integer> levelSet = new HashSet<Integer>();
        int index = 0;
        for (Map.Entry<Integer, Integer> searchEntry : searchMap.entrySet()) {
            Map.Entry<Integer, Integer> searchResEntry = searchEntry;
            levelSet.add(searchResEntry.getKey());
        }
        int agSum = 0;
        Iterator<Integer> levelIterator = levelSet.iterator();
        while (levelIterator.hasNext()) {
            Integer level = levelIterator.next();
            List<Integer> valList = levelValueMap.get(level);
            for (int value : valList) {
                agSum = agSum + value;
                System.out.println(value);
            }
        }

        Set<Integer> msp = new TreeSet<>();
        System.out.print("SUM : " + test.findRangeOfBST(test, 7, 15));
    }

    public BSTTree(int val) {
        this.nodeValue = val;
        leftChild = null;
        rightChild = null;
    }

    public void addBSTNode(BSTTree current, int value) {
        if (current == null) {
            current = new BSTTree(value);
        }

        BSTTree node = current;

        while (node != null) {
            if (node.nodeValue > value) {
                if (node.leftChild == null) {
                    node.leftChild = new BSTTree(value);
                    node = node.leftChild;
                } else if (node.leftChild != null && node.leftChild.nodeValue < value && (node.leftChild.leftChild == null || node.leftChild.leftChild.nodeValue > value)) {
                    BSTTree leftChild = node.leftChild;
                    node.leftChild = new BSTTree(value);
                    node.leftChild.leftChild = leftChild;
                } else if (node.rightChild != null && node.rightChild.nodeValue < value && (node.rightChild.rightChild == null || node.rightChild.rightChild.nodeValue > value)) {
                    BSTTree rightChild = node.rightChild;
                    node.rightChild = new BSTTree(value);
                    node.rightChild.rightChild = rightChild;
                }
                new BSTTree(value);
                node = node.leftChild;

            } else if (node.rightChild == null) {
                node.rightChild = new BSTTree(value);

            } else {
                node = node.rightChild;
            }

        }

    }

    public void insertNodeInBST(BSTTree node, int nodeValue) {

        if (node != null) {
            if (node.nodeValue > nodeValue) {
                if (node.leftChild == null) {
                    node.leftChild = new BSTTree(nodeValue);
                } else {
                    insertNodeInBST(node.leftChild, nodeValue);
                }
            } else {
                if (node.rightChild == null) {
                    node.rightChild = new BSTTree(nodeValue);
                } else {
                    insertNodeInBST(node.rightChild, nodeValue);
                }
            }
        }
    }

    public void findSumInBST(BSTTree node, int searchValue, int searchValue2, HashMap<String, Integer> sumMap, String key) {
        if (node.nodeValue == searchValue || node.nodeValue == searchValue2) {
            sumMap.put(key, sumMap.get(key) + node.nodeValue);
            return;
        }
        if (node != null && node.nodeValue > searchValue) {
            sumMap.put(key, sumMap.get(key) + node.nodeValue);
            findSumInBST(node.leftChild, searchValue, searchValue2, sumMap, key);
        }
        if (node != null && node.nodeValue < searchValue) {
            sumMap.put(key, sumMap.get(key) + node.nodeValue);
            findSumInBST(node.rightChild, searchValue, searchValue2, sumMap, key);
        }
    }

    public void findSumInBetweenInBST(BSTTree node, int searchValue, int searchValue2, HashMap<Integer, List<Integer>> sumMap, HashMap<Integer, Integer> levelMap, int level) {
        if (node != null && node.nodeValue == searchValue) {
            levelMap.put(level, node.nodeValue);
            setLevel(sumMap, level, node);
            return;
        }
        if (node != null && node.nodeValue > searchValue) {
            setLevel(sumMap, level, node);
            level = level + 1;
            findSumInBetweenInBST(node.leftChild, searchValue, searchValue2, sumMap, levelMap, level);
        }
        if (node != null && node.nodeValue < searchValue) {
            setLevel(sumMap, level, node);
            level = level - 1;
            findSumInBetweenInBST(node.rightChild, searchValue, searchValue2, sumMap, levelMap, level);
        }
    }

    private void setLevel(HashMap<Integer, List<Integer>> sumMap, int level, BSTTree node) {
        if (sumMap.containsKey(level)) {
            sumMap.put(level, (ArrayList<Integer>) sumMap.get(level)).add(node.nodeValue);
        } else {
            List<Integer> levelList = new ArrayList<>();
            levelList.add(node.nodeValue);
            sumMap.put(level, levelList);
        }
    }

    public int rangeSumBST(BSTTree root, int L, int R) {
        int result = 0;
        HashMap<Integer, List<Integer>> nodeMapByLevel = new HashMap<Integer, List<Integer>>();
        Set<Integer> searchKey = new TreeSet<Integer>();
        List<Integer> valList = new ArrayList<>();
        valList.add(root.nodeValue);
        nodeMapByLevel.put(0, valList);
        findRangeValues(root.leftChild, L, nodeMapByLevel, searchKey, 1);
        findRangeValues(root.rightChild, R, nodeMapByLevel, searchKey, -1);
        Iterator<Integer> searchKeyIt = searchKey.iterator();
        while (searchKeyIt.hasNext()) {
            Integer intValue = searchKeyIt.next();
            List<Integer> valueList = (ArrayList<Integer>) nodeMapByLevel.get(intValue);
            if (valueList != null) {
                for (Integer value : valueList) {
                    result = result + value;
                }
            }
        }
        return result;
    }

    private void findRangeValues(BSTTree root, int searchValue, HashMap<Integer, List<Integer>> nodeMapByLevel, Set<Integer> searchSet, int level) {
        if (root != null && root.nodeValue == searchValue) {
            searchSet.add(level);
            setLevelMap(root, level, nodeMapByLevel);
            return;
        }

        if (root != null && root.nodeValue < searchValue) {
            setLevelMap(root, level, nodeMapByLevel);
            level = level - 1;
            findRangeValues(root.rightChild, searchValue, nodeMapByLevel, searchSet, level);
        }

        if (root != null && root.nodeValue > searchValue) {
            setLevelMap(root, level, nodeMapByLevel);
            level = level + 1;
            findRangeValues(root.leftChild, searchValue, nodeMapByLevel, searchSet, level);
        }
    }

    private void setLevelMap(BSTTree root, int level, HashMap<Integer, List<Integer>> nodeMapByLevel) {
        if (nodeMapByLevel.containsKey(level)) {
            List<Integer> valueList = nodeMapByLevel.get(level);
            valueList.add(root.nodeValue);
            nodeMapByLevel.put(level, valueList);
        } else {
            List<Integer> valueList = new ArrayList<Integer>();
            valueList.add(root.nodeValue);
            nodeMapByLevel.put(level, valueList);
        }
    }

    public int findRangeOfBST(BSTTree root, int L, int R) {
        HashMap<String, Integer> sumMap = new HashMap<>();
        sumMap.put("SUM", 0);
        findRangeValues(root, L, R, sumMap);
        return sumMap.get("SUM");
    }

    private void findRangeValues(BSTTree root, int L, int R, HashMap<String, Integer> sum) {

        if (root != null && root.nodeValue >= L && root.nodeValue <= R) {
            sum.put("SUM", sum.get("SUM") + root.nodeValue);
        }
        if (root != null && root.leftChild != null) {
            findRangeValues(root.leftChild, L, R, sum);
        }

        if (root != null && root.rightChild != null) {
            findRangeValues(root.rightChild, L, R, sum);
        }
    }

    public int maxDepth(BSTTree root) {
        if(root==null){
            return 0;
        }
        Set<Integer> depthSet = new TreeSet<Integer>();
        findDepthOfAllLeafNodes(root,depthSet,1);
        Iterator<Integer> setIt = depthSet.iterator();
        int index = 0;
        int res = 0;
        while(setIt.hasNext()){
            Integer value = setIt.next();
            if(index==depthSet.size()-1){
                res = value;
                return res;
            }
        }
        return res;
    }

    private void findDepthOfAllLeafNodes(BSTTree root,Set<Integer> depthSet,int depth){
//        if(root!=null){
//            List<Node> children = root.;
//            if(children!=null && children.size()>0){
//                for(Node node:children){
//                    findDepthOfAllLeafNodes(node,depthSet,depth+1);
//                }
//            }else{
//                depthSet.add(depth);
//            }
//        }
    }

    private void addToStack(List<Node> nodeList, Stack<Node> nodeStack) {
        if (nodeList != null) {
            for (int index = nodeList.size() - 1; index >= 0; index = index - 1) {
                nodeStack.push(nodeList.get(index));
            }


        }
    }

    public BSTTree searchBST(BSTTree root, int val) {
        while (root!=null){
            if(root!=null && root.nodeValue==val){
                return root;
            }else if(val<root.nodeValue){
                root = root.leftChild;
            }else if(val>root.nodeValue){
                root = root.rightChild;
            }
        }
        return null;
    }

    private BSTTree searchBSTRecursion(BSTTree root,int val){
        BSTTree res = null;
        if(root==null || root.nodeValue==val){
            return root;
        }

        if(root.nodeValue>val){
            res = searchBSTRecursion(root.leftChild,val);
        }else{
            res = searchBSTRecursion(root.rightChild,val);
        }
        return res;
    }

    public void insertInBST(BSTTree root,int value){
        BSTTree node = new BSTTree(value);
        if(root==null){
            root = node;

            return;

        }

        BSTTree parent = null;
        BSTTree current = root;

        while(current!=null){
            parent = current;

            if(current.nodeValue>node.nodeValue){

                current = current.leftChild;
            }else{
                current = current.rightChild;

            }

        }

        if(parent.nodeValue>node.nodeValue){

            parent.leftChild = node;

        }else{

            parent.rightChild = node;

        }

    }

    public BSTTree inorderSuccessor(BSTTree root, BSTTree p) {
        if(root==null || p==null||root.nodeValue==p.nodeValue && root.rightChild==null){
            return null;
        }

        BSTTree lastLeft = new BSTTree(-1);
        BSTTree current = root;
        BSTTree findSearchKey = findSearchNode(current,lastLeft,p);
        BSTTree successor  = null;
        if(findSearchKey.rightChild!=null){
            findSearchKey = findSearchKey.rightChild;
            while(findSearchKey!=null){
                successor = findSearchKey;
                if(findSearchKey.leftChild==null){
                    return successor;
                }else{
                    findSearchKey = findSearchKey.leftChild;
                }
            }
        }else{
            return lastLeft;
        }
        return successor;
    }

    public BSTTree findSearchNode(BSTTree node,BSTTree lastLeft,BSTTree p){
        BSTTree res = null;
        if(node==null){
            return null;
        }else if(node.nodeValue==p.nodeValue){
            return node;
        }

        if(node.nodeValue>p.nodeValue){
            lastLeft = node;
            res = findSearchNode(node.leftChild,lastLeft,p);
        }else{
            res = findSearchNode(node.rightChild,lastLeft,p);
        }
        return res;
    }

    /**
     * In this approach in recursive way , first we are trying to find
     * the search value once node to delete is found now.
     * we are checking following conditions
     * 1- left and right child is null then delete that node.
     * 2- left child is null and right is not null then set node = node.rightChild
     * 3- right child is null and left is not null then set node = node.leftChild
     * 4- if left and right both child is not null then
     *    do following thing
     *    Step-1 : findMinimimunSuccessor in the subtree.
     *    Step-2 : replace value of node with value of minimumSuccessor.
     *    Step-3 : now delete that node from right subtree and replace node.right = deleteNodeFromBST(node.right,value)
     * @param node
     * @param value
     * @return
     */
    public BSTTree deleteNodeFromBST(BSTTree node,int value){
        if(node == null){
            return node;
        }

        if(node.nodeValue>value){
            node.leftChild = deleteNodeFromBST(node.leftChild,value);
        }else if(node.nodeValue<value){
            node.rightChild = deleteNodeFromBST(node.rightChild,value);
        }else{
            if(node.leftChild == null && node.rightChild==null){
                node = null;
            }else if(node.leftChild==null){
                BSTTree temp = node;
                node = node.rightChild;
                temp = null;
            }else if(node.rightChild == null){
                BSTTree temp = node;
                node = node.leftChild;
                temp = null;
            }else{
                BSTTree tem1 = node;
                BSTTree temp = findMin(node);
                node.nodeValue = temp.nodeValue;
                node.rightChild = deleteNodeFromBST(node.rightChild,temp.nodeValue);
            }
        }
        return node;
    }

    public BSTTree findMin(BSTTree tree){

        BSTTree temp = null;
        while(tree!=null){
            temp = tree;
            tree = tree.leftChild;
        }
        return  temp;
    }

    /**
     * Predecessor for a search key
     * Usecase 1- If search key found in BST Tree and it's left child is not null.
     *   In that case take following steps:
     *   1- Jump on the found nodes'left child 's right child and find the extreme righ value in left child's right subtree.
     *   2- if found node does not left sub tree in that case predecessor is node from where we took last right turn.
     *   3- if found node's right and left subtree both are nulll in that case last right turn
     *
     */
    public BSTTree findInorderPredecessor(BSTTree root,BSTTree searchNode){
        if(root==null || root.nodeValue==searchNode.nodeValue && root.leftChild==null && root.rightChild==null){
            return null;
        }

        HashMap<String,BSTTree> rightMap = new HashMap<>();

        BSTTree foundNode = findNodeFIP(root,rightMap,searchNode);

        if(foundNode.leftChild!=null){
            foundNode = foundNode.leftChild;
            if(foundNode.rightChild!=null){
                foundNode = foundNode.rightChild;
                while (foundNode.rightChild!=null){
                    foundNode = foundNode.rightChild;
                }
            }
            return foundNode;
        }
        return rightMap.get("RIGHT");
    }

    public BSTTree findNodeFIP(BSTTree root,HashMap<String,BSTTree> rightMap,BSTTree searchNod){
        BSTTree foundNode = null;
        if(root==null||searchNod==null){
            return null;
        }

        if(root.nodeValue == searchNod.nodeValue){
            return root;
        }

        if(root.nodeValue>searchNod.nodeValue){
            foundNode = findNodeFIP(root.leftChild,rightMap,searchNod);
        }else{
            rightMap.put("RIGHT",root);
            foundNode = findNodeFIP(root.rightChild,rightMap,searchNod);
        }
        return foundNode;
    }


}