package cs3500.marblesolitaire.model.hw04;

import java.util.ArrayList;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * An abstract class for the functional portion of the game.
 */
public abstract class AbstractSolitaireModel implements MarbleSolitaireModel {

  protected final int aThickness;
  protected final int sRow;
  protected final int sCol;

  protected ArrayList<ArrayList<SlotState>> board;
  protected int score;
  protected boolean gameState;

  /**
   * Create a new AbstractSolitaireModel object.
   */
  public AbstractSolitaireModel() {
    this.aThickness = 3;
    this.sRow = 3;
    this.sCol = 3;
  }

  /**
   * Creates a new AbstractSolitaireModel object that hold an empty spot based on given row and
   * column.
   *
   * @param sRow the row it selects to be empty.
   * @param sCol the column it selects to be empty.
   * @throws IllegalArgumentException if it's not a valid row or column.
   */
  public AbstractSolitaireModel(int sRow, int sCol) throws IllegalArgumentException {
    if (sRow < 0) {
      throw new IllegalArgumentException("Cannot select a negative row.");
    }
    if (sCol < 0) {
      throw new IllegalArgumentException("Cannot select a negative column.");
    }
    this.aThickness = 3;
    this.sRow = sRow;
    this.sCol = sCol;
  }

  /**
   * Creates a new AbstractSolitaireModel object based on the arm thickness.
   *
   * @param aThickness arm thickness, determines the size of the board.
   * @throws IllegalArgumentException if the arm thickness is even or less than 3.
   */
  public AbstractSolitaireModel(int aThickness) throws IllegalArgumentException {
    if (invalidAThickness(aThickness)) {
      throw new IllegalArgumentException("Not a valid arm thickness.");
    }
    this.aThickness = aThickness;
    this.sRow = (this.getBoardSize() - 1) / 2;
    this.sCol = (this.getBoardSize() - 1) / 2;
  }

  /**
   * Creates a new AbstractSolitaireModel object that hold an empty spot based on given row and
   * column.
   *
   * @param aThickness arm thickness, determines the size of the board.
   * @param sRow       the row it selects to be empty.
   * @param sCol       the column it selects to be empty.
   * @throws IllegalArgumentException if it's not a valid row or column or arm thickness.
   */
  public AbstractSolitaireModel(int aThickness, int sRow, int sCol)
          throws IllegalArgumentException {
    if (sRow < 0) {
      throw new IllegalArgumentException("Cannot select a negative row.");
    }
    if (sCol < 0) {
      throw new IllegalArgumentException("Cannot select a negative column.");
    }
    if (invalidAThickness(aThickness)) {
      throw new IllegalArgumentException("Not a valid arm thickness.");
    }
    this.aThickness = aThickness;
    this.sRow = sRow;
    this.sCol = sCol;
  }


  /**
   * Checks for the rows and columns that are considered invalid on the board.
   *
   * @param row is the row of the board.
   * @param col is the column of the board.
   * @return
   */
  protected boolean isInvalid(int row, int col) {
    boolean topInvalidRows = (row >= 0 && row < this.aThickness - 1);
    boolean botInvalidRows = (row > getBoardSize() - aThickness && row < this.getBoardSize());
    boolean leftInvalidCols = (col >= 0 && col < this.aThickness - 1);
    boolean rightInvalidCols = (col > getBoardSize() - aThickness && row < this.getBoardSize());
    if (topInvalidRows || botInvalidRows) {
      return leftInvalidCols || rightInvalidCols;
    }
    return false;
  }


  /**
   * Checks if it's a valid arm thickness.
   *
   * @param aThickness arm thickness of the board.
   * @return true if it's a valid arm thickness.
   */
  protected boolean invalidAThickness(int aThickness) {
    return aThickness % 2 == 0 || aThickness < 3;
  }

  /**
   * Move a single marble from a given position to another given position.
   * A move is valid only if the from and to positions are valid. Specific
   * implementations may place additional constraints on the validity of a move.
   *
   * @param fromRow the row number of the position to be moved from
   *                (starts at 0)
   * @param fromCol the column number of the position to be moved from
   *                (starts at 0)
   * @param toRow   the row number of the position to be moved to
   *                (starts at 0)
   * @param toCol   the column number of the position to be moved to
   *                (starts at 0)
   * @throws IllegalArgumentException if the move is from and to are diagonal.
   *                                  if the from position is outside the index.
   *                                  if the to position is outside the index.
   *                                  the from and to positions are more than two positions apart.
   *                                  if between the from and to positions does not have a marble.
   *                                  if the from position does not have a marble.
   *                                  if the to position is not empty.
   */
  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    boolean initialPosHasMarble = (getSlotAt(fromRow, fromCol) == SlotState.Marble);
    boolean finalPosIsEmpty = (getSlotAt(toRow, toCol) == SlotState.Empty);
    boolean rowTwoPosition = Math.abs(fromRow - toRow) == 2 && fromCol == toCol;
    boolean colTwoPosition = Math.abs(fromCol - toCol) == 2 && fromRow == toRow;

