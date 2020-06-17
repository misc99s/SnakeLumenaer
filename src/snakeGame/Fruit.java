package snakeGame;

import graphics.Color;
import graphics.GraphicElement;
import graphics.RectangleGraphicElement;

import java.awt.*;

abstract class Fruit extends GraphicElement {
    protected int x;
    protected int y;
    protected Color color;

    public Fruit() {
        super();
        this.x = (int)Math.round(Math.random() * 23);
        this.y = (int)Math.round(Math.random() * 22);
        System.out.println();
    }

    public Fruit(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }
}
