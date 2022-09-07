package cs3500.marblesolitaire.controller;

import java.io.IOException;
import java.util.Scanner;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

/**
 * A class that represents the controller aspect of the Solitaire game.
 */
public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {
  final private MarbleSolitaireModel model;
  final private MarbleSolitaireView view;
  final private Readable rd;

  /**
   * Controller for the game.
   *
   * @param model MarbleSolitaireModel, the function part of the game.
   * @param view  MarbleSolitaireView, the visual of the game.
   * @param rd    Readable, the inputs of the game.
   * @throws IllegalArgumentException if the model or view or readable is null.
   */
  public MarbleSolitaireControllerImpl(MarbleSolitaireModel model,
                                       MarbleSolitaireView view, Readable rd)
          throws IllegalArgumentException {
    if (model == null || view == null || rd == null) {
      throw new IllegalArgumentException("Model or view or readable cannot be null.");
    }
    this.model = model;
    this.view = view;
    this.rd = rd;
  }

  /**
   * Initializes the game and takes in inputs.
   */
  public void playGame() throws IllegalStateException {
    int num;
    Scanner input = new Scanner(this.rd); // gets the inputs
    int totalMoveInputs = 0;
    int[] moveInput = new int[]{0, 0, 0, 0};
    try {
      this.view.renderBoard();
      this.view.renderMessage("\n");
      this.view.renderMessage("Score: " + this.model.getScore() + "\n");
    } catch (Exception e) {
      throw new IllegalStateException(e);
    }
    while (input.hasNext() && totalMoveInputs < 4) {
      String scan = input.next();
      try {
        num = Integer.parseInt(scan);
        moveInput[totalMoveInputs] = num - 1;
        totalMoveInputs++;
        if (totalMoveInputs == 4) {
          try {
            model.move(moveInput[0], moveInput[1], moveInput[2], moveInput[3]);
            if (model.isGameOver()) {
              try {
                this.view.renderMessage("Game over!\n");
              } catch (IOException e) {
                throw new IllegalStateException(e);
              }
            }
            this.view.renderBoard();
            this.view.renderMessage("\n");
            this.view.renderMessage("Score: " + this.model.getScore() + "\n");
            totalMoveInputs = 0;
          } catch (IllegalArgumentException e) {
            try {
              this.view.renderMessage("Invalid move. Play again.\n");
            } catch (IOException ex) {
              throw new IllegalStateException(ex);
            }
            totalMoveInputs = 0;
          } catch (IOException e) {
            throw new IllegalStateException(e);
          }
        }
      } catch (NumberFormatException e) {
        if (scan.equals("q") || scan.equals("Q")) {
          try {
            this.view.renderMessage("Game quit!\n");
            this.view.renderMessage("State of game when quit:\n");
            this.view.renderBoard();
            this.view.renderMessage("\n");
            this.view.renderMessage("Score: " + this.model.getScore() + "\n");
          } catch (IllegalStateException ex) {
            throw new IllegalStateException(ex);
          } catch (IOException ex) {
            throw new IllegalStateException(ex);
          }
        } else {
          try {
            this.view.renderMessage("Enter valid value:\n");

          } catch (IOException ex) {
            throw new IllegalStateException(ex);
          }
        }
      }
    }
    while (!model.isGameOver()) {
      if (!input.hasNext()) {
        throw new IllegalStateException("No more inputs!");
      }
    }
  }
}




