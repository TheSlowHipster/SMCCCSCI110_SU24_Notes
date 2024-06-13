import java.util.Scanner;

class Example {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.print("How many pets do you have? ");
        int numPets = scnr.nextInt();
        if ((numPets < 4) && (numPets >= 0)) {
            System.out.println("You have a reasonable number of pets.");
        } else if ((numPets <= 6) || (numPets == 100)) {
            System.out.println("Wow, you have a lot of pets!");
        } else if (!(numPets > 90)) {
            System.out.println("You have so many pets how do you take care of them all?");
        } else {
            System.out.println("That's an interesting number of pets.");
        }
        System.out.println("After the if block");
    }
}