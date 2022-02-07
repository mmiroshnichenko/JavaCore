package main.java.com.mmiroshnichenko.javacore.chapter20;

import java.io.*;

public class DataIODemo {
    public static void main(String[] args) {
        try (DataOutputStream dout = new DataOutputStream(new FileOutputStream("Test.dat"))) {
            dout.writeDouble(98.6);
            dout.writeInt(1000);
            dout.writeInt(12000);
            dout.writeBoolean(true);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return;
        } catch (IOException e) {
            System.out.println("Error input output: " + e);
        }

        try (DataInputStream din = new DataInputStream(new FileInputStream("Test.dat"))) {
            double d = din.readDouble();
            int i = din.readInt();int i2 = din.readInt();
            boolean b = din.readBoolean();


            System.out.println("The values obtained: " + d + " " + i + " " + i2 + " " + b);
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }
    }
}

