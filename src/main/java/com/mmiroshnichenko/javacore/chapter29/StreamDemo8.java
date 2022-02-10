package main.java.com.mmiroshnichenko.javacore.chapter29;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Stream;

public class StreamDemo8 {
    public static void main(String[] args) {
        ArrayList<String> myList = new ArrayList<>();
        myList.add("alpha");
        myList.add("beta");
        myList.add("gamma");
        myList.add("delta");
        myList.add("ksy");
        myList.add("omega");

        Stream<String> myStream = myList.stream();

        Iterator<String> itr = myStream.iterator();

        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}
