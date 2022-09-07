package cs3500.marblesolitaire.model.hw04;

import java.util.ArrayList;

import cs3500.marblesolitaire.model.hw04.AbstractSolitaireModel;

/**
 * EuropeanSolitaireModel functional portion of the game.
 */
public class EuropeanSolitaireModel extends AbstractSolitaireModel {

  /**
   * Creates a new EuropeanSolitaireModel object.
   */
  public EuropeanSolitaireModel() {
    super();
    this.board = this.createBoard();
    this.score = this.getScore();
    this.gameState = this.isGameOver();
  }

  /**
   * Creates a new EuropeanSolitaireModel object that hold an empty spot based on given row and
   * column.
   *
   * @param sRow the row it selects to be empty.
   * @param sCol the column it selects to be empty.
   * @throws IllegalArgumentException if it's not a valid row or column.
   */
  public EuropeanSolitaireModel(int sRow, int sCol) throws IllegalArgumentException {
    super(sRow, sCol);
    this.board = this.createBoard();
    this.score = this.getScore();
    this.gameState = this.isGameOver();
    if (isInvalid(sRow, sCol)) {
      throw new IllegalArgumentException("Invalid empty cell position (" + sRow + "," + sCol + ")");
    }
  }

  /**
   * Creates a new EuropeanSolitaireModel object based on the arm thickness.
   *
   * @param aThickness arm thickness, determines the size of the board.
   * @throws IllegalArgumentException if the arm thickness is even or less than 3.
   */
  public EuropeanSolitaireModel(int aThickness) throws IllegalArgumentException {
    super(aThickness);
    this.board = this.createBoard();
    this.score = this.getScore();
    this.gameState = this.isGameOver();
  }


  /**
   * Creates a new EuropeanSolitaireModel object that hold an empty spot based on given row and
   * column.
   *
   * @param aThickness arm thickness, determines the size of the board.
   * @param sRow       the row it selects to be empty.
   * @param sCol       the column it selects to be empty.
   * @throws IllegalArgumentException if it's not a valid row or column or arm thickness.
   */
  public EuropeanSolitaireModel(int aThickness, int sRow, int sCol)
          throws IllegalArgumentException {
    super(aThickness, sRow, sCol);
    this.board = this.createBoard();
    this.score = this.getScore();
    this.gameState = this.isGameOver();
    if (isInvalid(sRow, sCol)) {
      throw new IllegalArgumentException("Invalid empty cell position (" + sRow + "," + sCol + ")");
    }
  }


  @Override
  protected boolean isInvalid(int sRow, int sCol) {
    int toprightside = this.getBoardSize() - aThickness + 1; //9
    int topleftside = aThickness - 2; // 3
    boolean toprows = sRow >= 0 && sRow <= aThickness - 2;
    boolean botrows = sRow >= this.getBoardSize() - aThickness + 1 && sRow < this.getBoardSize();
    boolean topleft = sCol <= topleftside - sRow;// 2 <= 1
    boolean topright = sCol >= toprightside + sRow;// 2 <=
    boolean botleft = sCol <= topleftside - (getBoardSize() - sRow - 1);
    boolean botright = sCol >= toprightside + (getBoardSize() - sRow - 1);
    if (toprows) {
      return (topleft || topright);
    }
    if (botrows) {
      return (botleft || botright);
    }
    return false;
  }

  /**
   * Creates a board.
   *
   * @return arraylist of the board.
   */
  protected ArrayList<ArrayList<SlotState>> createBoard() {
    ArrayList<ArrayList<SlotState>> board = new ArrayList<ArrayList<SlotState>>();
    int rightside = this.aThickness * 2 - 1;
    int leftside = this.aThickness - 1;
    int row1 = aThickness - 1;
    int row2 = aThickness * 2 - 2;
    for (int x = 0; x < this.getBoardSize(); x++) {
      ArrayList<SlotState> newRow = new ArrayList<SlotState>();
      for (int y = 0; y < leftside; y++) {
        newRow.add(SlotState.Invalid);
      }
      for (int y = leftside; y < rightside; y++) {
        newRow.add(SlotState.Marble);
      }
      for (int y = rightside; y < this.getBoardSize(); y++) {
        newRow.add(SlotState.Invalid);
      }

      if (x < row1) {
        leftside--;
        rightside++;
      }
      if (x >= row2) {
        leftside++;
        rightside--;
      }
      board.add(newRow);
    }
    board.get(sRow).set(sCol, SlotState.Empty);
    return board;
  }

}
