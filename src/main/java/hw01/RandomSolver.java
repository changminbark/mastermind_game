/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2023
 * Instructor: Prof. Joshua Stough
 *
 * Section: MWF (10:00 AM - 10:50 AM)
 * Lab Section: Thursday (10:00 AM - 11:50 AM)
 *
 * Name: Nolan Lwin and Chang Min
 * Date: 10/17/23
 * Time: 7:26 PM
 *
 * Project: csci205_hw
 * Package: hw01
 * Class: RandomSolver
 *
 * Description: The class that represents the random solver.
 *
 * ****************************************
 */

package hw01;

import java.util.Random;

/**
 * The RandomSolver solves the Mastermind game by randomly guessing the code.
 */
public class RandomSolver extends SolverCodeBreaker {

    /**
     * The space of possible pegs for the code.
     * Let's assume pegs can be one of these 6 numbers.
     */
    static final char[] POSSIBLE_PEGS = {'1', '2', '3', '4', '5', '6'};

    /**
     * The length of the code to guess.
     */
    static final int CODE_LENGTH = 4;

    /**
     * Random number generator.
     */
    private Random random = new Random();

    public RandomSolver() {
        super();
        setSolverType("RANDOM SOLVER");
    }

    /**
     * @override The method to take the user's input and store it as the guess code.
     * @return The randomly generated guess code.
     */
    public String takeInput() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < CODE_LENGTH; i++) {
            sb.append(POSSIBLE_PEGS[random.nextInt(POSSIBLE_PEGS.length)]);
        }
        return sb.toString();
    }

    /**
     * @override The method to analyze the results of the game.
     */
    public void analyzeRes() {
    }
}