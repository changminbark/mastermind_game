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
 * Description: The Board class to show the current guess, scoring, and remaining guesses of the player.
 *
 * ****************************************
 */

package hw01;

/**
 * The Board class is responsible for displaying the current state of the game.
 * It displays the current guess, the current scoring, and the number of remaining guesses.
 * It also displays a winning message if the player wins.
 * It also displays a goodbye message if the player quits.
 */
public class Board {

    /**
     * The current guess pegs.
     */
    private String currentGuessPegs;

    /**
     * The current scoring pegs.
     */
    private String currentScoringPegs;

    /**
     * The number of remaining guesses.
     */
    private int remainingGuesses;

    /**
     * The secret code.
     */
    private String secretCode;

    /**
     * The constructor for the Board class.
     * It initializes the current guess pegs, current scoring pegs, and the number of remaining guesses.
     * @param codeBreaker The CodeBreaker object containing the secret code.
     */
    public Board(CodeBreaker codeBreaker) {
        this.secretCode = codeBreaker.getSecretCode();
        currentGuessPegs = "";
        currentScoringPegs = "";
        remainingGuesses = 12;
    }

    /**
     * Clear the board.
     */
    public void clearBoard() {
        currentGuessPegs = "";
        currentScoringPegs = "";
        remainingGuesses = 12;
    }

    /**
     * Place the guess pegs.
     * @param codeGuess
     */
    public void placeGuessPegs(String codeGuess) {
        currentGuessPegs = codeGuess;
    }

    /**
     * Place the scoring pegs.
     * @param guessPegs
     */
    public void placeScoringPegs(String guessPegs) {
        currentScoringPegs = guessPegs;
        remainingGuesses--;
    }

    /**
     * Display the board.
     */
    public void displayBoard() {
        System.out.println("Guess my code, using numbers between 1 and 6. You have " + remainingGuesses + " guesses.");
        System.out.println("Guess " + (12 - remainingGuesses) + ": " + secretCode);
        System.out.println(currentGuessPegs + " --> " + currentScoringPegs + " Try again. " + remainingGuesses + " guesses left.");
    }

    /**
     * Display the winning message.
     * @param moves
     */
    public void displayWinningMessage(int moves) {
        System.out.println(currentGuessPegs + " --> " + currentScoringPegs + " YOU WON! You guessed the code in " + moves + " moves!");
        System.out.print("Would you like to play again? [Y/N]: ");
    }

    /**
     * Display the losing message.
     */
    public void displayLosingMessage() {
        System.out.println("You lost! The code was " + currentGuessPegs);
        System.out.print("Would you like to play again? [Y/N]: ");
    }

    /**
     * Display the goodbye message.
     */
    public void displayGoodbyeMessage() {
        System.out.println("Goodbye!");
    }
}