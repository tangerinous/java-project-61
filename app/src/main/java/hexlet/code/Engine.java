package hexlet.code;

import java.util.Objects;
import java.util.Scanner;

import static java.lang.System.out;

public class Engine {
    private final Scanner scanner;
    private int correctAnswers = 0;

    private final int maxCorrectAnswers;

    private final String name;


    /**
     * @param s
     * @param mca
     * @param nm
     */
    public Engine(Scanner s, int mca, String nm) {
        this.scanner = s;
        this.maxCorrectAnswers = mca;
        this.name = nm;
    }

    /**
     * @return bool
     */
    public boolean shouldContinue() {
        return correctAnswers < maxCorrectAnswers;
    }

    /**
     * @param question
     * @return string
     */
    public String askQuestion(Object question) {
        out.println("Question: " + question);
        out.println("Your answer: ");
        return scanner.next();
    }

    /**
     *
     */
    public void correctAnswer() {
        out.println("Correct!");
        correctAnswers++;
    }

    /**
     * @param answer
     * @param correct
     */
    public void notCorrectAnswer(String answer, String correct) {
        out.printf("""
                '%s' is wrong answer ;(. Correct answer was '%s'.
                Let's try again, %s!
                """, answer, correct, name);
        correctAnswers = Integer.MAX_VALUE;
    }

    /**
     * @param answer
     * @param correctAnswer
     */
    public void checkAnswer(String answer, String correctAnswer) {
        if (Objects.equals(answer, correctAnswer)) {
            correctAnswer();
        } else {
            notCorrectAnswer(answer, correctAnswer);
        }
    }
}
