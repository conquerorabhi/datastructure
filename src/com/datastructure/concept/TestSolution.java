package com.datastructure.concept;

import apple.laf.JRSUIUtils;

import java.util.*;

/**
 * Created by asingh on 12/8/18.
 */
public class TestSolution {

    public static void main(String[] args){
        Stack<Integer> test = new Stack<>();
        Solution.ListNode node3 = new Solution.ListNode(1);
        Solution.ListNode node2 = new Solution.ListNode(8);
        Solution.ListNode node1 = new Solution.ListNode(3);
        node2.setNext(node3);
        node1.setNext(node2);

        //Solution.ListNode node23 = new Solution.ListNode(4);
        Solution.ListNode node22 = new Solution.ListNode(7);
        Solution.ListNode node12 = new Solution.ListNode(1);
        //node22.setNext(node23);
        node12.setNext(node22);

        Solution sol = new Solution();
        Solution.ListNode sNode = sol.addTwoNumbers(node1,node2);
        sol.printList(sNode);

        ///System.out.println(System.currentTimeMillis()-(1*24*60*60*1000));

        TestSolution tst = new TestSolution();
        tst.numJewelsInStones("aA","aAAbbbb");
        String[] arg = {"","tea",""};
        char[] chArray = "team".toCharArray();
        Arrays.sort(chArray);
        String pal = "PAYPALISHIRING";
        System.out.println(tst.convertToString(pal,3));

        TreeNode root = new TreeNode(4);
        TreeNode rootLeftChild = new TreeNode(2);

        TreeNode leftChildLeftChild = new TreeNode(1);
        TreeNode leftChildRightChild = new TreeNode(3);
        rootLeftChild.left = leftChildLeftChild;
        rootLeftChild.right = leftChildRightChild;

        TreeNode rightChild = new TreeNode(7);
        root.left = rootLeftChild;
        root.right = rightChild;

        int[][] A = {{1,1,0,1},{1,0,1,1},{0,0,0,1}};

        tst.flipAndInvertImage(A);
        int[] num1={0};
        int[] num2={1};
        tst.findMedianSortedArrays(num1,num2);
        tst.mergeTwoSortedArrays(num1,num2);
        tst.merge(num1,0,num2,1);
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t1Left = new TreeNode(3);
        TreeNode t1Right = new TreeNode(2);

        t1.left = t1Left;
        t1.right = t1Right;

        TreeNode t2Left = new TreeNode(3);
        TreeNode t2Right = new TreeNode(2);

        t2.left = t2Left;
        t2.right = t2Right;

        tst.mergeTwoBinaryTree(t1,t2);
        int[] nums = {-1,0,1,-2,3,4};
        //tst.threeSum1(nums);

        int[][] points = {{1,3},{-2,2}};
        tst.kClosest(points,1);

        tst.printAllPrime(10);
        System.out.println(tst.isPrime(1001));
        int[] memo = new int[6];
        tst.calFibonaci(50);

        RunnableDemo demoThread = new RunnableDemo();
        Thread testThread = new Thread(demoThread);

        testThread.start();

        ThreadDemo demoThread2 = new ThreadDemo();
        demoThread2.start();

        TestSolution sol1 = new TestSolution();
        System.out.println("Fibonacci Number: "+sol1.calNthFibonaccci(3));
    }

    public List<List<String>> convertingStringToMap(String[] args){
        List<List<String>> result = new ArrayList<>();
        HashMap[] chMap = new HashMap[args.length];
        for(int index=0;index<args.length;index++){
            HashMap<Character,Integer> cMap = new HashMap<>();
            if(args[index]!=null){
                char[] input = args[index].toCharArray();
                for(char value:input){
                    if(cMap.containsKey(value)){
                        cMap.put(value,cMap.get(value)+1);
                    }else {
                        cMap.put(value,1);
                    }
                }
            }
            chMap[index] = cMap;
        }

        for(int index=0;index<chMap.length;index++){
            HashMap<Character,Integer> vMap = chMap[index];
            List<String> anaWord = new ArrayList<>();
            for(int nIndex=0;nIndex<chMap.length;nIndex++){
                if(isAnargon(chMap[index],chMap[nIndex])){
                    if(anaWord.indexOf(chMap[nIndex])==-1){
                        anaWord.add(args[nIndex]);
                    }
                }
            }
            if(anaWord.size()>0 && result.indexOf(anaWord)==-1) {
                result.add(anaWord);
            }
        }

        return result;
    }

