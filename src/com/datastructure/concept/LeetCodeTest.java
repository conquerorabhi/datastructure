package com.datastructure.concept;

import java.util.*;

/**
 * Created by asingh on 7/1/19.
 */
public class LeetCodeTest {

    public static void main(String[] args) {
        LeetCodeTest test = new LeetCodeTest();
        int[][] input={
            {1,2,3,4},{5,6,7,8},{9,10,11,12}
        };
        //List<Integer> result =test.spiralOrder(input);

        //String[] inputEmail = {"test.email+alex@leetcode.com","test.email.leet+alex@code.com"};
        //System.out.println(test.compareVersion("1","0"));

        System.out.println(test.findRepeatedDnaSequences("AAAAAAAAAAA"));

    }
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> inList = new ArrayList<Integer>();
        if(matrix.length==0){
            return inList;
        }
        int row = matrix.length;
        int columns = matrix[0].length;
        int i=0,j=0;
        for(int count=0;count<columns;){
            i = count;
            j = count;
            row = row-count;
            columns = columns-count;
            while(i<=row-1 && j<=columns-1){

                while(i==count && j<=columns-1){//Print first row starting from zero zero
                    if(j!=columns) {
                        inList.add(matrix[i][j]);
                    }
                    j++;
                }

                if(j==columns){
                    j=j-1;
                }

                while(j==columns-1 && i<=row-1){
                    i++;
                    if(i<=row-1) {
                        inList.add(matrix[i][j]);
                    }
                }
                if(i==row){
                    i=i-1;
                }

                while(i==row-1 && j>=count){
                    j--;
                    if(j>=count && i>row-1) {
                        inList.add(matrix[i][j]);
                    }
                }

                if(j<count){
                    j=count;
                }

                while(i>count && j==count){
                    i--;
                    if(i>count){
                        inList.add(matrix[i][j]);
                    }
                }
                count++;
                break;

            }
        }

        return inList;
    }

    public int numUniqueEmails(String[] emails) {
        if(emails==null){
            return 0;
        }
        List<String> uniqueEmail = new ArrayList<String>();
        for(String email:emails){
            validateEmailAddress(email,uniqueEmail);
        }

        return uniqueEmail!=null ? uniqueEmail.size():0;
    }

    private void validateEmailAddress(String email,List<String> uniqueEmailList){
        if(email!=null){
            String[] emailCom= email.split("@");
            String localName = emailCom[0];
            String domainName = emailCom[1];

            if(domainName!=null && !"".equals(domainName) && localName.charAt(0)!='+'){

                if(localName.indexOf("+")!=-1){
                    localName = localName.substring(0,localName.indexOf("+"));
                }
                localName = localName.replaceAll("\\.","");
                localName.trim();

                String validEmail = localName +"@"+ domainName;
                if(!uniqueEmailList.contains(validEmail)){
                    uniqueEmailList.add(validEmail);
                }
            }

        }

    }

    public int compareVersion(String version1, String version2) {
        if(version1==null && version2==null){
            return 0;
        }else if(version2==null && version1!=null){
            return 1;
        }else if(version1==null && version2!=null){
            return -1;
        }

        int v1=0;
        int v2=0;
        HashMap<Integer,Integer> v1Map = new HashMap<Integer,Integer>();
        HashMap<Integer,Integer> v2Map = new HashMap<Integer,Integer>();
        String[] version1Ar = null;
        String[] version2Ar = null;

        if(version1.indexOf(".")!=-1){
            version1Ar = version1.split("\\.");
        }else{
            v1Map.put(0,Integer.parseInt(version1));
        }

        if(version2.indexOf(".")!=-1){
            version2Ar = version2.split("\\.");
        }else{
            v2Map.put(0,Integer.parseInt(version2));
        }
        int count=0;
        if(version1Ar!=null){
            for(int idx=0;idx<=version1Ar.length-1;idx++){
                v1Map.put(idx,Integer.parseInt(version1Ar[idx]));
            }
        }
        count=0;
        if(version2Ar!=null){
            for(int idx1=0;idx1<=version2Ar.length-1;idx1++){
                v2Map.put(idx1,Integer.parseInt(version2Ar[idx1]));
            }
        }

        int v1Length = version1Ar!=null?version1Ar.length:1;
        int v2Length = version2Ar!=null?version2Ar.length:1;

        int maxLength= v2Length>v1Length?v2Length:v1Length;
        for(int index=0;index<=maxLength-1;index++){
            int v1Val = v1Map.get(index)!=null ? v1Map.get(index):0;
            int v2Val = v2Map.get(index)!=null ? v2Map.get(index):0;
            if(v1Val<v2Val){
                return -1;
            }else if(v1Val>v2Val){
                return 1;
            }
        }

        return 0;
    }

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        if(s==null||"".equals(s)){
            return res;
        }

        for(int index=0;index<s.length()-10;index++){
            String sub = s.substring(index,index+10);
            String rem = s;
            int occurence = 0;
            while(rem.length()>=10){
                if(rem.indexOf(sub)!=-1){
                    occurence = occurence + 1;
                    if(occurence==2){
                        if(!res.contains(sub)){
                            res.add(sub);
                        }

                        break;
                    }
                    int idx = rem.indexOf(sub);
                    rem = rem.substring(idx+10);
                }else{
                    break;
                }

            }
        }
        return res;
    }

}
