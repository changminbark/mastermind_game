/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2023
 * Instructor: Prof. Joshua Stough
 *
 * Section: MWF (10:00 AM - 10:50 AM)
 * Lab Section: Thursday (10:00 AM - 11:50 AM)
 *
 * Name: Nolan Lwin and Chang Min
 * Section: 02
 * Date: 10/16/2023
 * Time: 10:13 AM
 *
 * Project: csci205_hw
 * Package: hw01
 * Class: SolverCodeBreaker
 *
 * Description: The abstract class that represents the algorithmic solver as a code breaker.
 *
 * ****************************************
 */

package hw01.solver;

import hw01.game.CodeBreaker;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

public abstract class SolverCodeBreaker extends CodeBreaker {
    /**
     * The guess code from the solver.
     */
    String guessPegs;

    /**
     * The time it took for the game to simulate
     */
    private double playTime;

    /**
     * The list that represents the attempts for each game the solver made
     */
    private ArrayList<Integer> attemptsArr;


    /**
     * A string that represents the solver type
     */
    private String solverType;

    /**
     * The default constructor for solvers
     */
    public SolverCodeBreaker() {
        super();
        playTime = 0;
        attemptsArr = new ArrayList<Integer>();
    }


    // DEFAULT METHODS
    /**
     * Calculates the average number of turns it took to crack the code for all attempts
     * @return the average number of turns
     */
    public String calcAvgAttempt() {
        DecimalFormat df = new DecimalFormat("0.###");
        double average = this.attemptsArr.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0.0);
        return df.format(average);
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
    public void recordTime() {
        this.playTime = System.nanoTime() - this.playTime;
    }

    /**
     * A method that adds the number of attempts for a given run to the attempts array
     * @param attempts the number of turns that took for a run to complete
     */
    public void addAttempt(int attempts) {
        this.attemptsArr.add(attempts);
    }

    /**
     * Getter for solvertype
     * @return a String for solver type
     */
    public String getSolverType() {
        return solverType;
    }

    /**
     * Setter for solvertype
     * @param solverType the string for solver type
     */
    public void setSolverType(String solverType) {
        this.solverType = solverType;
    }

    /**
     * Getter for playtime
     * @return A string that represents playtime
     */
    public String getPlayTime() {
        DecimalFormat df = new DecimalFormat("0.###");
        return df.format(this.playTime/ 1000000000.0);
    }
}