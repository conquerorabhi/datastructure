package com.datastructure.concept;

/**
 * Created by asingh on 1/6/19.
 */
public class MergeSortedArrays {

    public static void main(String[] args){
        int[] arrayA = {2,4,5,6};
        int[] arrayB = {3,7,8};
        MergeSortedArrays.mergeTwoArrays(arrayA,arrayB);


    }

    public static void mergeTwoArrays(int[] a,int[] b){
        int low = a.length-1;
        int high = low+b.length-1;
        int [] arrayAwithBufferSize = new int[a.length+b.length];
        for(int index=0;index<=arrayAwithBufferSize.length-1;index++){
            if(index>a.length-1){
                arrayAwithBufferSize[index] = 0;
            }else{
                arrayAwithBufferSize[index] = a[index];
            }
        }
        int mid = a.length/2;
        for(int index=0;index<b.length;index++){
            int stIndex = a[mid]>=b[index]? 0:mid;
            int endIndex = a[mid]>=b[index]? mid:a.length-1;
            for(int counter=stIndex;counter<=endIndex;counter++){
                if(arrayAwithBufferSize[counter]>=b[index]){
                    pushElementToEND(arrayAwithBufferSize,counter,arrayAwithBufferSize.length-1);
                    arrayAwithBufferSize[counter] = b[index];
                }
            }
        }

        for(int val:arrayAwithBufferSize){
            System.out.println(val);
        }


    }

    public static void pushElementToEND(int[] input,int startIndex,int endIndex){
        for(int index=endIndex;index>startIndex;index--){
            int temp = input[index];
            input[index] = input[index-1];
            input[index-1] = temp;
        }
    }

}
