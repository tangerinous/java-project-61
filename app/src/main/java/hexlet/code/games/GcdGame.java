package hexlet.code.games;

import hexlet.code.EngineV3;

import java.util.Random;

public class GcdGame {

    public static final int BOUND = 100;

    public static void startGame() {
        String rule = "Find the greatest common divisor of given numbers.";

        Random random = new Random();
        String[][] questions = new String[3][2];
        for (int i = 0; i < questions.length; i++) {

            int left = random.nextInt(BOUND);
            int right = random.nextInt(BOUND);

            String question = String.format("%d %d", left, right);
            int correctAnswer = calcNod(left, right);
            questions[i] = new String[]{question, String.valueOf(correctAnswer)};
        }

        EngineV3.play(rule, questions);
    }

    private static int calcNod(int left, int right) {
        int max = Integer.max(left, right);
        int min = Integer.min(left, right);

        if (min == 0) {
            return 1;
        }

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
