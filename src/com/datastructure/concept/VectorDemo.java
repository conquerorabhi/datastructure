package com.datastructure.concept;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Vector;

/**
 * Created by asingh on 11/24/18.
 */
public class VectorDemo {
    public static void main(String [] args){
        Vector<String> ve = new Vector<String>();
        System.out.println("Current Capacity Of Vector: "+ve.capacity());// vector created from default constructor has default capacity 10.

        Vector<String> veWithCapacity = new Vector<String>(20,10);
        System.out.println("Vector initialized with capacity : "+veWithCapacity.capacity());// vector created from this constructor has capacity 20.
        System.out.println("Vector's Size : "+veWithCapacity.size());// vector created from this constructor has capacity 20.

        ve.add("One");
        ve.add("Two");
        ve.add("Three");
        ve.add("Four");
        ve.add("Five");
        ve.add("Six");
        ve.add("Seven");
        ve.add("Eight");
        ve.add("Nine");
        ve.add("Ten");

        String[] testData = new String[10];
        ve.copyInto(testData);

        System.out.println("*******Printing*******");
        for(String val:testData){
            System.out.println("Values : "+val);
        }
        printVectorWithIterator(ve);
        printVectorWithListIterator(ve);

        ve.add("Eleven");// initial capacity of this vector was 10 but after addition of this element current capacity will be doubled to 20.
        System.out.println("Current Capacity : "+ve.capacity());
        ve.trimToSize();// trimToSize() method reduces capacity of vector to current size
        System.out.println("Capacity after Trim : "+ve.capacity());



    }

    public static void printVectorWithIterator(Vector ve){
        Iterator<String> it = ve.iterator();
        System.out.println("Iterating By Normal Iterator : ");
        while(it.hasNext()){
            System.out.println("Value :"+it.next());
        }
    }

    public static void printVectorWithListIterator(Vector ve){
        ListIterator<String> lsItr = ve.listIterator();
        while(lsItr.hasNext()){
            System.out.println("List Iterator Values : "+lsItr.next());
        }
        System.out.println("Iterating in Reverse Order : ");
        while(lsItr.hasPrevious()){
            System.out.println("Reverse Order Index :"+lsItr.previousIndex());
            System.out.println("Reverse Order Values :"+lsItr.previous());
        }
    }
}
