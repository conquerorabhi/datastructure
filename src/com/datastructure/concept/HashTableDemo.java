package com.datastructure.concept;

import java.util.*;

/**
 * Created by asingh on 11/23/18.
 */
public class HashTableDemo {

    public static void main(String [] args){
        /**
         * Default initial capacity of Hashtable is 11 and default load factor is .75
         */
        Hashtable ht = new Hashtable();
        Hashtable htWithInicapacity = new Hashtable(20, 0.70f);// Initialized with initial capacity 20 and load factor 0.70

        //ht.put(null,"Key is null."); Key can not be null it throws Null Pointer exception.
        //ht.put("KeyIsNotNull", null); Value also can not be null in Hashtable.

        ht.put("1","One");
        ht.put("2","Two");
        ht.put("3","Three");
        ht.put("4","Four");

        System.out.println("Number of total keys in Hashtable : "+ ht.size());

        Enumeration keys = ht.keys();// returns enumeration of keys in Hashtable
        while(keys.hasMoreElements()){
            System.out.println(keys.nextElement());
        }

        Enumeration valueEnum = ht.elements(); // returns an enumeration of values in this Hashtable.

        while(valueEnum.hasMoreElements()){
            System.out.println(valueEnum.nextElement());
        }

        System.out.println("Contains Key :"+ht.containsKey("1"));
        System.out.println("Contains Value : "+ht.contains("Two"));
        System.out.println("Contains Value :"+ht.containsValue("Three"));

        //ht.contains(null); it will throw null pointer exception
        //ht.containsKey(null); This will also throw a null pointer exception

        //String value = ht.get("1"); get method returns object type value from its get method there this will throw incompatible type compile time error
        String value = (String)ht.get("2");
        System.out.println("Get value from Hashtable :"+value);

        ht.put("5", "Five");
        ht.put("7","Seven");
        ht.remove("6");// it removes only when it finds key in the hash table else it will do nothing

        Set<String> keySet = ht.keySet();
        Iterator<String> kSetIt = keySet.iterator();// returns an iterator on set it does not gaurantee any order
        while(kSetIt.hasNext()){
            String key = kSetIt.next();
            String val = (String)ht.get(key);
            System.out.println("Hashtable values : "+val);
            if("7".equals(key)){
                kSetIt.remove();
            }

        }
        System.out.println("Printing after remove object **********");

        printHashtableWithKeysetIterator(ht); //
        printHashtableWithEntryset(ht);//printing hash table contents via entryset iterator
        printHashtable(ht);

        // copy of hashtable
        Hashtable<String,String> clonedHashtable = (Hashtable)ht.clone();// creates a shallow copy of hashtable
        printHashtable(clonedHashtable);
        // print after removing from hashtable



    }

    private static void printHashtableWithKeysetIterator(Hashtable ht){
        Set<String> keySet = ht.keySet();
        Iterator<String> kSetIt = keySet.iterator();// returns an iterator on set it does not gaurantee any order
        while(kSetIt.hasNext()){
            String key = kSetIt.next();
            String val = (String)ht.get(key);
            System.out.println("Hashtable values : "+val);
        }
    }

    private static void printHashtableWithEntryset(Hashtable ht){
        Set<Map.Entry<String,String>> entryset = ht.entrySet();
        Iterator<Map.Entry<String,String>> entryIt = entryset.iterator();
        while(entryIt.hasNext()){
            Map.Entry<String,String> entry = entryIt.next();
            System.out.println("Key :"+entry.getKey()+" Value : "+entry.getValue());
        }
    }

    private static void printHashtable(Hashtable ht){
        System.out.println("****************************");
        Collection<String> cString = ht.values();
        Iterator<String> cIt = cString.iterator();

        while(cIt.hasNext()){
            System.out.println("Value : "+cIt.next());
        }
    }
}
