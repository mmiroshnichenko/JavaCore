package main.java.com.mmiroshnichenko.javacore.chapter11;

class A {
    synchronized void foo (B b) {
        String name = Thread.currentThread().getName();

        System.out.println(name + " entered in the method A.foo()");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Class A is interrupted");
        }
        System.out.println(name + " try to call the method b.last()");
        b.last();
    }

    synchronized void last() {
        System.out.println("In the method A.last()");
    }
}

class B {
    synchronized void bar(A a) {
        String name = Thread.currentThread().getName();
        System.out.println(name + " entered in the method B.bar()");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Class B is interrupted");
        }
        System.out.println(name + " try to call the method A.last()");
        a.last();
    }

    synchronized void last() {
        System.out.println("In the method A.last()");
    }
}

public class Deadlock implements Runnable {
    A a = new A();
    B b = new B();

    Deadlock() {
        Thread.currentThread().setName("Main thread");
        Thread t = new Thread(this, "Concurrent thread");
        t.start();

        a.foo(b);

        System.out.println("Back in the main thread");
    }

    @Override
    public void run() {
        b.bar(a);

        System.out.println("Back in the other thread");
    }

    public static void main(String[] args) {
        new Deadlock();
    }
}
