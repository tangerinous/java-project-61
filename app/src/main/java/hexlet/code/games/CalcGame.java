package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;

import static java.lang.System.out;

public class CalcGame {

    public static final int BOUND = 100;
    public static final int ZERO = 0;
    public static final int MAX_CORRECT_ANSWERS = 3;
    private static final String[] ops = {"+", "-", "*"};

    public static String[] generateQuestion() {
        String[] questionAns = new String[2];

        Random random = new Random();
        int operation = random.nextInt(ops.length);

        int left = random.nextInt(BOUND);
        int right = random.nextInt(BOUND);

        String question = String.format("%d %s %d", left, ops[operation], right);

        int correctAnswer = calculate(left, ops[operation], right);

        questionAns[0] = question;
        questionAns[1] = String.valueOf(correctAnswer);
        return questionAns;
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
