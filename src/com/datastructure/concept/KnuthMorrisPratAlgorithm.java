package com.datastructure.concept;

/**
 * Created by asingh on 6/18/19.
 *
 *
 * Step-1: create a LPS array :
 *  LPS array size is equals to pattern size.
 *  update LPS[0] = 0;
 *  begin loop from lpsArrayIndex = 1 and j=0 till lpsIndex<patternLEngth
 *  if(pattern.charAt[lpsIndex] == pattern.charAt(j)
 *      lps[lpsIndex] = j+1;
 *  else if j!=0
 *      j = lps[lpsIndex-1]
 *  else if j==0
 *      lps[lpsIndex] = j;
 *      lpsIndex++;
 *Step2 -
 * Begin loop input string index<length of the string and pIndex(patternIndex)<pattern.length()
 *  if(input.charAt(index) == pattern.charAt(pIndex))
 *      index++;pIndex++;
 *  else if index != 0
 *      pIndex = lps[index-1]
 *  else
 *      index = index + 1
 *
 */
public class KnuthMorrisPratAlgorithm {

    public static void main(String[] args){
        KnuthMorrisPratAlgorithm prattAlgorithm = new KnuthMorrisPratAlgorithm();
        System.out.println(prattAlgorithm.isPatternExist("abcdefij","abcd"));
    }

    public boolean isPatternExist(String input,String pattern){
        boolean isPatternExist = false;
        int index = 0;
        int len = input.length();
        int pIndex = 0;
        int[] lps = new int[pattern.length()];
        createLps(input,pattern,lps);

        while(index<len && pIndex<pattern.length()){
            if(input.charAt(index)==pattern.charAt(pIndex)){
                if(pIndex==pattern.length()-1){
                    System.out.println("Match Found "+(index-pIndex));
                    return true;
                }
                index++;
                pIndex++;

            }else{
                if(index!=0){
                    pIndex = lps[pIndex-1];
                }else{
                    index = index + 1;
                }
            }
        }
        return isPatternExist;
    }


    public void createLps(String input,String pattern,int[] lps){
        int lpsIndex = 1;
        lps[0] = 0;
        int j = 0;
        while (lpsIndex<pattern.length()){

         if(pattern.charAt(j)==pattern.charAt(lpsIndex)){
             lps[lpsIndex] = j + 1;
             j++;
             lpsIndex++;
         }else {
             if(j!=0){
                 j = lps[lpsIndex-1];
             }else{
                 lps[lpsIndex] = j;
                 lpsIndex++;
             }
         }

        }
    }
}
