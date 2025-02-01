package org.yevhen.multithreading_training.c_Synchronized_3;

public class Synchronized {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new Increaser("Thread " + i)).start();
        }
    }
}

class Increaser implements Runnable {
    public Increaser(String name) {
        Thread.currentThread().setName(name);
    }

    @Override
    public void run() {
        int i = 0;
        do {
            i++;
            Counter.increase();
            System.out.println(Counter.getCounter() + " " + Thread.currentThread().getName());
        } while (i < 1000000);
    }
}


