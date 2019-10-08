package com.datastructure.concept;

/**
 * Created by asingh on 6/9/19.
 */
public class RunnableDemo implements Runnable {
    public int count = 0;

    public void run(){
        System.out.println("Runnable Thread Starting");
        try {
            while(count<=7){
                Thread.sleep(500);
                count = count + 1;
                System.out.println("Runnable :"+count);
            }
        }catch (InterruptedException exc){
            System.out.println("Interrupted Thread Exception");
        }
    }

}
