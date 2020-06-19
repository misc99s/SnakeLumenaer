package snakeGame;

import graphics.GraphicElement;
import graphics.Color;
import lumenaer.PixelMatrix;

public class Balken extends GraphicElement {
    private int posX;
    private int posY;
    private Color color;
    private static int fruitsEaten = 0;

    public Balken (int x, int y) {
        posX = x;
        posY = y;
        color = new Color(0,0,0);
    }

    public Color getColor() { return color; }
    public void setColor(Color c) { this.color = c; }
    public static int getFruitsEaten() { return fruitsEaten; }
    public static void setFruitsEaten() { fruitsEaten++; }

    public void render (PixelMatrix matrix) {
        matrix.setPixel(posY, posX, color);
    }

    public void update (PixelMatrix matrix) {
        matrix.setPixel(posY, posX, color);
    }
}
