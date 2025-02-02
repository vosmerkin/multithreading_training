package org.yevhen.multithreading_training.d_Lock_4;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Synchronized_Tester {
    private static List<Integer> list=new ArrayList<>();
    //    public static int counterForSyncMethod =0;
//    public static int counterForSyncCode =0;
    private static final Object lock = new Object();
    public static final int NUM_OF_THREADS = 10;
    public static final int NUM_OF_RUNS = 1000;
    private List<Thread> threadList ;

    public static synchronized void addRandomSyncMethod(int i) {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        list.add(i);
    }

    public static void addRandomSyncCode(int i) {
        synchronized (lock) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.add(i);
        }
    }

    private <T extends Thread> void runner(Class<T> threadClass) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        threadList = new ArrayList<>();
        threadList.clear();
        System.out.println("Starting ...");
        long start = System.currentTimeMillis();

        System.out.println("Creating threads ...");
        for (int i = 0; i < NUM_OF_THREADS; i++) {
            threadList.add(threadClass.getDeclaredConstructor(int.class).newInstance(NUM_OF_RUNS));
        }

        System.out.println("Starting threads ...");
        for (Thread thread : threadList) {
            thread.start();
        }

        System.out.println("Joining threads ...");
        try {
            for (Thread thread : threadList) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Evaluating results ...");
        long end = System.currentTimeMillis();

        System.out.println("Time taken: " + (end - start));
    }


    public static void main(String[] args) {
        Synchronized_Tester synchronizedTester = new Synchronized_Tester();
        try {
            synchronizedTester.runner(SyncCode.class);
            synchronizedTester.runner(SyncMethod.class);
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