    public boolean isAnargon(HashMap<Character,Integer> word, HashMap<Character,Integer> anargomWord){
        if(word.size()==0 && anargomWord.size()==0){
            return true;
        }else if(word.size()==0 && anargomWord.size()!=0){
            return false;
        }
        Set<Character> key = word.keySet();
        Iterator<Character> chIt = key.iterator();
        boolean isNotAnargom = true;
        while(chIt.hasNext()){
            Character keyValue = chIt.next();
            if(word.get(keyValue)!=anargomWord.get(keyValue)){
                isNotAnargom = false;
            }
        }

        return isNotAnargom;
    }


    public int numJewelsInStones(String J, String S) {
        if(J==null || S==null){
            return 0;
        }else if(J.equals("")||S.equals("")){
            return 0;
        }
        HashMap<Character,Integer> chMap = new HashMap<Character,Integer>();
        for(int index=0;index<S.length();index++){
            if(chMap.containsKey((Character)S.charAt(index))){
                chMap.put((Character)S.charAt(index),chMap.get(S.charAt(index))+1);
            }else{
                chMap.put((Character)S.charAt(index),1);
            }
        }
        int totalJwels = 0;
        for(int index=0;index<J.length();index++){
            if(chMap.containsKey(S.charAt(index))) {
                totalJwels = totalJwels + chMap.get((Character) S.charAt(index));
            }
        }
        return totalJwels;
    }

    public List<List<String>> findGroupAnagrams(String[] strs){
        List<List<String>> res = new ArrayList<>();
        for(int index=0;index<strs.length;index++){

                List<String> anargomWords = new ArrayList<>();
                for (int counter = 0; counter < strs.length; counter++) {
                    if (isAnargom(strs[index], strs[counter])) {
                        if (!isThisAlreadyIncluded(strs[counter], res)) {
                            anargomWords.add(strs[counter]);
                        }

                    }
                }
                if (anargomWords.size() > 0) {
                    res.add(anargomWords);
                }

        }

        return res;
    }

    public boolean isAnargom(String word,String anargom){
        if(anargom.equals(word)){
            return true;
        }
        char[] wordCharArray = word.toCharArray();
        boolean isAnargom = true;
        if(wordCharArray.length==0){
            isAnargom = false;
        }
        for(int index=0;index<wordCharArray.length;index++){
            if(wordCharArray.length==anargom.length()){
                if(anargom.indexOf(wordCharArray[index])==-1){
                    isAnargom = false;
                }
            }else{
                isAnargom = false;
            }
        }
        char[] wordArray = anargom.toCharArray();
        for(int index=0;index<wordArray.length;index++){
            if(wordArray.length==word.length()){
                if(word.indexOf(wordArray[index])==-1){
                    isAnargom = false;
                }
            }else{
                isAnargom = false;
            }
        }
        return isAnargom;
    }

    public boolean isThisAlreadyIncluded(String word,List<List<String>> res){
        Iterator<List<String>> listIterator = res.listIterator();
        while(listIterator.hasNext()){
            List<String> wList = listIterator.next();
            if(wList.contains(word)){
                return true;
            }
        }
        return false;
    }

