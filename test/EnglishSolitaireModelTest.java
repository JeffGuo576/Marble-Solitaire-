import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

import static cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Empty;
import static cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Invalid;
import static cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Marble;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Tests for the class EnglishSolitaireModel.
 */
public class EnglishSolitaireModelTest {
  EnglishSolitaireModel g1;

  private void init() {
    g1 = new EnglishSolitaireModel();

  }

  @Test
  public void testdefaultValidBoard() {
    init();
    ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>> g1Board = new ArrayList<>();
    ArrayList<MarbleSolitaireModelState.SlotState> row0 =
            new ArrayList<MarbleSolitaireModelState.SlotState>(
                    Arrays.asList(Invalid, Invalid, Marble, Marble, Marble, Invalid, Invalid));
    ArrayList<MarbleSolitaireModelState.SlotState> row1 =
            new ArrayList<MarbleSolitaireModelState.SlotState>(
                    Arrays.asList(Marble, Marble, Marble, Marble, Marble, Marble, Marble));
    ArrayList<MarbleSolitaireModelState.SlotState> row2 =
            new ArrayList<MarbleSolitaireModelState.SlotState>(
                    Arrays.asList(Marble, Marble, Marble, Empty, Marble, Marble, Marble));
    g1Board.add(row0);
    g1Board.add(row0);
    g1Board.add(row1);
    g1Board.add(row2);
    g1Board.add(row1);
    g1Board.add(row0);
    g1Board.add(row0);
    assertEquals(g1Board, g1.returnBoard());
  }

  @Test
  public void testdefaultValidBoardSlot() {
    g1 = new EnglishSolitaireModel(2, 2);
    ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>> g1Board = new ArrayList<>();
    ArrayList<MarbleSolitaireModelState.SlotState> row0 =
            new ArrayList<MarbleSolitaireModelState.SlotState>(
                    Arrays.asList(Invalid, Invalid, Marble, Marble, Marble, Invalid, Invalid));
    ArrayList<MarbleSolitaireModelState.SlotState> row1 =
            new ArrayList<MarbleSolitaireModelState.SlotState>(
                    Arrays.asList(Marble, Marble, Marble, Marble, Marble, Marble, Marble));
    ArrayList<MarbleSolitaireModelState.SlotState> row2 =
            new ArrayList<MarbleSolitaireModelState.SlotState>(
                    Arrays.asList(Marble, Marble, Empty, Marble, Marble, Marble, Marble));
    g1Board.add(row0);
    g1Board.add(row0);
    g1Board.add(row2);
    g1Board.add(row1);
    g1Board.add(row1);
    g1Board.add(row0);
    g1Board.add(row0);
    assertEquals(g1Board, g1.returnBoard());
  }

  @Test
  public void testbiggerValidBoard() {
    g1 = new EnglishSolitaireModel(5);
    ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>> g1Board = new ArrayList<>();
    ArrayList<MarbleSolitaireModelState.SlotState> row0 =
            new ArrayList<MarbleSolitaireModelState.SlotState>(
                    Arrays.asList(Invalid, Invalid, Invalid, Invalid, Marble, Marble, Marble,
                            Marble, Marble, Invalid, Invalid, Invalid, Invalid));
    ArrayList<MarbleSolitaireModelState.SlotState> row1 =
            new ArrayList<MarbleSolitaireModelState.SlotState>(
                    Arrays.asList(Marble, Marble, Marble, Marble, Marble, Marble, Marble,
                            Marble, Marble, Marble, Marble, Marble, Marble));
    ArrayList<MarbleSolitaireModelState.SlotState> row2 =
            new ArrayList<MarbleSolitaireModelState.SlotState>(
                    Arrays.asList(Marble, Marble, Marble, Marble, Marble, Marble, Empty,
                            Marble, Marble, Marble, Marble, Marble, Marble));
    g1Board.add(row0);
    g1Board.add(row0);
    g1Board.add(row0);
    g1Board.add(row0);
    g1Board.add(row1);
    g1Board.add(row1);
    g1Board.add(row2);
    g1Board.add(row1);
    g1Board.add(row1);
    g1Board.add(row0);
    g1Board.add(row0);
    g1Board.add(row0);
    g1Board.add(row0);
    assertEquals(g1Board, g1.returnBoard());
  }

