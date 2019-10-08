package com.datastructure.concept;

import java.util.Set;
import java.util.HashSet;
/**
 * Created by asingh on 7/14/19.
 */
public class BitProgramming {

    public static void main(String[] args){
        BitProgramming bProg = new BitProgramming();
        int x = 10;
        int y = -15;

        boolean f = (x^y)<0;

        //int value = x
        System.out.println("Do they have opposite sign :"+((y>>0)&1));

        //System.out.println(bProg.reverseBits(43261596));
        bProg.isHappy(1111111);
    }

    public int reverseBits(int n) {
        int ans = n;
        for (int i = 0; i < 16; i++) {
            ans = helper(ans, i, 32 - i - 1);
        }
        return ans;
    }

    public int helper(int x, int i, int j) {
        int right_bit = (x >> i) & 1;
        int left_bit = (x >> j) & 1;
        if (right_bit != left_bit) {
            x ^= (1 << i) | (1 << j);
        }
        return x;

    }

    public boolean isHappy(int n) {

        int sum = 0;
        Set<Integer> numSet = new HashSet<>();
        int noEvaluateTo = 0;
        int remainder = 0;
        if(n<10){
            n = n*n;
        }
        while(n!=1 && !numSet.contains(n)){
            numSet.add(n);
            noEvaluateTo = 0;
            while(n>=10){
                remainder = n%10;
                n = n/10;
                noEvaluateTo = noEvaluateTo + (remainder*remainder);
                if(n<10){
                    noEvaluateTo = noEvaluateTo + (n*n);
                }

            }
            if(noEvaluateTo!=0 && noEvaluateTo<10 && noEvaluateTo!=1) {
                n = noEvaluateTo * noEvaluateTo;
            }else{
                n = noEvaluateTo;
            }
        }
        return n==1;
    }
}
