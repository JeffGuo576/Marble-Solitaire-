package cs3500.marblesolitaire.model.hw02;

import java.util.ArrayList;

import cs3500.marblesolitaire.model.hw04.AbstractSolitaireModel;

/**
 * A class that represents the functional portion of the game.
 */
public class EnglishSolitaireModel extends AbstractSolitaireModel {

  /**
   * Create a new EnglishSolitaireModel object.
   */
  public EnglishSolitaireModel() {
    super();
    this.board = this.createBoard();
    this.score = this.getScore();
    this.gameState = this.isGameOver();
  }

  /**
   * Creates a new EnglishSolitaire object that hold an empty spot based on given row and column.
   *
   * @param sRow the row it selects to be empty.
   * @param sCol the column it selects to be empty.
   * @throws IllegalArgumentException if it's not a valid row or column.
   */
  public EnglishSolitaireModel(int sRow, int sCol) throws IllegalArgumentException {
    super(sRow, sCol);
    this.board = this.createBoard();
    this.score = this.getScore();
    this.gameState = this.isGameOver();
    if (getSlotAt(sRow, sCol) == SlotState.Invalid) {
      throw new IllegalArgumentException("Invalid empty cell position (" + sRow + "," + sCol + ")");
    }
  }

  /**
   * Creates a new EnglishSolitaire object based on the arm thickness.
   *
   * @param aThickness arm thickness, determines the size of the board.
   * @throws IllegalArgumentException if the arm thickness is even or less than 3.
   */
  public EnglishSolitaireModel(int aThickness) throws IllegalArgumentException {
    super(aThickness);
    this.board = this.createBoard();
    this.score = this.getScore();
    this.gameState = this.isGameOver();
  }

  /**
   * Creates a new EnglishSolitaire object that hold an empty spot based on given row and column.
   *
   * @param aThickness arm thickness, determines the size of the board.
   * @param sRow       the row it selects to be empty.
   * @param sCol       the column it selects to be empty.
   * @throws IllegalArgumentException if it's not a valid row or column or arm thickness.
   */
  public EnglishSolitaireModel(int aThickness, int sRow, int sCol) throws IllegalArgumentException {
    super(aThickness, sRow, sCol);
    this.board = this.createBoard();
    this.score = this.getScore();
    this.gameState = this.isGameOver();
    if (getSlotAt(sRow, sCol) == SlotState.Invalid) {
      throw new IllegalArgumentException("Invalid empty cell position (" + sRow + "," + sCol + ")");
    }
  }

  /**
   * Creates a board.
   *
   * @return arraylist of the board.
   */

  protected ArrayList<ArrayList<SlotState>> createBoard() {
    ArrayList<ArrayList<SlotState>> board = new ArrayList<ArrayList<SlotState>>();
    for (int x = 0; x < this.getBoardSize(); x++) {
      ArrayList<SlotState> newRow = new ArrayList<SlotState>();
      for (int y = 0; y < this.getBoardSize(); y++) {
        if (this.isInvalid(x, y)) {
          newRow.add(SlotState.Invalid);
        } else if (x == this.sRow && y == this.sCol) {
          newRow.add(SlotState.Empty);
        } else {
          newRow.add(SlotState.Marble);
        }
      }
      board.add(newRow);
    }
    return board;
  }


}