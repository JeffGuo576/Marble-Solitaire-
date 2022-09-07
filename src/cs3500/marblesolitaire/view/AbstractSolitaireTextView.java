package cs3500.marblesolitaire.view;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * An abstract for the visual portion of the game.
 */
public abstract class AbstractSolitaireTextView implements MarbleSolitaireView {

  protected MarbleSolitaireModelState model;
  protected final Appendable ap;

  /**
   * Creates a TextView object of the model.
   *
   * @param model the type of model it's using.
   * @throws IllegalArgumentException if the model is null.
   */
  public AbstractSolitaireTextView(MarbleSolitaireModelState model) {
    if (model == null) {
      throw new IllegalArgumentException("Not a valid model.");
    }
    this.model = model;
    this.ap = System.out;
  }

  /**
   * Creates a TextView object of the model.
   *
   * @param model the type of model it's using.
   * @param ap the inputs it's reading.
   * @throws IllegalArgumentException if the model is null.
   */
  public AbstractSolitaireTextView(MarbleSolitaireModelState model, Appendable ap) {
    if (model == null || ap == null) {
      throw new IllegalArgumentException("Not a valid model or appendable.");
    }
    this.model = model;
    this.ap = System.out;
  }


  @Override
  public String toString() {
    String visual = "";
    for (int row = 0; row < model.getBoardSize(); row++) {
      for (int col = 0; col < model.getBoardSize(); col++) {
        if (model.getSlotAt(row, col) == MarbleSolitaireModelState.SlotState.Invalid) {
          visual = visual + "  ";
        }
        if (model.getSlotAt(row, col) == MarbleSolitaireModelState.SlotState.Empty) {
          visual = visual + "_ ";
        }
        if (model.getSlotAt(row, col) == MarbleSolitaireModelState.SlotState.Marble) {
          visual = visual + "O ";
        }
        if (col == model.getBoardSize() - 1) {
          visual = visual.stripTrailing();
        }
      }
      if (row != model.getBoardSize() - 1) {
        visual = visual + "\n";
      }
    }
    return visual;
  }

  /**
   * Renders the board into a string.
   */
  public void renderBoard() {
    try {
      this.ap.append(this.toString());
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }

  /**
   * Renders a message.
   *
   * @param message the message to be transmitted.
   */
  public void renderMessage(String message) {
    try {
      this.ap.append(message);
    } catch (IOException e) {
      throw new IllegalStateException("Not a string!");
    }

  }
}
