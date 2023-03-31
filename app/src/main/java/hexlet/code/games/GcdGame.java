package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

import static java.lang.System.out;

public class GcdGame {

    public static final int BOUND = 100;
    public static final int MAX_CORRECT_ANSWERS = 3;

    public static String[] generateQuestion() {
        Random random = new Random();

        int left = random.nextInt(BOUND);
        int right = random.nextInt(BOUND);

        String question = String.format("%d %d", left, right);
        int correctAnswer = calcNod(left, right);
        return new String[]{question, String.valueOf(correctAnswer)};
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
