package main.java.com.mmiroshnichenko.javacore.chapter15;

import java.util.function.Function;

public class UseFunctionalInterfaceDemo {
    public static void main(String[] args) {
        Function<Integer, Integer> factorial = (n) -> {
            int result = 1;
            for (int i = 1; i <= n; i++) {
                result = i * result;
            }
            return result;
        };

        System.out.println("Factorial of number 3 equals " + factorial.apply(3));
        System.out.println("Factorial of number 5 equals " + factorial.apply(5));
    }
}
