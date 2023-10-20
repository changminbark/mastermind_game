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
 * Description: A class that manages the Mastermind game playing modes such as user, minimax, random, genetic, and DFS algorithms.
 *
 * ****************************************
 */

package hw01.game;

import hw01.solver.DFSSolver;
import hw01.solver.MinimaxSolver;
import hw01.solver.RandomSolver;

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
     * A specialized CodeMaker property for the minimax algorithm
     */
    private CodeMaker minimaxcodemaker;

    /**
     * A specialized CodeMaker property for the DFS algorithm
     */
    private CodeMaker dfscodemaker;

    /**
     * A UserCodeBreaker property that represents the user of the game
     */
    private UserCodeBreaker usercodebreaker;

    /**
     * A GameManager class constructor that initializes the state as NOT_READY
     */
    public GameManager() {
        this.state = GameState.NOT_READY;
    }

    /**
     * Driver method that runs/simulates the MasterMind game for a user to play
     */
    public void runUser(){
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

    /**
     * The driver method for the minimax algorithm
     * @param numGames number of games to be played
     */
    public void runMinimax(int numGames){
        // Setting up objects for mastermind
        MinimaxSolver minimax = new MinimaxSolver();
        codemaker = new CodeMaker();
        boolean isDone;
        board = new Board();

        // Readying minimax for game
        minimax.startTime();
        for (int i = 0; i < numGames + 1; i++) {
            this.state = GameState.READY;
            // Entering state/loop of playing game
            while (this.state != GameState.NOT_READY) {
                int numTurns = 0;
                isDone = false;
                board.clearBoard();
                codemaker.generateCode();
                this.state = GameState.CHECKING;

                minimax.reset();
                minimaxcodemaker = new CodeMaker();

                // Entering the game loop for guessing
                while (!isDone) {
                    String guess = minimax.takeInput(minimaxcodemaker);
                    codemaker.setCurrentGuess(guess);
                    board.setGuessPegs(guess);
                    String scoringPegStr = codemaker.evaluateScoringPegs();
                    minimaxcodemaker.setSecretCode(guess);
                    minimax.removePegCombinations(scoringPegStr, minimaxcodemaker);
                    board.placeScoringPegs(scoringPegStr);

                    // Show hints/current state of board
                    // board.displayBoard();
                    numTurns += 1;

                    // If the solver answers correctly (WIN)
                    if (codemaker.checkGuess()) {
                        this.state = GameState.NOT_READY;
                        isDone = true;
                        continue;
                    }
                }
                minimax.addAttempt(numTurns);
            }
        }
        minimax.recordTime();
        board.displaySimulationMessage(numGames, minimax);
        board.displayGoodbyeMessage();
    }

    /**
     * The driver method for running the random algorithm
     * @param numGames number of games to be played
     */
    public void runRandom(int numGames){
        // Setting up objects for mastermind
        RandomSolver random = new RandomSolver();
        codemaker = new CodeMaker();
        boolean isDone;
        board = new Board();

        // Readying random for game
        random.startTime();
        for (int i = 0; i < numGames + 1; i++) {
            this.state = GameState.READY;
            // Entering state/loop of playing game
            while (this.state != GameState.NOT_READY) {
                int numTurns = 0;
                isDone = false;
                board.clearBoard();
                codemaker.generateCode();
                this.state = GameState.CHECKING;

                // Entering the game loop for guessing
                while (!isDone) {
                    String guess = random.takeInput();
                    codemaker.setCurrentGuess(guess);
                    board.setGuessPegs(guess);
                    String scoringPegStr = codemaker.evaluateScoringPegs();
                    board.placeScoringPegs(scoringPegStr);

                    // Show hints/current state of board
                    // board.displayBoard();
                    numTurns += 1;

                    // If the solver answers correctly (WIN)
                    if (codemaker.checkGuess()) {
                        this.state = GameState.NOT_READY;
                        isDone = true;
                        continue;
                    }
                }
                random.addAttempt(numTurns);
            }
        }
        random.recordTime();
        board.displaySimulationMessage(numGames, random);
        board.displayGoodbyeMessage();
    }

    /**
     * The driver method for running the genetic algorithm
     * @param numGames number of games to be played
     */
    public void runGenetic(int numGames){
        // Setting up objects for mastermind
        RandomSolver random = new RandomSolver();
        codemaker = new CodeMaker();
        boolean isDone;
        board = new Board();

        // Readying random for game
        random.startTime();
        for (int i = 0; i < numGames + 1; i++) {
            this.state = GameState.READY;
            // Entering state/loop of playing game
            while (this.state != GameState.NOT_READY) {
                int numTurns = 0;
                isDone = false;
                board.clearBoard();
                codemaker.generateCode();
                this.state = GameState.CHECKING;

                // Entering the game loop for guessing
                while (!isDone) {
                    String guess = random.takeInput();
                    codemaker.setCurrentGuess(guess);
                    board.setGuessPegs(guess);
                    String scoringPegStr = codemaker.evaluateScoringPegs();
                    board.placeScoringPegs(scoringPegStr);

                    // Show hints/current state of board
                    board.displayBoard();

                    numTurns += 1;

                    // If the solver answers correctly (WIN)
                    if (codemaker.checkGuess()) {
                        this.state = GameState.NOT_READY;
                        isDone = true;
                        continue;
                    }
                }
                random.addAttempt(numTurns);
            }
        }
        random.recordTime();
        board.displaySimulationMessage(numGames, random);
        board.displayGoodbyeMessage();
    }

    /**
     * The driver method for running the DFS algorithm
     * @param numGames number of games to be played
     */
    public void runDFS(int numGames) {
        // Setting up objects for mastermind
        DFSSolver dfsSolver = new DFSSolver();
        codemaker = new CodeMaker();
        boolean isDone;
        board = new Board();

        // Readying DFS for game
        dfsSolver.startTime();
        for (int i = 0; i < numGames; i++) {
            this.state = GameState.READY;
            while (this.state != GameState.NOT_READY) {
                int numTurns = 0;
                isDone = false;
                board.clearBoard();
                codemaker.generateCode();
                this.state = GameState.CHECKING;
                dfscodemaker = new CodeMaker();

                dfsSolver.reset();

                // Entering the game loop for guessing
                while (!isDone) {
                    String guess = dfsSolver.takeInput();
                    if (guess == null) {
                        break;
                    }

                    codemaker.setCurrentGuess(guess);
                    board.setGuessPegs(guess);
                    String scoringPegStr = codemaker.evaluateScoringPegs();
                    board.placeScoringPegs(scoringPegStr);

                    // Show hints/current state of board

                    numTurns += 1;

                    // If the solver answers correctly (WIN)
                    if (codemaker.checkGuess()) {
                        this.state = GameState.NOT_READY;
                        isDone = true;
                        continue;
                    }
                }
                dfsSolver.addAttempt(numTurns);
            }
        }
        dfsSolver.recordTime();
        board.displaySimulationMessage(numGames, dfsSolver);
        board.displayGoodbyeMessage();
    }
}