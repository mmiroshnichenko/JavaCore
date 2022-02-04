package main.java.com.mmiroshnichenko.javacore.chapter15;

interface MyFunc6<R, T> {
    R func(T n);
}

class MyClass5<T> {
    private T val;

    MyClass5(T v) {
        val = v;
    }

    MyClass5() {
        val = null;
    }

    T getVal() {
        return val;
    }
}

class MyClass6 {
    String str;

    MyClass6(String s) {
        str = s;
    }

    MyClass6() {
        str = "";
    }

    String getVal() {
        return str;
    }
}

public class ConstructorRefDemo3 {
    static <R, T> R myClassFactory(MyFunc6<R, T> cons, T v) {
        return cons.func(v);
    }

    public static void main(String[] args) {
        MyFunc6<MyClass5<Double>, Double> myClassCons = MyClass5<Double>::new;
        MyClass5<Double> mc = myClassFactory(myClassCons, 100.1);

        System.out.println("Value val in object mc equals " + mc.getVal());

        MyFunc6<MyClass6, String> myClassCons2 = MyClass6::new;
        MyClass6 mc2 = myClassFactory(myClassCons2, "Lambda");

        System.out.println("Value str in object mc2 equals " + mc2.getVal());
    }
}
