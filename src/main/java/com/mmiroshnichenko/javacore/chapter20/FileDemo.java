package main.java.com.mmiroshnichenko.javacore.chapter20;

import java.io.File;

public class FileDemo {
    static void p(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) {
        File f1 = new File("java/COPYRIGHT");
        p("File name: " + f1.getName());
        p("Path: " + f1.getPath());
        p("Absolute path: " + f1.getAbsolutePath());
        p("Parent directory: " + f1.getParent());
        p(f1.exists() ? "exists" : "not exists");
        p(f1.canWrite() ? "can write" : "cannot write");
        p(f1.canRead() ? "can read" : "cannot read");
        p(f1.isDirectory() ? "is directory" : "is not directory");
        p(f1.isFile() ? "simple file" : "may be named channel");
        p(f1.isAbsolute() ? "is absolute" : "is not absolute");
        p("Last changed: " + f1.lastModified());
        p("Size: " + f1.length() + " byte");
    }
}
