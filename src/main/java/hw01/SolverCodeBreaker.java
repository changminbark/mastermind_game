/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2023
 * Instructor: Prof. Joshua Stough
 *
 * Name: Chang Min Bark
 * Section: 02
 * Date: 10/16/2023
 * Time: 10:13 AM
 *
 * Project: csci205_hw
 * Package: hw01
 * Class: SolverCodeBreaker
 *
 * Description:
 *
 * ****************************************
 */
package hw01;

import java.util.ArrayList;
import java.util.List;

public abstract class SolverCodeBreaker extends CodeBreaker {
    /**
     * The guess code from the solver.
     */
    private String guessPegs;

    /**
     * The number of games the solver simulated/played
     */
    private int numGames;

    /**
     * The list that represents the attempts for each game the solver made
     */
    private List<Integer> attemptsArr;

    /**
     * The default constructor for solvers
     */
    public SolverCodeBreaker() {
        super();
        numGames = 0;
        attemptsArr = new ArrayList<>();
    }

    // NEED TO WORK ON THIS MORE
    public abstract void analyzeRes();

    // DEFAULT METHODS
    public int calcAvgAttempt() {

    }

    public int shortestAttempt() {

    }

    public int longestAttempt() {

    }

    public int recordTime() {

    }
}