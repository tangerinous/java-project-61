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
     * @param scanner
     * @param maxCorrectAnswers
     * @param name
     */
    public Engine(Scanner scanner, int maxCorrectAnswers, String name) {
        this.scanner = scanner;
        this.maxCorrectAnswers = maxCorrectAnswers;
        this.name = name;
    }

    /**
     * @return
     */
    public boolean shouldContinue() {
        return correctAnswers < maxCorrectAnswers;
    }

    /**
     * @param question
     * @return
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
