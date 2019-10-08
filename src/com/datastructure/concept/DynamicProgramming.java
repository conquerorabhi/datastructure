package com.datastructure.concept;

/**
 * Created by asingh on 7/19/19.
 */
public class DynamicProgramming {

    public static void main(String[] args){
        int [] arr = {2,1,3,2,3,4,5,1,2,8};
        int[] input = {1,3,5,4,2,3,4};
        DynamicProgramming dp = new DynamicProgramming();
        System.out.println(dp.findLengthOfLCIS(input));
    }

    /**
     * Find Minimun no of jumps to reach at the end of array.
     */
    public int minimumNoOfJumps(int[] arr){
        if(arr.length==0||arr.length==1){
            return 0;
        }

        int[] minJumpArray = new int[arr.length];
        int[] pathArray = new int[arr.length];
        minJumpArray[0] = 0;
        pathArray[0] = 0;
        int len = arr.length;
        for(int i=1;i<len;i++){
            for(int j=0;j<i;j++){
                if(i<=j+arr[j]){
                    if(minJumpArray[i]>0){
                        if(minJumpArray[j]+1<minJumpArray[i]){
                            pathArray[i] = j;
                        }
                        minJumpArray[i] = Math.min(minJumpArray[j]+1,minJumpArray[i]);

                    }else{
                        minJumpArray[i] =minJumpArray[j]+1;
                        pathArray[i] = j;
                    }

                }

            }
        }
        int pathIndex=pathArray[len-1];
        while(pathIndex!=0){
            System.out.print(pathIndex+"=>");
            pathIndex = pathArray[pathIndex];
        }
        System.out.print(pathIndex);
        System.out.println();
        return minJumpArray[len-1];
    }

    /**
     * Find longest increasing sub-sequence.
     */
    public int findLengthOfLCIS(int[] nums) {
        int max = 0;
        if(nums.length==0){
            return max;
        }else if(nums.length==1){
            return 1;
        }
        max = 1;
        for(int index=0;index<nums.length-1;index++){
            int prev=0;
            int counter = 1;
            while(index+1<=nums.length-1 && nums[index]==nums[index+1]){
                index = index+1;
            }
            int j=index+1;
            while(j<nums.length){
                if(j-index==1 && nums[j]>nums[index]){
                    counter = counter+1;
                    if(max<counter){
                        max = counter;
                    }
                    prev = nums[j];
                }else if(j-index>1 && nums[j]>prev){
                    counter = counter + 1;
                    if(max<counter){
                        max = counter;
                    }
                    prev = nums[j];
                }else{
                    prev = nums[j];
                    break;
                }
                j++;
            }
        }
        return max==0?1:max;
    }
}
