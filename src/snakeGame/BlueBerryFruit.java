package snakeGame;

import graphics.Color;
import lumenaer.PixelMatrix;

/**slows the snake down*/

public class BlueBerryFruit extends Fruit {

    public BlueBerryFruit() {
        super();
        color = new Color(0, 213, 255);
        //color = color.CYAN;
    }

    public BlueBerryFruit(int x, int y) {
        super(x, y);
        color = new Color(0, 213, 255);
        //color = color.CYAN;
    }

    @Override
    public void render(PixelMatrix matrix) {
        matrix.setPixel(y, x, color);
    }
}
