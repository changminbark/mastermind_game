/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2023
 * Instructor: Prof. Joshua Stough
 *
 * Name: Nolan Lwin and Chang Min
 * Section: 02
 * Date: 10/10/2023
 * Time: 6:17 PM
 *
 * Project: csci205_hw
 * Package: hw01
 * Class: GameManager
 *
 * Description: A class that manages the game
 *
 * ****************************************
 */

package hw01;

import java.util.Scanner;

/**
 * An enum that represents the state of the game
 */
enum GameState {
    NOT_READY,
    READY,
    CHECKING,
    WON,
    LOST
}

/**
 * A class that manages the game
 */
public class GameManager {
    /**
     * A GameState property that determines the current state of the game
     */
    private GameState state;

    private Board board;

    private CodeMaker codemaker;

    private CodeBreaker codebreaker;


    /**
     * A GameManager class constructor that initializes the state as NOT_READY
     */
    public GameManager() {
        this.state = GameState.NOT_READY;
    }

    /**
     * Main function that runs/simulates the MasterMind game
     */
    public void run() throws InvalidInputException {
        codebreaker = new CodeBreaker();
        codemaker = new CodeMaker();
        boolean isDone;
        board = new Board();
        Scanner scnr = new Scanner(System.in);

        this.state = GameState.READY;
        while (this.state != GameState.NOT_READY) {
            isDone = false;
            board.clearBoard();
            board.displayWelcomeMessage();
            codemaker.generateCode();
            this.state = GameState.CHECKING;

            // Entering the game loop for guessing
            while (!isDone) {
                String guess = codebreaker.takeInput();
                codemaker.setCurrentGuess(guess);
                board.setGuessPegs(guess);
                String scoringPegStr = codemaker.evaluateScoringPegs();
                board.placeScoringPegs(scoringPegStr);

                // If the person answers correctly (WIN)
                if (codemaker.checkGuess()){
                    this.state = GameState.WON;
                    board.displayWinningMessage(codebreaker.getAttempt());
                    if (scnr.nextLine().strip().equalsIgnoreCase("y")){
                        this.state = GameState.READY;
                    } else {
                        this.state = GameState.NOT_READY;
                    }
                    isDone = true;
                    continue;
                }

                // If the person runs out of remaining guesses (LOSE)
                if (board.getRemainingGuesses() == 0) {
                    this.state = GameState.LOST;
                    board.displayLosingMessage();
                    if (scnr.nextLine().strip().equalsIgnoreCase("y")){
                        this.state = GameState.READY;
                    } else {
                        this.state = GameState.NOT_READY;
                    }
                    isDone = true;
                }
                // Show hints/current state of board
                board.displayBoard();
            }
        }
        board.displayGoodbyeMessage();
    }
}