package com.datastructure.concept;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/**
 * Created by asingh on 6/2/19.
 */
public class SetOfStacks<T> {
    private StackNode<T>[] setOfStacks;
    private int currentStackIndex = 0;
    private int stackLimit;
    private int stackCapacity;
    public SetOfStacks(int stackLimit,int stackCapacity){
        this.stackLimit = stackLimit;
        this.stackCapacity = stackCapacity;
    }

    //push element
    public void push(T data){
        if(setOfStacks == null){
            this.setOfStacks = new StackNode[this.stackLimit];
            StackNode<T> stack = new StackNode<T>(data);
            this.setOfStacks[currentStackIndex]=stack;
        } else {
            StackNode<T> currentStack = this.setOfStacks[currentStackIndex];
            if(currentStack.getStackSize()>=this.stackCapacity){
                StackNode<T> newStack = new StackNode<T>(data);
                currentStackIndex= currentStackIndex + 1;
                this.setOfStacks[currentStackIndex] = newStack;
            }else{
                currentStack.push(data);
            }
        }
    }

    public T pop(){
        if(setOfStacks==null){
            throw new EmptyStackException();
        }
        StackNode<T> currentStack = this.setOfStacks[this.currentStackIndex];
        T data = currentStack.pop();
        if(currentStack.getStackSize()==0){
            this.setOfStacks[this.currentStackIndex] = null;
            this.currentStackIndex = this.currentStackIndex-1;
        }
        return data;
    }
}
