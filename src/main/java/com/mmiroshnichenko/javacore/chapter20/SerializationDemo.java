package main.java.com.mmiroshnichenko.javacore.chapter20;

import java.io.*;

class MyClass implements Serializable {
    String s;
    int i;
    double d;

    public MyClass(String s, int i, double d) {
        this.s = s;
        this.i = i;
        this.d = d;
    }

    @Override
    public String toString() {
        return "s='" + s + "', i=" + i + ", d=" + d;
    }
}

public class SerializationDemo {
    public static void main(String[] args) {
        try (ObjectOutputStream objOStrm = new ObjectOutputStream(new FileOutputStream("serial"))) {
            MyClass object1 = new MyClass("Hello", -7, 2.7e10);
            objOStrm.writeObject(object1);
        } catch (IOException e) {
            System.out.println("Serialization error: " + e);
        }

        try (ObjectInputStream objIStrm = new ObjectInputStream((new FileInputStream("serial")))) {
            MyClass object2 = (MyClass) objIStrm.readObject();
            System.out.println("Object2: " + object2);
        } catch (Exception e) {
            System.out.println("Deserialization error: " + e);
            System.exit(0);
        }
    }
}
