package hexlet.code.games;

import java.util.Random;

public class GcdGame {

    public static final int BOUND = 100;

    public static String[] generateQuestion() {
        System.out.println("Find the greatest common divisor of given numbers.");
        Random random = new Random();

        int left = random.nextInt(BOUND);
        int right = random.nextInt(BOUND);

        String question = String.format("%d %d", left, right);
        int correctAnswer = calcNod(left, right);
        return new String[]{question, String.valueOf(correctAnswer)};
    }

    private static int calcNod(int left, int right) {
        int max = Integer.max(left, right);
        int min = Integer.min(left, right);

        if(min == 0){
            return 1;
        }

        while (min > 1) {
            int mod = max % min;
            if (mod == 0) {
                return min;
            } else {
                max = min;
                min = mod;
            }
        }
        return 1;
    }


}
