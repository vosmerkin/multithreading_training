package org.yevhen.multithreading_training.a_Creating_Threads_01;

public class Extending {
    public static void main(String[] args) {
        Thread t1 = new Counter();
        t1.setName("First");

        Thread t2 = new Counter();
        t2.setName("Second");

        t1.start();
        t2.start();
    }


}

class Counter extends Thread{
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