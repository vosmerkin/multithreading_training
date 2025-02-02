package org.yevhen.multithreading_training.d_Lock_4;

import java.util.Random;

public class SyncCode extends Thread{
    private final int numberRuns;
    private Random random = new Random();

    public SyncCode(int numberRuns) {
        this.numberRuns = numberRuns;
    }

    public void run(){
        for (int i = 0; i < numberRuns; i++) {
            Synchronized_Tester.addRandomSyncCode(random.nextInt(100));
        }
    }
}
