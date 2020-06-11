package snakeGame;

import graphics.Color;

/**makes snake faster*/

abstract class BananaFruit extends Fruit {
    Color color;
    public BananaFruit(){
        super();
        color = new Color(246, 255, 0);
    }
}
