package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

import static java.lang.System.out;

public class EvenGame {
    public static void start(Scanner scanner, String name) {
        int correctAnswers = 0;
        Engine engine = new Engine(scanner, 3, name);

        while (correctAnswers < 3) {
            out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
            Random random = new Random();
            int num = random.nextInt(100);

            String answer = engine.askQuestion(num);

            boolean isEven = (num % 2) == 0;
            switch (answer) {
                case "yes" -> {
                    if (isEven) {
                        engine.correctAnswer();
                    } else {
                        engine.notCorrectAnswer(answer, "no");
                    }
                }
                case "no" -> {
                    if (isEven) {
                        engine.notCorrectAnswer(answer, "yes");
                    } else {
                        engine.correctAnswer();
                    }
                }
                default -> out.println("Answers may be only 'yes' or 'not'");
            }
        }
    }
}
