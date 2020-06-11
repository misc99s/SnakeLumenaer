package snakeGame;

import graphics.Color;

abstract class AppleFruit extends Fruit {
   Color color;
    public AppleFruit(){
        super();
        color = new Color(247, 67, 67);
    }
}
