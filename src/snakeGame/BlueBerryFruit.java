package snakeGame;

import graphics.Color;
import lumenaer.PixelMatrix;

/**Special Fruit, is blue, makes the snake slower if Bar is full, mainly blue fruits were eaten and mouse Button is pressed*/

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
