package main.java.com.mmiroshnichenko.javacore.chapter11;

public class DemoJoin {
    public static void main(String[] args) {
        NewThread3 ob1 = new NewThread3("One");
        NewThread3 ob2 = new NewThread3("Two");
        NewThread3 ob3 = new NewThread3("Three");

        System.out.println("Thread One is started: " + ob1.t.isAlive());
        System.out.println("Thread Two is started: " + ob2.t.isAlive());
        System.out.println("Thread Three is started: " + ob3.t.isAlive());

        try {
            System.out.println("Waiting thread completing");
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread is interrupted");
        }

        System.out.println("Thread One is started: " + ob1.t.isAlive());
        System.out.println("Thread Two is started: " + ob2.t.isAlive());
        System.out.println("Thread Three is started: " + ob3.t.isAlive());

        System.out.println("Main thread is completed");
    }
}
