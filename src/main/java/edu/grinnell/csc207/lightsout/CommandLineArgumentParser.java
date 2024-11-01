package edu.grinnell.csc207.lightsout;

/**
 * This class provides utility functions for parsing command line arguments.
 *
 * @author David William Stroud
 * @author Luis Lopez
 */
public class CommandLineArgumentParser {
  /**
   * The width requested by the user.
   */
  private int width;
  /**
   * The height requested by the user.
   */
  private int height;
  /**
   * The seed requested by the user.
   */
  private int seed;

  /**
   * This creates a parser for command line arguments, with the
   * specified default values.
   * @param width1 The default value for width.
   * @param height1 The default value for height.
   * @param seed1 The default value for the seed.
   */
  public CommandLineArgumentParser(int width1, int height1, int seed1) {
    this.width = width1;
    this.height = height1;
    this.seed = seed1;
  } // CommandLineArgumentParser(int, int, int)

  /**
   * Parses the command line arguments.
   * @param args The command-line arguments to parse.
   */
  public void parse(String[] args) throws NumberFormatException, InvalidArgumentException {
    for (int i = 0; i < args.length; i++) {
      if (args[i].equals("-w")) {
        this.width = Integer.parseInt(args[++i]);
        if (this.width < 1 || this.width > 50) {
          throw new InvalidArgumentException("-w not followed by an integer between 1 and 50");
        } // if
      } // if

      if (args[i].equals("-h")) {
        this.height = Integer.parseInt(args[++i]);
        if (this.height < 1 || this.height > 50) {
          throw new InvalidArgumentException("-h not followed by an integer between 1 and 50");
        } // if
      } // if

      if (args[i].equals("-s")) {
        this.seed = Integer.parseInt(args[++i]);
      } // if
    } // for
  } // parse(String[])

  /**
   * Returns the width given by the command-line.
   * @return The width given by the command-line.
   */
  public int getWidth() {
    return this.width;
  } // getWidth()

  /**
   * Returns the height given by the command-line.
   * @return The height given by the command-line.
   */
  public int getHeight() {
    return this.height;
  } // getHeight()

  /**
   * Returns the seed given by the command-line.
   * @return The seed given by the command-line.
   */
  public int getSeed() {
    return this.seed;
  } // getSeed()
} // class CommandLineArgumentParser
