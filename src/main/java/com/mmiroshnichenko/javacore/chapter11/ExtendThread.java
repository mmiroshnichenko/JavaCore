package main.java.com.mmiroshnichenko.javacore.chapter11;

class NewThread2 extends Thread {
    NewThread2() {
        super("Demo thread");
        System.out.println("Child thread: " + this);
        start();
    }

    @Override
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Child thread: " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Child thread is interrupted");
        }
        System.out.println("Child thread is completed");
    }
}

public class ExtendThread {
    public static void main(String[] args) {
        new NewThread2();
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Main thread: " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread is interrupted");
        }
        System.out.println("Main thread is completed");
    }
}
