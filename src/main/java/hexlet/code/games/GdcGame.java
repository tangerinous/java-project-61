package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

import static java.lang.System.out;

public class GdcGame {
    public static void start(Scanner scanner, String name) {
        Engine engine = new Engine(scanner, 3, name);

        while (engine.shouldContinue()) {
            out.println("Find the greatest common divisor of given numbers.");
            Random random = new Random();
            int operation = random.nextInt(3);

            int left = random.nextInt(100);
            int right = random.nextInt(100);

            String question = String.format("%d %d", left, right);

            int correctAnswer = calcNod(left, right);
            String answer = engine.askQuestion(question);


            engine.checkAnswer(answer, String.valueOf(correctAnswer));
        }
    }

    private static int calcNod(int left, int right) {
        int max = Integer.max(left, right);
        int min = Integer.min(left, right);

        while (min > 1) {
            int mod = max % min;
            if (mod == 0) {
                return min;
            } else {
                max = min;
                min = mod;
            }
        }
        return 1;
    }


}
