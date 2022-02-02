package main.java.com.mmiroshnichenko.javacore.chapter13;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ShowFile {
    public static void main(String[] args) {
        int i;
        FileInputStream fin = null;

        if (args.length != 1) {
            System.out.println("Using: ShowFile file_name");
            return;
        }

        System.out.println(args[0]);
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        try {
            fin = new FileInputStream(args[0]);
            //fin = new FileInputStream("C:\\Michael\\JavaProjects\\" + args[0]);

            do {
                i = fin.read();
                if (i != -1) System.out.print((char) i);
            } while (i != -1);

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error file reading");
        } finally {
            try {
                if (fin != null) fin.close();
            } catch (IOException e) {
                System.out.println("Error file closing");
            }
        }
    }
}
