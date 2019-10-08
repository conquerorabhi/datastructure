package com.datastructure.concept;

import java.util.*;

/**
 * Created by asingh on 12/13/18.
 */
public class TestProgramme {

    public static void main(String[] args){
        TestProgramme testProgramme = new TestProgramme();
        //System.out.println(testProgramme.reverse(1534236469));
        //System.out.println(testProgramme.isPalindrome(121));
        long currentTimeInMillies = System.currentTimeMillis();
//        System.out.println("Roman to Int : "+testProgramme.romanToInt("IVXXXXXLM"));
//        System.out.println("Time took : "+(currentTimeInMillies-System.currentTimeMillis()));
//        System.out.println(testProgramme.romanToIntAlternateWay("IVXXXXXLM"));
        String[] val = {"aa","ab","ca"};
//        System.out.println(testProgramme.longestCommonPrefix(val));


        ListNode l1=new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l123 = new ListNode(4);
        l1.next = l12;
        l12.next = l123;

        ListNode l2=new ListNode(1);
        ListNode l22 = new ListNode(3);
        ListNode l223 = new ListNode(4);
        l2.next = l22;
        l22.next = l223;
        //System.out.println(testProgramme.mergeTwoLists(l1,l2));
        //int [] input = {-2,1,-3,4,-1,2,1,-5,4};
        int [] input = {9};


        //testProgramme.findAllPrimeNumberInARange(1000);

        String value = "99";
        int valued = value.charAt(0)-'0';
        System.out.println(testProgramme.toDecimal(1011,2));

    }
    public long reverse(int x) {
        System.out.println(Integer.MAX_VALUE);

        if(x>Integer.MAX_VALUE || x<Integer.MIN_VALUE){
            return 0;
        }

        boolean isPositive = false;
        if(x>0){
            isPositive = true;
        } else{
            x = 0-x;
        }
        long reverseNumber = 0;
        while((x/10)>=1){
            int remainder = x%10;
            x = (int)Math.abs(Math.floor(x/10));
            reverseNumber = (reverseNumber*10) + remainder;
            if(reverseNumber>Integer.MAX_VALUE || reverseNumber<Integer.MIN_VALUE){
                return 0;
            }
        }

        if(x>0){
            reverseNumber = reverseNumber*10 + x;
        }

        if(!isPositive){
            reverseNumber = -1*reverseNumber;
        }
        if(reverseNumber>=Integer.MAX_VALUE || reverseNumber<Integer.MIN_VALUE){
            return 0;
        }
        return reverseNumber;

    }

    public boolean isPalindrome(int x) {
        int inputNumber = x;
        if(x<0){
            return false;
        } else if (x<10){
            return true;
        }

        long reverseNumber = 0;
        while((x/10)>=1){
            int remainder= x%10;
            x = (int)Math.abs(Math.floor(x/10));
            reverseNumber = (reverseNumber*10)+remainder;
            if(reverseNumber>Integer.MAX_VALUE || reverseNumber<Integer.MIN_VALUE){
                return false;
            }
        }

        if(x>0){
            reverseNumber = (reverseNumber*10)+x;
        }
        if(reverseNumber>Integer.MAX_VALUE || reverseNumber<Integer.MIN_VALUE){
            return false;
        }

        return reverseNumber == inputNumber;
    }

