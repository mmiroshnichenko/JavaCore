package main.java.com.mmiroshnichenko.javacore.chapter29;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class NamePhoneEmail2 {
    String name;
    String phoneNum;
    String email;

    public NamePhoneEmail2(String name, String phoneNum, String email) {
        this.name = name;
        this.phoneNum = phoneNum;
        this.email = email;
    }
}

class NamePhone2 {
    String name;
    String phoneNum;

    public NamePhone2(String name, String phoneNum) {
        this.name = name;
        this.phoneNum = phoneNum;
    }
}

public class StreamDemo7 {
    public static void main(String[] args) {
        ArrayList<NamePhoneEmail2> myList = new ArrayList<>();
        myList.add(new NamePhoneEmail2("user1", "555-55-55", "user1@gmail.com"));
        myList.add(new NamePhoneEmail2("user2", "666-66-66", "user2@gmail.com"));
        myList.add(new NamePhoneEmail2("user3", "777-77-77", "user3@gmail.com"));

        Stream<NamePhone> nameAndPhone = myList.stream().map((a) -> new NamePhone(a.name, a.phoneNum));

        List<NamePhone> npList = nameAndPhone.collect(Collectors.toList());

        System.out.println("Names and phone numbers in the list of type List: ");
        for (NamePhone e : npList) {
            System.out.println(e.name + ": " + e.phoneNum);
        }

        nameAndPhone = myList.stream().map((a) -> new NamePhone(a.name, a.phoneNum));

        Set<NamePhone> npSet = nameAndPhone.collect(Collectors.toSet());

        System.out.println("\nNames and phone numbers in collection of type Set: ");
        for (NamePhone e : npSet) {
            System.out.println(e.name + ": " + e.phoneNum);
        }
    }
}
