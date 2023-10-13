/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2023
 * Instructor: Prof. Joshua Stough
 *
 * Section: MWF (10:00 AM - 10:50 AM)
 * Lab Section: Thursday (10:00 AM - 11:50 AM)
 *
 * Name: Nolan Lwin and Chang Min
 * Date: 10/12/23
 * Time: 10:14 PM
 *
 * Project: csci205_hw
 * Package: hw01
 * Class: InvalidInputException
 *
 * Lab Assignment: Lab
 *
 * Description: The InvalidInputException class is responsible for throwing an exception when the user inputs an invalid input.
 *
 * ****************************************
 */

package hw01;

/**
 * The InvalidInputException class is responsible for throwing an exception when the user inputs an invalid input.
 */
public class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}
