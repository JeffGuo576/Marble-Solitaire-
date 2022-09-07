package cs3500.marblesolitaire.view;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * Represents the visual portion of the game.
 */
public class MarbleSolitaireTextView extends AbstractSolitaireTextView {
  private MarbleSolitaireModelState model;

  public Appendable ap;

  /**
   * Constructor for MarbleSolitaireTextView.
   *
   * @param model a EnglishSolitaireModel
   * @throws IllegalArgumentException if it's not a valid model.
   */

  public MarbleSolitaireTextView(MarbleSolitaireModelState model) throws IllegalArgumentException {
    super(model);
  }

  /**
   * Constructor for the MarbleSolitaireTextView.
   *
   * @param model MarbleSolitaireModel.
   * @param ap    System output.
   * @throws IllegalArgumentException if model is or appendable is null.
   */
  public MarbleSolitaireTextView(MarbleSolitaireModelState model, Appendable ap)
          throws IllegalArgumentException {
    super(model, ap);
  }

}



