package snakeGame;

import graphics.Color;
import lumenaer.PixelMatrix;

/**makes snake faster*/

public class BananaFruit extends Fruit {
    Color color;
    public BananaFruit() {
        super();
        color = new Color(246, 255, 0);
    }

    @Override
    public void render(PixelMatrix matrix) {
        matrix.setPixel(y, x, color);
    }
}
