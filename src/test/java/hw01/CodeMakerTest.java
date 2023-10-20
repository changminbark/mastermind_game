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
 * Time: 3:50 PM
 *
 * Project: csci205_hw
 * Package: hw01
 * Class: CodeMakerTest
 *
 * Description: The CodeMakerTest class is responsible for testing the CodeMaker class.
 * ****************************************
 */

package hw01;

import hw01.game.CodeMaker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The CodeMakerTest class is responsible for testing the CodeMaker class.
 */
class CodeMakerTest {

    /**
     * The CodeMaker object to be tested
     */
    CodeMaker testCodeMaker;

    /**
     * Sets up the CodeMaker object to be tested
     */
    @BeforeEach
    void setUp() {
        testCodeMaker = new CodeMaker();
    }

    /**
     * Checks whether the codemaker checks the guess by comparing it to the secret code
     */
    @Test
    void checkGuess() {
        // Testing for secret code and current guess matching
        testCodeMaker.setSecretCode("1234");
        testCodeMaker.setCurrentGuess("1234");
        assertTrue(testCodeMaker.checkGuess());

        // Testing for secret code and current guess not matching
        testCodeMaker.setSecretCode("1234");
        testCodeMaker.setCurrentGuess("4324");
        assertFalse(testCodeMaker.checkGuess());
    }

    /**
     * Tests for the codemaker evaluating and returning the scoring peg message
     */
    @Test
    void evaluateScoringPegs() {
        // Testing for one combination
        testCodeMaker.setSecretCode("1234");
        testCodeMaker.setCurrentGuess("1324");
        assertEquals("**++", testCodeMaker.evaluateScoringPegs());

        // Testing for another combination
        testCodeMaker.setSecretCode("4444");
        testCodeMaker.setCurrentGuess("1324");
        assertEquals("*---", testCodeMaker.evaluateScoringPegs());
    }

    /**
     * Tests for the codemaker retrieving the number of pegs that have the correct color and the right positions
     */
    @Test
    void getCorrPosCorrNum() {
        String[] arr1 = {"1", "2", "3", "4"};
        String[] arr2 = {"1", "3", "3", "4"};
        assertEquals(3, testCodeMaker.getCorrPosCorrNum(arr1, arr2));
    }

    /**
     * Tests for the codemaker retrieving the number of pegs that have the correct color but not in the right positions
     */
    @Test
    void getCorrNumNotPos() {
        String[] arr1 = {"2", "1", "1", "1"};
        String[] arr2 = {"1", "3", "3", "4"};
        assertEquals(1, testCodeMaker.getCorrNumNotPos(arr1, arr2, 0));

        String[] arr3 = {"1", "2", "1", "1"};
        String[] arr4 = {"1", "3", "3", "4"};
        assertEquals(0, testCodeMaker.getCorrNumNotPos(arr1, arr2, 1));
    }
}