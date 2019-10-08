package com.datastructure.concept;

import java.util.LinkedList;

/**
 * Created by asingh on 11/20/18.
 */
public class LinkedListDemo {

    public static void main(String args[]){
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList(8);
        singlyLinkedList.addNodeAtTail(7);
        singlyLinkedList.addNodeAtTail(6);
        singlyLinkedList.addNodeAtTail(5);
        singlyLinkedList.addNodeAtTail(4);
        singlyLinkedList.addNodeAtTail(3);
        singlyLinkedList.addNodeAtTail(2);
        SinglyLinkedList node = singlyLinkedList;
        while (node.nextNode!=null){
            System.out.println("Node Value :"+node.nodeValue);
            node = node.nextNode;
        }
        System.out.println("Node Value :"+node.nodeValue);
    }
}
