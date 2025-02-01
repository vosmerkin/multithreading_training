package org.yevhen.multithreading_training.b_Volatile_keyword_2;

import java.util.Scanner;

class Processor extends Thread {

    /*
     * Set shared variable to volatile to avoid caching between threads
     *  and guarantees that any thread will read the most recent written values
     */

    private volatile
    boolean running = true;

    @Override
    public void run() {

        //Run an Infinite loop

        long counter = 0;
        while (running) {
            System.out.println("Hello " + counter);
            counter++;
        }


        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void shutdown() {
        running = false;
    }

}

public class Volatile_keyword {
    public static void main(String[] args) {

        //Start thread 1 to invoke infinte loop
        Processor t1 = new Processor();
        t1.start();

        // Scan Input stream for return key and invoke shut down
        System.out.println("Press return to stop ...");
        new Scanner(System.in).nextLine();

        //Invoke shutdown
        t1.shutdown();

    }
}
