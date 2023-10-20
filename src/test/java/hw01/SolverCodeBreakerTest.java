/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2023
 * Instructor: Prof. Joshua Stough
 *
 * Section: MWF (10:00 AM - 10:50 AM)
 * Lab Section: Thursday (10:00 AM - 11:50 AM)
 *
 * Name: Nolan Lwin and Chang Min
 * Date: 10/17/23
 * Time: 7:53 PM
 *
 * Project: csci205_hw
 * Package: hw01
 * Class: SolverCodeBreakerTest
 *
 * Description: The test class for the SolverCodeBreaker class.
 *
 * ****************************************
 */

package hw01;

import hw01.solver.SolverCodeBreaker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test class for the SolverCodeBreaker class.
 */
class SolverCodeBreakerTest {

    /**
     * The SolverCodeBreaker object to test.
     */
    private SolverCodeBreaker solver;

    /**
     * The setUp method to initialize the SolverCodeBreaker object.
     */
    @BeforeEach
    public void setUp() {
        // This is a stubbed method for testing purposes.
        solver = new SolverCodeBreaker() {
        };
    }

    /**
     * The test method for the calcAvgAttempt method.
     */
    @Test
    public void testCalcAvgAttempt() {
        ArrayList<Integer> attempts = new ArrayList<>(Arrays.asList(2, 3, 4, 5));
        for (int attempt : attempts) {
            solver.addAttempt(attempt);
        }
        assertEquals("3.5", solver.calcAvgAttempt(), "Average should be correct");
    }

    /**
     * The test method for the shortestAttempt method.
     */
    @Test
    public void testShortestAttempt() {
        ArrayList<Integer> attempts = new ArrayList<>(Arrays.asList(2, 3, 1, 5));
        for (int attempt : attempts) {
            solver.addAttempt(attempt);
        }
        assertEquals(1, solver.shortestAttempt(), "Shortest attempt should be correct");
    }

    /**
     * The test method for the longestAttempt method.
     */
    @Test
    public void testLongestAttempt() {
        ArrayList<Integer> attempts = new ArrayList<>(Arrays.asList(2, 3, 1, 5));
        for (int attempt : attempts) {
            solver.addAttempt(attempt);
        }
        assertEquals(5, solver.longestAttempt(), "Longest attempt should be correct");
    }

    /**
     * The test method for the startTime and recordTime methods.
     */
    @Test
    public void testTimeRecording() {
        solver.startTime();
        try {
            Thread.sleep(105); // sleep for 100 milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        solver.recordTime();
        String recordedTime = solver.getPlayTime();
        double time = Double.parseDouble(recordedTime) ;
        assertTrue(time >= 0.1, "Recorded time should be at least 100 milliseconds in seconds");
    }
}