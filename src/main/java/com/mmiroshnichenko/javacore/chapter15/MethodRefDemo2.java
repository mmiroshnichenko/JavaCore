package main.java.com.mmiroshnichenko.javacore.chapter15;

interface StringFunc4 {
    String func(String n);
}
class MyStringOps2 {
    String strReverse(String str) {
        String result = "";
        int i;

        for (i = str.length() - 1; i >= 0; i--) {
            result += str.charAt(i);
        }
        return result;
    }
}

public class MethodRefDemo2 {
    static String stringOp(StringFunc4 sf, String s) {
        return sf.func(s);
    }

    public static void main(String args[]) {
        String inStr = "Lambda increases efficiency of Java";
        String outStr;

        MyStringOps2 strOps = new MyStringOps2();

        outStr = stringOp(strOps::strReverse, inStr);

        System.out.println("Input string: " + inStr);
        System.out.println("Reversed string: " + outStr);
    }
}
