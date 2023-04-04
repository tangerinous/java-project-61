package hexlet.code.games;

import hexlet.code.EngineV3;

import java.util.Random;

public class GcdGame {

    public static final int BOUND = 100;

    public static void startGame() {
        String rule = "Find the greatest common divisor of given numbers.";

        Random random = new Random();
        String[][] questionsAndAnswers = new String[EngineV3.QUESTIONS_SIZE][2];
        for (int i = 0; i < questionsAndAnswers.length; i++) {

            int left = random.nextInt(BOUND);
            int right = random.nextInt(BOUND);

            String question = String.format("%d %d", left, right);
            int correctAnswer = calcNod(left, right);
            questionsAndAnswers[i] = new String[]{question, String.valueOf(correctAnswer)};
        }

        EngineV3.play(rule, questionsAndAnswers);
    }

    private static int calcNod(int left, int right) {
        while (left != 0 && right != 0) {
            if (left > right) {
                left = left % right;
            } else {
                right = right % left;
            }
        }
        return left + right;
    }


}
