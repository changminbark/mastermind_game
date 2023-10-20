/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2023
 * Instructor: Prof. Joshua Stough
 *
 * Section: MWF (10:00 AM - 10:50 AM)
 * Lab Section: Thursday (10:00 AM - 11:50 AM)
 *
 * Name: Nolan Lwin and Chang Min
 * Date: 10/10/23
 * Time: 7:49 PM
 *
 * Project: csci205_hw
 * Package: hw01
 * Class: Board
 *
 * Description: The Board class to show the current guess, scoring, remaining guesses, and other statistics.
 *
 * ****************************************
 */

package hw01.game;

import hw01.solver.SolverCodeBreaker;

/**
 * The Board class is responsible for displaying the current state of the game.
 * It displays the current guess, the current scoring, and the number of remaining guesses.
 * It also displays a winning message if the player wins.
 * It also displays a goodbye message if the player quits.
 */
public class Board {

    /**
     * The current scoring pegs.
     */
    private String currentScoringPegs;

    /**
     * The number of remaining guesses.
     */
    int remainingGuesses;

    /**
     * The secret code.
     */
    private String guessPegs;

    /**
     * The constructor for the Board class.
     * It initializes the current guess pegs, current scoring pegs, and the number of remaining guesses.
     */
    public Board() {
        currentScoringPegs = "";
        remainingGuesses = 12;
    }

    /**
     * Clear the board.
     */
    public void clearBoard() {
        currentScoringPegs = "";
        remainingGuesses = 12;
    }

    /**
     * Set the guess pegs.
     * @param guessPegs
     */
    public void setGuessPegs(String guessPegs) {
        this.guessPegs = guessPegs;
    }

    /**
     * Place the scoring pegs.
     * @param scoringPegs
     */
    public void placeScoringPegs(String scoringPegs) {
        currentScoringPegs = scoringPegs;
        remainingGuesses--;
    }

    /**
     * Display the welcome message.
     */
    public void displayWelcomeMessage() {
        System.out.println("Welcome to Mastermind!");
        System.out.println("Guess my code, using numbers between 1 and 6. You have " + remainingGuesses + " guesses.");
    }

    /**
     * Display the board.
     */
    public void displayBoard() {
        System.out.println(guessPegs + " --> " + currentScoringPegs + " Try again. " + remainingGuesses + " guesses left.");
    }

    /**
     * Display the winning message.
     * @param moves
     */
    public void displayWinningMessage(int moves) {
        System.out.println(guessPegs + " --> " + currentScoringPegs + " YOU WON! You guessed the code in " + moves + " moves!");
        System.out.print("Would you like to play again? [Y/N]: ");
    }

    /**
     * Display the losing message.
     */
    public void displayLosingMessage(String secretCode) {
        System.out.println("You lost! The code was " + secretCode + "!");
        System.out.print("Would you like to play again? [Y/N]: ");
    }

    /**
     * Display the goodbye message.
     */
    public void displayGoodbyeMessage() {
        System.out.println("Goodbye!");
    }

    /**
     * Get the remaining guesses.
     */
    public int getRemainingGuesses() {
        return remainingGuesses;
    }

    /**
     * Display the simulation statistics message
     * @param numGames Number of games run
     * @param solver Any solving algorithm
     */
    public void displaySimulationMessage(int numGames, SolverCodeBreaker solver) {
        System.out.println("RESULTS");
        System.out.println(solver.getSolverType() + " - Statistics:");
        System.out.println("Number of Games: " + numGames);
        System.out.println("Average: " + solver.calcAvgAttempt());
        System.out.println("Shortest: " + solver.shortestAttempt());
        System.out.println("Longest: " + solver.longestAttempt());
        System.out.println("TOTAL TIME: " + solver.getPlayTime() + " seconds");
    }
}