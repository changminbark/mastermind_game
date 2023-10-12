/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2023
 * Instructor: Prof. Joshua Stough
 *
 * Section: MWF (10:00 AM - 10:50 AM)
 * Lab Section: Thursday (10:00 AM - 11:50 AM)
 *
 * Name: Nolan Lwin
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

/** The CodeBreaker class is responsible for taking the user's input and storing it as the secret code. */
public class CodeBreaker {

    /** The secret code. */
    private String secretCode;

    /** The constructor for the CodeBreaker class. */
    public CodeBreaker() {
        secretCode = "";
    }

    /** The method to take the user's input and store it as the secret code. */
    public String takeInput() {
        Scanner scanner = new Scanner(System.in);

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

    /** The method to get the secret code. */
    public String getSecretCode() {
        return secretCode;
    }

//    /** The method to set the secret code. */
//    public static void main(String[] args) {
//        CodeBreaker codeBreaker = new CodeBreaker();
//
//        System.out.println("Welcome to CodeBreaker!");
//        System.out.println("Enter a 4-digit secret code:");
//
//        // Take user input and set the secret code
//        String secretCode = codeBreaker.takeInput();
//        System.out.println("Secret code set: " + secretCode);
//    }
}