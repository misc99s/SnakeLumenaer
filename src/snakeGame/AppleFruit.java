package snakeGame;

import graphics.Color;
import lumenaer.PixelMatrix;

/**"Normal" Fruit, is red, doesn't do anything but can be eaten*/
public class AppleFruit extends Fruit {

    public AppleFruit() {
        super();
        color = new Color(247, 67, 67);
        //color = Color.RED;
    }

    public AppleFruit(int x, int y) {
        super(x, y);
        color = new Color(247, 67, 67);
        //color = Color.RED;
    }

    @Override
    public void render(PixelMatrix matrix) {
        matrix.setPixel(y, x, color);
    }
}
