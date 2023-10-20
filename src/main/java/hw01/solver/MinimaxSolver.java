/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2023
 * Instructor: Prof. Joshua Stough
 *
 * Section: MWF (10:00 AM - 10:50 AM)
 * Lab Section: Thursday (10:00 AM - 11:50 AM)
 *
 * Name: Nolan and Chang Min
 * Section: 02
 * Date: 10/17/2023
 * Time: 4:18 PM
 *
 * Project: csci205_hw
 * Package: hw01
 * Class: MinimaxSolver
 *
 * Description: A class that represents a solver that uses the minimax algorithm
 *
 * ****************************************
 */

package hw01.solver;

import hw01.game.CodeMaker;
import hw01.solver.SolverCodeBreaker;

import java.util.*;

public class MinimaxSolver extends SolverCodeBreaker {

    /**
     * The guess code that is going to be used
     */
    private String guessPegs;

    /**
     * An arraylist representing all possible unused code combinations
     */
    private ArrayList<String> allPossibleCombinations;

    /**
     * An arraylist representing all possible guesses
     */
    private ArrayList<String> pegCombinations;

    /**
     * The constructor for minimax
     */
    public MinimaxSolver() {
        super();
        setSolverType("MINIMAX SOLVER");
        guessPegs = "1122";
        // S
        pegCombinations = getAllPossibleCombinations();

        // 1296 UNUSED CODES
        allPossibleCombinations = getAllPossibleCombinations();
        allPossibleCombinations.remove("1122");
    }

    /**
     * A method that resets the minimax's fields
     */
    public void reset() {
        guessPegs = "1122";
        // S
        pegCombinations = getAllPossibleCombinations();

        // 1296 UNUSED CODES
        allPossibleCombinations = getAllPossibleCombinations();
        allPossibleCombinations.remove("1122");
    }

    /**
     * A method that removes codes that will not produce the same result if the current guess
     * was the secret code from pegCombinations
     * @param result The scoring peg results from evaluating the current guess
     * @param evaluator A dummy codemaker variable to evaluate guesses
     */
    public void removePegCombinations(String result, CodeMaker evaluator) {
        ArrayList<String> setS = new ArrayList<>();
        for (int i = 0; i < this.pegCombinations.size(); i++) {
            evaluator.setCurrentGuess(this.pegCombinations.get(i));
            if (evaluator.evaluateScoringPegs().equals(result)) {
                setS.add(this.pegCombinations.get(i));
            }
        }
        this.pegCombinations = setS;
    }

    /**
     * A method that generates all possible combinations of pegs
     * @return An array list of string with all possible combinations of pegs
     */
    private ArrayList<String> getAllPossibleCombinations() {
        ArrayList<String> pegs = new ArrayList<>();
        for (int p1 = 1; p1 < 7; p1++) {
            for (int p2 = 1; p2 < 7; p2++) {
                for (int p3 = 1; p3 < 7; p3++) {
                    for (int p4 = 1; p4 < 7; p4++) {
                        pegs.add(Integer.toString(p1)+Integer.toString(p2)+Integer.toString(p3)+Integer.toString(p4));
                    }
                }
            }
        }
        return pegs;
    }

    /**
     * A method that returns a string for the codemaker to evaluate
     * @param evaluator A dummy evaluator needed to evaluate guesses in the minimaxAlgo
     * @return A String of the next guess chosen
     */
    public String takeInput(CodeMaker evaluator) {
        if (this.guessPegs.equals("1122")) {
            this.guessPegs = "";
            return "1122";
        }
        this.guessPegs = minimaxAlgo(evaluator);
        this.allPossibleCombinations.remove(this.guessPegs);
        return this.guessPegs;
    }

    /**
     * The minimax algorithm that calculates and decides what guess to choose (Knuth's Algorithm)
     * Credits: https://github.com/NathanDuran/Mastermind-Five-Guess-Algorithm/tree/master
     * @param evaluator A dummy codemaker object that evaluates guesses
     * @return A string that will be used as the next guess
     */
    public String minimaxAlgo(CodeMaker evaluator) {
        // Initialize a sorted set that contains nothing
        TreeSet<String> guessMinScore = new TreeSet<>();
        double max = 1E10;

        // For every possible unused peg combination
        for (String possibleCode : this.allPossibleCombinations) {
            // Create a hashmap of the scores for each evaluation of unused peg and pegs
            // from pegCombinations
            HashMap<String, Integer> score = new HashMap<>();

            evaluator.setSecretCode(possibleCode);
            // Calculate number of codes that will not be eliminated from pegCombinations
            for (String remainingCode : this.pegCombinations) {
                evaluator.setCurrentGuess(remainingCode);
                String result = evaluator.evaluateScoringPegs();

                // Adding to the hashmap the number of codes that will remain (matches resulting scoring string)
                if (score.containsKey(result)) {
                    score.put(result, score.get(result) + 1);
                } else {
                    score.put(result, 1);
                }
            }

            double maxScore = Collections.max(score.values());

            // If a new minimum max is found, create a new set of codes with this max value
            if (maxScore < max) {
                guessMinScore.clear();
                guessMinScore.add(possibleCode);
                max = maxScore;
            } else if (maxScore == max){
                guessMinScore.add(possibleCode);
            }
        }

        // Select a guess that is also in set S (pegCombinations), otherwise choose the first element
        for (String guess : guessMinScore) {
            if (this.pegCombinations.contains(guess)){
                return guess;
            }
        }
        return guessMinScore.first();
    }
}