package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

import static java.lang.System.out;

public class ProgressionGame {

    public static final int BOUND_START = 100;
    public static final int BOUND_STEP = 10;
    public static final int BOUND_ORIGIN = 5;
    public static final int BOUND_LIMIT = 10;
    public static final int MAX_CORRECT_ANSWERS = 3;

    public static void start(Scanner scanner, String name) {
        Engine engine = new Engine(scanner, MAX_CORRECT_ANSWERS, name);

        out.println("What number is missing in the progression?");
        while (engine.shouldContinue()) {

            int[] arr = generateProgression();
            int hideElemPos = new Random().nextInt(arr.length);
            String maskedProgression = maskProgression(arr, hideElemPos);

            int correctAnswer = arr[hideElemPos];
            String answer = engine.askQuestion(maskedProgression);

            engine.checkAnswer(answer, String.valueOf(correctAnswer));
        }
        out.printf("Congratulations, %s!\n", name);
    }

    private static String maskProgression(int[] arr, int hideElemPos) {
        StringBuilder strB = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            strB.append(i != hideElemPos ? arr[i] : "..").append(" ");
        }
        return strB.toString();
    }

    private static int[] generateProgression() {
        Random random = new Random();

        int start = random.nextInt(BOUND_START);
        int step = random.nextInt(BOUND_STEP);
        int length = random.nextInt(BOUND_ORIGIN, BOUND_LIMIT);
        int[] arr = new int[length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = start;
            start += step;
        }

        return arr;
    }

}
