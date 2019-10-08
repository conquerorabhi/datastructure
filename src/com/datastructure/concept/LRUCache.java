package com.datastructure.concept;

import java.util.HashMap;

/**
 * Created by asingh on 8/19/19.
 */
public class LRUCache {

    HashMap<Integer,Entry> cache ;
    Entry start;
    Entry end;

    public LRUCache(){
        cache = new HashMap<>();
        start = null;
        end = null;
    }

    public void addAtTop(Entry entry){
        if(start == null){
            start = entry;
            end = start;
        }else{
            start.left = entry;
            entry.right = start;
            entry.left = null;
            start = entry;
        }
    }

    public void removeNode(Entry entry){
        if(entry.left!=null){
            entry.left.right = entry.right;
        }else{
            start = entry.right;
        }

        if(entry.right!=null){
            entry.right.left = entry.left;
        }else{
            end = entry.left;
        }
    }

    public int getValue(int key){
        if(cache.containsKey(key)){
            Entry entry = cache.get(key);
            removeNode(entry);
            addAtTop(entry);
            cache.put(key,entry);
            return entry.getValue();
        }
        return -1;
    }
}
