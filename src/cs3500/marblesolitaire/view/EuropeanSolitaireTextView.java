package cs3500.marblesolitaire.view;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * Tests for the visual portion of the game.
 */
public class EuropeanSolitaireTextView extends MarbleSolitaireTextView {

  public EuropeanSolitaireTextView(MarbleSolitaireModelState model)
          throws IllegalArgumentException {
    super(model);
  }

  public EuropeanSolitaireTextView(MarbleSolitaireModelState model, Appendable ap)
          throws IllegalArgumentException {
    super(model, ap);
  }
}
