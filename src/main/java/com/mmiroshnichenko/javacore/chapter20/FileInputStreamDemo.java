package main.java.com.mmiroshnichenko.javacore.chapter20;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamDemo {
    public static void main(String[] args) {
        int size;

        try (FileInputStream f = new FileInputStream("src/main/java/com/mmiroshnichenko/javacore/chapter20/FileInputStreamDemo.java")) {
            System.out.println("Total count available bytes: " + (size = f.available()));

            int n = size / 40;
            System.out.println("First " + n + " bytes read from file by method read()");
            for (int i = 0; i< n; i++) {
                System.out.print((char) f.read());
            }
            System.out.println("\nAvailable: " + f.available());
            System.out.println("Reading next " + n + " bytes by method read(b[])");
            byte b[] = new byte[n];
            if (f.read(b) != n) {
                System.err.println("Impossible reading " + n + " bytes.");
            }
            System.out.println(new String(b, 0, n));
            System.out.println("\nAvailable: " + f.available());
            System.out.println("Skip half bytes by method skip()");
            f.skip(size/2);
            System.out.println("\nAvailable: " + f.available());
            System.out.println("Reading " + n/2 + " bytes from end off array");
            if (f.read(b, n/2, n/2) != n/2) {
                System.err.println("Impossible reading " + n/2 + " bytes.");
            }
            System.out.println(new String(b, 0, b.length));
            System.out.println("\nAvailable: " + f.available());
        } catch (IOException e) {
            System.out.println("Error input-output: " + e);
        }
    }
}
