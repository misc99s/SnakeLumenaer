package snakeGame;

import graphics.Color;
import lumenaer.PixelMatrix;

/**slows the snake down*/

public class BlueBerryFruit extends Fruit {
    Color color;

    public BlueBerryFruit() {
        super();
        color = new Color(0, 213, 255);
    }

    @Override
    public void render(PixelMatrix matrix) {
        matrix.setPixel(y, x, color);
    }
}
