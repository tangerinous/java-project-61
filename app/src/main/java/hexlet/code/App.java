package hexlet.code;

import hexlet.code.games.*;

import java.util.Scanner;

import static java.lang.System.out;

public class App {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            out.println("Please enter the game number and press Enter.");
            out.println("""
                    1 - Greet
                    2 - Even
                    3 - Calc
                    4 - GCD
                    5 - Progression
                    6 - Prime
                    0 - Exit""");

            out.print("Your choice: ");

            String choice = scanner.next();
            if ("1".equals(choice)) {
                Cli.greeting(scanner);
                return;
            }

            switch (choice) {
                case "2" -> EvenGame.startGame();
                case "3" -> CalcGame.startGame();
                case "4" -> GcdGame.startGame();
                case "5" -> ProgressionGame.startGame();
                case "6" -> PrimeGame.startGame();
                default -> throw new RuntimeException("Unknown choice");
            }
            out.println("Goodbye");
        }
    }

}
