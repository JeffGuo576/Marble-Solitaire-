package cs3500.marblesolitaire.model.hw04;

import java.util.ArrayList;

/**
 * TriangleSolitaireModel functional portion of the game.
 */
public class TriangleSolitaireModel extends AbstractSolitaireModel {

  private int dimensions;

  /**
   * Creates a new TriangleSolitaireModel object.
   */
  public TriangleSolitaireModel() {
    super(0, 0);
    this.dimensions = 5;
    this.board = this.createBoard();
  }

  /**
   * Creates a new TriangleSolitaireModel object based on the dimension.
   *
   * @param dimensions determines the length of the board.
   * @throws IllegalArgumentException if the dimension is non-positive.
   */
  public TriangleSolitaireModel(int dimensions) {
    super(0, 0);
    if (dimensions < 0) {
      throw new IllegalArgumentException("Non-positive dimension!");
    }
    this.dimensions = dimensions;
    this.board = this.createBoard();
  }


  /**
   * Creates a new TriangleSolitaireModel object that hold an empty spot based on given row and
   * column.
   *
   * @param sRow the row it selects to be empty.
   * @param sCol the column it selects to be empty.
   * @throws IllegalArgumentException if it's not a valid row or column or arm thickness.
   */
  public TriangleSolitaireModel(int sRow, int sCol) {
    super(sRow, sCol);
    this.dimensions = 5;
    this.board = this.createBoard();
    if (isInvalid(sRow, sCol)) {
      throw new IllegalArgumentException("Invalid empty cell position (" + sRow + "," + sCol + ")");
    }
  }

  /**
   * Creates a new EuropeanSolitaireModel object that hold an empty spot based on given row and
   * column. The size of the EuropeanSolitaireModel is determined by the dimension.
   *
   * @param dimensions determines the length of the board.
   * @param sRow       the row it selects to be empty.
   * @param sCol       the column it selects to be empty.
   * @throws IllegalArgumentException if it's not a valid row or column or arm thickness.
   */
  public TriangleSolitaireModel(int dimensions, int sRow, int sCol) {
    super(sRow, sCol);
    if (dimensions < 0) {
      throw new IllegalArgumentException("Non-positive dimension!");
    }
    this.dimensions = dimensions;
    this.board = this.createBoard();
    if (isInvalid(sRow, sCol)) {
      throw new IllegalArgumentException("Invalid empty cell position (" + sRow + "," + sCol + ")");
    }
  }

  @Override
  protected boolean isInvalid(int sRow, int sCol) {
    return (sCol > sRow + 1 && sCol < this.dimensions);
  }

  /**
   * Creates a board.
   *
   * @return arraylist of the board.
   */
  protected ArrayList<ArrayList<SlotState>> createBoard() {
    ArrayList<ArrayList<SlotState>> board = new ArrayList<ArrayList<SlotState>>();
    int num = this.getBoardSize() - this.getBoardSize() + 1;
    for (int x = 0; x < this.getBoardSize(); x++) {
      ArrayList<SlotState> newRow = new ArrayList<SlotState>();
      for (int y = 0; y < num; y++) {
        newRow.add(SlotState.Marble);
      }
      for (int y = num; y < this.getBoardSize(); y++) {
        newRow.add(SlotState.Invalid);
      }
      board.add(newRow);
      num++;
    }
    board.get(sRow).set(sCol, SlotState.Empty);
    return board;
  }

  @Override
  public int getBoardSize() {
    return this.dimensions;
  }

  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    boolean initialPosHasMarble = (getSlotAt(fromRow, fromCol) == SlotState.Marble);
    boolean finalPosIsEmpty = (getSlotAt(toRow, toCol) == SlotState.Empty);
    boolean rowTwoPosition = Math.abs(fromRow - toRow) == 2 && fromCol == toCol;
    boolean colTwoPosition = Math.abs(fromCol - toCol) == 2 && fromRow == toRow;
    boolean diagional = Math.abs(fromRow - toRow) == 2 && Math.abs(fromCol - toCol) == 2;
    if (initialPosHasMarble && finalPosIsEmpty && (rowTwoPosition || colTwoPosition || diagional)) {
      board.get(fromRow).set(fromCol, SlotState.Empty);
      board.get(toRow).set(toCol, SlotState.Marble);
      board.get((fromRow + toRow) / 2).set((fromCol + toCol) / 2, SlotState.Empty);
    } else {
      throw new IllegalArgumentException("Not a valid move.");
    }
  }
}
