package com.datastructure.concept;
import java.util.HashMap;
import java.util.*;

/**
 * Created by asingh on 6/12/19.
 */
public class ProblemSolving {

    public static void main(String[] args){
        ProblemSolving solving = new ProblemSolving();
        String input = "Tact Coa";

        System.out.println(solving.isStringPermutationOfPallendrome(input.toLowerCase().trim()));
    }

    public boolean isStringPermutationOfPallendrome(String input){
        boolean isPermutaion = true;
        if(input == null && "".equals(input)){
            return true;
        }
        input = input.replaceAll(" ","");
        HashMap<Character,Integer> charMap = new HashMap<Character,Integer>();
        HashMap<String,List> charFrequencyType = new HashMap<String,List>();

        char[] inputCharArray = input.toCharArray();
        for(char chValue:inputCharArray){
            if(charMap.containsKey(chValue) && !" ".equals(chValue)){
                charMap.put(chValue,charMap.get(chValue)+1);
            }else if(!" ".equals(chValue)){
                charMap.put(chValue,1);
            }
        }
        charFrequencyType.put("ODD",new ArrayList<Character>());
        charFrequencyType.put("EVEN",new ArrayList<Character>());

        Set<Map.Entry<Character,Integer>> charFrequencySet = charMap.entrySet();
        Iterator<Map.Entry<Character,Integer>> charFreqIt = charFrequencySet.iterator();
        while(charFreqIt.hasNext()){
            Map.Entry<Character,Integer> entry = charFreqIt.next();
            Character chValue = entry.getKey();
            Integer frequency = entry.getValue();
            if(frequency%2==0){
                List<String> evenList = charFrequencyType.get("EVEN");
                evenList.add(String.valueOf(chValue));
                charFrequencyType.put("EVEN",evenList);
            }else{
                List<String> oddList = charFrequencyType.get("ODD");
                oddList.add(String.valueOf(chValue));
                charFrequencyType.put("ODD",oddList);
            }
        }

        if(charFrequencyType.get("ODD").size()>1){
            isPermutaion = false;
        }

        return isPermutaion;
    }
}
