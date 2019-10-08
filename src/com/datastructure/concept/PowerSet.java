package com.datastructure.concept;


import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * Created by asingh on 6/16/19.
 */
public class PowerSet {

    public static void main(String[] args){
        PowerSet pSet = new PowerSet();
        int[] input = {1,2,3};

        Set<String> itemSet = new HashSet<>();
        itemSet.add("Mango");
        itemSet.add("Oranges");
        itemSet.add("Grapes");
        String[] itemArray = new String[itemSet.size()];
        itemSet.toArray(itemArray);
        pSet.powerSet(itemArray);
    }

    public void powerSet(String[] input){
        Map<Integer,String> subset = new HashMap<Integer, String>();
        powerSetHelper(input,subset,0);
    }

    public void powerSetHelper(String[] input, Map<Integer,String> subset, int index){
        if(index==input.length){
            printPowerSet(subset);
        }else{
            subset.put(index,null);
            powerSetHelper(input,subset,index+1);
            subset.put(index,input[index]);
            powerSetHelper(input,subset,index+1);
        }
    }


    public void powerSet(int[] input){
        Map<Integer,Integer> subset = new HashMap<Integer, Integer>();

        powerSetHelper(input,subset,0);
    }

    public void powerSetHelper(int[] input, Map<Integer,Integer> subset, int index){
        if(index==input.length){
            printPowerSetMap(subset);
        }else{
            subset.put(index,null);
            powerSetHelper(input,subset,index+1);
            subset.put(index,input[index]);
            powerSetHelper(input,subset,index+1);
        }
    }

    private void printPowerSetMap(Map<Integer,Integer> pMap){
        List<Integer> mapValues = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry:pMap.entrySet()){
            if(entry.getValue()!=null) {
                mapValues.add(entry.getValue());
            }
        }
        System.out.println(mapValues);
    }

    private void printPowerSet(Map<Integer,String> pMap){
        List<String> mapValues = new ArrayList<>();
        for(Map.Entry<Integer,String> entry:pMap.entrySet()){
            if(entry.getValue()!=null) {
                mapValues.add(entry.getValue());
            }
        }
        System.out.println(mapValues);
    }
}
