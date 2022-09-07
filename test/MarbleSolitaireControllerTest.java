import org.junit.Test;

import java.io.StringReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Tests for Controller portion of the game.
 */
public class MarbleSolitaireControllerTest {
  StringReader r2;

  StringReader r3;

  StringReader r4;

  StringReader r5;

  StringReader r6;

  StringReader r7;

  StringReader r8;

  StringReader r9;

  StringReader r10;
  String b1;
  String b2;
  StringBuilder b3;

  String b4;

  MarbleSolitaireModel m1;

  MarbleSolitaireView mv1;
  MarbleSolitaireController controller;
  MarbleSolitaireController controller2;

  MarbleSolitaireController controller3;

  MarbleSolitaireController controller4;

  MarbleSolitaireController controller5;

  MarbleSolitaireController controller6;

  MarbleSolitaireController controller7;

  MarbleSolitaireController controller8;

  MarbleSolitaireController controller9;

  MarbleSolitaireController controller10;


  private void setup() {

    //gameover case
    r2 = new StringReader("4 2 4 4 4 5 4 3 4 7 4 5 2 4 4 4 4 4 4 6 2 5 4 5 4 5 4 7 6 5 4 5"
            + " 6 4 4 4 4 4 4 2 6 3 4 3 4 2 4 4 3 7 3 5 5 7 3 7 3 5 5 5 5 5 5 7 2 3 4 3"
            + " 4 3 4 5 3 1 3 3 5 1 5 3");

    r3 = new StringReader("4 2 4 4 4 2 4 4 q");

    r4 = new StringReader("4 2 4 j");

    r5 = new StringReader("-1 2 4 4");

    r6 = new StringReader("1 2 q");

    r7 = new StringReader("1 2 j");

    r8 = new StringReader("1 2 3 q");

    r9 = new StringReader("q");

    r10 = new StringReader("1 q 2");

    //default board
    b1 = ("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O");

    //valid input
    b2 = ("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n");

    b3 = new StringBuilder();

    b4 = new String("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ O _ _ O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 30\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ O _ O _ _\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 29\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O O O _ O O O\n" +
            "O _ O O O _ _\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 28\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O O O _ O O O\n" +
            "O _ O _ _ O _\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 27\n" +
            "    O O O\n" +
            "    O _ _\n" +
            "O O O _ _ O O\n" +
            "O _ O _ O O _\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 26\n" +
            "    O O O\n" +
            "    O _ _\n" +
            "O O O _ _ O O\n" +
            "O _ O _ _ _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 25\n" +
            "    O O O\n" +
            "    O _ _\n" +
            "O O O _ _ O O\n" +
            "O _ O _ O _ O\n" +
            "O O O O _ O O\n" +
            "    O O _\n" +
            "    O O O\n" +
            "Score: 24\n" +
            "    O O O\n" +
            "    O _ _\n" +
            "O O O _ _ O O\n" +
            "O _ O O O _ O\n" +
            "O O O _ _ O O\n" +
            "    O _ _\n" +
            "    O O O\n" +
            "Score: 23\n" +
            "    O O O\n" +
            "    O _ _\n" +
            "O O O _ _ O O\n" +
            "O O _ _ O _ O\n" +
            "O O O _ _ O O\n" +
            "    O _ _\n" +
            "    O O O\n" +
            "Score: 22\n" +
            "    O O O\n" +
            "    O _ _\n" +
            "O O O _ _ O O\n" +
            "O O O _ O _ O\n" +
            "O O _ _ _ O O\n" +
            "    _ _ _\n" +
            "    O O O\n" +
            "Score: 21\n" +
            "    O O O\n" +
            "    O _ _\n" +
            "O O O _ _ O O\n" +
            "O _ _ O O _ O\n" +
            "O O _ _ _ O O\n" +
            "    _ _ _\n" +
            "    O O O\n" +
            "Score: 20\n" +
            "    O O O\n" +
            "    O _ _\n" +
            "O O O _ O _ _\n" +
            "O _ _ O O _ O\n" +
            "O O _ _ _ O O\n" +
            "    _ _ _\n" +
            "    O O O\n" +
            "Score: 19\n" +
            "    O O O\n" +
            "    O _ _\n" +
            "O O O _ O _ O\n" +
            "O _ _ O O _ _\n" +
            "O O _ _ _ O _\n" +
            "    _ _ _\n" +
            "    O O O\n" +
            "Score: 18\n" +
            "    O O O\n" +
            "    O _ _\n" +
            "O O O _ _ _ O\n" +
            "O _ _ O _ _ _\n" +
            "O O _ _ O O _\n" +
            "    _ _ _\n" +
            "    O O O\n" +
            "Score: 17\n" +
            "    O O O\n" +
            "    O _ _\n" +
            "O O O _ _ _ O\n" +
            "O _ _ O _ _ _\n" +
            "O O _ _ _ _ O\n" +
            "    _ _ _\n" +
            "    O O O\n" +
            "Score: 16\n" +
            "    O O O\n" +
            "    _ _ _\n" +
            "O O _ _ _ _ O\n" +
            "O _ O O _ _ _\n" +
            "O O _ _ _ _ O\n" +
            "    _ _ _\n" +
            "    O O O\n" +
            "Score: 15\n" +
            "    O O O\n" +
            "    _ _ _\n" +
            "O O _ _ _ _ O\n" +
            "O _ _ _ O _ _\n" +
            "O O _ _ _ _ O\n" +
            "    _ _ _\n" +
            "    O O O\n" +
            "Score: 14\n" +
            "    O O O\n" +
            "    _ _ _\n" +
            "_ _ O _ _ _ O\n" +
            "O _ _ _ O _ _\n" +
            "O O _ _ _ _ O\n" +
            "    _ _ _\n" +
            "    O O O\n" +
            "Score: 13\n" +
            "Game over!\n" +
            "    O O O\n" +
            "    _ _ _\n" +
            "_ _ O _ _ _ O\n" +
            "O _ _ _ O _ _\n" +
            "_ _ O _ _ _ O\n" +
            "    _ _ _\n" +
            "    O O O\n" +
            "Score: 12\n");

    m1 = new EnglishSolitaireModel();

    mv1 = new MarbleSolitaireTextView(m1, b3);

    controller2 = new MarbleSolitaireControllerImpl(m1, mv1, r2);

    controller3 = new MarbleSolitaireControllerImpl(m1, mv1, r3);

    controller4 = new MarbleSolitaireControllerImpl(m1, mv1, r4);

    controller5 = new MarbleSolitaireControllerImpl(m1, mv1, r5);

    controller6 = new MarbleSolitaireControllerImpl(m1, mv1, r6);

    controller7 = new MarbleSolitaireControllerImpl(m1, mv1, r7);

    controller8 = new MarbleSolitaireControllerImpl(m1, mv1, r8);

    controller9 = new MarbleSolitaireControllerImpl(m1, mv1, r10);

    controller10 = new MarbleSolitaireControllerImpl(m1, mv1, r9);
  }