    public int romanToInt(String s) {
        HashMap<String,Integer> romanMap = new HashMap<String,Integer>();
        romanMap.put("I",1);
        romanMap.put("V",5);
        romanMap.put("X",10);
        romanMap.put("L",50);
        romanMap.put("C",100);
        romanMap.put("D",500);
        romanMap.put("M",1000);
        char[] charrArray = s.toCharArray();
        long actualNumber = 0;
        int counter = 0;
        for(int index=0;index<charrArray.length;index++){
            int nextIndex = index + 1;
            boolean isLastChar = (nextIndex>=charrArray.length);
            boolean isAnySubstractiveNumber = false;
            if("I".equals(String.valueOf(charrArray[index])) && !isLastChar && ("X".equals(String.valueOf(charrArray[nextIndex])) || "V".equals(String.valueOf(charrArray[nextIndex])))){
                actualNumber = actualNumber - romanMap.get("I");
                isAnySubstractiveNumber = true;
            } else if("I".equals(String.valueOf(charrArray[index]))){
                actualNumber = actualNumber + romanMap.get("I");
                isAnySubstractiveNumber = true;
            }

            if("X".equals(String.valueOf(charrArray[index])) && !isLastChar && ("L".equals(String.valueOf(charrArray[nextIndex])) || "C".equals(String.valueOf(charrArray[nextIndex])))){
                actualNumber = actualNumber - romanMap.get("X");
                isAnySubstractiveNumber = true;
            } else if("X".equals(String.valueOf(charrArray[index]))){
                actualNumber = actualNumber + romanMap.get("X");
                isAnySubstractiveNumber = true;
            }

            if("C".equals(String.valueOf(charrArray[index])) && !isLastChar && ("D".equals(String.valueOf(charrArray[nextIndex])) || "M".equals(String.valueOf(charrArray[nextIndex])))){
                isAnySubstractiveNumber = true;
                actualNumber = actualNumber - romanMap.get("C");
            } else if("C".equals(String.valueOf(charrArray[index]))) {
                actualNumber = actualNumber + romanMap.get("C");
                isAnySubstractiveNumber = true;
            }

            if(!isAnySubstractiveNumber){
                actualNumber = actualNumber + romanMap.get(charrArray[index]+"");
            }
        }
        return (int)actualNumber;
    }