  @Test
  public void testbiggerValidBoardAndEmptySlot() {
    g1 = new EnglishSolitaireModel(5, 0, 4);
    ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>> g1Board = new ArrayList<>();
    ArrayList<MarbleSolitaireModelState.SlotState> row0 =
            new ArrayList<MarbleSolitaireModelState.SlotState>(
                    Arrays.asList(Invalid, Invalid, Invalid, Invalid, Marble, Marble, Marble,
                            Marble, Marble, Invalid, Invalid, Invalid, Invalid));
    ArrayList<MarbleSolitaireModelState.SlotState> row1 =
            new ArrayList<MarbleSolitaireModelState.SlotState>(
                    Arrays.asList(Marble, Marble, Marble, Marble, Marble, Marble, Marble,
                            Marble, Marble, Marble, Marble, Marble, Marble));
    ArrayList<MarbleSolitaireModelState.SlotState> row3 =
            new ArrayList<MarbleSolitaireModelState.SlotState>(
                    Arrays.asList(Invalid, Invalid, Invalid, Invalid, Empty, Marble, Marble,
                            Marble, Marble, Invalid, Invalid, Invalid, Invalid));

    g1Board.add(row3);
    g1Board.add(row0);
    g1Board.add(row0);
    g1Board.add(row0);
    g1Board.add(row1);
    g1Board.add(row1);
    g1Board.add(row1);
    g1Board.add(row1);
    g1Board.add(row1);
    g1Board.add(row0);
    g1Board.add(row0);
    g1Board.add(row0);
    g1Board.add(row0);
    assertEquals(g1Board, g1.returnBoard());
  }

  @Test
  public void testInvalidArmThickness() {
    try {
      g1 = new EnglishSolitaireModel(-1, 0, 0);
      fail("Constructor did not throw an IllegalArgumentException, when it should");
    } catch (IllegalArgumentException e) {
      assertEquals("Not a valid arm thickness.", e.getMessage());
    }
    try {
      g1 = new EnglishSolitaireModel(-1);
      fail("Constructor did not throw an IllegalArgumentException, when it should");
    } catch (IllegalArgumentException e) {
      assertEquals("Not a valid arm thickness.", e.getMessage());
    }
    try {
      g1 = new EnglishSolitaireModel(4, 0, 0);
      fail("Constructor did not throw an IllegalArgumentException, when it should");
    } catch (IllegalArgumentException e) {
      assertEquals("Not a valid arm thickness.", e.getMessage());
    }
    try {
      g1 = new EnglishSolitaireModel(6);
      fail("Constructor did not throw an IllegalArgumentException, when it should");
    } catch (IllegalArgumentException e) {
      assertEquals("Not a valid arm thickness.", e.getMessage());
    }

  }

  @Test
  public void testInvalidSlot() {
    try {
      g1 = new EnglishSolitaireModel(3, 0, 0);
      fail("Constructor did not throw an IllegalArgumentException, when it should");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid empty cell position (0,0)", e.getMessage());
    }
    try {
      g1 = new EnglishSolitaireModel(3, -1, -1);
      fail("Constructor did not throw an IllegalArgumentException, when it should");
    } catch (IllegalArgumentException e) {
      assertEquals("Cannot select a negative row.", e.getMessage());
    }
    try {
      g1 = new EnglishSolitaireModel(-1, -1);
      fail("Constructor did not throw an IllegalArgumentException, when it should");
    } catch (IllegalArgumentException e) {
      assertEquals("Cannot select a negative row.", e.getMessage());
    }
    try {
      g1 = new EnglishSolitaireModel(1, 1);
      fail("Constructor did not throw an IllegalArgumentException, when it should");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid empty cell position (1,1)", e.getMessage());
    }
  }

  @Test
  public void testInvalidGetSlotIndex() {
    init();
    try {
      g1.getSlotAt(-1, 0);
      fail("Constructor did not throw an IllegalArgumentException, when it should");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid index.", e.getMessage());
    }
  }

  @Test
  public void testInvalidMoves() {
    init();
    try {
      g1.move(0, 0, 0, 2);
      fail("Constructor did not throw an IllegalArgumentException, when it should");
    } catch (IllegalArgumentException e) {
      assertEquals("Not a valid move.", e.getMessage());
    }
    try {
      g1.move(-1, -1, 1, 2);
      fail("Constructor did not throw an IllegalArgumentException, when it should");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid index.", e.getMessage());
    }
    try {
      g1.move(-1, -1, -1, -1);
      fail("Constructor did not throw an IllegalArgumentException, when it should");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid index.", e.getMessage());
    }
    try {
      g1.move(3, 3, 3, 3);
      fail("Constructor did not throw an IllegalArgumentException, when it should");
    } catch (IllegalArgumentException e) {
      assertEquals("Not a valid move.", e.getMessage());
    }
    try {
      g1.move(0, 0, 0, 0);
      fail("Constructor did not throw an IllegalArgumentException, when it should");
    } catch (IllegalArgumentException e) {
      assertEquals("Not a valid move.", e.getMessage());
    }
    try {
      g1.move(1, 1, 1, 6);
      fail("Constructor did not throw an IllegalArgumentException, when it should");
    } catch (IllegalArgumentException e) {
      assertEquals("Not a valid move.", e.getMessage());
    }
    try {
      g1.move(3, 1, 0, -1);
      fail("Constructor did not throw an IllegalArgumentException, when it should");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid index.", e.getMessage());
    }
    try {
      g1.move(2, 2, 4, 4);
      fail("Constructor did not throw an IllegalArgumentException, when it should");
    } catch (IllegalArgumentException e) {
      assertEquals("Not a valid move.", e.getMessage());
    }
    try {
      g1.move(1, 4, 3, 3);
      fail("Constructor did not throw an IllegalArgumentException, when it should");
    } catch (IllegalArgumentException e) {
      assertEquals("Not a valid move.", e.getMessage());
    }
    try {
      g1.move(3, 0, 3, 2);
      fail("Constructor did not throw an IllegalArgumentException, when it should");
    } catch (IllegalArgumentException e) {
      assertEquals("Not a valid move.", e.getMessage());
    }
    try {
      g1.move(3, 2, 3, 4);
      fail("Constructor did not throw an IllegalArgumentException, when it should");
    } catch (IllegalArgumentException e) {
      assertEquals("Not a valid move.", e.getMessage());
    }
  }

