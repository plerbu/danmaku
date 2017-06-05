/**
 * Created by blerpu on 6/1/17.
 */

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.Rectangle;

public class Player {

    public static boolean shooting;
    private int deltaX;
    private int deltaY;
    public static double positionX;
    public static double positionY;
    private Image image;
    private Image hitbox;
    public static boolean focused;
    private int width, height;

    public Player() {
        initPlayer();
    }

    private void initPlayer() {
        ImageIcon hitBox = new ImageIcon("hitbox.png");
        ImageIcon playerImage = new ImageIcon("edward.png");
        image = playerImage.getImage();
        hitbox = hitBox.getImage();
        positionX = 200 - 16;
        positionY = 520;
        width = hitbox.getWidth(null);
        height = hitbox.getHeight(null);
    }
    public void move() {
        positionX += deltaX;
        positionY += deltaY;
    }

    public double getX() {
        return positionX;
    }

    public double getY() {
        return positionY;
    }

    public Image getImage() {
        return image;
    }

    public Image getHitboxImage() {return hitbox; }

    public boolean isFocused() {return focused;}

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SHIFT) {
            focused = true;
        }

        if (key == KeyEvent.VK_Z) {
            shooting = true;
        }

        if (key == KeyEvent.VK_LEFT) {
            deltaX = -3;
        }

        if (key == KeyEvent.VK_RIGHT) {
            deltaX = 3;
        }
        if (key == KeyEvent.VK_LEFT && focused) {
            deltaX = -1;
        }

        if (key == KeyEvent.VK_RIGHT && focused) {
            deltaX = 1;
        }

        if (key == KeyEvent.VK_UP) {
            deltaY = -3;
        }

        if (key == KeyEvent.VK_DOWN) {
            deltaY = 3;
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

        if (key == KeyEvent.VK_Z) {
            shooting = false;
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

        deltaY = 0;
        if (key == KeyEvent.VK_DOWN) {
        }
    }

    public Rectangle getBounds() {
        return new Rectangle((int)positionX, (int)positionY, width, height);
    }
}
