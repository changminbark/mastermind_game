/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2023
 * Instructor: Prof. Joshua Stough
 *
 * Name: Nolan Lwin and Chang Min
 * Section: 02
 * Date: 10/11/2023
 * Time: 10:26 AM
 *
 * Project: csci205_hw
 * Package: hw01
 * Class: Main
 *
 * Description: A class that runs the MasterMind game
 *
 * ****************************************
 */

package hw01;

import java.util.Scanner;

/**
 * A class that runs the MasterMind game
 */
public class Main {

    /**
     * The main function to be run
     * @param args default main parameters
     */
    public static void main(String[] args) {
        GameManager game = new GameManager();
        Scanner scnr = new Scanner(System.in);
        boolean isCompleted = false;
        System.out.println("Please enter a following option: user, random, minimax, genetic");

        while (!isCompleted) {
            if (scnr.hasNextLine()) {
                String input = scnr.nextLine();
                if (!input.equalsIgnoreCase("user") && !input.equalsIgnoreCase("random") && !input.equalsIgnoreCase("minimax") && !input.equalsIgnoreCase("genetic")) {
                    System.out.println("Invalid input. Please try again!");
                } else if (input.equalsIgnoreCase("user")){
                    game.runUser();
                    isCompleted = true;
                } else if (input.equalsIgnoreCase("random")){
                    game.runRandom();
                    isCompleted = true;
                } else if (input.equalsIgnoreCase("minimax")){
                    game.runMinimax();
                    isCompleted = true;
                } else if (input.equalsIgnoreCase("genetic")){
                    game.runGenetic();
                    isCompleted = true;
                }
            }
        }
    }
}