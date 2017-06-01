/**
 * Created by blerpu on 6/1/17.
 */

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Player {

    private int deltaX;
    private int deltaY;
    private int positionX;
    private int positionY;
    private Image image;
    private Image dot;
    private boolean focused;

    public Player() {
        initPlayer();
    }

    private void initPlayer() {
        ImageIcon hitBox = new ImageIcon("")
        ImageIcon playerImage = new ImageIcon("player.png");
        image = playerImage.getImage();
        positionX = 200;
        positionY = 580;
    }
    public void move() {
        positionX += deltaX;
        positionY += deltaY;
    }

    public int getX() {
        return positionX;
    }

    public int getY() {
        return positionY;
    }

    public Image getImage() {
        return image;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SHIFT) {
            focused = true;
        }

        if (key == KeyEvent.VK_LEFT) {
            deltaX = -2;
        }

        if (key == KeyEvent.VK_RIGHT) {
            deltaX = 2;
        }

        if (key == KeyEvent.VK_UP) {
            deltaY = -2;
        }

        if (key == KeyEvent.VK_DOWN) {
            deltaY = 2;
        }

        if (key == KeyEvent.VK_LEFT && focused) {
            deltaX = -1;
        }


        if (key == KeyEvent.VK_RIGHT && focused) {
            deltaX = 1;
        }

        if (key == KeyEvent.VK_UP && focused) {
            deltaY = -1;
        }

        if (key == KeyEvent.VK_DOWN && focused) {
            deltaY = 1;
        }
    }

    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SHIFT) {
            focused = false;
        }

        if (key == KeyEvent.VK_LEFT) {
            deltaX = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            deltaX = 0;
        }

        if (key == KeyEvent.VK_UP) {
            deltaY = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            deltaY = 0;
        }
    }

}
