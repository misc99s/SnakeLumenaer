package snakeGame;

import graphics.Color;
import graphics.SpriteGraphicElement;

public class Snake extends SpriteGraphicElement {
    int maxX;
    int width = 1;
    int height = 3;

    public Snake(int posX, int posY) {
        super(posX, posY);
        speedX = 0;  //move right
        speedY = 1;  //move up, -speedY move down
        maxX = 21; //outermost right position
        sprite = new Color[width][height];

        Color bodyColor = new Color (74,43,27);
    }
}
