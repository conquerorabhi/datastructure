package com.datastructure.concept;

import java.util.*;

/**
 * Created by asingh on 5/18/19.
 */
public class FindCommonCharacters {

    public static void main(String[] args){
        FindCommonCharacters fcc = new FindCommonCharacters();
        String[] val = {"cool","lock","cook"};
        System.out.println(fcc.findCommonCharactersWords(val));
    }

    public List<String> findCommonCharactersWords(String[] wordListArray){
        int characterCount = 0;
        List<HashMap<Character,Integer>> wordList = new ArrayList<HashMap<Character,Integer>>();
        HashMap<Character,Integer> wordMap = new HashMap<Character, Integer>();
        Set<Character> chSet = new HashSet<Character>();
        int chOccurenceCount = 0;
        int maxOccurence = 0;

        for(String word:wordListArray){
            HashMap<Character,Integer> chMap = new HashMap<Character, Integer>();
            for(char ch:word.toCharArray()){
                chSet.add(ch);
                if(chMap.containsKey(ch)){
                    chMap.put(ch,chMap.get(ch)+1);
                }else{
                    chMap.put(ch,1);
                }

            }
            wordList.add(chMap);
        }

        for(char ch:chSet){
            chOccurenceCount = 0;
            characterCount = 0;
            for(HashMap<Character,Integer> map:wordList){
                if(map.containsKey(ch)){
                    chOccurenceCount = chOccurenceCount + 1;
                    if(characterCount>map.get(ch)){
                        characterCount = map.get(ch);
                    }else if(map.get(ch)>0 && characterCount==0){
                        characterCount = map.get(ch);
                    }
                }
            }
            if(chOccurenceCount==wordList.size()){
               wordMap.put(ch,characterCount);
            }
        }

        Set<Map.Entry<Character,Integer>> mapEntry = wordMap.entrySet();
        Iterator<Map.Entry<Character,Integer>> entry = mapEntry.iterator();
        List<String> charList = new ArrayList<String>();
        while(entry.hasNext()){
            Map.Entry<Character,Integer> ent = entry.next();
            Character val = ent.getKey();
            for(int idx=0;idx<ent.getValue();idx++){
                charList.add(String.valueOf(val));
            }
        }
        return charList;
    }
}
