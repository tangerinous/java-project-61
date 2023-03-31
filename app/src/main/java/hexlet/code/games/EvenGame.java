package hexlet.code.games;

import java.util.Random;

public class EvenGame {

    public static final int BOUND = 100;

    public static String[] generateQuestion() {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        Random random = new Random();
        String[] questionAns = new String[2];
        int num = random.nextInt(BOUND);
        boolean isEven = (num % 2) == 0;

        questionAns[0] = String.valueOf(num);
        questionAns[1] = isEven ? "yes" : "no";
        return questionAns;
    }

}
