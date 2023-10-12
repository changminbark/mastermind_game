package hw01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CodeMakerTest {

    CodeMaker testCodeMaker;

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