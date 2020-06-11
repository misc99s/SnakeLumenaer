package snakeGame;

import graphics.Color;
import graphics.GraphicElement;

abstract class Fruit extends GraphicElement {
    protected int x;
    protected int y;
    protected Color color;

    public Fruit(){
      this.x = (int)Math.random() * 24;
      this.y = (int)Math.random() * 24;
    }
}
