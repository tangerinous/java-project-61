package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

import static java.lang.System.out;

public class PrimeGame {

    public static final int BOUND = 100;
    public static final int MAX_CORRECT_ANSWERS = 3;

    public static void start(Scanner scanner, String name) {
        Engine engine = new Engine(scanner, MAX_CORRECT_ANSWERS, name);

        while (engine.shouldContinue()) {
            out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
            Random random = new Random();

            int num = random.nextInt(BOUND);

            boolean correctAnswer = isPrime(num);
            String answer = engine.askQuestion(num);

            engine.checkAnswer(answer, correctAnswer ? "yes" : "no");
        }
        out.printf("Congratulations, %s!\n", name);
    }

    private static boolean isPrime(int num) {
        if (num == 1) {
            return true;
        }

        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

}
