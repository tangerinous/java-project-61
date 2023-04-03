package hexlet.code.games;

import hexlet.code.EngineV3;

import java.util.Random;

public class ProgressionGame {

    public static final int BOUND_START = 100;
    public static final int BOUND_STEP = 10;
    public static final int BOUND_ORIGIN = 5;
    public static final int BOUND_LIMIT = 10;

    public static void startGame() {
        String rule = "What number is missing in the progression?";

        Random random = new Random();
        String[][] questions = new String[3][2];

        for (int i = 0; i < questions.length; i++) {
            int start = random.nextInt(BOUND_START);
            int step = random.nextInt(BOUND_STEP);
            int length = random.nextInt(BOUND_ORIGIN, BOUND_LIMIT);

            int[] arr = generateProgression(start, step, length);
            int hideElemPos = new Random().nextInt(arr.length);
            String maskedProgression = maskProgression(arr, hideElemPos);

            int correctAnswer = arr[hideElemPos];
            questions[i] = new String[]{maskedProgression, String.valueOf(correctAnswer)};
        }
        EngineV3.play(rule, questions);
    }

    private static String maskProgression(int[] arr, int hideElemPos) {
        StringBuilder strB = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            strB.append(i != hideElemPos ? arr[i] : "..").append(" ");
        }
        return strB.toString();
    }

    private static int[] generateProgression(int start, int step, int length) {

        int[] arr = new int[length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = start;
            start += step;
        }

        return arr;
    }

}
