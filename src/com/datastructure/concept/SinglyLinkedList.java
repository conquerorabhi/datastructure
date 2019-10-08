package com.datastructure.concept;

/**
 * Created by asingh on 5/31/19.
 */
public class SinglyLinkedList {

    SinglyLinkedList nextNode;
    int nodeValue;

    SinglyLinkedList(int nodeValue){
        this.nodeValue = nodeValue;
        nextNode = null;
    }

    public void addNodeAtTail(int nodeValue){
        SinglyLinkedList endNode = new SinglyLinkedList(nodeValue);
        SinglyLinkedList headNode = this;

        while(headNode.nextNode!=null){
            headNode = headNode.nextNode;
        }
        headNode.nextNode = endNode;
    }

    public SinglyLinkedList deleteNode(int nodeValue){
        SinglyLinkedList headNode = this;

        //if head node is matching node to delete
        if(this.nodeValue==nodeValue){
            return this.nextNode;
        }

        while(headNode.nextNode!=null){
            if(headNode.nextNode.nodeValue==nodeValue){
                headNode.nextNode = headNode.nextNode.nextNode;
            }
            headNode = headNode.nextNode;

        }
        return headNode;

    }
}
