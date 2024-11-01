package edu.grinnell.csc207.lightsout;

/**
 * This class represents an invalid command-line argument.
 *
 * @author David William Stroud
 * @author Luis Lopez
 */
public class InvalidArgumentException extends Exception {
  /**
   * Creates an InvalidArgumentException with no specific message.
   */
  public InvalidArgumentException() {
    super();
  } // InvalidArgumentException()

  /**
   * Creates an InvalidArgumentException with the given message.
   * @param message The message to use.
   */
  public InvalidArgumentException(String message) {
    super(message);
  } // InvalidArgumentException(String)
} // class InvalidArgumentException
