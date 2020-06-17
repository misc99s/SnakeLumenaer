package snakeGame;

import graphics.Color;
import lumenaer.PixelMatrix;

/**makes snake faster*/

public class BananaFruit extends Fruit {

    public BananaFruit() {
        super();
        color = new Color(246, 255, 0);
    }

    public BananaFruit(int x, int y) {
        super(x, y);
        color = new Color(246, 255, 0);
    }

    @Override
    public void render(PixelMatrix matrix) {
        matrix.setPixel(y, x, color);
    }

}


