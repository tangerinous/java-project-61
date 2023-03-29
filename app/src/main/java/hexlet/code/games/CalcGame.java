package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

import static java.lang.System.out;

public class CalcGame {

    public static final int BOUND = 100;
    public static final int ZERO = 0;
    public static final int MAX_CORRECT_ANSWERS = 3;

    public static void start(Scanner scanner, String name) {
        Engine engine = new Engine(scanner, MAX_CORRECT_ANSWERS, name);
        String[] ops = {"+", "-", "*"};

        while (engine.shouldContinue()) {
            out.println("What is the result of the expression?");
            Random random = new Random();
            int operation = random.nextInt(ops.length);

            int left = random.nextInt(BOUND);
            int right = random.nextInt(BOUND);

            String question = String.format("%d %s %d", left, ops[operation], right);

            String answer = engine.askQuestion(question);

            int correctAnswer = calculate(left, ops[operation], right);

            engine.checkAnswer(answer, String.valueOf(correctAnswer));
        }
    }

    private static int calculate(int left, String operation, int right) {
        return switch (operation) {
            case "+" -> left + right;
            case "-" -> left - right;
            case "*" -> left * right;
            default -> ZERO;
        };
    }

}
