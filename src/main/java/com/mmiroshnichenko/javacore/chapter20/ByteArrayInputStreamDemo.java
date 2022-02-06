package main.java.com.mmiroshnichenko.javacore.chapter20;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ByteArrayInputStreamDemo {
    public static void main(String[] args) throws IOException {
        String tmp = " abcdefghijklmnopqrstuvwxyz";
        byte b[] = tmp.getBytes();

        ByteArrayInputStream input1 = new ByteArrayInputStream(b);
        ByteArrayInputStream input2 = new ByteArrayInputStream(b, 0, 3);
        int c;
        while ((c = input1.read()) != -1) {
            System.out.print((char) c);
        }
    }
}