    public List<List<String>> findGroupAnargram(String[] strs){
        List<List<String>> anaGroupList = new ArrayList<>();
        HashMap<String,String> dicMap = new HashMap<String,String>();
        if(strs.length==0){
            return anaGroupList;
        }
        for(int index=0;index<strs.length;index++) {
            List<String> anaWordList = new ArrayList<>();
            if(strs[index]!=null && !dicMap.containsKey(strs[index])){
                char[] value = strs[index].toCharArray();
                Arrays.sort(value);
                String match = new String(value);
                if (anaWordList.indexOf(match) == -1) {
                    for (int pIndex = 0; pIndex < strs.length; pIndex++) {
                        if (strs[pIndex] != null && !dicMap.containsKey(strs[pIndex])) {
                            char[] input = strs[pIndex].toCharArray();
                            Arrays.sort(input);
                            String vMatch = new String(input);
                            if (vMatch.equals(match)) {
                                if (!dicMap.containsKey(strs[pIndex])) {
                                    dicMap.put(strs[pIndex], strs[index]);
                                }
                                anaWordList.add(strs[pIndex]);
                                strs[pIndex] = null;
                            }
                        } else if(strs[pIndex]!=null){
                            anaWordList.add(strs[pIndex]);
                            strs[pIndex] = null;
                        }
                    }
                    if (anaWordList.size() > 0 && anaGroupList.indexOf(anaWordList) == -1) {
                        anaGroupList.add(anaWordList);
                    }
                }
            }
        }

        return anaGroupList;
    }

    public List<List<String>> findGroupAnargramNew(String[] strs){
        HashMap<String,List<String>> anargomWordMap = new HashMap<>();
        List<List<String>> wordList = new ArrayList<>();
        for(String word :strs){
            char[] wordArray = word.toCharArray();
            Arrays.sort(wordArray);
            String keyWord = new String(wordArray);
            if(anargomWordMap.containsKey(keyWord)){
                List<String> anaWordList = anargomWordMap.get(keyWord);
                anaWordList.add(word);
            }else{
                List<String> anaWordList = new ArrayList<>();
                anaWordList.add(word);
                anargomWordMap.put(keyWord,anaWordList);
            }
        }
        Set<String> wordListIt = anargomWordMap.keySet();
        Iterator<String> key = wordListIt.iterator();
        while(key.hasNext()){
            wordList.add(anargomWordMap.get(key.next()));
        }
        return wordList;
    }

    public String findLongestPallendrome(String s){
        if(s.length()==0||s.length()==1||s.length()==2 && s.charAt(0)==s.charAt(1)){
            return s;
        }else if(s.length()==2 && s.charAt(0)!=s.charAt(1)){
            String val= s.charAt(0)+"";
            return val;
        }

        int key = 0;
        int left = 0;
        int right = 0;
        if(s.length()%2==0){
          key = 0;
          left=0;
          right=0;
        }else{
            key = 1;
            left = key-1;
            right = key+1;
        }
        String longestPallindrome = null;

        while(key<s.length() && left>=0 && right<s.length()){
            String tempLongestPal = null;
            if(s.charAt(left) == s.charAt(right)){
                if(right+1<s.length()){
                    tempLongestPal = s.substring(left,right+1);
                }else{
                    tempLongestPal = s.substring(left,right)+s.charAt(2);
                }
                if(left>0){
                    left = left-1;
                }
                if(right<s.length()){
                    right = right + 1;
                }
            }else if(s.charAt(left)==s.charAt(key)){
                tempLongestPal = s.substring(left,key+1);
                key = key + 1;
                left=key-1;
                right=key+1;

            }else if(s.charAt(right)==s.charAt(key)){
                tempLongestPal = s.substring(key,right+1);
                key = key + 1;
                left=key-1;
                right=key+1;
            }else{
                key = key + 1;
                left=key-1;
                right=key+1;
            }
            if(longestPallindrome!=null && tempLongestPal!=null && tempLongestPal.length()>=longestPallindrome.length()){
                longestPallindrome = tempLongestPal;
            }else if(longestPallindrome==null){
                longestPallindrome = tempLongestPal;
            }



        }
        if(longestPallindrome==null && s.length()>0){
            longestPallindrome=s.charAt(0)+"";
        }
        return longestPallindrome;
    }

    public String convertToString(String s,int n){
        List[] zigZagList = new List[n];
        int row = 0;
        boolean moveUp = true;

        for(int index=0;index<s.length();index++){
            if(zigZagList[row]==null){
                List<Character> list = new ArrayList<>();
                list.add(s.charAt(index));
                zigZagList[row] = list;
            }else{
                zigZagList[row].add(s.charAt(index));
            }

            if(moveUp){
                if(row==n-1){
                    moveUp = false;
                    row = row -1;
                }else{
                    row=row+1;
                }

            } else if(!moveUp){
                if(row==0){
                    moveUp = true;
                    row = row + 1;
                }else{
                    row = row -1;
                }

            }
        }
        StringBuilder builder = new StringBuilder();
        for(int pIndex=0;pIndex<zigZagList.length;pIndex++){
            List<Character> zigChar = zigZagList[pIndex];
           Iterator<Character> chIt = zigChar.iterator();
            while (chIt.hasNext()){
                builder.append(chIt.next());
            }
        }
        return builder.toString();

    }

