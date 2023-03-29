package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

import static java.lang.System.out;

public class ProgressionGame {
    public static void start(Scanner scanner, String name) {
        Engine engine = new Engine(scanner, 3, name);

        while (engine.shouldContinue()) {
            out.println("What number is missing in the progression?");
            Random random = new Random();
            int start = random.nextInt(100);
            int step = random.nextInt(10);
            int length = random.nextInt(5, 11);
            int hideElemPos = random.nextInt(length);
            int[] arr = new int[length];

            StringBuilder strB = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                arr[i] = start;
                start += step;
                strB.append(i != hideElemPos ? arr[i] : "...").append(" ");
            }

            int correctAnswer = arr[hideElemPos - 1] + step;
            String answer = engine.askQuestion(strB.toString());

            engine.checkAnswer(answer, String.valueOf(correctAnswer));
        }
    }


}
