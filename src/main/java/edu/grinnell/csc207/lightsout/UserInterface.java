package edu.grinnell.csc207.lightsout;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Random;

import edu.grinnell.csc207.util.IOUtils;

/**
 * This class represents the main user interface of the game.
 *
 * @author David William Stroud
 * @author Luis Lopez
 */
public class UserInterface {
  /**
   * The entry point of this program.
   * @param args The command-line arguments.
   */
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);

    CommandLineArgumentParser clap = new CommandLineArgumentParser(
        5,
        5,
        new Random().nextInt()
    );

    try {
      clap.parse(args);
    } catch (Exception err) {
      pen.printf("Error: %s. Aborting.\n", err.getMessage());
      return;
    } // try-catch

    PlayerBoard board = new PlayerBoard(clap.getWidth(), clap.getHeight());
    board.shuffle(new Random(clap.getSeed()));

    pen.printf(
        "Board width: %d\nBoard height: %d\nSeed: %d\n\n",
        board.getWidth(),
        board.getHeight(),
        clap.getSeed()
    );

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int numMoves = 0;
    while (!board.isSolved()) {
      UserInterface.printBoard(board, pen);

      int row = 0;
      boolean isError = false;
      do {
        isError = false;
        try {
          row = IOUtils.readInt(pen, br, "Select row to toggle: ");
          if (row < 1 || row > board.getHeight()) {
            isError = true;
            pen.println("The row is not within the bounds of the board. Please try again.");
          } // if
        } catch (IOException err) {
          pen.println("An I/O exception occurred. Please try again.");
          isError = true;
        } // try-catch
      } while (isError);

      int col = 0;
      do {
        isError = false;
        try {
          col = IOUtils.readInt(pen, br, "Select column to toggle: ");
          if (col < 1 || col > board.getWidth()) {
            isError = true;
            pen.println("The column is not within the bounds of the board. Please try again.");
          } // if
        } catch (IOException err) {
          pen.println("An I/O exception occurred. Please try again.");
          isError = true;
        } // try-catch
      } while (isError);

      board.toggleArea(row - 1, col - 1);

      numMoves++;
    } // while

    pen.printf(
        "Congratulations!\nYou won!\nThe number of moves you used is: %d.\n",
        numMoves
    );
  } // main(String[])

  /**
   * Prints out a visual representation of the board.
   * @param board The board to print out.
   * @param pen The PrintWriter to use to print out the board.
   */
  public static void printBoard(Board board, PrintWriter pen) {
    pen.println("Current board state:");
    for (int row = 0; row < board.getHeight(); row++) {
      for (int col = 0; col < board.getWidth(); col++) {
        LightStatus status = board.getAt(row, col);
        if (status == LightStatus.ON) {
          pen.print("O");
        } else {
          pen.print(".");
        } // if-else
      } // for
      pen.print("\n");
    } // for
    pen.flush();
  } // printBoard(Board, PrintWriter)
} // class UserInterface
