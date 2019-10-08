package com.datastructure.concept;

/**
 * Created by asingh on 11/20/18.
 */
public class TestList {

    int test1 = 0;
    int test2 = 0;

    public TestList(int test1,int test2){
        this.test1 = test1;
        this.test2 = test2;
    }


    public static void main(String[] args){
        TestList test = new TestList(1,2);
        test.testMethod(test);
        System.out.println(test.toString());
    }

    public void testMethod(TestList test){
        test = new TestList(20,30);
    }
    public String toString (){
        System.out.println(this.test1+" : "+this.test2);
        return this.test2+"";
    }

}
