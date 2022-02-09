package main.java.com.mmiroshnichenko.javacore.chapter22;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class URLConnectionDemo {
    public static void main(String[] args) throws Exception {
        int c;
        URL hp = new URL("http://www.internic.net");
        URLConnection hpCon = hp.openConnection();

        long d = hpCon.getDate();
        if (d == 0) {
            System.out.println("No date");
        } else {
            System.out.println("Date: " + new Date(d));
        }
        System.out.println("Type of content: " + hpCon.getContentType());
        d = hpCon.getExpiration();
        if (d == 0) {
            System.out.println("No expiration");
        } else {
            System.out.println("Expiration: " + new Date(d));
        }
        d = hpCon.getLastModified();
        if (d == 0) {
            System.out.println("No modified date");
        } else {
            System.out.println("Modified date: " + new Date(d));
        }
        long len = hpCon.getContentLengthLong();
        if (len == -1) {
            System.out.println("No content length");
        } else {
            System.out.println("Content length: " + len);
        }
        if (len != 0) {
            System.out.println("=== Content ===");
            InputStream input = hpCon.getInputStream();
            while ((c = input.read()) != -1) {
                System.out.print((char) c);
            }
            input.close();
        } else {
            System.out.println("No content");
        }
    }
}
