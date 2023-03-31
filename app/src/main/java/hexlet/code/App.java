package hexlet.code;

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

            EngineV2.startGame(scanner);

            out.println("Goodbye");
        }
    }

}
