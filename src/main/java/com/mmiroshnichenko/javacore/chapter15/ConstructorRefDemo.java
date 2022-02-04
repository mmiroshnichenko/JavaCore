package main.java.com.mmiroshnichenko.javacore.chapter15;

interface MyFunc4 {
    MyClass3 func(int n);
}

class MyClass3 {
    private int val;

    MyClass3(int v) {
        val = v;
    }

    MyClass3() {
        this(0);
    }

    int getVal() {
        return val;
    }
}

public class ConstructorRefDemo {

    public static void main(String[] args) {
        MyFunc4 myClassCons = MyClass3::new;
        MyClass3 mc = myClassCons.func(100);

        System.out.println("Value of val in the object mc equals " + mc.getVal());
    }


}
