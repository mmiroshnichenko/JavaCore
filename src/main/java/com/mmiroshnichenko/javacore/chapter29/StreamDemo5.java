package main.java.com.mmiroshnichenko.javacore.chapter29;

import java.util.ArrayList;
import java.util.stream.Stream;

class NamePhoneEmail {
    String name;
    String phoneNum;
    String email;

    public NamePhoneEmail(String name, String phoneNum, String email) {
        this.name = name;
        this.phoneNum = phoneNum;
        this.email = email;
    }
}

class NamePhone {
    String name;
    String phoneNum;

    public NamePhone(String name, String phoneNum) {
        this.name = name;
        this.phoneNum = phoneNum;
    }
}

public class StreamDemo5 {
    public static void main(String[] args) {
        ArrayList<NamePhoneEmail> myList = new ArrayList<>();
        myList.add(new NamePhoneEmail("user1", "555-55-55", "user1@gmail.com"));
        myList.add(new NamePhoneEmail("user2", "666-66-66", "user2@gmail.com"));
        myList.add(new NamePhoneEmail("user3", "777-77-77", "user3@gmail.com"));

        System.out.println("Source elements from myList: ");
        myList.stream().forEach((a) -> System.out.println(a.name + " " + a.phoneNum + " " + a.email));
        System.out.println();

        //Stream<NamePhone> nameAndPhone = myList.stream().map((a) -> new NamePhone(a.name, a.phoneNum));
        Stream<NamePhone> nameAndPhone = myList.stream().
                                        filter((a) -> a.name.equals("user2")).
                                        map((a) -> new NamePhone(a.name, a.phoneNum));
        System.out.println("List of names and phone numbers");
        nameAndPhone.forEach((a) -> System.out.println(a.name + " " + a.phoneNum));
    }
}
