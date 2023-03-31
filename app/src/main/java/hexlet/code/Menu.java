package hexlet.code;

import hexlet.code.games.*;

import java.util.Scanner;

import static java.lang.System.exit;

public class Menu {
    public static void processMenu(Scanner scanner, String name, String choice) {
        switch (choice) {
            case "2" -> EvenGame.start(scanner, name);
            case "3" -> CalcGame.start(scanner, name);
            case "4" -> GcdGame.start(scanner, name);
            case "5" -> ProgressionGame.start(scanner, name);
            case "6" -> PrimeGame.start(scanner, name);
            default -> exit(1);
        }

    }
}
