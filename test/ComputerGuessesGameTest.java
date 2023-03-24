import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class ComputerGuessesGameTest {
//    ComputerGuessesGame newGame = new ComputerGuessesGame();

    @Test
    void testInitialNumGuesses() {
        ComputerGuessesGame newGame = new ComputerGuessesGame();
        assertEquals(0, newGame.getNumGuesses());
    }

    //SHOULD FAIL
    @Test
    void testFirstGuessNum() {
        ComputerGuessesGame newGame = new ComputerGuessesGame();
        newGame.makeFirstGuess();
        assertEquals(1, newGame.getNumGuesses());
    }

    @Test
    void testFirstGuess() {
        ComputerGuessesGame newGame = new ComputerGuessesGame();
        newGame.makeFirstGuess();
        assertEquals(501, newGame.getLastGuess());
    }

    @Test
    void testMakeGuessLow() {
        ComputerGuessesGame newGame = new ComputerGuessesGame();
        newGame.makeFirstGuess();
        newGame.makeGuess(true);
        assertEquals(251, newGame.getLastGuess());
    }

    @Test
    void testMakeGuessHigh() {
        ComputerGuessesGame newGame = new ComputerGuessesGame();
        newGame.makeFirstGuess();
        newGame.makeGuess(false);
        assertEquals(751, newGame.getLastGuess());
    }

    //SHOULD FAIL
    @Test
    void testTargetIsMin() {
        ComputerGuessesGame newGame = new ComputerGuessesGame();
        newGame.makeFirstGuess();
        for(int i = 0; i < 10; i++) {
            newGame.makeGuess(true);
        }
        assertEquals(1, newGame.getLastGuess());
    }

    @Test
    void testTargetIsOBLow() {
        ComputerGuessesGame newGame = new ComputerGuessesGame();
        newGame.makeFirstGuess();
        for(int i = 0; i < 11; i++) {
            newGame.makeGuess(true);
        }
        assertTrue(newGame.getLastGuess() >= 1);
    }

    @Test
    void testTargetIsMax() {
        ComputerGuessesGame newGame = new ComputerGuessesGame();
        newGame.makeFirstGuess();
        for(int i = 0; i < 8; i++) {
            newGame.makeGuess(false);
        }
        assertEquals(1000, newGame.getLastGuess());
    }

    //SHOULD FAIL
    @Test
    void testTargetIsOBHigh() {
        ComputerGuessesGame newGame = new ComputerGuessesGame();
        newGame.makeFirstGuess();
        for(int i = 0; i < 9; i++) {
            newGame.makeGuess(false);
        }
        assertTrue(newGame.getLastGuess() <= 1000);
    }
}
