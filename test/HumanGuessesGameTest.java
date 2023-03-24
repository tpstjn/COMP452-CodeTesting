import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HumanGuessesGameTest {
    HumanGuessesGame newGame = new HumanGuessesGame();

    @Test
    void testConstructor() {
        HumanGuessesGame newGameTest = new HumanGuessesGame();
        assertEquals(0, newGameTest.getNumGuesses());
    }

    @Test
    void testNumGuesses() {
        //Make guess that won't end game
        int guess = (newGame.getTarget() != 1) ? 1 : 2;

        for (int i = 0; i < 3; i++) {
            newGame.makeGuess(guess);
        }

        assertEquals(3, newGame.getNumGuesses());
    }

    @Test
    void testGuessResultLow() {
        int guess = newGame.getTarget() - 1;
        assertEquals(GuessResult.LOW, newGame.makeGuess(guess));
    }

    @Test
    void testGuessResultOBLow() {
        int guess = 0;
        assertEquals(GuessResult.LOW, newGame.makeGuess(guess));
    }

    @Test
    void testGuessResultHigh() {
        int guess = newGame.getTarget() + 1;
        assertEquals(GuessResult.HIGH, newGame.makeGuess(guess));
    }

    @Test
    void testGuessResultOBHigh() {
        int guess = 1001;
        assertEquals(GuessResult.HIGH, newGame.makeGuess(guess));
    }

    @Test
    void testGuessCorrect() {
        assertEquals(GuessResult.CORRECT, newGame.makeGuess(newGame.getTarget()));
    }

    @Test
    void testIsDone() {
        newGame.makeGuess(newGame.getTarget());
        assertTrue(newGame.isDone());
    }
}