    if (initialPosHasMarble && finalPosIsEmpty && (rowTwoPosition || colTwoPosition)) {
      board.get(fromRow).set(fromCol, SlotState.Empty);
      board.get(toRow).set(toCol, SlotState.Marble);
      setMiddleMarble(fromRow, fromCol, toRow, toCol);
    } else {
      throw new IllegalArgumentException("Not a valid move.");
    }
  }

  /**
   * Finds the marble it jumped over and setting it to empty.
   *
   * @param fromRow the row number of the position to be moved from
   *                (starts at 0)
   * @param fromCol the column number of the position to be moved from
   *                (starts at 0)
   * @param toRow   the row number of the position to be moved to
   *                (starts at 0)
   * @param toCol   the column number of the position to be moved to
   *                (starts at 0)
   */
  protected void setMiddleMarble(int fromRow, int fromCol, int toRow, int toCol) {
    if (fromRow > toRow) {
      board.get(fromRow - 1).set(toCol, SlotState.Empty);
    }
    if (toRow > fromRow) {
      board.get(fromRow + 1).set(toCol, SlotState.Empty);
    }
    if (fromCol > toCol) {
      board.get(fromRow).set(fromCol - 1, SlotState.Empty);
    }
    if (toCol > fromCol) {
      board.get(fromRow).set(fromCol + 1, SlotState.Empty);
    }
  }

  /**
   * Checks if there is a marble in between the given rows and columns.
   *
   * @param fromRow the row number of the position to be moved from
   *                (starts at 0)
   * @param fromCol the column number of the position to be moved from
   *                (starts at 0)
   * @param toRow   the row number of the position to be moved to
   *                (starts at 0)
   * @param toCol   the column number of the position to be moved to
   *                (starts at 0)
   * @return true if there is a marble in between the given rows and columns.
   */
  protected boolean isMarbleMiddle(int fromRow, int fromCol, int toRow, int toCol) {
    if (fromRow > toRow) {
      return getSlotAt(fromRow - 1, fromCol) == SlotState.Marble;
    }
    if (toRow > fromRow) {
      return getSlotAt(fromRow + 1, fromCol) == SlotState.Marble;
    }
    if (fromCol > toCol) {
      return getSlotAt(fromRow, fromCol - 1) == SlotState.Marble;
    }
    if (toCol > fromCol) {
      return getSlotAt(fromRow, fromCol + 1) == SlotState.Marble;
    }
    return false;
  }


  /**
   * Checks if the game is over.
   *
   * @return true if the game is over.
   */
  @Override
  public boolean isGameOver() {
    return this.anyPossibleMoves() == 0 && getScore() >= 1;
  }

  /**
   * Gets the board size.
   *
   * @return board size.
   */
  @Override
  public int getBoardSize() {
    return this.aThickness + (this.aThickness - 1) * 2;
  }

  /**
   * Checks if the given row and column slot.
   *
   * @param row the row of the position sought, starting at 0
   * @param col the column of the position sought, starting at 0
   * @return the state of the given Slot.
   * @throws IllegalArgumentException if it's beyond the dimensions of the board.
   */
  @Override
  public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
    if (row < 0 || row > getBoardSize() - 1 || col < 0 || col > getBoardSize() - 1) {
      throw new IllegalArgumentException("Invalid index.");
    }
    if ((board.get(row).get(col) == SlotState.Invalid)
            || (board.get(row).get(col) == SlotState.Marble)
            || (board.get(row).get(col) == SlotState.Empty)) {
      return board.get(row).get(col);
    } else {
      throw new IllegalArgumentException("Beyond the dimensions of the board");
    }
  }

  @Override
  public int getScore() {
    int score = 0;
    for (int x = 0; x < this.getBoardSize(); x++) {
      for (int y = 0; y < this.getBoardSize(); y++) {
        if (board.get(x).get(y) == SlotState.Marble) {
          score++;
        }
      }
    }
    return score;
  }

  /**
   * Checks if there are marbles with any possible moves.
   *
   * @return a given amount of marbles with possible moves.
   */
  protected int anyPossibleMoves() {
    int possibleMoves = 0;
    for (int x = 0; x < this.getBoardSize(); x++) {
      for (int y = 0; y < this.getBoardSize(); y++) {
        if (getSlotAt(x, y) == SlotState.Marble) {
          if (isMarbleNext(x, y)) {
            possibleMoves++;
          }
        }
      }
    }
    return possibleMoves;
  }

  /**
   * Checks if any marbles are next to it.
   *
   * @param row the row of the position sought, starting at 0
   * @param col the column of the position sought, starting at 0
   * @return true if there are marbles nearby.
   */
  protected boolean isMarbleNext(int row, int col) {
    if (row == 0 && col == 0) {
      return false;
    }
    if (row == 0 && col == getBoardSize() - 1) {
      return false;
    }
    if (row == getBoardSize() - 1 && col == 0) {
      return false;
    }
    if (row == getBoardSize() - 1 && col == getBoardSize() - 1) {
      return false;
    }
    if (row == 0) {
      return ((this.leftMarble(row, col) && this.slotEmptyOrOutbounds(row, col - 2))
              || (this.rightMarble(row, col) && this.slotEmptyOrOutbounds(row, col + 2))
              || (this.botMarble(row, col) && this.slotEmptyOrOutbounds(row + 2, col)));
    }
    if (col == 0) {
      return ((this.topMarble(row, col) && this.slotEmptyOrOutbounds(row - 2, col))
              || (this.botMarble(row, col) && this.slotEmptyOrOutbounds(row + 2, col))
              || (this.rightMarble(row, col) && this.slotEmptyOrOutbounds(row, col + 2)));
    }
    if (col == getBoardSize() - 1) {
      return ((this.topMarble(row, col) && this.slotEmptyOrOutbounds(row - 2, col))
              || (this.botMarble(row, col) && this.slotEmptyOrOutbounds(row + 2, col))
              || (this.leftMarble(row, col) && this.slotEmptyOrOutbounds(row, col - 2)));
    }
    if (row == getBoardSize() - 1) {
      return ((this.leftMarble(row, col) && this.slotEmptyOrOutbounds(row, col - 2))
              || (this.rightMarble(row, col) && this.slotEmptyOrOutbounds(row, col + 2))
              || (this.topMarble(row, col) && this.slotEmptyOrOutbounds(row - 2, col)));
    }
    return ((this.botMarble(row, col) && this.slotEmptyOrOutbounds(row + 2, col))
            || (this.rightMarble(row, col) && this.slotEmptyOrOutbounds(row, col + 2))
            || (this.leftMarble(row, col) && this.slotEmptyOrOutbounds(row, col - 2))
            || ((this.topMarble(row, col) && this.slotEmptyOrOutbounds(row - 2, col))));
  }

  /**
   * Checks if there is a marble in a row above.
   *
   * @param row the row of the position sought, starting at 0
   * @param col the column of the position sought, starting at 0
   * @return true if there is a marble in a row above.
   */
  protected boolean topMarble(int row, int col) {
    return this.getSlotAt(row - 1, col) == SlotState.Marble;
  }

  /**
   * Checks if there is a marble in a row below.
   *
   * @param row the row of the position sought, starting at 0
   * @param col the column of the position sought, starting at 0
   * @return true if there is a marble in a row below.
   */
  protected boolean botMarble(int row, int col) {
    return this.getSlotAt(row + 1, col) == SlotState.Marble;
  }

  /**
   * Checks if there is a marble to the column on the left.
   *
   * @param row the row of the position sought, starting at 0
   * @param col the column of the position sought, starting at 0
   * @return true if there is a marble on the left column.
   */
  protected boolean leftMarble(int row, int col) {
    return this.getSlotAt(row, col - 1) == SlotState.Marble;
  }

  /**
   * Checks if there is a marble to the column on the right.
   *
   * @param row the row of the position sought, starting at 0
   * @param col the column of the position sought, starting at 0
   * @return true if there is a marble on the right column.
   */
  protected boolean rightMarble(int row, int col) {
    return this.getSlotAt(row, col + 1) == SlotState.Marble;
  }

  /**
   * Checks if the slot is empty or not.
   *
   * @param row the row of the position sought, starting at 0
   * @param col the column of the position sought, starting at 0
   * @return true if its empty, false if it's not.
   */

  protected boolean slotEmptyOrOutbounds(int row, int col) {
    try {
      this.getSlotAt(row, col);
      return this.getSlotAt(row, col) == SlotState.Empty;
    } catch (IllegalArgumentException e) {
      return false;
    }
  }

  /**
   * It gets the data of the board.
   *
   * @return the contents of the board.
   */
  public ArrayList<ArrayList<SlotState>> returnBoard() {
    return this.board;
  }
}