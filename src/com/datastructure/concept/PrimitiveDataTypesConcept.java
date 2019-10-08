package com.datastructure.concept;

/**
 * Created by asingh on 12/13/18.
 */
public class PrimitiveDataTypesConcept {

    public static void main(String[] args){


        //Identify a negative and positive number

        //byte is 8 bit signed two's complement integer . It has minimum value of - 128 and maximum value of 2^.
        //byte byteValue = -129; it will give compile time error because -129 is less than -129

        byte byteValue = 22;
        byte byteVal1 = 10;
        byte byteVal2 = 11;
        String byteValString = "122";

        System.out.println("Byte Compare : "+Byte.compare(byteVal1,byteVal2));//Negative -1 is returned if val1 is less than val2
        System.out.println("Byte Compare : "+Byte.compare(byteVal2,byteVal1));//Positive 1 is returned if val1 is greater than val2
        System.out.println("Byte Compare Relational: "+(byteVal2<byteVal1));// relational operator comparison it will return true / false in this case it is false.
        System.out.println("Byte toString() : "+Byte.toString(byteVal1)); // convert this to string
        System.out.println("Byte decode : "+Byte.decode(Byte.toString(byteVal1))); // this method takes string as input and gives back value in byte
        System.out.println("Byte valueOf() :"+Byte.valueOf(byteVal1));// this method takes byte as input and returns back wrapper object , this method should be used instead of constructor
        System.out.println("Byte valueOf() :"+Byte.parseByte(byteValString)); // parses string to byte

        //short is 16 bit signed two's compliment integer .it has maximum value 32768 and minimum -32768
        System.out.println(Math.pow(2,7));


        //int is a 32 bit signed two's complement integer. It has minimum value -2^32 to 2^32.

        //long is a 64 bit signed two's complement integer . it



    }
}
