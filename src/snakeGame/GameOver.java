package snakeGame;

import graphics.Color;
import graphics.SpriteGraphicElement;
import lumenaer.PixelMatrix;
import lumenaer.Game;


import static graphics.Color.BLACK;
import static graphics.Color.WHITE;

public class GameOver extends SpriteGraphicElement {
    /* The actual storage of the color pixels*/
    private Color[][] pixelArray;

    /* The background color for the pixel matrix*/
    private Color backgroundColor;
    public GameOver(int posX, int posY) {
        super(posX,posY);
        PixelMatrix.setBackgroundColor(BLACK);
        sprite[0][0] = Color.TRANSPARENT;
        Color bodyColor = WHITE;

        //G:
        sprite[0][3] = bodyColor;
        sprite[0][2] = bodyColor;
        sprite[0][1] = bodyColor;
        sprite[0][0] = bodyColor;
        sprite[0][1] = bodyColor;
        sprite[0][2] = bodyColor;
        sprite[0][3] = bodyColor;
        sprite[0][4] = bodyColor;
        sprite[1][4] = bodyColor;
        sprite[2][4] = bodyColor;
        sprite[3][4] = bodyColor;
        sprite[3][3] = bodyColor;
        sprite[3][2] = bodyColor;
        sprite[2][2] = bodyColor;

        //A:
        sprite[5][0] = bodyColor;
        sprite[6][0] = bodyColor;
        sprite[7][0] = bodyColor;
        sprite[8][0] = bodyColor;
        sprite[5][1] = bodyColor;
        sprite[5][2] = bodyColor;
        sprite[5][3] = bodyColor;
        sprite[5][4] = bodyColor;
        sprite[8][1] = bodyColor;
        sprite[8][2] = bodyColor;
        sprite[8][3] = bodyColor;
        sprite[8][4] = bodyColor;
        sprite[6][2] = bodyColor;
        sprite[7][2] = bodyColor;
        // M:
        sprite[10][0] = bodyColor;
        sprite[10][1] = bodyColor;
        sprite[10][2] = bodyColor;
        sprite[10][3] = bodyColor;
        sprite[10][4] = bodyColor;
        sprite[11][0] = bodyColor;
        sprite[12][0] = bodyColor;
        sprite[12][1] = bodyColor;
        sprite[12][2] = bodyColor;
        sprite[13][0] = bodyColor;
        sprite[14][0] = bodyColor;
        sprite[14][1] = bodyColor;
        sprite[14][2] = bodyColor;
        sprite[14][3] = bodyColor;
        sprite[14][4] = bodyColor;

// E:
        sprite[16][0] = bodyColor;
        sprite[16][1] = bodyColor;
        sprite[16][2] = bodyColor;
        sprite[16][3] = bodyColor;
        sprite[16][4] = bodyColor;
        sprite[17][0] = bodyColor;
        sprite[17][2] = bodyColor;
        sprite[17][4] = bodyColor;
        sprite[18][0] = bodyColor;
        sprite[18][2] = bodyColor;
        sprite[18][4] = bodyColor;

        // O:
        sprite[2][6] = bodyColor;
        sprite[2][7] = bodyColor;
        sprite[2][8] = bodyColor;
        sprite[2][9] = bodyColor;
        sprite[2][10] = bodyColor;
        sprite[3][6] = bodyColor;
        sprite[3][10] = bodyColor;
        sprite[4][6] = bodyColor;
        sprite[4][7] = bodyColor;
        sprite[4][8] = bodyColor;
        sprite[4][9] = bodyColor;
        sprite[4][10] = bodyColor;

// V:
        sprite[6][6] = bodyColor;
        sprite[6][7] = bodyColor;
        sprite[6][8] = bodyColor;
        sprite[6][9] = bodyColor;
        sprite[6][10] = bodyColor;
        sprite[7][9] = bodyColor;
        sprite[8][8] = bodyColor;
        sprite[9][7] = bodyColor;
        sprite[10][6] = bodyColor;

// E:
        sprite[12][6] = bodyColor;
        sprite[12][7] = bodyColor;
        sprite[12][8] = bodyColor;
        sprite[12][9] = bodyColor;
        sprite[12][10] = bodyColor;

        sprite[13][6] = bodyColor;
        sprite[13][8] = bodyColor;
        sprite[13][10] = bodyColor;
        sprite[14][6] = bodyColor;
        sprite[14][8] = bodyColor;
        sprite[14][10] = bodyColor;

// R:
        sprite[16][6] = bodyColor;
        sprite[16][7] = bodyColor;
        sprite[16][8] = bodyColor;
        sprite[16][9] = bodyColor;
        sprite[16][10] = bodyColor;
        sprite[17][6] = bodyColor;
        sprite[17][8] = bodyColor;
        sprite[18][6] = bodyColor;
        sprite[18][7] = bodyColor;
        sprite[18][8] = bodyColor;
        sprite[18][9] = bodyColor;
        sprite[19][10] = bodyColor;

    }

}
