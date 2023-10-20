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
 * Time: 10:19 PM
 *
 * Project: csci205_hw
 * Package: hw01
 * Class: CodeBreakerTest
 *
 * Description: The CodeBreakerTest class is responsible for testing the CodeBreaker class.
 * ****************************************
 */

package hw01;

import hw01.game.UserCodeBreaker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The CodeBreakerTest class is responsible for testing the CodeBreaker class.
 */
class UserCodeBreakerTest {

    /**
     * The method to set up the test.
     */
    @BeforeEach
    void setUp() {
    }

    /**
     * The method to tear down the test.
     */
    @AfterEach
    void tearDown() {
    }

    /**
     * The method to test the takeInput method.
     */
    @Test
    void takeInput() {
        UserCodeBreaker usercodebreaker = new UserCodeBreaker();
        String input = "1234";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals("1234", usercodebreaker.takeInput());
    }
}
