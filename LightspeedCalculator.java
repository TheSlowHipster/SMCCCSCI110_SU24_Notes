import java.util.*;

class LightspeedCalculator {
    public static double LIGHT_SPEED_MPH = 671000001.0;

    public static void main(String[] args) {

        System.out.println("How many miles is it to the planet?");
        // Open the terminal input as a scanner
        Scanner scnr = new Scanner(System.in);
        double distance = scnr.nextDouble();
        System.out.println("Your planet would take " + distance / LIGHT_SPEED_MPH + " hours to travel to.");
    }
}