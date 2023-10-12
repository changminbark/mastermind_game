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
 * Time: 3:28 PM
 *
 * Project: csci205_hw
 * Package: hw01
 * Class: CodeBreakerTest
 *
 * Description: The CodeBreakerTest class is responsible for testing the CodeBreaker class.
 * ****************************************
 */

package hw01;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

/** The CodeBreakerTest class is responsible for testing the CodeBreaker class. */
class CodeBreakerTest {

    /** Sets up the CodeBreaker object to be tested */
    @BeforeEach
    void setUp() {
    }

    /** Tears down the CodeBreaker object to be tested */
    @AfterEach
    void tearDown() {
    }

    /**
     * The method to test the input from the user
     */
    @Test
    void testInput() {
        CodeBreaker codeBreaker = new CodeBreaker();
        System.setIn(new java.io.ByteArrayInputStream("1234\n".getBytes()));

        // Use assertThrows to check if the exception is thrown
        Exception exception = assertThrows(Exception.class, () -> {
            codeBreaker.takeInput();
        });
    }

    /**
     * The method to test the invalid input from the user (not a correct length)
     */
    @Test
    void testInvalidLengthInput() {
        CodeBreaker codeBreaker = new CodeBreaker();
        System.setIn(new java.io.ByteArrayInputStream("123\n".getBytes()));

        // Use assertThrows to check if the exception is thrown
        Exception exception = assertThrows(Exception.class, () -> {
            codeBreaker.takeInput();
        });
    }

    /**
     * The method to test the invalid input from the user (not within a range [1-6])
     */
    @Test
    void testInvalidRangeInput() {
        CodeBreaker codeBreaker = new CodeBreaker();
        System.setIn(new java.io.ByteArrayInputStream("1237\n".getBytes()));

        // Use assertThrows to check if the exception is thrown
        Exception exception = assertThrows(Exception.class, () -> {
            codeBreaker.takeInput();
        });
    }
}