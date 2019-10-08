package com.datastructure.concept;

/**
 * Created by asingh on 1/3/19.
 */
public class InsertionSort {

    public static void main(String[] args){
        int[] input = {4,2,5,7,9,3};
        InsertionSort instSort = new InsertionSort();
        int[] resultArray = instSort.sortArray(input);
        for(int value:resultArray){
            System.out.println(value);
        }

    }

    public int[] sortArray(int[] input){

        for(int index=1;index<input.length;index++){
            int key = input[index];
            int j = index-1;
            while(j>=0 && input[j]>key){
                    input[j+1] = input[j];
                j = j-1;
            }
            input[j+1] = key;
        }
        return input;
    }
}
