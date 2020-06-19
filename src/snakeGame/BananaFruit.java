package snakeGame;

import graphics.Color;
import graphics.GraphicElement;
import lumenaer.PixelMatrix;

/**makes snake faster*/

public class BananaFruit extends Fruit {

    public BananaFruit() {
        super();
        color = new Color(246, 255, 0);
        //color = color.YELLOW;
    }

    public BananaFruit(int x, int y) {
        super(x, y);
        color = new Color(246, 255, 0);
        //color = color.YELLOW;
    }

    @Override
    public void render(PixelMatrix matrix) {
        matrix.setPixel(y, x, color);
    }

}


