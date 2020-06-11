package lumenaer;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import display.HardwareMatrixCommunicator;
import display.PixelMatrixPanel;

import astroidsGame.MiniAstroidsGame;
import snakeGame.MiniSnakeGame;

/**
 * The lumenaer framework class for setting up games and displaying them either on
 * a real 24x24 pixel matrix or in a window for development pruposes.
 */
public class Lumenaer {

    /* flag that determines whether the output shoud be on the real HW-Matrix*/
    private final boolean SENDTOMATRIX;

    /* constants encoding the physical dimensions of the HW-screen*/
    private LumenaerConstants lumenaerConstants;

    /* variables for display on a computer screen*/
    private JFrame frame;
    private JPanel drawPanel;

    /* serial communcation with the HW-Matrix*/
    private HardwareMatrixCommunicator hwCommunicator;

    /* */
    private PixelMatrix pixelMatrix;

    private Game currentGame;

    public Lumenaer(boolean hwMatrixMode) {
        SENDTOMATRIX = hwMatrixMode;
        lumenaerConstants = new LumenaerConstants();
    }

    /**
     * Run loop: runs forever, unless interrupted. Triggers the next game step
     * and displays the current pixelMatrix (depending on the operation mode)
     *
     * @throws InterruptedException
     */
    void runForever() throws InterruptedException {

        while (true) {
            Thread.sleep(100); //TODO: Framerate aus Constants
            currentGame.nextGameStep();
            displayPixelMatrix();
        }
    }


    public void setup() {

        frame = new JFrame("Lumenaer " + LumenaerConstants.VERSIONNUMBER);

        pixelMatrix = new PixelMatrix(lumenaerConstants.REALSCREENHEIGHT, lumenaerConstants.REALSCREENWIDTH);

        // register listeners, so that the current Game can be informed about changes
        MouseAdapter mouseListener = new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                currentGame.buzzered();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                currentGame.buzzerReleased();
            }

        };
        frame.addMouseListener(mouseListener);

        MouseWheelListener wheelListener = new MouseWheelListener() {

            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                currentGame.wheelRotation(e.getWheelRotation());
            }

        };
        frame.addMouseWheelListener(wheelListener);


        // falls das Spiel auf dem normalen Bildschrim angezeigt werden soll
        if (SENDTOMATRIX) {

            //setUp hardware displayPixelMatrix
            hwCommunicator = new HardwareMatrixCommunicator(lumenaerConstants);

            // make empty frame, positon mouse on it, so that mouse events get captured
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

            // the mouse pointer must be over the window so that mouse events are recognized...
            try {
                Robot initialMousePositioner = new Robot();
                initialMousePositioner.mouseMove(200, 200);
            } catch (Exception e) {
                System.out.println("Mouse could not be positioned...");
            }

        } else {
            // create a swing panel and displayPixelMatrix the matrix on the computer screen
            int scaleFactor = 30;
            drawPanel = new PixelMatrixPanel(pixelMatrix, scaleFactor);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(drawPanel);
            frame.pack();
        }

        //bring the panel to front
        frame.setVisible(true);
        frame.toFront();

        // later on: logic to change the current game
        currentGame = new MiniSnakeGame(pixelMatrix);

        prepareExitHandler();
    }


    /**
     * Draws the actual frame or sends it to the hardware matrix, depending on the mode
     */
    public void displayPixelMatrix() {

        // Aufrufen der Send Methode und Übergabe des aktuellen Bildes
        if (SENDTOMATRIX) {
            hwCommunicator.translateToSingleScreen(pixelMatrix.getPixels());
        } else {
            drawPanel.repaint();
        }
    }


    /**
     * Shuts down the screen if window is closed
     */
    private void prepareExitHandler() {
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                if (SENDTOMATRIX) {
                    hwCommunicator.shutDown();
                }
            }
        }));
    }


}
