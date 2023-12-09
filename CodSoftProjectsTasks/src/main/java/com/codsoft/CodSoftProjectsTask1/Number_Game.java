package com.codsoft.CodSoftProjectsTask1;


import java.util.Scanner;
import java.util.Random;

public class Number_Game {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int attemptsLimit = 8; // Number of attempts allowed
        int roundsWon = 0;

        while (playAgain) {
            int randomNumber = generateRandomNumber(1, 100, random);
            int attempts = 0;
            boolean guessed = false;

            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("Guess the number between 1 and 100. You have " + attemptsLimit + " attempts.");

            while (!guessed && attempts < attemptsLimit) {
                System.out.print("Enter your guess: ");
                int userGuess = getUserInput(sc);

                if (userGuess == randomNumber) {
                    System.out.println("Congratulations!(You Won One crore) You guessed the correct number in " + attempts + " attempts.");
                    roundsWon++;
                    guessed = true;
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low!! Try again.");
                } else {
                    System.out.println("Too high!! Try again.");
                }
                attempts++;
            }

            if (!guessed) {
                System.out.println("Sorry, you've used all your attempts. The number was: " + randomNumber);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playChoice = sc.next().toLowerCase();
            playAgain = playChoice.equals("yes");

            if (!playAgain) {
                System.out.println("Thank you for playing! Rounds won: " + roundsWon);
            }
        }

        sc.close();
    }

    // Method to generate a random number within the specified range
    public static int generateRandomNumber(int min, int max, Random random) {
        return random.nextInt(max - min + 1) + min;
    }

    // Method to get user input and handle non-integer inputs
    public static int getUserInput(Scanner scanner) {
        while (true) {
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.println("Please enter a valid number.");
                scanner.next(); // to clear the invalid input from scanner
            }
        }
    }
}