  @Test
  public void testInvalidMoveOneSpot() {
    init();
    g1.move(3, 1, 3, 3);
    try {
      g1.move(3, 1, 3, 3);
      fail("Constructor did not throw an IllegalArgumentException, when it should");
    } catch (IllegalArgumentException e) {
      assertEquals("Not a valid move.", e.getMessage());
    }
  }

  @Test
  public void testMoveDiagonal() {
    init();
    g1.move(3, 1, 3, 3);
    try {
      g1.move(1, 4, 3, 3);
      fail("Constructor did not throw an IllegalArgumentException, when it should");
    } catch (IllegalArgumentException e) {
      assertEquals("Not a valid move.", e.getMessage());
    }
  }


  @Test
  public void testMoveUpRight() {
    init();
    g1.move(3, 1, 3, 3);
    assertEquals(Empty, g1.getSlotAt(3,2));
    assertEquals(Empty, g1.getSlotAt(3,1));
    assertEquals(Marble, g1.getSlotAt(3,3));
    g1.move(1, 2, 3, 2);
    assertEquals(Empty, g1.getSlotAt(1,2));
    assertEquals(Empty, g1.getSlotAt(2,2));
    assertEquals(Marble, g1.getSlotAt(3,3));
  }

  @Test
  public void testMoveDownLeft() {
    init();
    g1.move(1, 3, 3, 3);
    assertEquals(Empty, g1.getSlotAt(1,3));
    assertEquals(Empty, g1.getSlotAt(2,3));
    assertEquals(Marble, g1.getSlotAt(3,3));
    g1.move(2, 5, 2, 3);
    assertEquals(Empty, g1.getSlotAt(2,5));
    assertEquals(Empty, g1.getSlotAt(2,4));
    assertEquals(Marble, g1.getSlotAt(2,3));
  }

  @Test
  public void testIsGameOver() {
    init();
    assertEquals(false, g1.isGameOver());
    g1.move(3, 1, 3, 3);
    g1.move(3, 4, 3, 2);
    g1.move(3, 6, 3, 4);

    g1.move(1, 3, 3, 3);
    g1.move(3, 3, 3, 5);
    g1.move(1, 4, 3, 4);

    g1.move(3, 4, 3, 6);
    g1.move(5, 4, 3, 4);
    g1.move(5, 3, 3, 3);

    g1.move(3, 3, 3, 1);
    g1.move(5, 2, 3, 2);
    g1.move(3, 1, 3, 3);

    g1.move(2, 6, 2, 4);
    g1.move(4, 6, 2, 6);
    g1.move(2, 4, 4, 4);

    g1.move(4, 4, 4, 6);
    g1.move(1, 2, 3, 2);
    g1.move(3, 2, 3, 4);
    g1.move(2, 0, 2, 2);
    g1.move(4, 0, 4, 2);

    assertEquals(true, g1.isGameOver());
  }


  @Test
  public void testGetSlotAt() {
    init();
    Assert.assertEquals(Empty, g1.getSlotAt(3, 3));
    Assert.assertEquals(Marble, g1.getSlotAt(3, 4));
  }


  @Test
  public void testGetBoardSize() {
    init();
    assertEquals(7, g1.getBoardSize());
    g1 = new EnglishSolitaireModel(5);
    assertEquals(13, g1.getBoardSize());
  }

  @Test
  public void testGetScore() {
    init();
    assertEquals(32, g1.getScore());
    g1.move(3, 1, 3, 3);
    assertEquals(31, g1.getScore());
    g1 = new EnglishSolitaireModel(5);
    assertEquals(104, g1.getScore());
  }
}