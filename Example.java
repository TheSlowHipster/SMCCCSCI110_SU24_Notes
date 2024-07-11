import java.util.Arrays;
import java.util.Scanner;

class Example {
    // public - anyone can use this
    // static - shared across all instances (created by `new Example()`)
    // final - does not change
    public static final int SET_SIZE = 10;

    // private - Only this class

    // protected - Only this package

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        Test testOne = new Test();
        testOne.var = 5;
        Test testTwo = new Test();

        System.out.println(testOne);
        System.out.println(testTwo);
        System.out.println("\n");
    }
}