    public int romanToIntAlternateWay(String s) {
        HashMap<String,Integer> romanMap = new HashMap<String,Integer>();
        romanMap.put("I",1);
        romanMap.put("V",5);
        romanMap.put("X",10);
        romanMap.put("L",50);
        romanMap.put("C",100);
        romanMap.put("D",500);
        romanMap.put("M",1000);
        char[] charrArray = s.toCharArray();
        long sum = 0;
        int counter = 0;
        for(int index=0;index<charrArray.length-1;index++){
            int temp1 = romanMap.get(String.valueOf(charrArray[index]));
            int temp2 = romanMap.get(String.valueOf(charrArray[index+1]));

            if(temp1<temp2){
                sum-=temp1;
            } else {
                sum+=temp1;
            }
        }
        sum = sum + romanMap.get(String.valueOf(charrArray[charrArray.length-1]));
        return (int)sum;
    }

    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        } else if (strs.length == 1){
            return strs[0];
        }

        int smallestStringSize = 0;
        String smallestPrefix = null;
        for(String val:strs){
            if(val!=null && val.length()==0){
                return "";
            }
            if(smallestStringSize==0){
                smallestStringSize = val.length();
                smallestPrefix = val;
            } else if (smallestStringSize > val.length()){
                smallestStringSize = val.length();
                smallestPrefix = val;
            }
        }
        String longestPrefix = "";
        int longestPrefixLength = 0;
        char[] prefixArray = smallestPrefix.toCharArray();
        int startIndexOfPrefix = 0;
        boolean charIsNotCommon = false;
        for(int index=0; index<prefixArray.length;index++){
            char pChar = prefixArray[index];
            if(charIsNotCommon){
                continue;
            }
            for(int pIndex=0;pIndex<strs.length;pIndex++){
                String temp = strs[pIndex];
                if(temp.length()>0) {
                    char preChar = temp.charAt(index);
                    if (String.valueOf(preChar).equals(String.valueOf(pChar))) {

                    } else {
                        charIsNotCommon = true;
                        if (charIsNotCommon) {
                            String tempVal = smallestPrefix.substring(startIndexOfPrefix, index);
                            if (longestPrefixLength < tempVal.length()) {
                                longestPrefixLength = tempVal.length();
                                longestPrefix = tempVal;
                            }
                            return longestPrefix;
                        }
                    }
                }
            }
        }

        if(startIndexOfPrefix>=0 && (startIndexOfPrefix < prefixArray.length)){
            String tempVal = smallestPrefix.substring(startIndexOfPrefix);
            if(longestPrefixLength<  tempVal.length()){
                longestPrefixLength = tempVal.length();
                longestPrefix = tempVal;
            }
        }
        return longestPrefix;
    }

    public boolean isValid(String s) {
        HashMap<Character,Character> chMap = new HashMap<Character, Character>();
        chMap.put(')','(');
        chMap.put('}','{');
        chMap.put(']','[');

        int length = s.length();
        if(length==0){
            return true;
        }

        if(length%2!=0){
            return false;
        }
        Stack<Character> inputStack = new Stack<Character>();

        for(int chIndex=0;chIndex<length;chIndex++){
            if(chMap.containsKey(s.charAt(chIndex))){
                char match = inputStack.size()>0 ? inputStack.pop():'#';
                if(match != chMap.get(s.charAt(chIndex))){
                    return false;
                }
            } else {
                inputStack.add(s.charAt(chIndex));
            }
        }

        if(inputStack.size()>0){
            return false;
        }

        return true;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        int listOneLength = listSize(l1);
        int listTwoLength = listSize(l2);
        ListNode itNode = null;
        ListNode itOverNode = null;
        int longestList = 0;
        if(listOneLength > listTwoLength){
            itNode = l1;
            longestList = listOneLength;
            itOverNode = l2;
        } else {
            longestList = listTwoLength;
            itNode = l2;
            itOverNode = l1;
        }


        ListNode mergedList = mergeList(longestList,itNode,itOverNode);
        return mergedList;
    }

    public int listSize(ListNode l1){
        int size = 0 ;
        ListNode itNode = l1;
        while(itNode!=null){
            size = size + 1;
            itNode = itNode.next;
        }
        return size;
    }

    public ListNode mergeList(int maxLength,ListNode itNode, ListNode itOverNode){
        ListNode itNodeOver2 = null;
        ListNode mergedList = null;
        for(int index = 0;index<maxLength;index++){

        }
        while(itNode!=null){
            itNodeOver2 = itOverNode;
            while(itNodeOver2!=null){
                if(itNode.val>itNodeOver2.val){
                    mergedList=mergeNode(itNodeOver2,itNode,mergedList);
                    break;
                } else if(itNode.val<=itNodeOver2.val) {
                    mergedList = mergeNode(itNode,itOverNode,mergedList);
                    break;
                }
                itNodeOver2 = itNodeOver2.next;
            }

            if(itNodeOver2 == null){
                ListNode newNode = new ListNode(itNode.val);
                mergedList.next = newNode;
            }

            itNode = itNode.next;
        }
        return mergedList;
    }

    public ListNode mergeNode(ListNode smallerNode,ListNode largerNode, ListNode mergeList){
        if(mergeList==null){
            mergeList = new ListNode(smallerNode.val);
            ListNode nextNode = new ListNode(largerNode.val);
            mergeList.next = nextNode;
        } else {
            ListNode firstNextNode = new ListNode(smallerNode.val);
            ListNode nextNextNode = new ListNode(largerNode.val);
            firstNextNode.next = nextNextNode;
            mergeList.next =  firstNextNode;
        }
        return mergeList;
    }

    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        int arrayLen = length;
        for(int index = length-1;index>0;index--){
            if(nums[index]==nums[index-1]){
                nums[index-1] = nums[index];
                arrayLen = arrayLen - 1;
                for(int counter = index-1;counter<length-1;counter++){
                    nums[counter] = nums[counter+1];
                    nums[counter+1] = 0;
                }
            }

        }

        return arrayLen;
    }

    public int removeElement(int[] nums, int val) {
        if(nums.length == 0){
            return 0;
        } else if(nums.length == 1){
            if(nums[0]==val){
                return 0;
            } else {
                return 1;
            }
        }

        int actualLength = nums.length;
        for(int index=0;index<nums.length;){
            if(val == nums[index]){
                actualLength--;
                findAndReplace(index,nums,val);
                if(index!=0){
                    index = index -1;
                }
            }else {
                index = index + 1;
            }
        }
        return actualLength;
    }

    public void findAndReplace(int counter,int[] nums,int val){
        for(int index=counter;index<nums.length-1;index++){
            nums[index] = nums[index+1];
            nums[index+1] = val>0?val+val:1;
        }
    }

    public int searchInsert(int[] nums, int target) {
        if(nums.length==0){
            return -1;
        }

        int placeIndex = -1;
        int median = 0;
        if(nums.length%2==0){
            median =nums.length/2;
        }else{
            median = ((int)Math.abs(Math.floor(nums.length/2)))+1;
        }
        int startingIndex = 0;
        int endIndex = 0;
        if(nums[median-1]>=target){
            startingIndex = 0;
            endIndex = median;
        }else{
            startingIndex = median-1;
            endIndex = nums.length;
        }

        for(int index=startingIndex;index<endIndex;index++){
            if(nums[index]==target){
                return index;
            } else if(target>nums[index] && index+1<nums.length && target<nums[index+1]){
                return index+1;
            } else if(index==0 && target<nums[index]){
                return 0;
            } else if(target>nums[index] && index==nums.length-1){
                return index+1;
            }
        }
        return 0;
    }

    public int maxSubArray(int[] nums) {
        if(nums.length==0){
            return 0;
        } else if(nums.length==1){
            return nums[0];
        }

        int stIndex = 0;
        int endIndex = 0;
        int maxSoFor = Integer.MIN_VALUE;
        int maxHere = 0;
        int sum = 0;
        boolean atLeastAnumber = false;
        for(int index=0;index<nums.length;index++){
            maxHere = maxHere + nums[index];
            if(maxSoFor<maxHere){
                maxSoFor = maxHere;
            }

            if(maxSoFor>=maxHere && maxHere<=0){
                maxHere = 0;
                if(index==nums.length-1){
                    if(maxSoFor<nums[index]){
                        maxSoFor = nums[index];
                    }
                }
            }
        }
        return maxSoFor;
    }

    public int lengthOfLastWord(String s) {
        if(s==null || s.length()==0){
            return 0;
        }

        String lastWord = lastWord(s);
        return lastWord.length();
    }

    public String lastWord(String s){
        String input = s;
        String lastWord = null;
        int lastIndexOf = input.lastIndexOf(' ');
        int length = input.length();
        if(lastIndexOf!=-1){
            if(length-1==lastIndexOf){
                lastWord = lastWord(input.substring(0,(input.length()-1)));
            }else{
                lastWord = input.substring(lastIndexOf+1);
            }
        }else{
            lastWord= s;
        }
        return lastWord;
    }

    public int[] plusOne(int[] digits) {
        if(digits.length==0){
            return digits;
        }
        int length = digits.length;
        int carryOver = 0;
        for(int index=length-1;index>=0;index--){
            if(index==0){
                int temp = digits[index];
                if(index==length-1){
                    temp = temp + 1;
                }
                temp = temp + carryOver;
                carryOver = 0;
                if(temp>=10){
                    int remainder = temp%10;
                    digits[index] = remainder;
                    carryOver = (int)Math.abs(Math.floor(temp/10));
                    digits = copyToNewArray(digits);
                    digits[index]=carryOver;
                }else{
                    digits[index]=temp;
                }
            }else{
                int temp = digits[index];
                if(carryOver>0){
                    temp = temp + carryOver;
                    carryOver = 0;
                }
                if(index==length-1){
                    temp = temp + 1;
                }
                if(temp>=10){
                    int remainder = temp % 10;
                    carryOver = (int)Math.abs(Math.floor(temp/10));
                    digits[index] = remainder;
                }else{
                    digits[index] = temp;
                }

            }


        }
        return digits;

    }

    public int[] copyToNewArray(int[] plArray){
        int[] newPlArray = new int[plArray.length+1];
        int length = newPlArray.length;
        int counter = plArray.length-1;
        for(int index=length-1;index>=0;index--){
            if(index==0){
                newPlArray[index] = 0;
            }else{
                newPlArray[index]=plArray[counter];
                counter = counter - 1;
            }
        }
        return newPlArray;
    }

    public String addBinary(String a, String b) {
        if(a==null || b==null){
            return null;
        }
        String sbr = null;
        int maxLength = a.length()>b.length()?a.length():b.length();
        int carryOver = 0;
        int aCounter = a.length()-1;
        int bCounter = b.length()-1;

        for(int index=maxLength-1;index>=0;index--){
            int element1=0;
            int element2=0;
            if(aCounter>=0){
               element1 = a.charAt(aCounter)-'0';
                aCounter = aCounter - 1;
            }

            if(bCounter>=0){
                element2 = b.charAt(bCounter)-'0';
                bCounter = bCounter - 1;
            }

            int sum = element1 + element2;
            if(carryOver>0){
                sum = sum + carryOver;
                carryOver = 0;
            }
            if(sum>=2){
                int remainder= sum%2;
                carryOver = (int)Math.abs(Math.floor(sum/2));
                if(sbr==null){
                    sbr = remainder+"";
                } else {
                    sbr = remainder + sbr;
                }

            } else {
                if(sbr==null){
                    sbr = sum+"";
                } else {
                    sbr = sum + sbr;
                }
            }

        }
        if(carryOver>0){
            if(sbr==null){
                sbr = carryOver+"";
            } else {
                sbr = carryOver + sbr;
            }
        }
        return sbr;
    }


    public void findAllPrimeNumbers(int n){
        if(n<=1) {
            System.out.println(n+"This is not a prime number.");
            return;
        }

        if(n==2){
            System.out.println(2+"This is a prime number.");
            return;
        }

        if(n%2==0){
            System.out.println(n+" This is not a prime number.");
            return;
        }
        int m = (int) Math.sqrt(n);
        for(int i = 3;i<=m;i=i+2){
            if(n%i==0){
                System.out.println(n+ "This number is not a prime number.");
                return;
            }
        }
        System.out.println(n+" This is a prime number.");

    }

    /**
     * Algorithm known as Sieve of Eratosthenes
     * @param n
     */
    private void findAllPrimeNumberInARange(int n){
        boolean [] primeArray = new boolean[n+1];
        Arrays.fill(primeArray,true);
        primeArray[0] = false;
        primeArray[1] = false;
        int m = (int)Math.sqrt(n);
        for(int i=2;i<=m;i++){
            if(primeArray[i]){
                for(int k=i*i;k<=n;k=k+i){
                    primeArray[k] = false;
                }
            }
        }

        for(int index=2;index<primeArray.length;index++){
            if(primeArray[index]){
                System.out.print(index+",");
            }
        }
    }

    /**
     * Euclids Algorithm to find the greatest common divisor(GCD).
     *
     * @param a
     * @param b
     * @return
     */
    private int findGCD(int a, int b){
        if(b==0){
            return a;
        }else{
            return findGCD(b,a%b);
        }

    }

    /**
     * Euclids theorem to find LCM
     */
    private int findLCM(int a, int b){
        return  a*b/findGCD(a,b);
    }

    /*
    This programme converts a number n into a decimal number.
     */
    private int toDecimal(int n, int b){
        int result = 0;
        int multiplier = 1;
        while (n>0){
            result = result + (n%b)*multiplier;
            multiplier = multiplier * b;
            n = (int)Math.abs(Math.floor(n/10));
        }
        return result;
    }
}
