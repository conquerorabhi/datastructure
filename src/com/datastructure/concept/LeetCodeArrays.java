package com.datastructure.concept;

import java.util.List;
import java.util.ArrayList;
import java.util.*;

/**
 * Created by asingh on 7/7/19.
 */
public class LeetCodeArrays {

    public static void main(String[] args){
        LeetCodeArrays ar = new LeetCodeArrays();

        int[] nums= {8,7,1,2,6,5,4,3};
        //ar.threeSum(nums);
        //ar.nextPermutation(nums);
       // ar.quickSort(nums,2,6);
        int[][] sCard = {{1,91},{1,92},{2,93},{2,97},{1,60},{2,77},{1,65},{1,87},{1,100},{2,100},{2,76}};
        int[] input = {3,3,6,5,-2,2,5,1,-9,4};
        //ar.findAverage(sCard);
        ar.nextPermutation(input);
        //ar.canThreePartsEqualSum(input);
        //ar.lengthOfLongestSubstring("bcadabc");
        ar.lengthOfLongestSubstringTwoDistinct("eceba");
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length==0){
            return result;
        }
        int l = 0;
        int r = nums.length-1;
        Arrays.sort(nums);

        for(int index=0;index<nums.length-2;index++){

//            if(nums[index]==nums[index+1]){
//                index++;
//                continue;
//            }
            l = index+1;
            while(l<r){
                if(nums[index]+nums[l]+nums[r]==0){
                    List<Integer> numList = new ArrayList<>();
                    numList.add(nums[index]);
                    numList.add(nums[l]);
                    numList.add(nums[r]);
                    result.add(numList);
                    while(l<r && nums[l]==nums[l+1]){
                        l++;
                    }while(l<r && nums[r]==nums[r-1]){
                        r--;
                    }
                    l++;
                    r--;
                }else if(nums[index]+nums[l]+nums[r]>0){
                    r=r-1;
                }else if(nums[index]+nums[l]+nums[r]<0){
                    l=l+1;
                }else{
                    l=l+1;
                    r=r-1;
                }
            }
        }

        return result;
    }

    /**
     * Scan from right to left find firs non increasing number if not found print none.
     * if non increasing number is found at index i then now find next greater number from i to length-1;
     * Let's say number is found at j = i+1 index between i and length-1;
     * Swap index i and index j=i+1 number;
     * Quick sort array between i+1 to end.
     *
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        if(nums.length>0){
            boolean isLexigraphicalNumberFound = false;

            int d1 = 0;
            int d2 = 0;
            int smallestNumber = 0;
            int smallestNumberIdx = 0;
            int difference = 0;
            for(int idx=nums.length-1;idx>=1;idx--){
                if(nums[idx]>nums[idx-1]){
                    d1 = idx-1;
                    for(int index=d1+1;index<=nums.length-1;index++){
                        if(nums[d1]>nums[index]){
                            smallestNumber = nums[index];
                            smallestNumberIdx = index;
                            break;
                        }
                    }
                    int temp = nums[d1];
                    nums[d1] = smallestNumber;
                    nums[smallestNumberIdx] = temp;
                    quickSort(nums,d1,smallestNumberIdx);
                    break;
                }
            }

            if(!isLexigraphicalNumberFound){
                int left = 0;
                int right = nums.length-1;
                while(left<right){
                    if(nums[left]>=nums[right]){
                        int temp = nums[left];
                        nums[left] = nums[right];
                        nums[right] = temp;
                        left = left + 1;
                        right = right - 1;
                    }
                }
            }
        }
    }

    private void quickSort(int[] nums,int fromIndex,int toIndex){
        int partitionIdx = partition( nums, fromIndex, toIndex);
        if(fromIndex<partitionIdx-1){
            quickSort(nums,fromIndex,partitionIdx-1);
        }

        if(toIndex>partitionIdx){
            quickSort(nums,partitionIdx,toIndex);
        }
    }

    private int partition(int[] nums,int frmIdx,int toIdx){
        int pivot = nums[(frmIdx+toIdx)/2];
        int left = frmIdx;
        int right = toIdx;
        while(left<right){
            while(nums[left]<pivot){
                left++;
            }
            while(nums[right]>pivot){
                right--;
            }

            if(left<=right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        return left;
    }

    private int[][] findAverage(int[][] studentsScoreCard){
        int row = studentsScoreCard.length;
        int columns = studentsScoreCard[0].length;
        HashMap<Integer,List<Integer>> scoreMap = new HashMap<>();
        for(int count = 0;count<=row-1;count++){
            for(int index=0;index<=columns-1;index++){
                System.out.println(studentsScoreCard[columns][index]);
            }
        }
        return  studentsScoreCard;
    }

    public boolean canThreePartsEqualSum(int[] A) {
        if(A.length==0||A.length==2){
            return false;
        }
        int sum = 0;
        for(int index=0;index<A.length;index++){
            sum = sum + A[index];
        }

        int leftSum = 0;
        int rightSum = 0;
        int lPrev = 0;
        int rPrev = 0;
        int l = 0 ;
        int r = A.length-1;
        while(l<=r){
            if(lPrev!=l) {
                leftSum = leftSum + A[l];
            }
            if(rPrev!=r) {
                rightSum = rightSum + A[r];
            }
            lPrev = l;
            rPrev = r;
            if(leftSum==sum/3 && rightSum==sum/3){
                return true;
            }else if(leftSum>rightSum && rightSum!=sum/3){
                r--;
            }else if(rightSum>leftSum && leftSum!=sum/3){
                l++;
            }else{
                l++;
                r--;
            }

        }

        return false;
    }

    public int lengthOfLongestSubstring(String s) {
        if(s==null||"".equals(s)){
            return 0;
        }else if(s.length()==1){
            return 1;
        }
        Set<Character> charSet = new HashSet<Character>();
        HashMap<Character,Integer> chMap = new HashMap<>();
        int left=0,right=0,res=0;

        while(right<s.length()){

            if(charSet.contains(s.charAt(right))){
                right = chMap.get(s.charAt(right))+1;
                charSet = new HashSet<>();
            }else{
                charSet.add(s.charAt(right));
                chMap.put(s.charAt(right),right);
                res=Math.max(res,charSet.size());
                right++;
            }
        }
        return res;
    }

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Set<Character> uniqueSet = new LinkedHashSet<>();
        List<Character> sub = new ArrayList<>();
        HashMap<Character,Integer> chMap = new HashMap<>();
        int l=0,r=0,res=0;

        while(r<s.length()){
            if(uniqueSet.size()<=2){
                chMap.put(s.charAt(r),r);
                uniqueSet.add(s.charAt(r));
                if(uniqueSet.size()<=2){
                    sub.add(s.charAt(r));
                    res = Math.max(sub.size(),res);
                    r++;
                }

            }else if(uniqueSet.size()>=2){
                chMap.put(s.charAt(r),r);
                uniqueSet.add(s.charAt(r));
                char value = sub.get(l);
                int to = chMap.get(value);
                int from = l;
                while(from<=to){
                    char val = s.charAt(from);
                    int nextIdx = chMap.get(val);
                    if(to<nextIdx){
                        to = nextIdx;
                    }
                    if(sub.contains(val)) {
                        sub.remove((Character)val);
                    }
                    uniqueSet.remove(val);
                    from=from+1;
                }

                l=to+1;
            }
        }
        return res;
    }


}
