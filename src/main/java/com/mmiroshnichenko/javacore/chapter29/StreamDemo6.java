package main.java.com.mmiroshnichenko.javacore.chapter29;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class StreamDemo6 {
    public static void main(String[] args) {
        ArrayList<Double> myList = new ArrayList<>();

        myList.add(1.1);
        myList.add(3.6);
        myList.add(9.2);
        myList.add(4.7);
        myList.add(12.1);
        myList.add(5.0);

        System.out.print("Source values from the list myList: ");
        myList.stream().forEach((a) -> System.out.print(a + " "));
        System.out.println();

        IntStream cStrm = myList.stream().mapToInt((a) -> (int) Math.ceil(a));
        System.out.print("Maximum allowed limits of values from the list myList: ");
        cStrm.forEach((a) -> System.out.print(a + " "));
    }
}
