package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

import static java.lang.System.out;

public class EvenGame {

    public static final int BOUND = 100;
    public static final int MAX_CORRECT_ANSWERS = 3;

    public static void start(Scanner scanner, String name) {
        Engine engine = new Engine(scanner, MAX_CORRECT_ANSWERS, name);
        out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        while (engine.shouldContinue()) {
            Random random = new Random();
            int num = random.nextInt(BOUND);

            String answer = engine.askQuestion(num);

            boolean isEven = (num % 2) == 0;

            engine.checkAnswer(answer, isEven ? "yes" : "no");
        }
        out.printf("Congratulations, %s!\n", name);
    }
}
