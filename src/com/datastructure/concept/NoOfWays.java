package com.datastructure.concept;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by asingh on 6/16/19.
 * Finding number of ways to reach to the nth StairCase
 */
public class NoOfWays {

    public static void main(String[] args){
        NoOfWays test = new NoOfWays();
        System.out.println(test.findNoOfWays(6));
    }

    public int findNoOfWays(int n){
        HashMap<Integer,Integer> waysMap = new HashMap<>();
        return findWays(n,waysMap);
    }

    public int findWays(int n,Map<Integer,Integer> memo){

        if(n==0 ||n==1){
            return 1;
        }

        if(memo.containsKey(n)){
            return memo.get(n);
        }else{
            int totalWays = findWays(n-1,memo)+findWays(n-2,memo);
            memo.put(n,totalWays);
            return  totalWays;
        }
    }
}
