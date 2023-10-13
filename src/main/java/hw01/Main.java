/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2023
 * Instructor: Prof. Joshua Stough
 *
 * Name: Nolan Lwin and Chang Min
 * Section: 02
 * Date: 10/11/2023
 * Time: 10:26 AM
 *
 * Project: csci205_hw
 * Package: hw01
 * Class: Main
 *
 * Description: A class that runs the MasterMind game
 *
 * ****************************************
 */

package hw01;

/**
 * A class that runs the MasterMind game
 */
public class Main {

    /**
     * The main function to be run
     * @param args default main parameters
     */
    public static void main(String[] args) {
        GameManager game = new GameManager();
        game.run();
    }
}