    public TreeNode searchBST(TreeNode root, int val) {

        while (root!=null){
            if(val<root.val){

            }else if(val>root.val){

            }else if(val==root.val){

            }
        }
        return null;
    }

    public TreeNode searchNode(TreeNode root,int val){
        System.out.println(root.val);
        if(root!=null && root.val==val){
            return root;
        }else if(root!=null) {
            if(root != null && root.left!=null){
               root = searchNode(root.left,val);
                if(root!=null){
                    return root;
                }
            }

            if(root != null && root.right!=null){
               root = searchNode(root.right,val);
                if(root!=null){
                    return root;
                }
            }
        }
        return null;
    }

    public int[][] flipAndInvertImage(int[][] A) {
        for(int row=0;row<A.length;row++){
            int columns = A[row].length;
            int j = columns-1;
            int mid = 0;
            if(columns%2==0){
                mid = columns/2;
            }else{
                mid = (int)Math.abs(Math.floor(columns/2))+1;
            }
            for(int pIndex=0;pIndex<mid;pIndex++){
                int temp = A[row][pIndex];
                if(pIndex==j){
                    int tempValue = A[row][pIndex];
                    A[row][pIndex] = tempValue==1?0:1;
                }else {
                    A[row][pIndex] = A[row][j] == 1 ? 0 : 1;
                    A[row][j] = temp == 1 ? 0 : 1;
                    System.out.println(A[row][pIndex]);
                }
                j=j-1;

            }
        }
        return A;
    }

    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        if(nums1.length==0 && nums2.length==0){
            return 0.0;
        }

