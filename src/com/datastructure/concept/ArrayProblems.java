package com.datastructure.concept;

import java.util.*;

/**
 * Created by asingh on 7/25/19.
 */
public class ArrayProblems {

    public static void main(String[] args){
        int[][] input = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };

        ArrayProblems arrayProblems = new ArrayProblems();
        //arrayProblems.printMatricesSpiralFormat(input,input.length,input[0].length);
        int[] ints= {4,2,-3,-1,0,4};
        int[] inputArr = {2,0,2,1,4,3,1,0};
        //arrayProblems.printSubArrayWithSumZero(ints);
        arrayProblems.largestSubarrayByConsecutiveIntegers(inputArr);
    }

    public void printMatricesSpiralFormat(int[][] input,int rowLen,int colLen){

        int last_row = rowLen-1;
        int last_col = colLen-1;
        int row = 0;
        int col = 0;
        while(row<=last_row && col<=last_col){
            //print first row
            for(int i = col;i<=last_col;i++){
                System.out.print(input[row][i]);
            }
            System.out.println("");
            row++;

            for(int j=row;j<=last_row;j++){
                System.out.print(input[j][last_col]);
            }
            System.out.println("");
            last_col = last_col-1;

            if(col<last_col){
                for(int k=last_col;k>=col;k--){
                    System.out.print(input[last_row][k]);
                }
            }
            System.out.println("");
            last_row = last_row-1;

            if(row<last_row){
                for(int m=last_row;m>=row;m--){
                    System.out.print(input[m][col]);
                }
                System.out.println("");
            }
            col = col+1;
        }
    }

    public void printSubArrayWithSumZero(int[] input){
        HashMap<Integer,Integer> sumMap = new HashMap<>();
        HashMap<Integer,List<Integer>> acMap = new HashMap<>();

        int sum = 0;
        for(int index=0;index<input.length;index++){
            sum = sum + input[index];
            if(sumMap.containsKey(sum)){
                int jIndex = sumMap.get(sum);
                List<Integer> idxList = new ArrayList<>();
                for(int idx=jIndex+1;idx<=index;idx++){
                    idxList.add(input[idx]);
                }
                acMap.put(index,idxList);
            }
            sumMap.put(sum,index);
        }
        for(Map.Entry<Integer,List<Integer>> entry:acMap.entrySet()){
            List<Integer> valList = entry.getValue();
            System.out.println(valList);
        }
    }

    public void largestSubarrayByConsecutiveIntegers(int[] input){
        if(input.length==0){
            return;
        }

        List<Integer> uniqueList = new ArrayList<>();
        List<Integer> maxList = null;
        int startingIndex = 0;
        int maxLen = 0;
        for(int index=0;index<input.length;){
            if(uniqueList.contains(input[index])){
                uniqueList.remove((Integer)input[startingIndex]);
                startingIndex++;
            }else{
                uniqueList.add(input[index]);
                if(maxLen<uniqueList.size()){
                    maxLen = uniqueList.size();
                    maxList = new ArrayList<>(uniqueList);
                }
                index++;
            }
        }
        for(Integer iValue:maxList){
            System.out.println("Value : "+iValue);
        }
    }
}
