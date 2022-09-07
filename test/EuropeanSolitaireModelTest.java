
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

import static cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Empty;
import static cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Invalid;
import static cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Marble;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Testing the EuropeanSolitaireModel functional portion.
 */
public class EuropeanSolitaireModelTest {

  EuropeanSolitaireModel e1;

  EuropeanSolitaireModel e2;

  EuropeanSolitaireModel e3;

  EuropeanSolitaireModel e4;

  private void init() {
    e1 = new EuropeanSolitaireModel();

    e2 = new EuropeanSolitaireModel(5);

    e3 = new EuropeanSolitaireModel(5, 3, 5);

    e4 = new EuropeanSolitaireModel(3, 2);
  }

  @Test
  public void testDefaultValidBoard() {
    init();
    ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>> e1Board = new ArrayList<>();
    ArrayList<MarbleSolitaireModelState.SlotState> row0 =
            new ArrayList<MarbleSolitaireModelState.SlotState>(
                    Arrays.asList(Invalid, Invalid, Marble, Marble, Marble, Invalid, Invalid));
    ArrayList<MarbleSolitaireModelState.SlotState> row1 =
            new ArrayList<MarbleSolitaireModelState.SlotState>(
                    Arrays.asList(Invalid, Marble, Marble, Marble, Marble, Marble, Invalid));
    ArrayList<MarbleSolitaireModelState.SlotState> row2 =
            new ArrayList<MarbleSolitaireModelState.SlotState>(
                    Arrays.asList(Marble, Marble, Marble, Marble, Marble, Marble, Marble));
    ArrayList<MarbleSolitaireModelState.SlotState> row3 =
            new ArrayList<MarbleSolitaireModelState.SlotState>(
                    Arrays.asList(Marble, Marble, Marble, Empty, Marble, Marble, Marble));
    e1Board.add(row0);
    e1Board.add(row1);
    e1Board.add(row2);
    e1Board.add(row3);
    e1Board.add(row2);
    e1Board.add(row1);
    e1Board.add(row0);
    assertEquals(e1Board, e1.returnBoard());
  }

  @Test
  public void testBiggerValidBoard() {
    init();
    e2 = new EuropeanSolitaireModel(5);
    ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>> e2Board = new ArrayList<>();
    ArrayList<MarbleSolitaireModelState.SlotState> row0 =
            new ArrayList<MarbleSolitaireModelState.SlotState>(
                    Arrays.asList(Invalid, Invalid, Invalid, Invalid, Marble, Marble, Marble,
                            Marble, Marble, Invalid, Invalid, Invalid, Invalid));
    ArrayList<MarbleSolitaireModelState.SlotState> row1 =
            new ArrayList<MarbleSolitaireModelState.SlotState>(
                    Arrays.asList(Invalid, Invalid, Invalid, Marble, Marble, Marble, Marble,
                            Marble, Marble, Marble, Invalid, Invalid, Invalid));
    ArrayList<MarbleSolitaireModelState.SlotState> row2 =
            new ArrayList<MarbleSolitaireModelState.SlotState>(
                    Arrays.asList(Invalid, Invalid, Marble, Marble, Marble, Marble, Marble,
                            Marble, Marble, Marble, Marble, Invalid, Invalid));
    ArrayList<MarbleSolitaireModelState.SlotState> row3 =
            new ArrayList<MarbleSolitaireModelState.SlotState>(
                    Arrays.asList(Invalid, Marble, Marble, Marble, Marble, Marble, Marble,
                            Marble, Marble, Marble, Marble, Marble, Invalid));
    ArrayList<MarbleSolitaireModelState.SlotState> row4 =
            new ArrayList<MarbleSolitaireModelState.SlotState>(
                    Arrays.asList(Marble, Marble, Marble, Marble, Marble, Marble, Marble,
                            Marble, Marble, Marble, Marble, Marble, Marble));
    ArrayList<MarbleSolitaireModelState.SlotState> row5 =
            new ArrayList<MarbleSolitaireModelState.SlotState>(
                    Arrays.asList(Marble, Marble, Marble, Marble, Marble, Marble, Empty,
                            Marble, Marble, Marble, Marble, Marble, Marble));

    e2Board.add(row0);
    e2Board.add(row1);
    e2Board.add(row2);
    e2Board.add(row3);
    e2Board.add(row4);
    e2Board.add(row4);
    e2Board.add(row5);
    e2Board.add(row4);
    e2Board.add(row4);
    e2Board.add(row3);
    e2Board.add(row2);
    e2Board.add(row1);
    e2Board.add(row0);
    assertEquals(e2Board, e2.returnBoard());
  }

