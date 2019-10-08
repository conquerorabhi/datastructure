package com.datastructure.concept;

/**
 * Quick sort has complexity of Big O of n^2.
 *
 */
public class QuickSort {

    public static void main(String[] args){
        QuickSort qSort = new QuickSort();
        int[] input = {4,7,2};
        qSort.quickSort(input);
        for(int value:input){
            System.out.println(value);
        }
    }

    public void quickSort(int [] input){
        quickSort(input,0,input.length-1);
    }

    public void quickSort(int[] input,int left,int right){
        int partitionIndex = partition(input,left,right);
        if(left<partitionIndex-1){
            quickSort(input,left,partitionIndex-1);
        }
        if(right>partitionIndex){
            quickSort(input,partitionIndex,right);
        }
    }

    public int partition(int[] input,int left,int right){
        int pivot = input[(left+right)/2];
        while(left<=right){
            while(input[left]<pivot){
                left++;
            }
            while(input[right]>pivot){
                right--;
            }

            if(left<=right){
                int temp = input[right];
                input[right] = input[left];
                input[left] = temp;
                right--;
                left++;
            }
        }
        return left;
    }


}
