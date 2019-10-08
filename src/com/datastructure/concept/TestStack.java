package com.datastructure.concept;

/**
 * Created by asingh on 6/2/19.
 */
public class TestStack {

    public static void main(String[] args){

        SetOfStacks<String> setOfStacks = new SetOfStacks<>(10,2);
        setOfStacks.push("One");
        setOfStacks.push("Two");

        setOfStacks.push("Three");
        setOfStacks.push("Four");

        setOfStacks.push("Five");

        System.out.println("Pop Go One : "+setOfStacks.pop());
        System.out.println("Pop Go Two : "+setOfStacks.pop());
        System.out.println("Pop Go Three : "+setOfStacks.pop());
        System.out.println("Pop Go Four : "+setOfStacks.pop());
        System.out.println("Pop Go Five : "+setOfStacks.pop());




        StackNode<String> testStack = new StackNode<>("One");
        testStack.push("Two");
        testStack.push("Three");
        testStack.push("Four");
        testStack.push("Five");
        System.out.println("Peek Element:"+testStack.peek());
        System.out.println("Is Stack Empty :"+testStack.isEmpty());
        System.out.println("Pop Go One : "+testStack.pop());
        System.out.println("Pop Go Two : "+testStack.pop());
        System.out.println("Pop Go Three : "+testStack.pop());
        System.out.println("Pop Go Four : "+testStack.pop());
        System.out.println("Pop Go Five : "+testStack.pop());

    }
}
