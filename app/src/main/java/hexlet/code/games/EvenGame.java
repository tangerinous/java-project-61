package hexlet.code.games;

import java.util.Random;

public class EvenGame {

    public static final int BOUND = 100;
    public static final int MAX_CORRECT_ANSWERS = 3;

    public static String[] generateQuestion() {
        Random random = new Random();
        String[] questionAns = new String[2];
        int num = random.nextInt(BOUND);
        boolean isEven = (num % 2) == 0;

        questionAns[0] = String.valueOf(num);
        questionAns[1] = isEven ? "yes" : "no";
        return questionAns;
    }

}
