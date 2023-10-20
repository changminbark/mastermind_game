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

package hw01.game;

import hw01.game.GameManager;

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
        System.out.println("Please enter a following option for a solver algorithm: user, random, minimax, dfs");

        while (!isCompleted) {
            if (scnr.hasNextLine()) {
                String input = scnr.nextLine();
                if (!input.equalsIgnoreCase("user") && !input.equalsIgnoreCase("random") && !input.equalsIgnoreCase("minimax") && !input.equalsIgnoreCase("genetic") && !input.equalsIgnoreCase("dfs")) {
                    System.out.println("Invalid input. Please try again!");
                } else if (input.equalsIgnoreCase("user")){
                    game.runUser();
                    isCompleted = true;
                    break;
                }
                System.out.println("Enter the number of games for the simulation");
                if (scnr.hasNextLine()){
                    int numGames = Integer.parseInt(scnr.nextLine());
                    if (input.equalsIgnoreCase("random")){
                        game.runRandom(numGames);
                        isCompleted = true;
                    } else if (input.equalsIgnoreCase("minimax")){
                        game.runMinimax(numGames);
                        isCompleted = true;
                    }
                    // CODE FOR GENETIC ALGORITHM THAT DOESN'T WORK
                    // else if (input.equalsIgnoreCase("genetic")){
                    //     game.runGenetic(numGames);
                    //     isCompleted = true;}
                    else if (input.equalsIgnoreCase("dfs")) {
                        game.runDFS(numGames);
                        isCompleted = true;
                    }
                }
            }
        }
    }
}