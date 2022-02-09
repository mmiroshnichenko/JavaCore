package main.java.com.mmiroshnichenko.javacore.chapter22;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Whois2 {
    public static void main(String[] args) throws Exception {
        int c;

        try (Socket s = new Socket("whois.internic.net", 43)) {
            InputStream in = s.getInputStream();
            OutputStream out = s.getOutputStream();
            //create request
            String str = (args.length == 0 ? "MHPProfessional.com" : args[0]) + "\n";

            byte buf[] = str.getBytes();
            // send request
            out.write(buf);

            //read response
            while ((c = in.read()) != -1) {
                System.out.print((char) c);
            }
        }
    }
}
