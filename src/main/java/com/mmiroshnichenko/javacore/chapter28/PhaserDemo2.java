package main.java.com.mmiroshnichenko.javacore.chapter28;

import java.util.concurrent.Phaser;

class MyPhaser extends Phaser {
    int numPhases;

    MyPhaser(int parties, int phaseCount) {
        super(parties);
        numPhases = phaseCount - 1;
    }

    @Override
    protected boolean onAdvance(int phase, int registeredParties) {
        System.out.println("Phase " + phase + " is completed.\n");

        if (phase == numPhases || registeredParties == 0) {
            return true;
        }
        return false;
    }
}

public class PhaserDemo2 {
    public static void main(String[] args) {
        MyPhaser phaser = new MyPhaser(1, 4);

        System.out.println("Start of threads\n");
        new MyThread4(phaser, "A");
        new MyThread4(phaser, "B");
        new MyThread4(phaser, "C");

        while (!phaser.isTerminated()) {
            phaser.arriveAndAwaitAdvance();
        }

        System.out.println("The phase synchronizer is completed");
    }
}

class MyThread4 implements Runnable {
    Phaser phaser;
    String name;

    public MyThread4(Phaser phaser, String name) {
        this.phaser = phaser;
        this.name = name;

        this.phaser.register();
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (!phaser.isTerminated()) {
            System.out.println("Thread " + name + " began the phase " + phaser.getPhase());
            phaser.arriveAndAwaitAdvance();

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
