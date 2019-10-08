package com.datastructure.concept;

import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 * Created by asingh on 12/4/18.
 *
 * In the depth first search we recursively search the adjacent nodes of each vertices. In this we visit root node and then we try
 * to find the adjacent node and recursively we go in side the adjacent node until we have nothing to visit.
 **/
public class DepthFirstSearch {

    public static void main(String[] args){
        int[] nums = {10,9,2,5,3,7,101,18};
        int[][] emp = {{30,50},{12,2},{3,4},{12,15}};
        DepthFirstSearch dfs = new DepthFirstSearch();
        //dfs.lengthOfLIS1(nums);
        dfs.maxEnvelopes(emp);
    }


    public void depthFirstSearch(AdjacencyListGraph graph,int startingNode){
        HashSet<Integer> visitedNodes = new HashSet<Integer>();
        doDepthFirstSearch(visitedNodes,graph,startingNode);

    }

    public void doDepthFirstSearch(HashSet<Integer> visitedNodes,AdjacencyListGraph graph, int startingNode){
        if(visitedNodes.contains(startingNode)){
            return ;
        }
        visitedNodes.add(startingNode);
        Node startingVertice = graph.getVertice(startingNode);
        for(Node vertice:startingVertice.getNeighbors()){
            System.out.println("Visiting Vertice : "+vertice.getId());
            this.doDepthFirstSearch(visitedNodes,graph,vertice.getId());
        }
    }

    public int lengthOfLIS(int[] nums) {

        int res = 0;
        if(nums.length==0){
            return res;
        }
        int prevValue = 0;
        int maxSize = 0;
        List<List<Integer>> inputList = new ArrayList<>();
        for(int index=0;index<nums.length;index++){
            int j = index+1;
            List<Integer> list = new ArrayList<>();
            list.add(nums[index]);
            prevValue = nums[index];
            while(j<=nums.length-1){

                while(j<=nums.length-1 && prevValue>nums[j]){
                    j++;
                }

                if(j<=nums.length-1 && prevValue<nums[j]){
                    prevValue = nums[j];
                    list.add(nums[j]);
                }
                j++;

            }

            if(list.size()>maxSize){
                maxSize = list.size();
            }
        }

        return maxSize;
    }

    public int lengthOfLIS1(int[] nums) {

        if(nums.length==0){
            return 0;
        }

        int[][] res = new int[nums.length+1][nums.length+1];

        for(int i=0;i<=nums.length-1;i++){
            int resIndex = i+1;
            for(int j=0;j<=nums.length-1;j++){
                int resColumns = j+1;
                if(nums[j]>nums[i]){
                    res[resIndex][resColumns] = res[resIndex-1][resColumns-1]+1;
                }else{
                    res[resIndex][resColumns] = Math.max(res[resIndex-1][resColumns],res[resIndex][resColumns-1]);
                }
            }
        }

        return res[nums.length][nums.length];
    }

    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes.length==0){
            return 0;
        }else if(envelopes.length==1){
            return 1;
        }
        int len = envelopes.length;
        int[] res = new int[len];
        Arrays.fill(res,1);
        int max = 0;

        for(int i=0;i<envelopes.length;i++){

            for(int j=i+1;j<envelopes.length;j++){
                int[] env1 = envelopes[i];
                int[] env2 = envelopes[j];
                if(env1[0]>env2[0]){
                    int[] temp = envelopes[i];
                    envelopes[i] = envelopes[j];
                    envelopes[j] = temp;
                }else if(env1[0]==env2[0]  && env1[1]>env2[1]){
                    int[] temp = envelopes[i];
                    envelopes[i] = envelopes[j];
                    envelopes[j] = temp;
                }
            }
        }
        for(int index=1;index<len;index++){
            int j=0;
            int[] temp1 = envelopes[index];

            while(j<index){
                int[] temp2 = envelopes[j];
                if(temp1[0]>temp2[0] && temp1[1]>temp2[1]){
                    if(res[j]+1>res[index]){
                        res[index] = res[j]+1;
                        if(max<res[index]){
                            max=res[index];
                        }
                    }
                }
                j++;
            }
        }
        return max>1?max:1;
    }
}
