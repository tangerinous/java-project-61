package hexlet.code.games;

import java.util.Random;

import static java.lang.System.out;

public class CalcGame {

    public static final int BOUND = 100;
    private static final String[] OPS = {"+", "-", "*"};

    public static String[] generateQuestion() {
        out.println("What is the result of the expression?");
        String[] questionAns = new String[2];

        Random random = new Random();
        int operation = random.nextInt(OPS.length);

        int left = random.nextInt(BOUND);
        int right = random.nextInt(BOUND);

        String question = String.format("%d %s %d", left, OPS[operation], right);

        int correctAnswer = calculate(left, OPS[operation], right);

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
