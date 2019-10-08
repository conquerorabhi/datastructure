package com.datastructure.concept;

/**
 * Created by asingh on 6/9/19.
 */
public class ThreadDemo extends Thread {
 public int count = 0;
    public void run(){
        System.out.println("Starting Thread ");
        try {
            while (count < 7) {
                Thread.sleep(5000);
                count = count+1;
                System.out.println("Thread : "+count);
            }
        }catch (InterruptedException ie){

        }
    }
}
