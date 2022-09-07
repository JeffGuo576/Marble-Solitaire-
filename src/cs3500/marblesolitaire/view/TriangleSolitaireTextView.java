package cs3500.marblesolitaire.view;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * Class for the visual portion for the TriangleSolitaire.
 */
public class TriangleSolitaireTextView extends AbstractSolitaireTextView {

  /**
   * Constructor for MarbleSolitaireTextView.
   *
   * @param model a EnglishSolitaireModel
   * @throws IllegalArgumentException if it's not a valid model.
   */

  public TriangleSolitaireTextView(MarbleSolitaireModelState model)
          throws IllegalArgumentException {
    super(model);
  }

  /**
   * Constructor for the MarbleSolitaireTextView.
   *
   * @param model MarbleSolitaireModel.
   * @param ap    System output.
   * @throws IllegalArgumentException if model is or appendable is null.
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState model, Appendable ap)
          throws IllegalArgumentException {
    super(model, ap);
  }

  @Override
  public String toString() {
    String visual = "";
    int num = model.getBoardSize() - 1;
    int num2 = model.getBoardSize() - 1;
    for (int row = 0; row < model.getBoardSize(); row++) {
      String visual2 = "";
      num = num2;
      while (num > 0) {
        visual2 = visual2 + " ";
        num--;
      }
      visual = visual + visual2;
      num2--;
      for (int col = 0; col < model.getBoardSize(); col++) {
        if (model.getSlotAt(row, col) == MarbleSolitaireModelState.SlotState.Marble) {
          visual = visual + "O ";
        }
        if (model.getSlotAt(row, col) == MarbleSolitaireModelState.SlotState.Empty) {
          visual = visual + "_ ";
        }
        if (model.getSlotAt(row, col) == MarbleSolitaireModelState.SlotState.Invalid) {
          visual = visual + "  ";
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
}