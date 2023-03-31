package hexlet.code;

import java.util.Scanner;

import static java.lang.System.out;

public class Cli {
    public static String greeting(Scanner scanner) {
        out.println("Welcome to the Brain Games!");

        out.println("May I have your name? ");

        String name = scanner.next();

        out.println("Hello, " + name + "!");
        return name;
    }

}
