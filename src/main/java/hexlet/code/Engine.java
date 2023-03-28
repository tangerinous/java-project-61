package hexlet.code;

import java.util.Scanner;

import static java.lang.System.out;

public class Engine {
    private final Scanner scanner;
    private int correctAnswers = 0;

    private final int maxCorrectAnswers;

    private final String name;

    public Engine(Scanner scanner, int maxCorrectAnswers, String name) {
        this.scanner = scanner;
        this.maxCorrectAnswers = maxCorrectAnswers;
        this.name = name;
    }

    public boolean shouldContinue() {
        return correctAnswers < maxCorrectAnswers;
    }

    public String askQuestion(Object question) {
        out.println("Question " + question);
        return scanner.next();
    }

    public void correctAnswer() {
        out.println("Correct!");
        correctAnswers++;
    }

    public void notCorrectAnswer(String answer, String correct) {
        out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.\n" +
                "Let's try again, %s! \n", answer, correct, name);
    }
}
