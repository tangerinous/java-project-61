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
        String[][] questionsAndAnswers = new String[EngineV3.QUESTIONS_SIZE][2];

        for (int i = 0; i < questionsAndAnswers.length; i++) {
            int start = random.nextInt(BOUND_START);
            int step = random.nextInt(BOUND_STEP);
            int length = random.nextInt(BOUND_ORIGIN, BOUND_LIMIT);

            int[] progression = generateProgression(start, step, length);
            int hideElemPos = new Random().nextInt(progression.length);
            String maskedProgression = maskProgression(progression, hideElemPos);

            int correctAnswer = progression[hideElemPos];
            questionsAndAnswers[i] = new String[]{maskedProgression, String.valueOf(correctAnswer)};
        }
        EngineV3.play(rule, questionsAndAnswers);
    }

    private static String maskProgression(int[] progression, int hideElemPos) {
        StringBuilder strB = new StringBuilder();
        for (int i = 0; i < progression.length; i++) {
            strB.append(i != hideElemPos ? progression[i] : "..").append(" ");
        }
        return strB.toString();
    }

    private static int[] generateProgression(int start, int step, int length) {

        int[] progression = new int[length];

        for (int i = 0; i < progression.length; i++) {
            progression[i] = start;
            start += step;
        }

        return progression;
    }

}
