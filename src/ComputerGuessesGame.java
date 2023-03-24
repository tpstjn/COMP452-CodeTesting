import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public class ComputerGuessesGame {
    private int numGuesses;
    private int lastGuess;

    // upperBound and lowerBound track the computer's knowledge about the correct number
    // They are updated after each guess is made
    private int upperBound; // correct number is <= upperBound
    private int lowerBound; // correct number is >= lowerBound

    ComputerGuessesGame() {
        numGuesses = 0;
        upperBound = 1000;
        lowerBound = 1;
    }

    String makeGuess(boolean isLower) {
        if (isLower) {
            upperBound = Math.min(upperBound, lastGuess);
        } else {
            lowerBound = Math.max(lowerBound, lastGuess + 1);
        }
        lastGuess = (lowerBound + upperBound + 1) / 2;
        numGuesses += 1;
        return "I guess " + lastGuess + ".";
    }

    String makeFirstGuess() {
        lastGuess = (lowerBound + upperBound + 1) / 2;
        return "I guess " + lastGuess + ".";
    }

    void correctGuess(Consumer<GameResult> gameFinishedCallback) {
        GameResult result = new GameResult(false, lastGuess, numGuesses);
        gameFinishedCallback.accept(result);
        numGuesses = 0;
    }

    int getNumGuesses() {
        return numGuesses;
    }

    int getLastGuess() {
        return lastGuess;
    }
}
