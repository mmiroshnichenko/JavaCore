package main.java.com.mmiroshnichenko.javacore.chapter15;

import java.util.Locale;

interface StringFunc2 {
    String func(String n);
}

public class LambdasAsArgumentsDemo {
    static String stringOp(StringFunc2 sf, String s) {
        return sf.func(s);
    }

    public static void main(String[] args) {
        String inStr = "Lambda increases JAVA efficiency";
        String outStr;

        System.out.println("It is input string: " + inStr);

        outStr = stringOp((str) -> str.toUpperCase(), inStr);
        System.out.println("It is string in upper case: " + outStr);

        outStr = stringOp((str) -> {
                            String result = "";
                            int i;

                            for (i = 0; i < str.length(); i++) {
                                if (str.charAt(i) != ' ') {
                                    result += str.charAt(i);
                                }
                            }
                            return result;
                        }, inStr);
        System.out.println("This is string without spaces: " + outStr);

        StringFunc2 reverse = (str) -> {
            String result = "";
            int i;

            for (i = str.length() - 1; i >= 0; i--) {
                result += str.charAt(i);
            }
            return result;
        };

        System.out.println("This is reverse string: " + stringOp(reverse, inStr));
    }
}
