package cs3500.marblesolitaire;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * Represents a Marble Solitaire game where you can run a specific solitaire game
 * from English, European, or Triangle.
 */
public final class MarbleSolitaire {

  /**
   * The main method to call when running the game.
   * @param args determine which game to play.
   */
  public static void main(String[] args) {
    String input = args[0];
    MarbleSolitaireModelState model;
    MarbleSolitaireController controller;
  }
}
