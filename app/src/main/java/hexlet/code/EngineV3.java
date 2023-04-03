package hexlet.code;

import java.util.Objects;
import java.util.Scanner;

import static java.lang.System.out;

public class EngineV3 {

    public static void play(String rules, String[][] questions) {
        try (Scanner scanner = new Scanner(System.in)) {

            String name = greeting(scanner);

            System.out.println(rules);
            for (int i = 0; i < questions.length; i++) {
                String answer = askQuestion(scanner, questions[i][0]);

                if (Objects.equals(answer, questions[i][1])) {
                    out.println("Correct!");
                } else {
                    out.printf("""
                            '%s' is wrong answer ;(. Correct answer was '%s'.
                            Let's try again, %s!
                            """, answer, questions[i][1], name);
                    break;
                }
            }
        }
    }

    public static String greeting(Scanner scanner) {
        out.println("Welcome to the Brain Games!");

        out.println("May I have your name? ");

        String name = scanner.next();

        out.println("Hello, " + name + "!");
        return name;
    }
    private static String askQuestion(Scanner scanner, Object question) {
        out.println("Question: " + question);
        out.println("Your answer: ");
        return scanner.next();
    }
}
