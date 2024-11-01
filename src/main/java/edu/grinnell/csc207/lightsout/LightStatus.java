package edu.grinnell.csc207.lightsout;

/**
 * This enum represents the two states in which a light can be.
 * 
 * @author David William Stroud
 * @author Luis Lopez
 */
public enum LightStatus {
  /**
   * This state means the light is on.
   */
  ON,
  /**
   * This state means the light is off.
   */
  OFF;

  /**
   * This function turns this status into a boolean.
   * LightStatus.ON is true, LightStatus.OFF is false.
   * @return The boolean version of this status.
   */
  public boolean toBoolean() {
    return this == LightStatus.ON;
  } // toBoolean()

  /**
   * This function turns a boolean into a LightStatus.
   * True is LightStatus.ON, false is LightStatus.OFF.
   * @param value
   *   The boolean one wants to turn into a LightStatus.
   * @return The LightStatus associated with that boolean.
   */
  public static LightStatus fromBoolean(boolean value) {
    return value ? LightStatus.ON : LightStatus.OFF;
  } // fromBoolean(boolean)

  /**
   * Toggles this LightStatus.
   * @return The toggled version of this LightStatus.
   */
  public LightStatus toggle() {
    return (this == LightStatus.ON) ? LightStatus.OFF : LightStatus.ON;
  } // toggle()
} // enum LightStatus
