package com.datastructure.concept;

/**
 * Created by asingh on 1/5/19.
 * Step1- if stardIndex>endIndex return -1;
 * Step2- find middle by startIndex+endIndex/2;
 * Step3- if search value>arr[middle] then call sameMethod doBinarySearch(arr,searchValue,middle,hight)
 * Step4- else if search value < arr[middle] then call sameMethod doBinarySearch(arr,searchValue,0,middle)
 * Step5- return middle index.
 */
public class BinarySearchAlgorithm {
    public static void main(String[] args){
        BinarySearchAlgorithm bsa = new BinarySearchAlgorithm();
        int[] input = {2,3,4,5,6,7,8,9};
        System.out.println(bsa.doBinarySearch(input,6,0,input.length-1));
    }
    public int doBinarySearch(int [] input,int searchValue,int startIndex,int endIndex){
        if(startIndex>endIndex) return -1;
        int middle = (startIndex+endIndex)/2;
        if(searchValue>input[middle]){
            return doBinarySearch(input,searchValue,middle+1,endIndex);
        } else if(searchValue<input[middle]){
            return doBinarySearch(input,searchValue,startIndex,middle-1);
        } else{
            return middle;
        }

    }
}
