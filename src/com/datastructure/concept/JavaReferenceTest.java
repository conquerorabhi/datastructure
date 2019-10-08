package com.datastructure.concept;

/**
 * Created by asingh on 7/4/19.
 */
public class JavaReferenceTest {

    int value;
    ListNode node;

    public JavaReferenceTest(int primValue, int nodeValue){
        this.value = primValue;
        this.node = new ListNode(nodeValue);
    }

    public static void main(String[] args){
        JavaReferenceTest test = new JavaReferenceTest(10,20);
        int primValue = 70;
        System.out.println("Values Before Method call:");

        System.out.println("Object Value : "+test.value);
        System.out.println("Object Node Value : "+test.node.val);
        System.out.println("Primitive Value : "+primValue);
        test.testMethod(test,primValue);
        System.out.println("Values After Method call:");

        System.out.println("Object Value : "+test.value);
        System.out.println("Object Node Value : "+test.node.val);
        System.out.println("Primitive Value : "+primValue);

    }

    private void testMethod(JavaReferenceTest test,int primValue){
        test.value = 50;
        test.node.val = 100;
        primValue = 200;
        test = new JavaReferenceTest(0,0);
    }
}
