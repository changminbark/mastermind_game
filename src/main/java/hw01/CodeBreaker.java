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
 * Description: The class that is responsible for taking the user's input and storing it as the secret code.
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
     * The number of attempts the user has made.
     */
    private int attempt;

    /**
     * The guess code from a user.
     */
    private String guessPegs;

    /**
     * The constructor for the CodeBreaker class.
     */
    public CodeBreaker() {
        guessPegs = "";
        attempt = 1;
    }

    /**
     * The method to take the user's input and store it as the guess code.
     */
    public String takeInput() {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        boolean isDone = false;

        System.out.println("Guess " + attempt + ": ");

        // Prompt the user to enter the secret code
        while (!isDone) {
            if (scanner.hasNextLine()) {
                input = scanner.nextLine();

                // Check if the input is valid
                if (input.length() != 4) {
                    System.out.println("Invalid input. Please enter a 4-digit code.");
                } else {
                    boolean isValid = true;
                    for (char digit : input.toCharArray()) {
                        if (digit < '1' || digit > '6') {
                            isValid = false;
                            break;
                        }
                    }

                    if (isValid) {
                        guessPegs = input;
                        isDone = true;
                        attempt++; // Increment attempt only if input is valid
                    } else {
                        System.out.println("Invalid input. Please enter a 4-digit code.");
                    }
                }
            }
        }
        return guessPegs;
    }

    /**
     * The method to get the number of attempts the user has made.
     */
    public int getAttempt() {
        return attempt;
    }

    /**
     * The method to set the number of attempts the user has made.
     */
    public void setAttempt(int attempt) {
        this.attempt = attempt;
    }
}