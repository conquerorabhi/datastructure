package com.datastructure.concept;

/**
 * Created by asingh on 6/15/19.
 */
public class BinarySearch {

    public static void main(String[] args){
        BinarySearch binSearch = new BinarySearch();
        int[] a = {1,4,5,9};
        int[] b = {3,6,7,8};
        try{
            System.out.println(binSearch.findMedianOfTwoSortedArrays(a,b));
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public double findMedianOfTwoSortedArrays(int[] firstArray,int[] secondArray) throws Exception{
        double median = 0.0;
        if(firstArray.length==0 && secondArray.length==0){
            throw new Exception("Invalid / empty input");
        }

        if(firstArray.length == 0){
            return findMedianOfAnArray(secondArray);
        }else if(secondArray.length==0){
            return findMedianOfAnArray(firstArray);
        }
        int lengthOfFirstArray = firstArray.length;
        int lengthOfSecondArray = secondArray.length;

        if(lengthOfFirstArray>lengthOfSecondArray){
            return findMedianOfTwoSortedArrays(secondArray,firstArray);
        }

        int start = 0;
        int end = lengthOfFirstArray;
        int partitionOfFirstArray = (start+end)/2;
        int partitionOfSecondArray = ((lengthOfFirstArray+lengthOfSecondArray+1)/2)-partitionOfFirstArray;

        while(start<=end){
            int maxLeftOfFirstArray = partitionOfFirstArray==0?Integer.MIN_VALUE:firstArray[partitionOfFirstArray-1];
            int minRightOfFirstArray = partitionOfFirstArray==lengthOfFirstArray?Integer.MAX_VALUE:firstArray[partitionOfFirstArray];

            int maxLeftOfSecondArray = partitionOfSecondArray==0?Integer.MIN_VALUE:secondArray[partitionOfSecondArray-1];
            int minRightOfSecondArray = partitionOfSecondArray==lengthOfSecondArray?Integer.MAX_VALUE:secondArray[partitionOfSecondArray];

            if( (maxLeftOfFirstArray<=minRightOfSecondArray) && (maxLeftOfSecondArray<=minRightOfFirstArray)){
                if((lengthOfFirstArray+lengthOfSecondArray)%2==0){
                    median = (Math.max(maxLeftOfFirstArray,maxLeftOfSecondArray)+Math.min(minRightOfFirstArray,minRightOfSecondArray))/2.0;
                }else{
                    median = Math.max(maxLeftOfFirstArray,maxLeftOfSecondArray);
                }
                return median;
            }else if(maxLeftOfFirstArray>=minRightOfSecondArray){
                end = end -1;
                partitionOfFirstArray = (start+end)/2;
                partitionOfSecondArray = (lengthOfFirstArray+lengthOfSecondArray+1)/2-partitionOfFirstArray;
            }else{
                start = start + 1;
                partitionOfFirstArray = (start+end)/2;
                partitionOfSecondArray = (lengthOfFirstArray+lengthOfSecondArray+1)/2-partitionOfFirstArray;
            }
        }

        return median;
    }

    public double findMedianOfAnArray(int[] input){
        int length = input.length;
        double median = 0.0;
        if(length%2==0){
            int medIndex = (length/2);
            median = input[medIndex] + input[medIndex+1];
        }else{
            median = input[(length+1)/2];
        }
        return median;
    }
}
