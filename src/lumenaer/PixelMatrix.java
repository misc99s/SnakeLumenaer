package lumenaer;

import graphics.Color;

/**
 * Class representing the pixelArray matrix. Can be displayed on various output media,
 * e.g. either a real HW pixelArray matrix, or in a software window on a computer screen.
 * This is completely abstracted from the output format.
 */
public class PixelMatrix {

	/* The actual storage of the color pixels*/
	private Color[][] pixelArray;

	/* The background color for the pixel matrix*/
	private static Color backgroundColor;


	public PixelMatrix(int height, int width) {
		this(width,height,Color.WHITE);
	}

	public PixelMatrix(int height, int width, Color backgroundColor) {
		pixelArray = new Color[height][width];
		this.backgroundColor = backgroundColor;
		drawBackground();
	}

	public int getHeight() {
		return pixelArray.length;
	}

	public int getWidth() {
		return pixelArray[0].length;
	}

	public Color getPixel(int y, int x) {
		return pixelArray[y][x];
	}

	/**
	 * Returns the the integer value representing the color at a given location in the matrix
	 * @param y y-position of the pixel
	 * @param x x-position of the pixel
	 * @return the integer value representing the color
	 */
	public int getIntValue(int y, int x) {
		return pixelArray[y][x].getIntValue();
	}

	public void setPixel(int y, int x, Color color) {
		// only set a pixelArray if possible and not transparent
		if (y >= 0 && y < pixelArray.length &&
				x >= 0 && x < pixelArray[0].length &&
				color != Color.TRANSPARENT) {
			pixelArray[y][x] = color;
		}
	}

	/**
	 * Sets the color values of all Pixels to the background color
	 */
	public void drawBackground() {
		for (int y=0; y < getHeight(); y++) {
			for (int x=0; x < getWidth(); x++) {
				setPixel(y, x, backgroundColor);
			}
		}		
	}

	/**
	 * Linearizes the 2D Pixel Matrix in a 1D integer array used for serial
	 * communication with the HW-Matrix. The individual pixels represent
	 * a color value each, the position in the 1D array codes the exact position
	 * in the HW matrix (can be decoded there).
	 *
	 * @return linearized pixel information
	 */
	int[] getPixels() {
		int[] linearPixels = new int[pixelArray[0].length * pixelArray.length];
		int idx = 0;
		for (int y=0; y<getHeight(); y++) {
			for (int x=0; x<getHeight(); x++) {
				linearPixels[idx] = pixelArray[y][x].getIntValue();
				idx++;
			}
		}
		return linearPixels;
	}

	public Color getBackgroundColor() {
		return backgroundColor;
	}

	public static void setBackgroundColor(Color bc) {
		backgroundColor = bc;
	}


}
