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
 * Time: 12:23 PM
 *
 * Project: csci205_hw
 * Package: hw01
 * Class: CodeBreaker
 *
 * Lab Assignment: Lab
 *
 * Description: The abstract class that represents the code breaker.
 *
 * ****************************************
 */

package hw01.game;

import java.util.Scanner;

/**
 * The abstract class that represents the code breaker.
 */
public abstract class CodeBreaker {

     /**
     * The guess code from a user.
     */
    private String guessPegs;

    /**
     * The constructor for the CodeBreaker class.
     */
    public CodeBreaker() {
        guessPegs = "";
    }
}