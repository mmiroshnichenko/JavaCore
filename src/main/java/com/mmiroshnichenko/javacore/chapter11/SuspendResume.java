package main.java.com.mmiroshnichenko.javacore.chapter11;

class NewThread4 implements Runnable {
    String name;
    Thread t;
    boolean suspendFlag;

    NewThread4(String threadName) {
        name = threadName;
        t = new Thread(this, name);
        System.out.println("New thread: " + t);
        suspendFlag = false;
        t.start();
    }

    @Override
    public void run() {
        try {
            for (int i =15; i > 0; i--) {
                System.out.println(name + ": " + i);
                Thread.sleep(200);
                synchronized (this) {
                    while (suspendFlag) {
                        wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            System.out.println(name + " is interrupted");
        }
        System.out.println(name + " is completed");
    }

    synchronized void mySuspend() {
        suspendFlag = true;
    }

    synchronized void myResume() {
        suspendFlag = false;
        notify();
    }
}

public class SuspendResume {
    public static void main(String[] args) {
        NewThread4 ob1 = new NewThread4("One");
        NewThread4 ob2 = new NewThread4("Two");

        try {
            Thread.sleep(1000);
            ob1.mySuspend();
            System.out.println("Suspend the thread One");
            Thread.sleep(1000);
            ob1.myResume();
            System.out.println("Resume the thread One");

            ob2.mySuspend();
            System.out.println("Suspend the thread Two");
            Thread.sleep(1000);
            ob2.myResume();
            System.out.println("Resume the thread Two");
        } catch (InterruptedException e) {
            System.out.println("Main thread is interrupted");
        }

        try {
            System.out.println("Waiting completed of threads");
            ob1.t.join();
            ob2.t.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread is interrupted");
        }

        System.out.println("Main thread is completed");
    }
}
