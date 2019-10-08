package com.datastructure.concept;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by asingh on 6/6/19.
 */
public class FindSecondHighestRepetiton {

    public static void main(String[] args){
        FindSecondHighestRepetiton test = new FindSecondHighestRepetiton();
        System.out.println(test.findSecondHighestRepeatedCharacter("abcdeabcdaad"));

        System.out.println(test.findSecondMostRepetition("abcdeabcdaad"));
    }

    public Character findSecondHighestRepeatedCharacter(String input){
        if(input==null || "".equals(input)){
            return null;
        }

        char[] charArray = input.toCharArray();
        HashMap<Character,Integer> charDict = new HashMap<Character,Integer>();
        for(char ch :charArray){
            if(charDict.containsKey(ch)){
                charDict.put(ch,charDict.get(ch)+1);
            }else{
                charDict.put(ch,1);
            }
        }

        int maxOccur=0;
        int secondMax=0;
        Character keyValue = null;
        Set<Map.Entry<Character,Integer>> charSet = charDict.entrySet();
        Iterator<Map.Entry<Character,Integer>> charIterator = charSet.iterator();
        while(charIterator.hasNext()){
            Map.Entry<Character,Integer> entry = charIterator.next();
            Character key = entry.getKey();
            Integer noOfOccurences = entry.getValue();

            if(noOfOccurences>maxOccur){
                maxOccur = noOfOccurences;
            }else if(noOfOccurences>secondMax){
                secondMax = noOfOccurences;
                keyValue = key;
            }
        }
        return keyValue;
    }

    public Character findSecondMostRepetition(String input){
        if(input==null||"".equals(input)){
            return null;
        }

        HashMap<Character,Integer> charMap = new HashMap<Character,Integer>();
        HashMap<String,String> maxRepetition = new HashMap<String,String>();

        char[] chArray = input.toCharArray();
        for(char ch:chArray){
            if(charMap.containsKey(ch)){
                charMap.put(ch,charMap.get(ch)+1);
            } else {
                charMap.put(ch,1);
            }
        }
        int maxOcc = 0;
        int secondMax = 0;
        Set<Map.Entry<Character,Integer>> charSet = charMap.entrySet();
        Iterator<Map.Entry<Character,Integer>> charSetIt = charSet.iterator();
        while(charSetIt.hasNext()){
            Map.Entry<Character,Integer> entry = charSetIt.next();
            Integer noOfOccurences = entry.getValue();
            Character keyValue = entry.getKey();
            if(maxOcc<noOfOccurences){
                maxOcc = noOfOccurences;
            }else if(noOfOccurences>=secondMax){
                secondMax = noOfOccurences;
                if(maxRepetition.containsKey("SecondMax")){
                    maxRepetition.put("SecondMax",maxRepetition.get("SecondMax")+","+keyValue);
                }else{
                    maxRepetition.put("SecondMax",String.valueOf(keyValue));
                }
            }
        }

        String secondMaxRepetition = maxRepetition.get("SecondMax");
        return secondMaxRepetition.charAt(secondMaxRepetition.length()-1);
    }
}
