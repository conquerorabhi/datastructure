package com.datastructure.concept;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by asingh on 6/15/19.
 */
public class TrieNode {

    public static void main(String[] args){
        TrieNode node = new TrieNode();

        node.insertWordRecursive("abcd",node,0);
        node.insertWord("nfm",node);
        node.printTrieNode(node);

        System.out.println("Is Prefix Exist :"+node.isPrefixExist("abcd",node,0));
        node.delete("nfm");
        node.printTrieNode(node);
    }

    boolean isEndOfWord ;
    HashMap<Character,TrieNode> children;

    public TrieNode (){
        isEndOfWord = false;
        children = new HashMap<Character, TrieNode>();
    }

    public void insertWordRecursive(String word, TrieNode root,int index){
            TrieNode current = root;
            char chValue = word.charAt(index);
            TrieNode childNode = current.children.get(chValue);
            if (childNode == null) {
                childNode = new TrieNode();
                if (index == word.length() - 1) {
                    childNode.isEndOfWord = true;
                }
                current.children.put(chValue, childNode);
                current = childNode;
            }
            if(index<word.length()-1) {
                insertWordRecursive(word, current, index + 1);
            }
    }

    public void insertWord(String word,TrieNode rootNode){
        char[] charArr = word.toCharArray();
        TrieNode currentNode = rootNode;
        for(int index=0;index<charArr.length;index++){
            char chValue = charArr[index];
            TrieNode childNode = currentNode.children.get(chValue);
            if(childNode==null){
                childNode = new TrieNode();
                if (index == word.length() - 1) {
                    childNode.isEndOfWord = true;
                }
                currentNode.children.put(chValue, childNode);
                currentNode = childNode;
            }else{
                currentNode = childNode;
            }
        }
    }

    public boolean isPrefixExist(String word,TrieNode node,int index){
        HashMap<Character,TrieNode> children = node.children;
        TrieNode childNode = children.get(word.charAt(index));
        if(childNode!=null){
            if(word.length()-1==index){
                return true;
            }else {
                return isPrefixExist(word, childNode, index + 1);
            }
        }
        return false;
    }

    public void printTrieNode(TrieNode node){
        HashMap<Character,TrieNode> children = node.children;
        for(Map.Entry<Character,TrieNode> entry:children.entrySet()){
            System.out.println("Character :"+entry.getKey());
            printTrieNode(entry.getValue());
        }
    }

    public void delete(String word){
        TrieNode rootNode = this;
        deleteWordFromTrie(word,rootNode,0);
    }

    public boolean deleteWordFromTrie(String word,TrieNode current,int index){
      //This one to check last node and setting endOfWord
      if(index == word.length()){
          if(current.isEndOfWord){
              current.isEndOfWord = false;
          }
          return current.children.size()==0;
      }
      //Otherwise get child node
      HashMap<Character,TrieNode> children = current.children;
      TrieNode childNode = children.get(word.charAt(index));
      boolean isDeleteParentNode = deleteWordFromTrie(word,childNode,index+1);

      if(isDeleteParentNode){
          current.children.remove(word.charAt(index));
      }
      return current.children.size()==0;
    }
}
