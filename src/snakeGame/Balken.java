package snakeGame;

import graphics.GraphicElement;
import graphics.Color;
import lumenaer.PixelMatrix;

public class Balken extends GraphicElement {
    private static int fruitsEaten = 0;

    public Balken (int x, int y) {
        this.x = x;
        this.y = y;
        color = new Color(0,0,0);
    }

    public Color getColor() { return color; }
    public void setColor(Color c) { this.color = c; }
    public static int getFruitsEaten() { return fruitsEaten; }
    public static void setFruitsEaten() { fruitsEaten = (fruitsEaten+1)%6; }
    public static void resetFruitsEaten() { fruitsEaten = 0; }

    public void render (PixelMatrix matrix) {
        matrix.setPixel(y, x, color);
    }

    public void update (PixelMatrix matrix) {
        matrix.setPixel(y, x, color);
    }
}
