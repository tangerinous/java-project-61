package hexlet.code;

import hexlet.code.games.CalcGame;
import hexlet.code.games.EvenGame;
import hexlet.code.games.GcdGame;
import hexlet.code.games.ProgressionGame;

import java.util.Scanner;

import static java.lang.System.exit;
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
                    0 - Exit""");

            out.print("Your choice: ");

            String choice = scanner.next();

            out.println("Welcome to the Brain Games!");

            out.println("May I have your name? ");

            String name = scanner.next();

            out.println("Hello, " + name);

            switch (choice) {
                case "2" -> {
                    EvenGame.start(scanner, name);
                }
                case "3" -> {
                    CalcGame.start(scanner, name);
                }
                case "4" -> {
                    GcdGame.start(scanner, name);
                }
                case "5" -> {
                    ProgressionGame.start(scanner, name);
                }
                default -> exit(1);
            }

            out.println("Goodbye");
        }
    }
}