        int sum1 = 0;
        float median1 = 0.0f;
        int sum2 = 0;
        float median2 = 0.0f;
        float length1 = nums1.length;
        for(int index=0;index<nums1.length;index++){
            sum1 = sum1+nums1[index];
        }
        if(nums1.length>0){
            median1 = sum1/length1;
        }
        float length2 = nums2.length;
        for(int pIndex=0;pIndex<nums2.length;pIndex++){
            sum2 = sum2+nums2[pIndex];
        }
        if(nums2.length>0){
            median2 = sum2/length2;
        }
        double ts = (median1+median2)/2.0;
        return Math.ceil((median1+median2)/2);
    }

    public double findMedian(int[] nums1,int[] nums2){
        double median = 0.0f;

        int length1 = nums1.length;
        int length2 = nums2.length;

        if(length1==0 && length2!=0) {
            if(length2%2==0){
                median = (nums2[length2/2-1]+nums2[length2/2])/2.0;
            }else{
                median = (nums2[length1/2+1])/2.0;
            }
            return median;
        } else if (length2==0 && length1!=0) {
            if(length1%2==0){
                median = (nums1[length1/2-1]+nums1[length1/2])/2.0;
            }else{
                median = (nums1[length1/2+1])/2.0;
            }
            return median;
        }
        int median1 = length1%2==0?(length1/2):(length1/2+1);
        int median2 = length2%2==0?(length2/2):(length2/2+1);
        int i=0;int j=0;
        if(nums1[length1-1]<nums2[length2-1]){
            i=median1;
            int numberOFelements1 = length1-median1;
            j=median2;
            int numberOfElements2 = median2;
            int sum = numberOFelements1 + numberOfElements2;
            if(sum%2==0){
                int med1 = sum/2;
                int med2 = sum/2+1;
                if(i+med1>length1){
                    med1 = nums2[(i+med1)-length1];
                    med2 = nums2[(i+med1+1)-length1];
                    median = (med1+med2)/2.0;
                }else{
                    if(i+med1+1>length1){
                        med2 = nums2[i+med1+1-length1];
                    }else{
                        med2 = nums2[i+med1+1];
                    }
                }

            }else{
                int med2 = sum/2+1;
                if(i+med2>length1){
                    median = (nums2[(i+med2+1)-length1])/2.0;
                }else{

                    median = nums1[i+med2+1]/2.0;

                }
            }
        }
        return median;

    }

    /**
     *
     * @param nums1
     * @param nums2
     * @return
     *
     * Algorithm:
     * Partition both arrays in such a way that number of elements in left partition of array 1 and array 2 == number of elements in right partition of array1 and array2.
     * After finding this condition finding median is based on following condition.
     * If total length of both arrays is odd then median = Math.max(array1[partition1-1],array2[partition2-1]);
     * If total length of both arrays is even then median = Avg (Max(array1[partition1-1],array2[partition2-1])+Min(array1[partition1],array2[partition2]))
     *
     * Do Binary search on smaller array :
     * low = 0;
     * high = smallerArray.length;
     *
     * while(low<=high){
     *     int partitionX = (low+high)/2;
     *     int partitionY = (array1.length+array2.length+1)/2-partitionX;
     *
     *     int maxLeftX = partitionX==0?Integer.MIN_VALUE:array1[partitionX-1];
     *     int minRightX = partionX==array1.length?Integer.MAX_VALUE:array2[partitionX];
     *
     *     int maxLeftY = partitionY==0?Integer.MIN_VALUE:array2[partitionY-1];
     *     int minRightY = partitionY==array2.length?Integer.MAX_VALUE:array2[partitionY];
     *
     *     if(maxLeftX<=minRightY && maxLeftY<=minRightY)
     *       then check total length of the two arrays if odd then median = Max(maxLeftX,maxLeftY)
     *       else AVg(Math.max(maxLeftX,maxLeftY)+Math.min(minRightX,minRightY))
     *     else if maxLeftX>minRightY{
     *         low = partitionX-1;
     *     }else{
     *         low - partitionX+1;
     *     }
     *
     * }
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            return  findMedianSortedArrays(nums2,nums1);
        }
        int start = 0;
        int end = nums1.length;
        int total = nums1.length+nums2.length;
        double median = 0.0d;
        while(start<=end){
            int partition1 = (start+end)/2;
            int partition2 = (nums1.length+nums2.length+1)/2-partition1;

            int minLeft1 = partition1==0?Integer.MIN_VALUE:nums1[partition1-1];
            int maxLeft1 = partition1==nums1.length?Integer.MAX_VALUE:nums1[partition1];

            int minLeft2 = partition2==0?Integer.MIN_VALUE:nums2[partition2-1];
            int maxLeft2 = partition2==nums2.length?Integer.MAX_VALUE:nums2[partition2];

            if(minLeft1<=maxLeft2 && minLeft2<=maxLeft1){
                if(total%2==0){
                    median = (Math.max(minLeft1,minLeft2)+Math.min(maxLeft1,maxLeft2))/2;
                }else{
                    median = Math.max(minLeft1,minLeft2);
                }
                return median;
            }else if(minLeft1>maxLeft2){
                end = partition1-1;
            }else{
                start = partition1+1;
            }
        }
        return median;
    }

    public int[] mergeTwoSortedArrays(int[] nums1,int [] nums2){
        if(nums1.length==0){
            return nums2;
        }else if(nums2.length==0){
            return nums1;
        }
        int[] mergedArray = new int[nums1.length+nums2.length];
        int i=0,j=0;
        for(int index=0;index<mergedArray.length;index++){
            if(i<nums1.length && j<nums2.length && nums1[i]<=nums2[j]){
                mergedArray[index] = nums1[i];
                i = i + 1;
            }else if(i<nums1.length && j<nums2.length && nums2[j]<nums1[i]){
                mergedArray[index] = nums2[j];
                j = j + 1;
            }else if(i==(nums1.length) && j<nums2.length){
                mergedArray[index] = nums2[j];
                j = j + 1;
            }else if(j==(nums2.length) && i<nums1.length){
                mergedArray[index] = nums1[i];
                i = i + 1;
            }
        }
        return mergedArray;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums1.length == 0){
            return;
        }else if(nums2.length == 0){
            return;
        }
        if(nums2.length<nums1.length){
            merge(nums2,n,nums1, m);
        }
        int j = 0;
        for(int index=0;index<nums1.length;index++){
            System.out.println("Index :"+index);
            for(int pIndex=index;pIndex<nums2.length;pIndex++){
                if(nums1[index]!=0 && nums1[index]<=nums2[pIndex] && pIndex<n){
                    replaceInArray(pIndex,nums1[index],nums2);
                    n = n + 1;
                    break;
                }else if(pIndex>=n){
                    replaceInArray(pIndex,nums1[index],nums2);
                    n = n + 1;
                    break;
                }
            }
        }
    }

    public void replaceInArray(int pIndex,int value,int[] nums){
        int nextValue = 0;
        for(int index=pIndex;index<nums.length;index++){
            if(index==pIndex){
                nextValue = nums[index];
                nums[index] = value;
            }else{
                int temp = nums[index];
                nums[index] = nextValue;
                nextValue = temp;
            }
        }
    }

    public TreeNode mergeTwoBinaryTree(TreeNode node1 , TreeNode node2){
        if(node1!=null && node2!=null){
            node1.val = node1.val + node2.val;
        }else if(node1 == null && node2!=null){
            node1 = new TreeNode(node2.val);
        }
        if(node1.left!=null || node2.left!=null) {
            mergeTwoBinaryTree(node1 != null ? node1.left : null, node2 != null ? node2.left : null);
        }
        if(node1.right!=null || node2.right!=null) {
            mergeTwoBinaryTree(node1 != null ? node1.right : null, node2 != null ? node2.right : null);
        }
        return node1;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length==0){
            return result;
        }


        for(int index=0;index<nums.length-2;index++){
            for(int pIndex=index+1;pIndex<nums.length-1;pIndex++){
                for(int count=pIndex+1;count<nums.length;count++){
                    if(nums[index]+nums[pIndex]+nums[count]==0){
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(nums[index]);
                        list.add(nums[pIndex]);
                        list.add(nums[count]);
                        Collections.sort(list);
                        if(list.size()>0 && !result.contains(list)){
                            result.add(list);
                        }
                    }
                }
            }
        }
        return result;
    }

//    public List<List<Integer>> threeSum1(int[] nums) {
//        List<List<Integer>> result = new ArrayList<>();
//        List<Integer> numList = new ArrayList<>();
//        Arrays.sort(nums);
//        for(int index=0;index<nums.length-1;index++){
//            if(!numList.contains(nums[index]) && nums[index]!=nums[index+1]){
//                numList.add(nums[index]);
//                int j=index+1;
//                int k=j+1;
//                while(j<nums.length-2 && k<nums.length){
//                    if(nums[j]!=nums[j+1]){
//                        if(k<=nums.length-1 && nums[k]!=nums[k+1]){
//                            List<Integer> uniqueList = new ArrayList<>();
//                            if(nums[index]+nums[j]+nums[k]==0){
//                                uniqueList.add(nums[index]);
//                                uniqueList.add(nums[j]);
//                                uniqueList.add(nums[k]);
//                                result.add(uniqueList);
//                                k=k+1;
//                            }else{
//                                if(k==nums.length-1 && j<=nums.length-2){
//                                    j=j+1;
//                                }else{
//                                    k=k+1;
//                                }
//                            }
//                        }else{
//                            k=k+1;
//                        }
//                    }else{
//                        j=j+1;
//                    }
//                }
//            }
//
//        }
//
//        return result;
//    }

    public int getNestedSum(){
        HashMap<Integer,Integer> map = new HashMap<>();
        Set<Map.Entry<Integer,Integer>> tmpSet = map.entrySet();
        Iterator<Map.Entry<Integer,Integer>> it= tmpSet.iterator();
        while(it.hasNext()){
            Map.Entry<Integer,Integer> eVal = it.next();
           // eVal.
        }
        return 1;
    }

    public int repeatedNTimes(int[] A) {

        if(A.length==0){
            return 0;
        }
        HashMap<Integer,Integer> intMap = new HashMap<Integer,Integer>();

        for(int index=0;index<intMap.size();index++){
            if(intMap.containsKey(A[index])){
                intMap.put(A[index],(intMap.get(A[index]))+1);
            }else{
                intMap.put(A[index],1);
            }
        }
        int key = A.length/2;
        int result = 0;
        Set<Map.Entry<Integer,Integer>> eSet = intMap.entrySet();
        Iterator<Map.Entry<Integer,Integer>> it= eSet.iterator();
        while(it.hasNext()){
            Map.Entry eVal = it.next();
            if((int)eVal.getValue()==key){
                result = (int)eVal.getKey();
            }
        }
        return result;
    }

    public int[][] kClosest(int[][] points, int K) {
        int[][] closestPoint = new int[K][2];
        if(points.length==0){
            return closestPoint;
        }

        int row = points.length;
        int columns = points[0].length;
        HashMap<Double,String> distanceMap = new HashMap<Double,String>();
        Set<Double> distanceSet = new TreeSet<Double>();

        for(int rIndex=0;rIndex<row;rIndex++){
            double distanceFromOrigine = Math.sqrt(Math.pow(points[rIndex][0],2)+Math.pow(points[rIndex][1],2));
            distanceSet.add(distanceFromOrigine);
            distanceMap.put(distanceFromOrigine,points[rIndex][0]+"#"+points[rIndex][1]);
        }

        Iterator<Double> setIt = distanceSet.iterator();

        int counter = 0;
        int index = 0;
        while(setIt.hasNext()){
            if(counter==K){
                break;
            }else{
                String indexValue = distanceMap.get(setIt.next());
                String[] stArr = indexValue.split("#");
                closestPoint[index][0]=Integer.parseInt(stArr[0]);
                closestPoint[index][1]=Integer.parseInt(stArr[1]);
                index=index+1;
                counter= counter+1;
            }
        }
        return closestPoint;
    }

    public ListNode deleteNodeFromLinkedList(ListNode node,int nodeVal){

        if(node!=null && node.val==node.val){
            return node.next;
        }

        while(node.next!=null){
            if(node.next.val == nodeVal){
                node.next = node.next.next;
                return node;
            }
            node = node.next;
        }
        return node;
    }
    public boolean isPrime(int n){
        boolean isPrime = false;
        if(n==1){
            return true;
        }else if(n==2){
            return true;
        }else {
            int m = (int)Math.sqrt(n);
            for(int i=3;i<=m;i=i+1){
                if(n%i==0){
                    return false;
                }
            }
        }
        return true;
    }

    public void printAllPrime(int n){
        boolean[] prime = new boolean[n+1];
        Arrays.fill(prime,true);
        prime[0]=false;
        prime[1]=false;

        for(int i=2;i<n;i++){
            if(prime[i]){
                for(int k=i*i;k<=n;k=k+i){
                    prime[k] = false;
                }
            }
        }

        for(int index = 0;index<=n;index++){
            if(prime[index]){
                System.out.print(index+",");
            }
        }

    }

    public void calFibonaci(int n){
        int t1 = 0;
        int t2 = 1;
        int i=0;
        while (t1<=n){
            i=i+1;
            System.out.println(t1);
            int sum = t1 + t2;
            t1 = t2;
            t2 = sum;
        }
    }

    public int partition(int[] input,int left,int right){
        if(left==right){
            return left;
        }
        int pivote = (left+right)/2;
        while(left<=right){

            while(input[left]<input[pivote]) left++;
            while(input[right]>input[pivote]) right--;

            if(left<=right){
                swap(input,left,right);
                left++;
                right--;
            }
        }
        return left;
    }

    public void quickSort(int[] input,int left, int right){
        int index = partition(input,left,right);

        if(left<index-1){
            quickSort(input,left,index-1);
        }

        if(right>index){
            quickSort(input,index,right);
        }
    }

    private void swap(int[] input,int left,int right){
        int temp = input[left];
        input[left] = right;
        input[right] = temp;
    }

    public int calNthFibonaccci(int n){

        if(n<=2){
            return 1;
        }

        return calNthFibonaccci(n-1)+calNthFibonaccci(n-2);

    }


}
