import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int attemptsLimit = 5;
        int score = 0;

        System.out.println("Welcome to the Guess the Number game!");

        boolean playAgain = true;
        while (playAgain) {
            System.out.println("You have " + attemptsLimit + " attempts to guess the number between "
                + minRange + " and " + maxRange);
            int generatedNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            boolean guessedCorrectly = false;

            while (attempts < attemptsLimit && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == generatedNumber) {
                    System.out.println("Congratulations! You've guessed the number (" + generatedNumber + ") correctly in " + attempts + " attempts.");
                    score += attemptsLimit - attempts + 1; // Incrementing score based on remaining attempts
                    guessedCorrectly = true;
                } else if (guess < generatedNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts. The correct number was: " + generatedNumber);
            }

            System.out.print("Would you like to play again? (yes/no): ");
            String playAgainResponse = scanner.next().toLowerCase();
            playAgain = playAgainResponse.equals("yes") || playAgainResponse.equals("y");
        }

        System.out.println("Your final score: " + score);
        scanner.close();
    }
}