  @Test
  public void testBiggerValidBoardWithSlot() {
    init();
    ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>> e3Board = new ArrayList<>();
    ArrayList<MarbleSolitaireModelState.SlotState> row0 =
            new ArrayList<MarbleSolitaireModelState.SlotState>(
                    Arrays.asList(Invalid, Invalid, Invalid, Invalid, Marble, Marble, Marble,
                            Marble, Marble, Invalid, Invalid, Invalid, Invalid));
    ArrayList<MarbleSolitaireModelState.SlotState> row1 =
            new ArrayList<MarbleSolitaireModelState.SlotState>(
                    Arrays.asList(Invalid, Invalid, Invalid, Marble, Marble, Marble, Marble,
                            Marble, Marble, Marble, Invalid, Invalid, Invalid));
    ArrayList<MarbleSolitaireModelState.SlotState> row2 =
            new ArrayList<MarbleSolitaireModelState.SlotState>(
                    Arrays.asList(Invalid, Invalid, Marble, Marble, Marble, Marble, Marble,
                            Marble, Marble, Marble, Marble, Invalid, Invalid));
    ArrayList<MarbleSolitaireModelState.SlotState> row3 =
            new ArrayList<MarbleSolitaireModelState.SlotState>(
                    Arrays.asList(Invalid, Marble, Marble, Marble, Marble, Marble, Marble,
                            Marble, Marble, Marble, Marble, Marble, Invalid));
    ArrayList<MarbleSolitaireModelState.SlotState> row4 =
            new ArrayList<MarbleSolitaireModelState.SlotState>(
                    Arrays.asList(Marble, Marble, Marble, Marble, Marble, Marble, Marble,
                            Marble, Marble, Marble, Marble, Marble, Marble));
    ArrayList<MarbleSolitaireModelState.SlotState> row5 =
            new ArrayList<MarbleSolitaireModelState.SlotState>(
                    Arrays.asList(Invalid, Marble, Marble, Marble, Marble, Empty, Marble,
                            Marble, Marble, Marble, Marble, Marble, Invalid));

    e3Board.add(row0);
    e3Board.add(row1);
    e3Board.add(row2);
    e3Board.add(row5);
    e3Board.add(row4);
    e3Board.add(row4);
    e3Board.add(row4);
    e3Board.add(row4);
    e3Board.add(row4);
    e3Board.add(row3);
    e3Board.add(row2);
    e3Board.add(row1);
    e3Board.add(row0);
    assertEquals(e3Board, e3.returnBoard());
  }

