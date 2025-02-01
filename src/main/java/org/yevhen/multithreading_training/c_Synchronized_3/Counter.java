package org.yevhen.multithreading_training.c_Synchronized_3;

public class Counter {

    private static Integer counter=0;

    public static   void increase() {
        counter++;
    }

    public static int getCounter() {
        return counter;
    }

}
