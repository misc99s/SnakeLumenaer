package snakeGame;

import graphics.Color;
import graphics.SpriteGraphicElement;
import lumenaer.PixelMatrix;
import lumenaer.Game;


import static graphics.Color.BLACK;
import static graphics.Color.WHITE;

/**The Game Over Screen, appears when you hit a wall*/

public class GameOver extends SpriteGraphicElement {
    /* The actual storage of the color pixels*/
    private Color[][] pixelArray;

    /* The background color for the pixel matrix*/
    private Color backgroundColor;
    private static Color bodyColor;

    public GameOver(int posX, int posY) {
        super(posX, posY);
        //sprite[0][0] = Color.TRANSPARENT;
        sprite = new Color[11][20];
        Color bodyColor = WHITE;

        for(int i=0; i<11; i++) {
            for(int j=0; j<20; j++) {
                sprite[i][j] = Color.TRANSPARENT;
            }
        }

        //G:
        sprite[3][0] = bodyColor;
        sprite[2][0] = bodyColor;
        sprite[1][0] = bodyColor;
        sprite[0][0] = bodyColor;
        sprite[4][0] = bodyColor;
        sprite[4][1] = bodyColor;
        sprite[4][2] = bodyColor;
        sprite[4][3] = bodyColor;
        sprite[3][3] = bodyColor;
        sprite[2][3] = bodyColor;
        sprite[2][2] = bodyColor;
        sprite[0][1] = bodyColor;
        sprite[0][2] = bodyColor;
        sprite[0][3] = bodyColor;

        //A:
        sprite[0][5] = bodyColor;
        sprite[0][6] = bodyColor;
        sprite[0][7] = bodyColor;
        sprite[0][8] = bodyColor;
        sprite[1][5] = bodyColor;
        sprite[2][5] = bodyColor;
        sprite[3][5] = bodyColor;
        sprite[4][5] = bodyColor;
        sprite[1][8] = bodyColor;
        sprite[2][8] = bodyColor;
        sprite[3][8] = bodyColor;
        sprite[4][8] = bodyColor;
        sprite[2][6] = bodyColor;
        sprite[2][7] = bodyColor;

        // M:
        sprite[0][10] = bodyColor;
        sprite[1][10] = bodyColor;
        sprite[2][10] = bodyColor;
        sprite[3][10] = bodyColor;
        sprite[4][10] = bodyColor;
        sprite[0][11] = bodyColor;
        sprite[0][12] = bodyColor;
        sprite[1][12] = bodyColor;
        sprite[2][12] = bodyColor;
        sprite[0][13] = bodyColor;
        sprite[0][14] = bodyColor;
        sprite[1][14] = bodyColor;
        sprite[2][14] = bodyColor;
        sprite[3][14] = bodyColor;
        sprite[4][14] = bodyColor;

// E:
        sprite[0][16] = bodyColor;
        sprite[1][16] = bodyColor;
        sprite[2][16] = bodyColor;
        sprite[3][16] = bodyColor;
        sprite[4][16] = bodyColor;
        sprite[0][17] = bodyColor;
        sprite[2][17] = bodyColor;
        sprite[4][17] = bodyColor;
        sprite[0][18] = bodyColor;
        sprite[2][18] = bodyColor;
        sprite[4][18] = bodyColor;

        // O:
        sprite[6][2] = bodyColor;
        sprite[7][2] = bodyColor;
        sprite[8][2] = bodyColor;
        sprite[9][2] = bodyColor;
        sprite[10][2] = bodyColor;
        sprite[6][3] = bodyColor;
        sprite[10][3] = bodyColor;
        sprite[6][4] = bodyColor;
        sprite[7][4] = bodyColor;
        sprite[8][4] = bodyColor;
        sprite[9][4] = bodyColor;
        sprite[10][4] = bodyColor;

// V:
        sprite[6][6] = bodyColor;
        sprite[7][6] = bodyColor;
        sprite[8][6] = bodyColor;
        sprite[9][6] = bodyColor;
        sprite[10][6] = bodyColor;
        sprite[9][7] = bodyColor;
        sprite[8][8] = bodyColor;
        sprite[7][9] = bodyColor;
        sprite[6][10] = bodyColor;

// E:
        sprite[6][12] = bodyColor;
        sprite[7][12] = bodyColor;
        sprite[8][12] = bodyColor;
        sprite[9][12] = bodyColor;
        sprite[10][12] = bodyColor;
        sprite[6][13] = bodyColor;
        sprite[8][13] = bodyColor;
        sprite[10][13] = bodyColor;
        sprite[6][14] = bodyColor;
        sprite[8][14] = bodyColor;
        sprite[10][14] = bodyColor;

// R:
        sprite[6][16] = bodyColor;
        sprite[7][16] = bodyColor;
        sprite[8][16] = bodyColor;
        sprite[9][16] = bodyColor;
        sprite[10][16] = bodyColor;
        sprite[6][17] = bodyColor;
        sprite[8][17] = bodyColor;
        sprite[6][18] = bodyColor;
        sprite[7][18] = bodyColor;
        //sprite[8][18] = bodyColor;
        sprite[9][18] = bodyColor;
        sprite[10][18] = bodyColor;

    }

}
