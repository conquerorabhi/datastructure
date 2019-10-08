package com.datastructure.concept;

/**
 * Created by asingh on 7/23/19.
 */
public class SortingAlgorithm {

    public static void main(String[] args){
        int[] input= {3,5,2,8,4,9};
        SortingAlgorithm sort = new SortingAlgorithm();
        try {
            sort.selectionSort(input);
        }catch (Exception e){

        }

    }

    /**
     * In this algorithm there will be fix pointer and dynamic pointer will keep moving with every comparison while fix pointer will only move once we reach to
     * the end of comparison. During comparison if arr[fix] > arr[dynamic] then swap with each other.
     * Complexity : O(n*n)
     * Space Complexity : O(n)
     * @param input
     */
    public void selectionSort(int[] input) throws Exception{
        if(input.length==0){
            return;
        }else if(Integer.MAX_VALUE>input.length || Integer.MIN_VALUE<input.length){
            throw new Exception("Invalid array input exception.");
        }

        for(int index=0;index<input.length-1;index++){
            for(int count=index+1;count<input.length-1;count++){
                if(input[index]>input[count]){
                    int temp = input[index];
                    input[index] = input[count];
                    input[count] = temp;
                }
            }
        }
    }
}
