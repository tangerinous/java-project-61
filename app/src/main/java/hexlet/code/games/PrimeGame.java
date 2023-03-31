package hexlet.code.games;

import java.util.Random;

public class PrimeGame {

    public static final int BOUND = 100;

    public static String[] generateQuestion() {
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
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
