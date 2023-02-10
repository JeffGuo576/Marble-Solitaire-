package cs3500.marblesolitaire;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * Represents a Marble Solitaire game where you can run a specific solitaire game
 * from English, European, or Triangle.
 */
public final class MarbleSolitaire {

  /**
   * This is the main method which is what the program will call to run the game.
   * @param args are the arguments from the command line that determines which solitaire game to
   *             play.
   */
  public static void main(String[] args) {
    MarbleSolitaireModel game = null;
    MarbleSolitaireView gameView = null;
    String model = null;
    String size = null;
    String hole1 = null;
    String hole2 = null;
    int index = 0;
    while (index < args.length) {
      switch (args[index]) {
        case "english":
        case "european":
        case "triangular":
          model = args[index];
          index++;
          break;
        case "-size":
          size = args[index + 1];
          index++;
          break;
        case "-hole":
          hole1 = args[index + 1];
          hole2 = args[index + 2];
          index += 2;
          break;
        default:
          break;
      }
    }

    int s;
    int hole1Num;
    int hole2Num;
    if (model != null) {
      try {
        s = Integer.parseInt(size);
      } catch (NumberFormatException e) {
        s = -1;
      }
      try {
        hole1Num = Integer.parseInt(hole1);
        hole2Num = Integer.parseInt(hole2);
      } catch (NumberFormatException e) {
        hole1Num = -1;
        hole2Num = -1;
      }
      // default constructor
      if (size == null && hole1 == null && hole2 == null) {
        switch (model) {
          case "english":
            game = new EnglishSolitaireModel();
            gameView = new MarbleSolitaireTextView(game);
            break;
          case "european":
            game = new EuropeanSolitaireModel();
            gameView = new EuropeanSolitaireTextView(game);
            break;
          case "triangular":
            game = new TriangleSolitaireModel();
            gameView = new TriangleSolitaireTextView(game);
            break;
          default:
            break;
        }
      } // given all arm and empty position
      else if (size != null && hole1 != null && hole2 != null) {
        switch (model) {
          case "english":
            game = new EnglishSolitaireModel(s, hole1Num, hole2Num);
            gameView = new MarbleSolitaireTextView(game);
            break;
          case "european":
            game = new EuropeanSolitaireModel(s, hole1Num, hole2Num);
            gameView = new EuropeanSolitaireTextView(game);
            break;
          case "triangular":
            game = new TriangleSolitaireModel(s, hole1Num, hole2Num);
            gameView = new TriangleSolitaireTextView(game);
            break;
          default:
            break;
        } // second constructor given arm length
      }
      else if (size != null && hole1 == null && hole2 == null) {
        switch (model) {
          case "english":
            game = new EnglishSolitaireModel(s);
            gameView = new MarbleSolitaireTextView(game);
            break;
          case "european":
            game = new EuropeanSolitaireModel(s);
            gameView = new EuropeanSolitaireTextView(game);
            break;
          case "triangular":
            game = new TriangleSolitaireModel(s);
            gameView = new TriangleSolitaireTextView(game);
            break;
          default:
            break;
        } // given empty slot position
      }
      else if (size == null && hole1 != null && hole2 != null) {
        switch (model) {
          case "english":
            game = new EnglishSolitaireModel(hole1Num, hole2Num);
            gameView = new MarbleSolitaireTextView(game);
            break;
          case "european":
            game = new EuropeanSolitaireModel(hole1Num, hole2Num);
            gameView = new EuropeanSolitaireTextView(game);
            break;
          case "triangular":
            game = new TriangleSolitaireModel(hole1Num, hole2Num);
            gameView = new TriangleSolitaireTextView(game);
            break;
          default:
            break;
        }
      }
    }
    Reader in = new InputStreamReader(System.in);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(game, gameView, in);
    controller.playGame();
  }
}
