package main.java.com.mmiroshnichenko.javacore.chapter28;

import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        new LockThread(lock, "A");
        new LockThread(lock, "B");
    }
}

class Shared2 {
    static int count = 0;
}

class LockThread implements Runnable {
    String name;
    ReentrantLock lock;

    LockThread(ReentrantLock lk, String n) {
        lock = lk;
        name = n;

        new Thread(this).start();
    }

    public void run() {
        System.out.println("Staring of thread " + name);

        try {
            System.out.println("Thread " + name + " is waiting for the counter locking");
            lock.lock();
            System.out.println("Thread " + name + " is locking the counter");
            Shared2.count++;
            System.out.println("Thread " + name + ": " + Shared2.count);
            System.out.println("Thread " + name + " is waiting");
            Thread.sleep(1000);
        } catch (InterruptedException exc) {
            System.out.println(exc);
        } finally {
            System.out.println("Thread " + name + " unlocked the counter");
            lock.unlock();
        }
    }
}