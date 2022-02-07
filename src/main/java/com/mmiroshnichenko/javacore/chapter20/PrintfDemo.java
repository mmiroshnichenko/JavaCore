package main.java.com.mmiroshnichenko.javacore.chapter20;

public class PrintfDemo {
    public static void main(String[] args) {
        System.out.println("Below are some values in different formats.\n");

        System.out.println("Different integer formats: ");
        System.out.printf("%d %(d %+d %05d\n", 3, -3, 3, 3);
        System.out.println();
        System.out.printf("Float format by default: %f\n", 1234567.123);
        System.out.printf("Float format separated by coma: %,f\n", 1234567.123);
        System.out.printf("Format negative number with float by default: %,f\n", -1234567.123);
        System.out.printf("Other format of negative numbers with float: %,(f\n", -1234567.123);
        System.out.println();
        System.out.printf("Baseline positive and negative numeric values:\n");
        System.out.printf("% ,.2f\n% ,.2f\n", 1234567.123, -1234567.123);
    }
}
