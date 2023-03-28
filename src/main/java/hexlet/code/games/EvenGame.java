package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

import static java.lang.System.out;

public class EvenGame {
    public static void start(Scanner scanner, String name) {
        int correctAnswers = 0;
        Engine engine = new Engine(scanner, 3, name);

        while (engine.shouldContinue()) {
            out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
            Random random = new Random();
            int num = random.nextInt(100);

            String answer = engine.askQuestion(num);

            boolean isEven = (num % 2) == 0;

            engine.checkAnswer(answer, isEven ? "yes" : "no");
        }
    }
}
