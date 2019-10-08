package com.datastructure.concept;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Created by asingh on 6/2/19.
 */
public class StackNode <T> {
    T data;
    StackNode<T> nextNode;
    private int stackSize;

    public StackNode(T item){
        this.data = item;
        stackSize = 1;
    }

    StackNode<T> top ;

    //pop (Remove the element from top
    public T pop(){
        if(top == null){
            this.stackSize = this.stackSize - 1;
            return this.data;
        }

        T head = top.data;
        top = top.nextNode;
        this.stackSize = this.stackSize - 1;
        return head;
    }

    public void push(T item){
        StackNode<T> newNode = new StackNode<T>(item);
        if(this.top==null){
            this.top = this;
        }
        newNode.nextNode = this.top;
        this.stackSize = this.stackSize+1;
        top = newNode;
    }

    public T peek(){
        if(top == null){
            throw new EmptyStackException();
        }

        return top.data;
    }

    public boolean isEmpty(){
        return this.data==null;
    }

    public int getStackSize(){
        return this.stackSize;
    }
}
