/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2023
 * Instructor: Prof. Joshua Stough
 *
 * Name: Chang Min Bark
 * Section: 02
 * Date: 10/10/2023
 * Time: 6:17 PM
 *
 * Project: csci205_hw
 * Package: hw01
 * Class: GameManager
 *
 * Description:
 *
 * ****************************************
 */
package hw01;

enum GameState {
    NOT_READY,
    READY,
    CHECKING,
    WON,
    LOST
}

public class GameManager {
    private GameState state;


    public GameManager() {
        this.state = GameState.NOT_READY;
    }

    /**
     * Main function that runs/simulates the MasterMind game
     * @param args - Default main parameters
     */
    public static void main(String[] args) {
        // NEED TO SET UP ALL OBJECTS (LIKE BOARD, CODEMAKER, CODEBREAKER)
        // NEED TO USE GAMESTATE TO CONTROL FLOW OF CODE
    }
}