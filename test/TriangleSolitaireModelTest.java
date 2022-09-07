import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;

import static cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Empty;
import static cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Invalid;
import static cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Marble;
import static org.junit.Assert.assertEquals;

/**
 * Test class for the TriangleSolitaire functional portion of the game.
 */
public class TriangleSolitaireModelTest {
  TriangleSolitaireModel t1;

  TriangleSolitaireModel t2;

  TriangleSolitaireModel t3;

  TriangleSolitaireModel t4;

  TriangleSolitaireModel t5;

  private void init() {
    t1 = new TriangleSolitaireModel();
    t2 = new TriangleSolitaireModel(7);
    t3 = new TriangleSolitaireModel(7, 3, 2);
    t4 = new TriangleSolitaireModel(2, 2);
    t5 = new TriangleSolitaireModel(7, 2, 0);
  }

  @Test
  public void testValidBoardDefault() {
    init();
    ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>> t1Board = new ArrayList<>();
    ArrayList<MarbleSolitaireModelState.SlotState> row0 =
            new ArrayList<MarbleSolitaireModelState.SlotState>(
                    Arrays.asList(Empty, Invalid, Invalid, Invalid, Invalid));
    ArrayList<MarbleSolitaireModelState.SlotState> row1 =
            new ArrayList<MarbleSolitaireModelState.SlotState>(
                    Arrays.asList(Marble, Marble, Invalid, Invalid, Invalid));
    ArrayList<MarbleSolitaireModelState.SlotState> row2 =
            new ArrayList<MarbleSolitaireModelState.SlotState>(
                    Arrays.asList(Marble, Marble, Marble, Invalid, Invalid));
    ArrayList<MarbleSolitaireModelState.SlotState> row3 =
            new ArrayList<MarbleSolitaireModelState.SlotState>(
                    Arrays.asList(Marble, Marble, Marble, Marble, Invalid));
    ArrayList<MarbleSolitaireModelState.SlotState> row4 =
            new ArrayList<MarbleSolitaireModelState.SlotState>(
                    Arrays.asList(Marble, Marble, Marble, Marble, Marble));

    t1Board.add(row0);
    t1Board.add(row1);
    t1Board.add(row2);
    t1Board.add(row3);
    t1Board.add(row4);

    assertEquals(t1Board, t1.returnBoard());
  }

  @Test
  public void testBiggerValidBoardDefault() {
    init();
    ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>> t2Board = new ArrayList<>();
    ArrayList<MarbleSolitaireModelState.SlotState> row0 =
            new ArrayList<MarbleSolitaireModelState.SlotState>(
                    Arrays.asList(Empty, Invalid, Invalid, Invalid, Invalid, Invalid, Invalid));
    ArrayList<MarbleSolitaireModelState.SlotState> row1 =
            new ArrayList<MarbleSolitaireModelState.SlotState>(
                    Arrays.asList(Marble, Marble, Invalid, Invalid, Invalid, Invalid, Invalid));
    ArrayList<MarbleSolitaireModelState.SlotState> row2 =
            new ArrayList<MarbleSolitaireModelState.SlotState>(
                    Arrays.asList(Marble, Marble, Marble, Invalid, Invalid, Invalid, Invalid));
    ArrayList<MarbleSolitaireModelState.SlotState> row3 =
            new ArrayList<MarbleSolitaireModelState.SlotState>(
                    Arrays.asList(Marble, Marble, Marble, Marble, Invalid, Invalid, Invalid));
    ArrayList<MarbleSolitaireModelState.SlotState> row4 =
            new ArrayList<MarbleSolitaireModelState.SlotState>(
                    Arrays.asList(Marble, Marble, Marble, Marble, Marble, Invalid, Invalid));
    ArrayList<MarbleSolitaireModelState.SlotState> row5 =
            new ArrayList<MarbleSolitaireModelState.SlotState>(
                    Arrays.asList(Marble, Marble, Marble, Marble, Marble, Marble, Invalid));
    ArrayList<MarbleSolitaireModelState.SlotState> row6 =
            new ArrayList<MarbleSolitaireModelState.SlotState>(
                    Arrays.asList(Marble, Marble, Marble, Marble, Marble, Marble, Marble));

    t2Board.add(row0);
    t2Board.add(row1);
    t2Board.add(row2);
    t2Board.add(row3);
    t2Board.add(row4);
    t2Board.add(row5);
    t2Board.add(row6);

    assertEquals(t2Board, t2.returnBoard());
  }

