package hexlet.code;

import hexlet.code.games.*;

import java.util.Objects;
import java.util.Scanner;

import static java.lang.System.exit;
import static java.lang.System.out;

public class EngineV2 {
    public static void startGame(Scanner scanner) {
        int correctAnswers = 0;

        String choice = scanner.next();
        if ("1".equals(choice)) {
            Cli.greeting(scanner);
            return;
        }

        String name = Cli.greeting(scanner);

        while (correctAnswers < 3) {
            String[] question = generateQuestion(choice);

            String answer = askQuestion(scanner, question[0]);

            if (Objects.equals(answer, question[1])) {
                out.println("Correct!");
                correctAnswers++;
            } else {
                out.printf("""
                '%s' is wrong answer ;(. Correct answer was '%s'.
                Let's try again, %s!
                """, answer, question[1], name);
                correctAnswers = Integer.MAX_VALUE;

            }

        }
    }

    private static String askQuestion(Scanner scanner, Object question) {
        out.println("Question: " + question);
        out.println("Your answer: ");
        return scanner.next();
    }


    private static String[] generateQuestion(String choice) {
        return switch (choice) {
//            case "2" -> EvenGame.generateQuestion();
            case "3" -> CalcGame.generateQuestion();
//            case "4" -> GcdGame.generateQuestion();
//            case "5" -> ProgressionGame.generateQuestion();
//            case "6" -> PrimeGame.generateQuestion();
            default -> throw new RuntimeException("Unknown choice");
        };
    }
}
