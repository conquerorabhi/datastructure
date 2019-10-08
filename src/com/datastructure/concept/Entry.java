package com.datastructure.concept;

/**
 * Created by asingh on 8/19/19.
 */
public class Entry {

    int value;
    int key;

    Entry left;
    Entry right;

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
