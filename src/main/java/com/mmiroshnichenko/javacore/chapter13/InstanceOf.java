package main.java.com.mmiroshnichenko.javacore.chapter13;

class A {
    int i, j;
}

class B {
    int i, j;
}

class C extends A {
    int k;
}

class D extends A {
    int k;
}

public class InstanceOf {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();
        D d = new D();

        if (a instanceof A) {
            System.out.println("a is instance of A");
        }
        if (b instanceof B) {
            System.out.println("b is instance of B");
        }
        if (c instanceof C) {
            System.out.println("c is instance of C");
        }
        if (c instanceof A) {
            System.out.println("c can lead to type A");
        }
        if (a instanceof C) {
            System.out.println("a can lead to type C");
        }
        System.out.println();

        A ob;

        ob = d;

        System.out.println("ob is linked to d now");
        if (ob instanceof D) {
            System.out.println("ob is instance of D");
        }
        System.out.println();

        ob = c;
        System.out.println("ob is linked to c now");

        if (ob instanceof D) {
            System.out.println("ob can lead to type D");
        } else {
            System.out.println("ob cannot lead to type D");
        }

        if (ob instanceof A) {
            System.out.println("ob can lead to type A");
        }
        System.out.println();

        if (a instanceof Object) {
            System.out.println("a can lead to type Object");
        }

        if (b instanceof Object) {
            System.out.println("b can lead to type Object");
        }

        if (c instanceof Object) {
            System.out.println("c can lead to type Object");
        }

        if (d instanceof Object) {
            System.out.println("d can lead to type Object");
        }
    }
}
