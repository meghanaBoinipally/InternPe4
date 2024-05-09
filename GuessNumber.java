import java.util.Scanner;
import java.util.Random;

public class GuessNumber {
    private int numberToGuess;
    private int maxAttempts;
    private int attemptsLeft;
    private boolean hasWon;

    public GuessNumber(int min, int max, int maxAttempts) {
        Random rand = new Random();
        this.numberToGuess = rand.nextInt(max - min + 1) + min;
        this.maxAttempts = maxAttempts;
        this.attemptsLeft = maxAttempts;
        this.hasWon = false;
    }

    public void playGame() {
        System.out.println("Welcome to Guess the Number!");
        System.out.println("I have chosen a number between 1 and 100. You have " + maxAttempts + " attempts to guess it.");

        Scanner scanner = new Scanner(System.in);
        int guess;

        while (attemptsLeft > 0 && !hasWon) {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            attemptsLeft--;

            if (guess == numberToGuess) {
                hasWon = true;
                System.out.println("Congratulations! You've guessed the number " + numberToGuess + " correctly!");
            } else if (guess < numberToGuess) {
                System.out.println("Too low! You have " + attemptsLeft + " attempts left.");
            } else {
                System.out.println("Too high! You have " + attemptsLeft + " attempts left.");
            }
        }

        if (!hasWon) {
            System.out.println("Sorry, you've used all your attempts. The number I was thinking of was: " + numberToGuess);
        }

        scanner.close();
    }

    public static void main(String[] args) {
        GuessNumber game = new GuessNumber(1, 100, 10);
        game.playGame();
    }
}
