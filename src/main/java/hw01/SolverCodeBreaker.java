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
import java.util.Collections;

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
     * The time it took for the game to simulate
     */
    private long playTime;

    /**
     * The list that represents the attempts for each game the solver made
     */
    private ArrayList<Integer> attemptsArr;

    /**
     * The default constructor for solvers
     */
    public SolverCodeBreaker() {
        super();
        numGames = 0;
        playTime = 0;
        attemptsArr = new ArrayList<Integer>();
    }


    // DEFAULT METHODS
    /**
     * Calculates the average number of turns it took to crack the code for all attempts
     * @return the average number of turns
     */
    public double calcAvgAttempt() {
        double average = this.attemptsArr.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0.0);
        return average;
    }

    /**
     * Finds the shortest attempt (smallest value of turns)
     * @return the smallest value of turns
     */
    public int shortestAttempt() {
        Collections.sort(this.attemptsArr);
        return this.attemptsArr.get(0);
    }

    /**
     * Finds the longest attempt (largest value of turns)
     * @return the largest value of turns
     */
    public int longestAttempt() {
        Collections.sort(this.attemptsArr);
        return this.attemptsArr.get(this.attemptsArr.size() - 1);
    }

    /**
     * Starts/sets the playTime so that when the {@code recordTime()} is called, the time is correct.
     */
    public void startTime() {
        this.playTime = System.nanoTime();
    }

    /**
     * Records the time the program took to simulate the solvers.
     * @return the time it took to simulate the solvers
     */
    public long recordTime() {
        this.playTime = System.nanoTime() - this.playTime;
        return this.playTime;
    }
}