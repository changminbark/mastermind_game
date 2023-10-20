/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2023
 * Instructor: Prof. Joshua Stough
 *
 * Section: MWF (10:00 AM - 10:50 AM)
 * Lab Section: Thursday (10:00 AM - 11:50 AM)
 *
 * Name: Nolan Lwin and Chang Min
 * Date: 10/19/23
 * Time: 2:55 PM
 *
 * Project: csci205_hw
 * Package: hw01
 * Class: DFSSolver
 *
 * Description: The DFS Solver class to solve the Mastermind game using Depth First Search (DFS).
 *
 * ****************************************
 */

package hw01.solver;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

/**
 * The DFS Solver class to solve the Mastermind game using Depth First Search (DFS).
 */
public class DFSSolver extends SolverCodeBreaker {

    /**
     * The list of all possible codes.
     */
    private List<String> allPossibleCodes;

    /**
     * The iterator for the list of all possible codes.
     */
    private Iterator<String> codeIterator;

    /**
     * The constructor for the DFS Solver class.
     * It initializes the list of all possible codes and the iterator for the list of all possible codes.
     */
    public DFSSolver() {
        setSolverType("DFS SOLVER");
        allPossibleCodes = generateAllPossibleCodes();
        codeIterator = allPossibleCodes.iterator();
    }

    /**
     * Generate all possible codes.
     * @return the list of all possible codes.
     */
    private List<String> generateAllPossibleCodes() {
        List<String> codes = new ArrayList<>();
        // Loop through all possible codes and add them to the list
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                for (int k = 1; k <= 6; k++) {
                    for (int l = 1; l <= 6; l++) {
                        codes.add("" + i + j + k + l);
                    }
                }
            }
        }
        return codes;
    }

    /**
     * Take input from the list of all possible codes.
     * @return the next code in the list of all possible codes.
     */
    public String takeInput() {
        // If there is a next code in the list, return it
        if (codeIterator.hasNext()) {
            return codeIterator.next();
        }
        return null;
    }

    /**
     * Reset the iterator for the list of all possible codes.
     */
    public void reset() {
        // Resets the iterator for the list of all possible codes
        codeIterator = allPossibleCodes.iterator();
    }
}