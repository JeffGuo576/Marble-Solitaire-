package cs3500.marblesolitaire.controller;

import java.io.InputStreamReader;
import java.io.Reader;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;

/**
 * Starts the game and allows any input from the person.
 */
public class MarbleSolitaireGame {

  /**
   * Starts the game and allows any input from the person.
   */
  public static void main(String []args) {
    MarbleSolitaireModel g1 = new TriangleSolitaireModel();
    MarbleSolitaireView gv1 = new TriangleSolitaireTextView(g1);
    Reader in = new InputStreamReader(System.in);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(g1, gv1, in);
    controller.playGame();
  }
}
