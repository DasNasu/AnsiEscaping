package dev.thatsnasu.ansi;

/**
 * Objects of Color will hold the rgb values, as well as providing methods for using and converting them.
 */
public class Color {
	private int red;
	private int green;
	private int blue;
	
	/**
	 * Creates a new Color Object and sets its color values.
	 * @param red value of this color
	 * @param green value of this color
	 * @param blue value of this color
	 */
	public Color(int red, int green, int blue) {
		this.red = red;
		this.green = green;
		this.blue = blue;
	}
	
	/**
	 * Creates a new Color Object and sets its color values
	 * @param hexcode of this color
	 */
	public Color(String hexcode) {
		if(hexcode.contains("#")) hexcode = hexcode.replace("#", "");
		long l = Long.parseLong(hexcode, 16);
		this.red = (int) (l/(256*256));
		this.green = (int) (l-(256*256*this.red))/256;
		this.blue = (int) l-(256*256*this.red)-(256*this.green);
	}
	
	/**
	 * Returns the String representation of the colorCode associated with this {@link Color} Object.
	 * @return colorCode as ANSI Escape Sequence String part.
	 */
	public String getColorCode() {
		return this.red+";"+this.green+";"+this.blue;
	}
	
	/**
	 * Returns the String representation of the colorCode associated with this {@link Color} Object as Hexadecimal value.
	 * @return colorCode as Hex.
	 */
	public String getHex() {
		return String.format("#%02x%02x%02x", this.red, this.green, this.blue);
	}
	
	/**
	 * Returns the red value of this color.
	 * @return red value
	 */
	public int getRed() {
		return this.red;
	}
	
	/**
	 * Returns the red value of this color as hexadecimal String.
	 * @return red value
	 */
	public String getRedAsHex() {
		return String.format("%02x", this.red);
	}
	
	/**
	 * Returns the green value of this color.
	 * @return green value
	 */
	public int getGreen() {
		return this.green;
	}
	
	/**
	 * Returns the green value of this color as hexadecimal String.
	 * @return red value
	 */
	public String getGreenAsHex() {
		return String.format("%02x", this.green);
	}
	
	/**
	 * Returns the blue value of this color.
	 * @return blue value
	 */
	public int getBlue() {
		return this.blue;
	}
	
	/**
	 * Returns the blue value of this color as hexadecimal String.
	 * @return red value
	 */
	public String getBlueAsHex() {
		return String.format("%02x", this.blue);
	}
	
	/**
	 * Returns the rgb values of this color as int[]. Index 0 will be red, 1 will be green and 2 will be blue.
	 * @return rbg values as int[]
	 */
	public int[] getRGB() {
		return new int[] {this.red, this.green, this.blue};
	}
	
	/**
	 * Returns the String representation of the ANSI Escape value associated with this {@link Color} Object.
	 * @return colorCode as full ANSI Escape Sequence String.
	 */
	@Override
	public String toString() {
		return "\u001b[38;2;"+this.getColorCode()+"m";
	}
}
