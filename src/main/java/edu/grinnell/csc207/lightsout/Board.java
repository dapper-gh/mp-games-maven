package edu.grinnell.csc207.lightsout;

import edu.grinnell.csc207.util.*;

/**
 * This class implements the basic operations of a board in Lights Out.
 * 
 * @author David William Stroud
 * @author Luis Lopez
 */
public class Board {
  /**
   * This is the underlying matrix representing the board.
   */
  private Matrix<LightStatus> matrix;

  /**
   * Creates a board of the specified width and height, with all lights turned out.
   * @param width The width of the board.
   * @param height The height of the board.
   */
  public Board(int width, int height) {
    matrix = new MatrixV0<LightStatus>(width, height, LightStatus.OFF);
  } // Board

  /**
   * This function returns whether the light at row, col is on.
   * @param row The row of the light.
   * @param col The column of the light.
   * @return Whether the light is on.
   */
  public LightStatus getAt(int row, int col) {
    return matrix.get(row, col);
  } // getAt(int, int)

  /**
   * This functions sets whether the light at row, col is on to value. 
   * @param row The row of the light.
   * @param col 
   * @param value
   */
  public void setAt(int row, int col, LightStatus value) {
    matrix.set(row, col, value);
  } // setAt(int, int, boolean)

  /**
   * This function toggles the light at row, col.
   * @param row The row of the light.
   * @param col The column of the light.
   */
  public void toggleAt(int row, int col) {
    this.setAt(row, col, this.getAt(row, col).toggle());
  } // toggleAt(int, int)

  /**
   * Returns the width of this board.
   * @return The width of this board.
   */
  public int getWidth() {
    return this.matrix.width();
  } // getWidth()

  /**
   * Returns the height of this board.
   * @return The height of ths board.
   */
  public int getHeight() {
    return this.matrix.height();
  } // getHeight()
} // class Board