  @Test
  public void testBiggerValidBoardDefaultWithSlot() {
    init();
    ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>> t3Board = new ArrayList<>();
    ArrayList<MarbleSolitaireModelState.SlotState> row0 =
            new ArrayList<MarbleSolitaireModelState.SlotState>(
                    Arrays.asList(Marble, Invalid, Invalid, Invalid, Invalid, Invalid, Invalid));
    ArrayList<MarbleSolitaireModelState.SlotState> row1 =
            new ArrayList<MarbleSolitaireModelState.SlotState>(
                    Arrays.asList(Marble, Marble, Invalid, Invalid, Invalid, Invalid, Invalid));
    ArrayList<MarbleSolitaireModelState.SlotState> row2 =
            new ArrayList<MarbleSolitaireModelState.SlotState>(
                    Arrays.asList(Marble, Marble, Marble, Invalid, Invalid, Invalid, Invalid));
    ArrayList<MarbleSolitaireModelState.SlotState> row3 =
            new ArrayList<MarbleSolitaireModelState.SlotState>(
                    Arrays.asList(Marble, Marble, Empty, Marble, Invalid, Invalid, Invalid));
    ArrayList<MarbleSolitaireModelState.SlotState> row4 =
            new ArrayList<MarbleSolitaireModelState.SlotState>(
                    Arrays.asList(Marble, Marble, Marble, Marble, Marble, Invalid, Invalid));
    ArrayList<MarbleSolitaireModelState.SlotState> row5 =
            new ArrayList<MarbleSolitaireModelState.SlotState>(
                    Arrays.asList(Marble, Marble, Marble, Marble, Marble, Marble, Invalid));
    ArrayList<MarbleSolitaireModelState.SlotState> row6 =
            new ArrayList<MarbleSolitaireModelState.SlotState>(
                    Arrays.asList(Marble, Marble, Marble, Marble, Marble, Marble, Marble));

    t3Board.add(row0);
    t3Board.add(row1);
    t3Board.add(row2);
    t3Board.add(row3);
    t3Board.add(row4);
    t3Board.add(row5);
    t3Board.add(row6);

    assertEquals(t3Board, t3.returnBoard());
  }

  @Test
  public void testDefaultWithSlot() {
    init();
    ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>> t4Board = new ArrayList<>();
    ArrayList<MarbleSolitaireModelState.SlotState> row0 =
            new ArrayList<MarbleSolitaireModelState.SlotState>(
                    Arrays.asList(Marble, Invalid, Invalid, Invalid, Invalid));
    ArrayList<MarbleSolitaireModelState.SlotState> row1 =
            new ArrayList<MarbleSolitaireModelState.SlotState>(
                    Arrays.asList(Marble, Marble, Invalid, Invalid, Invalid));
    ArrayList<MarbleSolitaireModelState.SlotState> row2 =
            new ArrayList<MarbleSolitaireModelState.SlotState>(
                    Arrays.asList(Marble, Marble, Empty, Invalid, Invalid));
    ArrayList<MarbleSolitaireModelState.SlotState> row3 =
            new ArrayList<MarbleSolitaireModelState.SlotState>(
                    Arrays.asList(Marble, Marble, Marble, Marble, Invalid));
    ArrayList<MarbleSolitaireModelState.SlotState> row4 =
            new ArrayList<MarbleSolitaireModelState.SlotState>(
                    Arrays.asList(Marble, Marble, Marble, Marble, Marble));

    t4Board.add(row0);
    t4Board.add(row1);
    t4Board.add(row2);
    t4Board.add(row3);
    t4Board.add(row4);

    assertEquals(t4Board, t4.returnBoard());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructorsForEmptySlotNegative() {
    t1 = new TriangleSolitaireModel(-1, -1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructorsForEmptySlotInvalidSpot() {
    t1 = new TriangleSolitaireModel(0, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructorsForEmptySlotInvalidSpot2() {
    t1 = new TriangleSolitaireModel(0, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructorsForDimensionAndSlOt() {
    t1 = new TriangleSolitaireModel(-1, 0, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructorsForDimensionAndSlot2() {
    t1 = new TriangleSolitaireModel(4, 0, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructorsForThickness() {
    t1 = new TriangleSolitaireModel(-1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoves() {
    init();
    t1.move(0, 0, 0, 2);
    t1.move(0, 3, 0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMovesMiddleEmpty() {
    init();
    t5.move(0, 1, 0, 3);
  }

  @Test
  public void testValidMoves() {
    init();
    //down
    t5.move(0, 0, 2, 0);
    assertEquals(Empty, t1.getSlotAt(0, 0));
  }

  @Test
  public void testGameOver() {
    init();
    t1.move(2, 0, 0, 0); // up
    t1.move(2, 2, 2, 0); // left
    t1.move(0, 0, 2, 2); // diagonal

    t1.move(3, 3, 1, 1);// diagonal up left
    t1.move(3, 0, 1, 0);//up
    t1.move(4, 1, 2, 1);//up
    t1.move(4, 3, 4, 1);//left
    t1.move(4, 0, 4, 2);//right
    t1.move(2, 1, 4, 3);//diagonal down right
    t1.move(4, 3, 4, 1);//left

    assertEquals(true, t1.isGameOver());
  }

  @Test
  public void testGetSlotAt() {
    init();
    assertEquals(Marble, t1.getSlotAt(3, 1));
    assertEquals(Invalid, t1.getSlotAt(3, 4));
    assertEquals(Empty, t1.getSlotAt(0, 0));
  }
}
