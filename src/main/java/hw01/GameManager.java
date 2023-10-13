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
    public void run(){

    }
}