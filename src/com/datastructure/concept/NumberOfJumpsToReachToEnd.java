package com.datastructure.concept;

/**
 * Created by asingh on 6/16/19.
 */
public class NumberOfJumpsToReachToEnd {

    public static void main(String[] args){
        NumberOfJumpsToReachToEnd test = new NumberOfJumpsToReachToEnd();
        int[] input = {2,1,3,1,4};
        System.out.println(test.noMinOfJumps(input));
    }

    public int noMinOfJumps(int[] arr){
        if(arr.length<1){
            return 0;
        }

        int ladder = arr[0];
        int stairs = arr[0];
        int jump = 1;
        for(int level =1;level<arr.length;level++){
            if(level==arr.length-1){
                return jump;
            }

            if(level+arr[level]>ladder){
                ladder = level+arr[level];
            }
            stairs = stairs - 1;

            if(stairs==0){
                jump = jump + 1;
                stairs = ladder - level;
            }
        }
        return jump;

    }
}
