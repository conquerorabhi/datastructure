
package com.datastructure.concept;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public Solution.ListNode addTwoNumbers(Solution.ListNode l1, Solution.ListNode l2) {
        Integer[] inputNumber1 = generateNumber(l1);
        Integer[] inputNumber2 = generateNumber(l2);
        ArrayList<Integer> merged = sumOfTwoArrays(inputNumber1,inputNumber2);
        Solution.ListNode resultNode = null;
        for(Integer intval:merged){
            if(resultNode==null){
                resultNode = new Solution.ListNode(intval);
            }else{
                addNode(intval,resultNode);
            }

        }
        return resultNode;
    }

    public Integer [] generateNumber(Solution.ListNode input){
        int inputNumber = input.value;
        String value = null;
        int multiplier = 1;
        if(input.next!=null){
            inputNumber = visitNode(inputNumber,multiplier,input);
        }

        return this.convertToArray(inputNumber);
    }

    public int visitNode(int inputNumber,int multiplier, Solution.ListNode node){
        Solution.ListNode nextNode = node.next;
        if(nextNode!=null){
            multiplier = multiplier*10;
            inputNumber = inputNumber + (multiplier*nextNode.value);
            if(nextNode.next!=null){
                inputNumber=visitNode(inputNumber,multiplier,nextNode);
            }
        }
        return inputNumber;
    }



    public Solution.ListNode addNode(int value,Solution.ListNode parent){

        if(parent!=null) {
            while (parent.next != null) {
                parent = visitNode(parent);
            }
            Solution.ListNode nextNode = new Solution.ListNode(value);
            parent.next = nextNode;
        } else {
            parent = new Solution.ListNode(value);
        }
        return parent;
    }

    public Solution.ListNode visitNode(Solution.ListNode lNode){
        return lNode.next;
    }

    public void printList(Solution.ListNode node){
        while (node.next!=null){
            System.out.println(node.value);
            node = visitNode(node);
        }
        System.out.println(node.value);
    }

    static class ListNode{
        int value;
        public ListNode next;
        public ListNode(int value){
            this.value = value;
        }
        public void setNext(ListNode node){
            this.next = node;
        }
    }

    private Integer[] convertToArray(int inputNumber){
        ArrayList<Integer> intArray = new ArrayList<Integer>();
        while(inputNumber/10>=1){
            double val = Math.abs((Math.floor(inputNumber/10)));
            int remainder = inputNumber%10;
            inputNumber=((int)val);
            intArray.add(remainder);
        }
        if(inputNumber<10){
            intArray.add(inputNumber);
        }
        Integer [] valueArray = new Integer[intArray.size()];
        return intArray.toArray(valueArray);
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
                    int sum = 0;
                    if(mergedArray.size()>counter){
                        sum = mergedArray.get(counter)+remainder;
                    } else {
                        sum = remainder;
                    }
                    remainder = 0;
                    if(sum/10>=1){
                        remainder = (int)Math.abs(Math.floor(sum/10));
                        sum = sum%10;
                        mergedArray.set(counter,sum);
                        counter++;
                    } else {
                        if(mergedArray.size()>counter) {
                            mergedArray.set(counter, sum);
                        }else {
                            mergedArray.add(sum);
                        }
                        counter++;
                    }
                }

            }
        } else {
            mergedArray = copyToList(array2);
            for(int index = 0;index<array1.length;index++){
                int sum = array1[index]+mergedArray.get(index)+remainder;
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
                int counter = array1.length;
                while (remainder>0){
                 int sum = 0;
                 if(mergedArray.size()>counter){
                sum = mergedArray.get(counter)+remainder;
                 } else {
                     sum = remainder;
                 }
                    remainder = 0;
                    if(sum/10>=1){
                        remainder = (int)Math.abs(Math.floor(sum/10));
                        sum = sum%10;
                        mergedArray.set(counter,sum);
                        counter++;
                    } else {
                        if(mergedArray.size()>counter) {
                            mergedArray.set(counter, sum);
                        }else {
                            mergedArray.add(sum);
                        }
                        counter++;
                    }
                }

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