  @Test
  public void testGameOver() {
    setup();
    controller2.playGame();
    assertEquals(b4, b3.toString());
  }

  @Test (expected = IllegalStateException.class)
  public void testInvalidMove() {
    setup();
    controller3.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "Invalid move. Play again.\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n", b3.toString());
  }

  @Test (expected = IllegalStateException.class)
  public void testInvalidMoveOutOfIndex() {
    setup();
    controller5.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Invalid move. Play again.\n", b3.toString());
  }

  @Test (expected = IllegalStateException.class)
  public void testInvalidLetter() {
    setup();
    controller4.playGame();
    assertEquals("    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 32\n"
            + "Enter valid value:\n", b3.toString());
  }

  @Test (expected = IllegalStateException.class)
  public void testQuit() {
    setup();
    controller10.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n", b3.toString());
  }

  @Test (expected = IllegalStateException.class)
  public void testQuitSecond() {
    setup();
    controller9.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n", b3.toString());
  }

  @Test (expected = IllegalStateException.class)
  public void testQuitThird() {
    setup();
    controller6.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n", b3.toString());
  }

  @Test (expected = IllegalStateException.class)
  public void testQuitFourth() {
    setup();
    controller8.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n", b3.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullReadableConstructor() {
    setup();
    controller = new MarbleSolitaireControllerImpl(m1, mv1, null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullModelConstructor() {
    setup();
    controller = new MarbleSolitaireControllerImpl(null, mv1, r2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullViewConstructor() {
    setup();
    controller = new MarbleSolitaireControllerImpl(m1, null, r2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullReadableConstructorPlayGame() {
    setup();
    try {
      new MarbleSolitaireControllerImpl(m1, mv1, null).playGame();
      fail("Play did not throw an IllegalArgumentException, when it should");
    } catch (IllegalStateException e) {
      throw new IllegalStateException(e);
    }
  }

  @Test
  public void testReadableOutOfInputs() {
    setup();
    try {
      controller7.playGame();
      fail("Not enough inputs for the game, should throw exception");
    } catch (IllegalStateException e) {
      assertEquals("No more inputs!", e.getMessage());
    }
  }
}
