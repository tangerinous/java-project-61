package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

import static java.lang.System.out;

public class PrimeGame {

    public static final int BOUND = 100;
    public static final int MAX_CORRECT_ANSWERS = 3;

    public static String[] generateQuestion() {
        Random random = new Random();

        int num = random.nextInt(BOUND);

        boolean correctAnswer = isPrime(num);

        return new String[]{String.valueOf(num), correctAnswer ? "yes" : "no"};

    }

    private static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }

        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

}
