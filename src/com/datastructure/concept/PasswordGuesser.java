package com.datastructure.concept;

import java.util.*;

/**
 * Created by asingh on 8/16/19.
 */
public class PasswordGuesser {

    //input maximum length is Max value
    //if input null/empty return same string
    //any unitcode characters
    //case insensitive matching
    // return in successful case array of string

    public String[] getCorrectPasswords(String corruptedPassword,String[] possiblePasswords){
        String[] result = null;
        if(corruptedPassword==null || "".equals(corruptedPassword)){
            return result;
        }else if(corruptedPassword.length()>Integer.MAX_VALUE){
            return result;
        }

        Map<Character,List<Integer>> corruptedPasswordMap = new HashMap<>();
        List<HashMap<Character,List<Integer>>> possiblePasswordList = new ArrayList<HashMap<Character,List<Integer>>>();

        int cIndex = 0;
        for(char cValue:corruptedPassword.toCharArray()){
            List<Integer> cIndexList;
            if('-'!=cValue) {
                if (corruptedPasswordMap.containsKey(cValue)) {
                    cIndexList = corruptedPasswordMap.get(cValue);
                } else {
                    cIndexList = new ArrayList<>();

                }
                cIndexList.add(cIndex);
                corruptedPasswordMap.put(cValue, cIndexList);
            }
            cIndex++;
        }

        // Possible word List
        for(String inputWordValue:possiblePasswords){
            int index = 0;
            HashMap<Character,List<Integer>> wordMap = new HashMap<>();
            for(char value:inputWordValue.toCharArray()){
                List<Integer> indexList;
                if(wordMap.containsKey(value)){
                    indexList = wordMap.get(value);
                }else{
                    indexList = new ArrayList<>();
                }
                indexList.add(index);
                wordMap.put(value,indexList);
                index++;
            }

                int cLenghtMatch = wordMap.size();
                List<String> possible = new ArrayList<>();
                Iterator<HashMap<Character,List<Integer>>>  listIt = possiblePasswordList.iterator();
                    while (listIt.hasNext()){
                        Map<Character,List<Integer>> pCMap = listIt.next();
                        int matchCounter = 0;
                        for(Map.Entry<Character,List<Integer>> entry:wordMap.entrySet()) {
                            Character cChar = entry.getKey();
                            List<Integer> cIndexList = entry.getValue();
                            if(pCMap.get(cChar).equals(cIndexList)) {
                                matchCounter=matchCounter+1;
                            }
                        }

                        if(matchCounter==cLenghtMatch) {
                            //possible
                        }
                    }
                }

        }




    }

}
