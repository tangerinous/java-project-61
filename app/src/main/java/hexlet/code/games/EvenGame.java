package hexlet.code.games;

import hexlet.code.EngineV3;

import java.util.Random;

public class EvenGame {

    public static final int BOUND = 100;

    public static void startGame() {
        String rule = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        String[][] questionsAndAnswers = new String[EngineV3.QUESTIONS_SIZE][2];
        Random random = new Random();

        for (int i = 0; i < questionsAndAnswers.length; i++) {
            String[] questionAns = new String[2];
            int num = random.nextInt(BOUND);
            boolean isEven = (num % 2) == 0;

            questionAns[0] = String.valueOf(num);
            questionAns[1] = isEven ? "yes" : "no";
            questionsAndAnswers[i] = questionAns;
        }

        EngineV3.play(rule, questionsAndAnswers);
    }

}
