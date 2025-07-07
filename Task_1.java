package Cod_Soft;

import java.util.Scanner;
import java.util.Random;

public class Task_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int maxAttempts = 10;
        int score = 0;
        int round = 1;
        System.out.println(" Welcome to the Number Guessing Game!");
        boolean playAgain = true;
        while (playAgain) {
            int rand = random.nextInt(100) + 1;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\n Round " + round + " begins! Guess a number between  1  and 100: ");
            System.out.println("You have " + maxAttempts + " attempts");

            while (attempts < maxAttempts) {
                System.out.print("Attempt " + (attempts + 1) + ": Enter your guess: ");

                // Handle invalid input
                if (!sc.hasNextInt()) {
                    System.out.println("Please enter a valid number!");
                    sc.next(); // discard invalid input
                    continue;
                }
                int guess = sc.nextInt();
                attempts++;


                if (guess < rand) {
                    System.out.println("Too low!");
                } else if (guess > rand) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Correct! You guessed it in " + attempts + " attempts.");
                    score++;
                    guessedCorrectly = true;
                    break;
                }
            }

            if (!guessedCorrectly) {
                System.out.println("You're out of attempts! The correct number was: " + rand);
            }

            System.out.println("Score: " + score + " | Rounds Played: " + round);

            System.out.print("Do you want to play another round? (yes/no): ");
            String response = sc.next().toLowerCase();
            if (!response.equals("yes")) {
                playAgain = false;
            }
            round++;
        }

        System.out.println("Thanks for playing! Final Score: " + score);
        sc.close();
    }
}
