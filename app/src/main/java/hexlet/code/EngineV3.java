package hexlet.code;

import java.util.Objects;
import java.util.Scanner;

import static java.lang.System.out;

public class EngineV3 {

    public static void play(String rules, String[][] questions) {
        try (Scanner scanner = new Scanner(System.in)) {

            out.println("Welcome to the Brain Games!");

            out.println("May I have your name? ");

            String name = scanner.next();

            out.println("Hello, " + name + "!");

            System.out.println(rules);
            for (String[] question : questions) {

                out.println("Question: " + question[0]);
                out.println("Your answer: ");
                String answer = scanner.next();

                if (Objects.equals(answer, question[1])) {
                    out.println("Correct!");
                } else {
                    out.printf("""
                            '%s' is wrong answer ;(. Correct answer was '%s'.
                            Let's try again, %s!
                            """, answer, question[1], name);
                    break;
                }
            }
        }
    }
}
