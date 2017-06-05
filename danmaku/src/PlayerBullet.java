/**
 * Created by blerpu on 6/3/17.
 */

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.Rectangle;

public class PlayerBullet extends LinearBullet {

    private Image image;
    public static long minMillisBetweenShots;
    public static long lastShotTime;
    private int width, height;

    public PlayerBullet(int xInitial, int yInitial) {
        super(xInitial, yInitial, -1);
        ImageIcon bullet = new ImageIcon("bullet_player.png");
        image = bullet.getImage();
        minMillisBetweenShots = 200;
        width = image.getWidth(null);
        height = image.getHeight(null);;
    }

    public void bulletMove() {
        super.setYPosition(super.getYPosition() - 3);
    }

    public static boolean readyToShoot () {return System.currentTimeMillis() - lastShotTime > minMillisBetweenShots;}

    public Image getImage() {return image;}

    public Rectangle getBounds() {
        return new Rectangle((int)this.getXPosition(), (int)this.getYPosition(), width, height);
    }
}
