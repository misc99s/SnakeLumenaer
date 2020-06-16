package snakeGame;

import graphics.Color;
import lumenaer.PixelMatrix;

public class AppleFruit extends Fruit {
    private Color color;
    public AppleFruit() {
        super();
        color = new Color(247, 67, 67);
    }

    @Override
    public void render(PixelMatrix matrix) {
        matrix.setPixel(y, x, color);
    }
}
