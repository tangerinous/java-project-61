package hexlet.code.games;

import hexlet.code.EngineV3;

import java.util.Random;

public class CalcGame {

    public static final int BOUND = 100;
    private static final String[] OPS = {"+", "-", "*"};
    public static final int QUESTIONS_SIZE = 3;

    public static void startGame() {
        String rule = "What is the result of the expression?";

        String[][] questions = new String[QUESTIONS_SIZE][2];

        Random random = new Random();
        for (int i = 0; i < questions.length; i++) {
            int operation = random.nextInt(OPS.length);
            String[] questionAns = new String[2];

            int left = random.nextInt(BOUND);
            int right = random.nextInt(BOUND);

            String question = String.format("%d %s %d", left, OPS[operation], right);

            int correctAnswer = calculate(left, OPS[operation], right);

            questionAns[0] = question;
            questionAns[1] = String.valueOf(correctAnswer);
            questions[i] = questionAns;
        }

        EngineV3.play(rule, questions);
    }

    private static int calculate(int left, String operation, int right) {
        return switch (operation) {
            case "+" -> left + right;
            case "-" -> left - right;
            case "*" -> left * right;
            default -> throw new RuntimeException("Unexpected operation");
        };
    }

}
