package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

import static java.lang.System.out;

public class CalcGame {
    public static void start(Scanner scanner, String name) {
        Engine engine = new Engine(scanner, 3, name);
        String[] ops = {"+", "-", "*"};

        while (engine.shouldContinue()) {
            out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
            Random random = new Random();
            int operation = random.nextInt(3);

            int left = random.nextInt(100);
            int right = random.nextInt(100);

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
            default -> 0;
        };
    }

}
