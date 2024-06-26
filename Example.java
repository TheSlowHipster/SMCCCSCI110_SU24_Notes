import java.util.Scanner;

class Example {
    public enum Difficulty {
        EASY, BALANCED, HARD, UNFAIR
    }

    public static void main(String[] args) {
        Difficulty choice = getUserDifficultyChoice();
        switch (choice):
            case EASY:
                setPlayerHealth(200);
                break;
            case BALANCED:
                setPlayerHealth(100);
                break;
            case HARD:
                setPlayerHealth(50);
                break;
            case UNFAIR:
                setPlayerHealth(25);
                break;
    }
}