package hexlet.code.games;

import hexlet.code.EngineV3;

import java.util.Random;

public class PrimeGame {

    public static final int BOUND = 100;

    public static void startGame() {
        String rule = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

        Random random = new Random();
        String[][] questions = new String[3][2];

        for (int i = 0; i < questions.length; i++) {
            int num = random.nextInt(BOUND);

            boolean correctAnswer = isPrime(num);

            questions[i] = new String[]{String.valueOf(num), correctAnswer ? "yes" : "no"};
        }

        EngineV3.play(rule, questions);
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
