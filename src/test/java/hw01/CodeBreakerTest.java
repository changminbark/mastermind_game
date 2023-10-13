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

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CodeBreakerTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void takeInput() throws Exception {
        String input = "1234";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        CodeBreaker codeBreaker = new CodeBreaker();
        assertEquals("1234", codeBreaker.takeInput());
    }

    @Test
    void takeInputInvalidInputException() throws Exception {
        String input = "12345";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        CodeBreaker codeBreaker = new CodeBreaker();
    }
}
