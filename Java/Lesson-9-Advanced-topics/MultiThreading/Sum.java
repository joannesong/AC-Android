package com.company;

/**
 * Created by justiceo on 10/31/17.
 */
public class Sum implements Runnable {

    private int start;
    private int end;
    private long sum;

    public Sum(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public long getSum() {
        return sum;
    }

    @Override
    public void run() {
        for(int i = start; i < end; i++) {
            sum += i;
        }

    }

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.nanoTime();

        Sum s1 = new Sum(1, Integer.MAX_VALUE/2);
        Thread t1 = new Thread(s1);
        t1.start();

        Sum s2 = new Sum(Integer.MAX_VALUE/2, Integer.MAX_VALUE);
        Thread t2 = new Thread(s2);
        t2.start();

        t1.join();
        t2.join();
        System.out.println("sum is: " + (s1.getSum() + s2.getSum()));


        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Finished in: " + duration);
    }


}
