package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

import static java.lang.System.out;

public class ProgressionGame {

    public static final int BOUND_START = 100;
    public static final int BOUND_STEP = 10;
    public static final int BOUND_ORIGIN = 5;
    public static final int BOUND_LIMIT = 11;
    public static final int MAX_CORRECT_ANSWERS = 3;

    public static void start(Scanner scanner, String name) {
        Engine engine = new Engine(scanner, MAX_CORRECT_ANSWERS, name);

        out.println("What number is missing in the progression?");
        while (engine.shouldContinue()) {
            Random random = new Random();
            int start = random.nextInt(BOUND_START);
            int step = random.nextInt(BOUND_STEP);
            int length = random.nextInt(BOUND_ORIGIN, BOUND_LIMIT);
            int hideElemPos = random.nextInt(length);
            int[] arr = new int[length];

            StringBuilder strB = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                arr[i] = start;
                start += step;
                strB.append(i != hideElemPos ? arr[i] : "...").append(" ");
            }

            int correctAnswer = arr[hideElemPos - 1] + step;
            String answer = engine.askQuestion(strB.toString());

            engine.checkAnswer(answer, String.valueOf(correctAnswer));
        }
        out.printf("Congratulations, %s!\n", name);
    }


}
