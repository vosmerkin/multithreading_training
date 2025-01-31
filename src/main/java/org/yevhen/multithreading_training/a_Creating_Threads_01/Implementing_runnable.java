package org.yevhen.multithreading_training.a_Creating_Threads_01;

import static java.lang.Thread.currentThread;

public class Implementing_runnable {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Counter1());
        t1.setName("First");

        Thread t2 = new Thread(new Counter1());
        t2.setName("Second");

        t1.start();
        t2.start();

    }
}

class Counter1 implements Runnable {

    @Override
    public void run() {
        System.out.println(currentThread().getName() + " started");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(currentThread().getName() + " finishes");
    }
}
