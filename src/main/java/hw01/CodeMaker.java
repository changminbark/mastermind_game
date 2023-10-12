/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2023
 * Instructor: Prof. Joshua Stough
 *
 * Name: Chang Min Bark
 * Section: 02
 * Date: 10/11/2023
 * Time: 10:29 AM
 *
 * Project: csci205_hw
 * Package: hw01
 * Class: CodeMaker
 *
 * Description:
 *
 * ****************************************
 */
package hw01;

import java.util.HashMap;
import java.util.Random;

public class CodeMaker {


    private String secretCode;
    private String currentGuess;
    private Random rand = new Random();

    /**
     * Default constructor for codemaker
     */
    public CodeMaker() {
        this.secretCode = "";
        this.currentGuess = "";
    }

    /**
     * Generates and sets the secret code
     * @return The secret code in a string form
     */
    public void generateCode() {
        int peg1 = rand.nextInt(5) + 1;
        int peg2 = rand.nextInt(5) + 1;
        int peg3 = rand.nextInt(5) + 1;
        int peg4 = rand.nextInt(5) + 1;
        String res = "" + peg1 + peg2 + peg3 + peg4;
        this.setSecretCode(res);
    }

    /**
     * Checks the current guess by comparing it to the secret code
     * @return a boolean value
     */
    public boolean checkGuess() {
        if (this.getCurrentGuess().equalsIgnoreCase(this.getSecretCode())) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Compares the guess to the secret code to generate a message showing number of pegs that are the right "color" and
     * the number of pegs that are in the right position
     * @return a String message that shows the scoring peg
     */
    public String evaluateScoringPegs() {
        String[] guessStrArr = this.currentGuess.split("(?!^)");
        String[] codeStrArr = this.secretCode.split("(?!^)");
        String scorePegMessage = "";

        // Tracking number of pegs that are the right color and in the right position
        int corrPosCorrNum = 0;
        for (int i = 0; i < guessStrArr.length; i++) {
            if (guessStrArr[i].equals(codeStrArr[i])) {
                corrPosCorrNum += 1;
            }
        }

        // Tracking number of pegs that are right color but in the wrong position
        int corrNumNotPos = 0;
        // Initializing the hashmap for the guess
        HashMap<String, Integer> guessHashmap = new HashMap<String, Integer>();
        for (String ch : guessStrArr) {
            if (guessHashmap.containsKey(ch)) {
                guessHashmap.put(ch, guessHashmap.get(ch) + 1);
            } else {
                guessHashmap.put(ch, 1);
            }
        }
        // Initializing the hashmap for the code
        HashMap<String, Integer> codeHashmap = new HashMap<String, Integer>();
        for (String ch : codeStrArr) {
            if (codeHashmap.containsKey(ch)) {
                codeHashmap.put(ch, codeHashmap.get(ch) + 1);
            } else {
                codeHashmap.put(ch, 1);
            }
        }
        // Checking for common keys (common pegs) and finding the minimum number of common pegs
        for (String ch : codeHashmap.keySet()) {
            if (guessHashmap.containsKey(ch)) {
                corrNumNotPos += Math.min(codeHashmap.get(ch), guessHashmap.get(ch));
            }
        }
        // Need to take into account pegs that are in correct position and number to not double count
        corrNumNotPos -= corrPosCorrNum;

        // Constructing the Scoring Peg Message
        for (int i = 0; i < corrPosCorrNum; i++) {
            scorePegMessage += "*";
        }
        for (int i = 0; i < corrNumNotPos; i++) {
            scorePegMessage += "+";
        }
        for (int i = 0; i < 4 - (corrPosCorrNum + corrNumNotPos); i++) {
            scorePegMessage += "-";
        }
        return scorePegMessage;
    }

    public String getSecretCode() {
        return secretCode;
    }

    public void setSecretCode(String secretCode) {
        this.secretCode = secretCode;
    }

    public String getCurrentGuess() {
        return currentGuess;
    }

    public void setCurrentGuess(String currentGuess) {
        this.currentGuess = currentGuess;
    }
}