  @Test
  public void testDefaultBoardWithSlot() {
    init();
    ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>> e4Board = new ArrayList<>();
    ArrayList<MarbleSolitaireModelState.SlotState> row0 =
            new ArrayList<MarbleSolitaireModelState.SlotState>(
                    Arrays.asList(Invalid, Invalid, Marble, Marble, Marble, Invalid, Invalid));
    ArrayList<MarbleSolitaireModelState.SlotState> row1 =
            new ArrayList<MarbleSolitaireModelState.SlotState>(
                    Arrays.asList(Invalid, Marble, Marble, Marble, Marble, Marble, Invalid));
    ArrayList<MarbleSolitaireModelState.SlotState> row2 =
            new ArrayList<MarbleSolitaireModelState.SlotState>(
                    Arrays.asList(Marble, Marble, Marble, Marble, Marble, Marble, Marble));
    ArrayList<MarbleSolitaireModelState.SlotState> row3 =
            new ArrayList<MarbleSolitaireModelState.SlotState>(
                    Arrays.asList(Marble, Marble, Empty, Marble, Marble, Marble, Marble));
    e4Board.add(row0);
    e4Board.add(row1);
    e4Board.add(row2);
    e4Board.add(row3);
    e4Board.add(row2);
    e4Board.add(row1);
    e4Board.add(row0);
    assertEquals(e4Board, e4.returnBoard());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructorsForEmptySlotNegative() {
    e1 = new EuropeanSolitaireModel(-1, -1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructorsForEmptySlot() {
    e1 = new EuropeanSolitaireModel(0, 0);
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void testInvalidConstructorsForEmptySlotOutOfBounds() {
    e1 = new EuropeanSolitaireModel(0, 7);
  }

  @Test
  public void testInvalidConstructorsForEmptySlotInvalidSpot() {
    try {
      e2 = new EuropeanSolitaireModel(5, 0, 2);
      fail("Constructor did not throw an IllegalArgumentException, when it should");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid empty cell position (0,2)", e.getMessage());
    }
  }


  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructorsArmThickness() {
    e2 = new EuropeanSolitaireModel(4);
    e4 = new EuropeanSolitaireModel(4, 3, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructorsNegativeArmThickness() {
    e2 = new EuropeanSolitaireModel(-4);
    e3 = new EuropeanSolitaireModel(-4, 3, 3);
  }


  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoves() {
    init();
    e1.move(4, 1, 4, 3);
    e1.move(4, 1, 4, 3);
  }

  @Test
  public void testInvalidMovesDiagonal() {
    init();
    e1.move(3, 1, 3, 3);
    try {
      e1.move(1, 4, 3, 3);
      fail("Constructor did not throw an IllegalArgumentException, when it should");
    } catch (IllegalArgumentException e) {
      assertEquals("Not a valid move.", e.getMessage());
    }
  }

  @Test
  public void testGameOver() {
    init();
    e1.move(3, 1, 3, 3);
    e1.move(3, 4, 3, 2);
    e1.move(3, 6, 3, 4);
    e1.move(1, 3, 3, 3);

    e1.move(3, 3, 3, 5);
    e1.move(1, 4, 3, 4);
    e1.move(3, 4, 3, 6);
    e1.move(5, 4, 3, 4);

    e1.move(5, 3, 3, 3);
    e1.move(3, 3, 3, 1);
    e1.move(5, 2, 3, 2);
    e1.move(3, 1, 3, 3);

    e1.move(2, 6, 2, 4);
    e1.move(4, 6, 2, 6);
    e1.move(2, 4, 4, 4);
    e1.move(4, 4, 4, 6);

    e1.move(1, 2, 3, 2);
    e1.move(3, 2, 3, 4);

    e1.move(5, 1, 3, 1);//corner move
    e1.move(2, 1, 4, 1);
    e1.move(4, 0, 4, 2);

    e1.move(2, 0, 4, 0);

    assertEquals(true, e1.isGameOver());
  }

  @Test
  public void testGetSlotAt() {
    init();
    assertEquals(Empty, e1.getSlotAt(3, 3));
    assertEquals(Marble, e1.getSlotAt(3, 4));
    assertEquals(Invalid, e1.getSlotAt(0, 0));
  }

  @Test
  public void testGetBoardSize() {
    init();
    assertEquals(7, e1.getBoardSize());
    e2 = new EuropeanSolitaireModel(5);
    assertEquals(13, e2.getBoardSize());
  }

  @Test
  public void testGetScore() {
    init();
    assertEquals(36, e1.getScore());
    e1.move(3, 1, 3, 3);
    assertEquals(35, e1.getScore());
    e1 = new EuropeanSolitaireModel(5);
    assertEquals(128, e1.getScore());
  }

  @Test
  public void testMoveUpRight() {
    init();
    e1.move(3, 1, 3, 3);
    assertEquals(Empty, e1.getSlotAt(3, 2));
    assertEquals(Empty, e1.getSlotAt(3, 1));
    assertEquals(Marble, e1.getSlotAt(3, 3));
    e1.move(1, 2, 3, 2);
    assertEquals(Empty, e1.getSlotAt(1, 2));
    assertEquals(Empty, e1.getSlotAt(2, 2));
    assertEquals(Marble, e1.getSlotAt(3, 3));
  }

  @Test
  public void testMoveDownLeft() {
    init();
    e1.move(1, 3, 3, 3);
    assertEquals(Empty, e1.getSlotAt(1, 3));
    assertEquals(Empty, e1.getSlotAt(2, 3));
    assertEquals(Marble, e1.getSlotAt(3, 3));
    e1.move(2, 5, 2, 3);
    assertEquals(Empty, e1.getSlotAt(2, 5));
    assertEquals(Empty, e1.getSlotAt(2, 4));
    assertEquals(Marble, e1.getSlotAt(2, 3));
  }
}






