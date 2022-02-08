package main.java.com.mmiroshnichenko.javacore.chapter21;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class DirList {
    public static void main(String[] args) {
        String dirname = "java";

        try (DirectoryStream<Path> dirstrm = Files.newDirectoryStream(Paths.get(dirname))) {
            System.out.println("Directory: " + dirname);
            for (Path entry : dirstrm) {
                BasicFileAttributes attrs = Files.readAttributes(entry, BasicFileAttributes.class);
                if (attrs.isDirectory()) {
                    System.out.print("<DIR> ");
                } else {
                    System.out.print("      ");
                }
                System.out.println(entry.getName(1));
            }
        } catch (InvalidPathException e) {
            System.out.println("Path exception: " + e);
        } catch (NotDirectoryException e) {
            System.out.println("Directory not found: " + e);
        } catch (IOException e) {
            System.out.println("Error input output: " + e);
        }
    }
}
