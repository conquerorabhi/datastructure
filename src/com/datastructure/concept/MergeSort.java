package com.datastructure.concept;

/**
 * Created by asingh on 1/4/19.
 * Implementing Recursive Merge sort algorithm.
 *
 * Algorithm:
 * It devides collection in two parts and keep deviding collection until there is not more than two elements.
 * And then after merges it in one .
 * Find middle index based on (low+high)/2;
 * Then
 */
public class MergeSort {

    public static void main(String args[]){
        MergeSort mSort = new MergeSort();
        int[] input = {3,5,2};
        mSort.mergeSort(input);

    }

    public void mergeSort(int[] input){
        int[] helperArray = new int[input.length];
        mergeSort(input,helperArray,0,input.length-1);
        for(int value:input){
            System.out.println("Input Value :"+ value);
        }
    }

    public void mergeSort(int[] input, int[] helperArray,int low,int high){
        if(low<high) {
            int middle = (low+high)/2;
            mergeSort(input, helperArray, 0, middle);
            mergeSort(input, helperArray, (middle + 1), high);
            merge(input, helperArray, low, middle, high);
        }
    }

    public void merge(int[] input, int[] helperArray,int low, int middle,int high){
        //Copy Left and right array into helper array
        for(int index=low;index<=high;index++){
            helperArray[index]=input[index];
        }

        //merge left and right array
        int helpLeft = low;
        int helpRight = middle+1;
        int current = low;

        //comparing and merging left and right arrays
        while(helpLeft<=middle && helpRight<=high){
            if(helperArray[helpLeft]<=helperArray[helpRight]){
                input[current] = helperArray[helpLeft];
                helpLeft++;
            }else{
                input[current] = helperArray[helpRight];
                helpRight++;
            }
            current++;
        }

        int remaining = middle-helpLeft;
        for(int index=0;index<=remaining;index++){
            input[current+index]=helperArray[helpLeft+index];
        }

    }
}
