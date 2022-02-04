package main.java.com.mmiroshnichenko.javacore.chapter15;

interface MyFunc5<T> {
    MyClass4<T> func(T n);
}

class MyClass4<T> {
    private T val;

    MyClass4(T v) {
        val = v;
    }

    MyClass4() {
        val = null;
    }

    T getVal() {
        return val;
    }
}

public class ConstructorRefDemo2 {
    public static void main(String[] args) {
        MyFunc5<Integer> myClassCons = MyClass4<Integer>::new;

        MyClass4<Integer> mc = myClassCons.func(100);

        System.out.println("Value of val in the object mc equals " + mc.getVal());
    }
}
