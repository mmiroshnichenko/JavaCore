package main.java.com.mmiroshnichenko.javacore.chapter21;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class DirList2 {
    public static void main(String[] args) {
        String dirname = "java";

        DirectoryStream.Filter<Path> how = new DirectoryStream.Filter<Path>() {
            @Override
            public boolean accept(Path filename) throws IOException {
                if (Files.isWritable(filename)) {
                    return true;
                } else {
                    return false;
                }
            }
        };

        try (DirectoryStream<Path> dirstrm = Files.newDirectoryStream(Paths.get(dirname), how)) {
            System.out.println("Directory " + dirname);
            for (Path entry : dirstrm) {
                BasicFileAttributes attrbts = Files.readAttributes(entry, BasicFileAttributes.class);

                if (attrbts.isDirectory()) {
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
