package main.java.com.mmiroshnichenko.javacore.chapter22;

import com.sun.source.doctree.SeeTree;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HttpURLConnectionDemo {
    public static void main(String[] args) throws Exception {
        URL hp = new URL("http://www.google.com");
        HttpURLConnection hpCon = (HttpURLConnection) hp.openConnection();

        System.out.println("Request method: " + hpCon.getRequestMethod());
        System.out.println("Response code: " + hpCon.getResponseCode());
        System.out.println("Response message: " + hpCon.getResponseMessage());

        Map<String, List<String>> hdrMap = hpCon.getHeaderFields();
        Set<String> hdrField = hdrMap.keySet();
        System.out.println("\nNext follows a header:");

        for (String k : hdrField) {
            System.out.println("Key: " + k + " Value: " + hdrMap.get(k));
        }
    }
}
