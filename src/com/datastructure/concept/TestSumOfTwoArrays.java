package com.datastructure.concept;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by asingh on 12/9/18.
 */
public class TestSumOfTwoArrays {

    public static void main (String[] args){
        Integer[] array1 = {2,3,4,5,5,7,8,9};
        Integer[] array2 = {1,2,3,4,5};
        ArrayList<Integer> result = sumOfTwoArrays(array1,array2);
        for(Integer val:result){
            System.out.println(val);
        }
    }

    public  static ArrayList<Integer> sumOfTwoArrays(Integer[] array1, Integer[] array2){
        int length1 = array1.length;
        int length2 = array2.length;
        int max = length1 > length2 ? length1:length2;
        ArrayList<Integer> mergedArray = new ArrayList<Integer>();
        int remainder = 0;

        if(length1>length2){
            mergedArray = copyToList(array1);
            for(int index = 0;index<array2.length;index++){
                int sum = array2[index]+mergedArray.get(index)+remainder;
                remainder = 0;
                if(sum/10>=1){
                    remainder = (int)Math.abs(Math.floor(sum/10));
                    sum = sum%10;
                    mergedArray.set(index,sum);
                } else {
                    mergedArray.set(index,sum);
                }
            }
            if(remainder>0){
                int counter = array2.length;
                while (remainder>0){
                    int sum = mergedArray.get(counter)+remainder;
                    remainder = 0;
                    if(sum/10>=1){
                        remainder = sum%10;
                        sum = (int)Math.abs(Math.floor(sum/10));
                        mergedArray.set(counter,sum);
                        counter++;
                    } else {
                        mergedArray.set(counter,sum);
                        counter++;
                    }
                }

            }
        } else {
            mergedArray = copyToList(array2);;
            for(int index = 0;index<array1.length;index++){
                int sum = array1[index]+mergedArray.get(index)+remainder;
                remainder = 0;
                if(sum/10>=1){
                    remainder = sum%10;
                    sum = (int)Math.abs(Math.floor(sum/10));
                } else {
                    mergedArray.set(index,sum);
                }
            }
            if(remainder>0){
                mergedArray.add(remainder);
            }
        }
       return mergedArray;
    }

    private static ArrayList<Integer> copyToList(Integer[] array) {
        ArrayList<Integer> aList = new ArrayList<Integer>();
        for (Integer val : array) {
            aList.add(val);
        }
        return  aList;
    }
}
