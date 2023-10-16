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

    /**
     * A Board property that represents the board of the game
     */
    private Board board;

    /**
     * A CodeMaker property that represents the codemaker of the game
     */
    private CodeMaker codemaker;

    /**
     * A UserCodeBreaker property that represents the user of the game
     */
    private UserCodeBreaker usercodebreaker;

    // /**
    //  * A solver property that represents the A SPECIFIC SOLVER of the game
    //  */
    // private

    /**
     * A GameManager class constructor that initializes the state as NOT_READY
     */
    public GameManager() {
        this.state = GameState.NOT_READY;
    }

    /**
     * Main function that runs/simulates the MasterMind game
     */
    public void run(){
        // Setting up objects for mastermind
        usercodebreaker = new UserCodeBreaker();
        codemaker = new CodeMaker();
        boolean isDone;
        board = new Board();
        Scanner scnr = new Scanner(System.in);

        // Readying player for game
        this.state = GameState.READY;
        // Entering state/loop of playing game
        while (this.state != GameState.NOT_READY) {
            isDone = false;
            board.clearBoard();
            board.displayWelcomeMessage();
            codemaker.generateCode();
            usercodebreaker.setAttempt(1);
            this.state = GameState.CHECKING;

            // Entering the game loop for guessing
            while (!isDone) {
                String guess = usercodebreaker.takeInput();
                codemaker.setCurrentGuess(guess);
                board.setGuessPegs(guess);
                String scoringPegStr = codemaker.evaluateScoringPegs();
                board.placeScoringPegs(scoringPegStr);

                // Show hints/current state of board
                board.displayBoard();

                // If the person answers correctly (WIN)
                if (codemaker.checkGuess()){
                    this.state = GameState.WON;
                    board.displayWinningMessage(usercodebreaker.getAttempt());
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
                    board.displayLosingMessage(codemaker.getSecretCode());
                    if (scnr.nextLine().strip().equalsIgnoreCase("y")) {
                        this.state = GameState.READY;
                    } else {
                        this.state = GameState.NOT_READY;
                    }
                    isDone = true;
                }
            }
        }
        board.displayGoodbyeMessage();
    }
}