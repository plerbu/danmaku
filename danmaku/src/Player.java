/**
 * Created by blerpu on 6/1/17.
 */

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Player {

    public static boolean shooting;
    private int deltaX;
    private int deltaY;
    public static int positionX;
    public static int positionY;
    private Image image;
    private Image hitbox;
    public static boolean focused;

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

        if ((this.positionX >= 0) && (this.positionX <= 400)) {
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
        } else if (this.positionX < 0) {
            if (key == KeyEvent.VK_LEFT) {
                deltaX = 0;
            }

            if (key == KeyEvent.VK_RIGHT) {
                deltaX = 3;
            }
            if (key == KeyEvent.VK_LEFT && focused) {
                deltaX = 0;
            }

            if (key == KeyEvent.VK_RIGHT && focused) {
                deltaX = 1;
            }
        } else if (this.positionX > 400) {
            if (key == KeyEvent.VK_LEFT) {
                deltaX = -3;
            }

            if (key == KeyEvent.VK_RIGHT) {
                deltaX = 0;
            }
            if (key == KeyEvent.VK_LEFT && focused) {
                deltaX = -1;
            }

            if (key == KeyEvent.VK_RIGHT && focused) {
                deltaX = 0;
            }
        }

        if ((this.positionY >= 0) && (this.positionY <= 600)) {
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
        } else if (this.positionY < 0) {
            if (key == KeyEvent.VK_UP) {
                deltaY = 0;
            }

            if (key == KeyEvent.VK_DOWN) {
                deltaY = 3;
            }

            if (key == KeyEvent.VK_UP && focused) {
                deltaY = 0;
            }

            if (key == KeyEvent.VK_DOWN && focused) {
                deltaY = 1;
            }
        } else if (this.positionY > 600) {
            if (key == KeyEvent.VK_UP) {
                deltaY = -3;
            }

            if (key == KeyEvent.VK_DOWN) {
                deltaY = 0;
            }

            if (key == KeyEvent.VK_UP && focused) {
                deltaY = -1;
            }

            if (key == KeyEvent.VK_DOWN && focused) {
                deltaY = 0;
            }
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

        if (key == KeyEvent.VK_DOWN) {
            deltaY = 0;
        }
    }

}
