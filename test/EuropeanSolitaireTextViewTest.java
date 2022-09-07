import org.junit.Test;

import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.view.EuropeanSolitaireTextView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Tests the EuropeanSolitaire visual portion of the game.
 */
public class EuropeanSolitaireTextViewTest {
  EuropeanSolitaireTextView e1 = new EuropeanSolitaireTextView(new EuropeanSolitaireModel());
  EuropeanSolitaireTextView e2 = new EuropeanSolitaireTextView(new EuropeanSolitaireModel(5));

  @Test
  public void testConstructorNull() {
    try {
      e1 = new EuropeanSolitaireTextView(null);
      fail("Constructor did not throw an IllegalArgumentException, when it should");
    } catch (IllegalArgumentException e) {
      assertEquals("Not a valid model.", e.getMessage());
    }
  }

  @Test
  public void testToString() {
    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", e1.toString());
  }

  @Test
  public void testToStringBigger() {
    assertEquals("        O O O O O\n" +
            "      O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O _ O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "      O O O O O O O\n" +
            "        O O O O O", e2.toString());
  }
}
