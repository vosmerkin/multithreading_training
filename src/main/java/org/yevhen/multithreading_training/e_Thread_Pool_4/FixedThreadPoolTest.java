package org.yevhen.multithreading_training.e_Thread_Pool_4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class FixedThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(5);

        for (int i=0;i<10;i++) {
            exec.submit(new SomeThread(i));
        }
        //Stop accepting new task after completion of all tasks
        exec.shutdown();

        System.out.println("All tasks submitted");

        try {
            exec.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("All tasks Completed");
    }
}

class SomeThread implements Runnable{
    private int id;
    public SomeThread(int id) {
        this.id=id;
    }

    @Override
    public void run() {
        System.out.println("Starting:"+id);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        };
        System.out.println("Completed:"+id);
    }
}
