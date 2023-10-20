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
 * Time: 7:35 PM
 *
 * Project: csci205_hw
 * Package: hw01
 * Class: RandomSolverTest
 *
 * Description: The class that tests the RandomSolver class.
 *
 * ****************************************
 */

package hw01;

import hw01.solver.RandomSolver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RandomSolverTest {

    private RandomSolver solver;

    @BeforeEach
    public void setUp() {
        solver = new RandomSolver();
    }

    @Test
    public void testTakeInputLength() {
        String input = solver.takeInput();
        assertEquals(RandomSolver.CODE_LENGTH, input.length(), "Generated code should have correct length");
    }

    @Test
    public void testTakeInputContainsValidPegs() {
        String input = solver.takeInput();
        for (char c : input.toCharArray()) {
            boolean isValidPeg = false;
            for (char validPeg : RandomSolver.POSSIBLE_PEGS) {
                if (c == validPeg) {
                    isValidPeg = true;
                    break;
                }
            }
            assertTrue(isValidPeg, "Generated code should only contain valid pegs");
        }
    }
}
