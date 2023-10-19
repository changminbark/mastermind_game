/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2023
 * Instructor: Prof. Joshua Stough
 *
 * Name: Chang Min Bark
 * Section: 02
 * Date: 10/17/2023
 * Time: 4:18 PM
 *
 * Project: csci205_hw
 * Package: hw01
 * Class: MinimaxSolver
 *
 * Description:
 *
 * ****************************************
 */
package hw01;

import java.util.*;

public class MinimaxSolver extends SolverCodeBreaker{

    /**
     * The guess code that is going to be used
     */
    private String guessPegs;


    private ArrayList<String> allPossibleCombinations;


    private ArrayList<String> pegCombinations;


    public MinimaxSolver() {
        super();
        guessPegs = "1122";
        // S
        pegCombinations = getAllPossibleCombinations();

        // 1296 UNUSED CODES
        allPossibleCombinations = getAllPossibleCombinations();
        allPossibleCombinations.remove("1122");
    }

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

    public String takeInput(CodeMaker evaluator) {
        if (this.guessPegs.equals("1122")) {
            this.guessPegs = "";
            return "1122";
        }
        this.guessPegs = minimaxAlgo(evaluator);
        this.allPossibleCombinations.remove(this.guessPegs);
        return this.guessPegs;
    }

    public String minimaxAlgo(CodeMaker evaluator) {
        TreeSet<String> guessMinScore = new TreeSet<>();
        double max = 1E10;

        for (String possibleCode : this.allPossibleCombinations) {
            HashMap<String, Integer> score = new HashMap<>();
            evaluator.setSecretCode(possibleCode);

            // Calculate number of codes that will be eliminated from pegCombinations
            for (String remainingCode : this.pegCombinations) {
                evaluator.setCurrentGuess(remainingCode);
                String result = evaluator.evaluateScoringPegs();

                if (score.containsKey(result)) {
                    score.put(result, score.get(result) + 1);
                } else {
                    score.put(result, 1);
                }
            }

            double maxScore = Collections.max(score.values());

            if (maxScore < max) {
                guessMinScore.clear();
                guessMinScore.add(possibleCode);
                max = maxScore;
            } else if (maxScore == max){
                guessMinScore.add(possibleCode);
            }
        }

        for (String guess : guessMinScore) {
            if (this.pegCombinations.contains(guess)){
                return guess;
            }
        }
        return guessMinScore.first();
    }
}