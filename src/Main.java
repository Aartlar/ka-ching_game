import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        startGame();
    }

    //Game initializer / main loop
    public static void startGame() {
        Scanner userInput = new Scanner(System.in);
        int turn = 1;

        System.out.println("Welcome to ka-ching game!");
        System.out.println("You will by prompted for number, ");
        System.out.println("don't forget to call \"ka\", \"ching!\" \n" +
                "and \"ka-ching!\" in right time!");
        System.out.println();

        while(agree(turn)) {
            System.out.println("It's " + turn + " Turn");
            System.out.println("Provide an answer: ");
            String inputTemp = userInput.nextLine();

            if(isValid(turn, inputTemp)) {
                System.out.println("That is correct! Next one please");
            } else {
                System.out.println("You lose, next player please!");
            }


            turn++;
        }
    }

    //Prompts user if the game should be continued / Should be started
    public static boolean agree(int turn) {
        Scanner agreement = new Scanner(System.in);
        if(turn == 1) {
            System.out.println("Do you want to start a game? Y/N");
        } else {
            System.out.println("Do you want to continue? Y/N");
        }

        switch (agreement.nextLine().toUpperCase()) {
            case "Y":
                return true;
            case "N":
                System.out.println("Have a nice day :)");
                return false;
            default:
                System.out.println("Input not valid, try again!");
                return agree(turn);
        }
    }

    //Check if input fallows the rules
    public static boolean isValid(int turn, String answer) {
        if(turn % 15 == 0) {
            return answer.equals("ka-ching!");
        } else if(turn % 5 == 0) {
            return answer.equals("ching!");
        } else if(turn % 3 == 0) {
            return answer.equals("ka");
        } else {
            return answer.equals(Integer.toString(turn));
        }
    }
}