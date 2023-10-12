/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2023
 * Instructor: Prof. Joshua Stough
 *
 * Section: MWF (10:00 AM - 10:50 AM)
 * Lab Section: Thursday (10:00 AM - 11:50 AM)
 *
 * Name: Nolan Lwin and Chang Min
 * Date: 10/12/23
 * Time: 12:23 PM
 *
 * Project: csci205_hw
 * Package: hw01
 * Class: CodeBreaker
 *
 * Lab Assignment: Lab
 *
 * Description:
 *
 * ****************************************
 */

package hw01;

import java.util.Scanner;

/**
 * The CodeBreaker class is responsible for taking the user's input and storing it as the secret code.
 */
public class CodeBreaker {

    /**
     * The secret code.
     */
    private String secretCode;

    /**
     * The scanner to take the user's input.
     */
    private Scanner scanner;

    /**
     * The constructor for the CodeBreaker class.
     */
    public CodeBreaker() {
        scanner = new Scanner(System.in);
        secretCode = "";
    }

    /**
     * The method to check if the user wants to play again.
     */
    public boolean askPlayAgain() {
        String userInput = scanner.nextLine().toUpperCase();

        // Check if the user input is 'Y' for yes
        return userInput.equals("Y");
    }

    /**
     * The method to take the user's input and store it as the secret code.
     */
    public String takeInput() {

        // Prompt the user to enter the secret code
        boolean isDone = false;
        while (!isDone) {
            String input = scanner.nextLine();

            // Check if the input is valid
            if (input.length() != 4) {
                System.out.println("Invalid input. Please enter a 4-digit code.");
            }
            // Check if the input is within the range [1-6]
            else if (input.contains("0") || input.contains("7") || input.contains("8") || input.contains("9")) {
                System.out.println("Invalid input. Please enter a 4-digit code.");
            }else {
                // Check if the input is a number
                try {
                    Integer.parseInt(input);
                    secretCode = input;
                    isDone = true;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a 4-digit code.");
                }
            }
        }
        return secretCode;
    }

    /**
     * The method to get the secret code.
     */
    public String getSecretCode() {
        return secretCode;
    }
}