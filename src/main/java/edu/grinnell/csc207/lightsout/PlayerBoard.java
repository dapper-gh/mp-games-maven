package edu.grinnell.csc207.lightsout;

import java.util.Random;

/**
 * This represents the operations on the board useful to the player.
 *
 * @author David William Stroud
 * @author Luis Lopez
 */
public class PlayerBoard extends Board {
  /**
   * Creates a board of width, height.
   * @param width The width of the board.
   * @param height The height of the board.
   */
  public PlayerBoard(int width, int height) {
    super(width, height);
  } // PlayerBoard(int, int)

  /**
   * Toggles a light and its four adjacent lights.
   * @param row The row at the center of the region.
   * @param col The column at the center of the region.
   */
  public void toggleArea(int row, int col) {
    int[][] candidates = new int[][] {
      new int[] {row, col},
      new int[] {row + 1, col},
      new int[] {row - 1, col},
      new int[] {row, col + 1},
      new int[] {row, col - 1} // int[]
    }; // int[][] candidates

    for (int[] coords : candidates) {
      if (coords[1] >= this.getWidth() || coords[1] < 0) {
        continue;
      } // if

      if (coords[0] >= this.getHeight() || coords[0] < 0) {
        continue;
      } // if

      this.toggleAt(coords[0], coords[1]);
    } // for
  } // toggleArea(int, int)

  /**
   * Checks whether this board is solved
   * (i.e. all the lights are off).
   * @return Whether the board is solved.
   */
  public boolean isSolved() {
    for (int i = 0; i < this.getWidth(); i++) {
      for (int j = 0; j < this.getHeight(); j++) {
        if (this.getAt(j, i) == LightStatus.ON) {
          return false;
        } // if
      } // for
    } // for

    return true;
  } // isSolved()

  /**
   * Shuffles the board according to the randomness from rng.
   * @param rng The random number generator to use.
   */
  public void shuffle(Random rng) {
    int numMoves = rng.nextInt(0, 10000);
    for (int i = 0; i < numMoves; i++) {
      int row = rng.nextInt(0, this.getHeight());
      int col = rng.nextInt(0, this.getWidth());

      this.toggleArea(row, col);
    } // for
  } // shuffle()
} // class PlayerBoard
