package hexlet.code;

import hexlet.code.games.EvenGame;

import java.util.Random;
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
                    0 - Exit""");

            out.print("Your choice: ");

            String choice = scanner.next();

            out.println("Welcome to the Brain Games!");

            out.println("May I have your name? ");

            String name = scanner.next();

            out.println("Hello, " + name);

            switch (choice) {
                case "2": {
                    EvenGame.start(scanner, name);
                    break;
                }
                default:
                    exit(1);
            }

            out.println("Goodbye");
        }
    }
}
