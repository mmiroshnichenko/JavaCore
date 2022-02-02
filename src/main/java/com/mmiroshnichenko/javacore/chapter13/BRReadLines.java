package main.java.com.mmiroshnichenko.javacore.chapter13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BRReadLines {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        System.out.println("Input string of the text");
        System.out.println("Input 'stop' for finishing");

        do {
            str = br.readLine();
            System.out.println(str);
        } while(!str.equals("stop"));
    }
}
