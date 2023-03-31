package hexlet.code;

import hexlet.code.games.CalcGame;
import hexlet.code.games.EvenGame;
import hexlet.code.games.GcdGame;
import hexlet.code.games.PrimeGame;
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
                    6 - Prime
                    0 - Exit""");

            out.print("Your choice: ");

            String choice = scanner.next();
            if ("1".equals(choice)) {
                Cli.greeting(scanner);
                return;
            }

            String name = Cli.greeting(scanner);

            Menu.processMenu(scanner, name, choice);

            out.println("Goodbye");
        }
    }

}
