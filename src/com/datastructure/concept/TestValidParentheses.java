package com.datastructure.concept;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by asingh on 5/18/19.
 */
public class TestValidParentheses {

    public static void main(String[] args){
        TestValidParentheses parentheses = new TestValidParentheses();
        String input = "(()())(())(()(()))";
        System.out.println(parentheses.findValidParentheses(input));
    }

    public String findValidParentheses(String S){
        String result = "";
        if(S==null){
            return "Invalid String";
        }else if("".equals(S)){
            return S;
        }else {
            List<String> indexList = new ArrayList<String>();
            Stack<Character> charStack = new Stack<Character>();
            int startingIndex = 0;
            int endIndex = 0;
            int index = 0;
            char[] inputCharArray = S.toCharArray();
            for(char element:inputCharArray){
                if('('==element){
                    charStack.push(element);
                }else if(')'== element){//
                    charStack.pop();
                }

                if(index>0 && charStack.size()==0 && endIndex-startingIndex>2){
                    System.out.println("StartIndex :"+startingIndex+" EndIndex :"+(endIndex-1));
                    indexList.add(startingIndex+"#"+endIndex);
                    startingIndex = index;
                    endIndex = index;
                }
                index = index + 1;
                endIndex = endIndex + 1;

            }
            int endIdx = 0;
            for(String indexElement:indexList){
                String[] indexArray = indexElement.split("#");
                int stIndex = Integer.parseInt(indexArray[0])+1;
                int endIndx = Integer.parseInt(indexArray[1]);
                if(endIndx<(S.length()-1)){
                    result = result+S.substring(stIndex,endIndx);
                }else if(endIndx==S.length()-1){
                    result = result+S.substring(stIndex);
                }

                endIdx = Integer.parseInt(indexArray[1]);
            }
            if(endIdx<S.length()-1){
                result = result+S.substring(endIdx);
            }
        }
        return result;
    }
}
