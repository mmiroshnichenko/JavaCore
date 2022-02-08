package main.java.com.mmiroshnichenko.javacore.chapter21;

import java.io.IOException;
import java.nio.file.*;

public class NIOCopy {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Invalid parameters");
            return;
        }

        try {
            Path source = Paths.get(args[0]);
            Path target = Paths.get(args[1]);

            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
        } catch (InvalidPathException e) {
            System.out.println("Path exception");
        } catch (IOException e) {
            System.out.println("Error input output");
        }
    }
}
