import org.junit.Test;

import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Tests for the visual portion of the game.
 */
public class TriangleSolitaireTextViewTest {
  TriangleSolitaireTextView t1 = new TriangleSolitaireTextView(new TriangleSolitaireModel());
  TriangleSolitaireTextView t2 = new TriangleSolitaireTextView(new TriangleSolitaireModel(8));


  @Test
  public void testConstructorNull() {
    try {
      t1 = new TriangleSolitaireTextView(null);
      fail("Constructor did not throw an IllegalArgumentException, when it should");
    } catch (IllegalArgumentException e) {
      assertEquals("Not a valid model.", e.getMessage());
    }
  }

  @Test
  public void testToString() {
    assertEquals("    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O", t1.toString());
  }

  @Test
  public void testToStringBigger() {
    assertEquals("       _\n" +
            "      O O\n" +
            "     O O O\n" +
            "    O O O O\n" +
            "   O O O O O\n" +
            "  O O O O O O\n" +
            " O O O O O O O\n" +
            "O O O O O O O O", t2.toString());
  }
}
