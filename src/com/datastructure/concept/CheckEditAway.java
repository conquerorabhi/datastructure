package com.datastructure.concept;

/**
 * Created by asingh on 5/29/19.
 */
public class CheckEditAway {

    public static void main(String [] args){

        CheckEditAway editAway = new CheckEditAway();
        System.out.println(editAway.isOneEditAway("Pales","Pale"));

    }

    boolean isOneEditAway(String wordToMatch,String wordToEdit){
        int numOfEditRequired = 0;
        char[] wordArray = wordToMatch.toCharArray();
        char[] editWordArray = wordToEdit.toCharArray();
        int editArrayCounter = 0;
        for(int index=0;index<wordArray.length;index++){
            if(editArrayCounter<editWordArray.length && wordArray[index] == editWordArray[editArrayCounter]){
                editArrayCounter = editArrayCounter+1;
            }else {
                numOfEditRequired = numOfEditRequired + 1;
            }
        }

        if(numOfEditRequired==1){
            return true;
        }else {
            return false;
        }
    }
}
