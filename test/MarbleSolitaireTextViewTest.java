import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


/**
 * Test class for MarbleSolitaireTestView.
 */
public class MarbleSolitaireTextViewTest {
  MarbleSolitaireView g1 = new MarbleSolitaireTextView(new EnglishSolitaireModel());
  MarbleSolitaireView g2 = new MarbleSolitaireTextView(new EnglishSolitaireModel(5));


  @Test
  public void testConstructorNull() {
    try {
      g1 = new MarbleSolitaireTextView(null);
      fail("Constructor did not throw an IllegalArgumentException, when it should");
    } catch (IllegalArgumentException e) {
      assertEquals("Not a valid model.", e.getMessage());
    }
  }


  @Test
  public void testToString() {
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", g1.toString());
  }

  @Test
  public void testToStringBigger() {
    assertEquals("        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O _ O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O", g2.toString());
  }

}