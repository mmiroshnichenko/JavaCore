package main.java.com.mmiroshnichenko.javacore.chapter21;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class PathDemo {

    public static void main(String[] args) {
        Path filepath = Paths.get("java\\test.txt");

        System.out.println("File name: " + filepath.getName(1));
        System.out.println("File path: " + filepath);
        System.out.println("Absolute file path: " + filepath.toAbsolutePath());
        System.out.println("Parent directory: " + filepath.getParent());

        if (Files.exists(filepath)) {
            System.out.println("File exists");
        } else {
            System.out.println("File not exists");
        }

        try {
            if (Files.isHidden(filepath)) {
                System.out.println("File is hidden");
            } else {
                System.out.println("File is not hidden");
            }
        } catch (IOException e) {
            System.out.println("Error input output: " + e);
        }

        Files.isWritable(filepath);
        System.out.println("File is available for writing");

        Files.isReadable(filepath);
        System.out.println("File is available for reading");

        try {
            BasicFileAttributes attrs = Files.readAttributes(filepath, BasicFileAttributes.class);

            if (attrs.isDirectory()) {
                System.out.println("It's directory");
            } else {
                System.out.println("It isn't directory");
            }

            if (attrs.isRegularFile()) {
                System.out.println("It is regular file");
            } else {
                System.out.println("It isn't regular file");
            }

            if (attrs.isSymbolicLink()) {
                System.out.println("It is symbolic link");
            } else {
                System.out.println("In is not symbolic link");
            }

            System.out.println("Last modified time: " + attrs.lastModifiedTime());
            System.out.println("File size: " + attrs.size());
        } catch (IOException e) {
            System.out.println("Error input output: " + e);
        }
    }
}
