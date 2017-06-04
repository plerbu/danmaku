/**
 * Created by blerpu on 6/2/17.
 */
import java.awt.Image;
import javax.swing.ImageIcon;

public class Enemy {

    private double xPosition;
    private double yPosition;
    private double deltaX;
    private double deltaY;
    private Image image;
    private double speed;
    public static long minMillisBetweenRandomShots = 100;
    public long lastRandomShotTime;
    public static long minMillisBetweenShots = 400;
    public long lastShotTime;
    public static int difficulty = 5;


    public Enemy (double xInitial, double yInitial, double deltaX, double deltaY) {
        this.xPosition = xInitial;
        this.yPosition = yInitial;
        this.deltaX = deltaX;
        this.deltaY = deltaY;
        ImageIcon enemy = new ImageIcon("enemy_one.png");
        image = enemy.getImage();
    }

    public Image getImage() {
        return image;
    }

    public int getX() {
        return (int)Math.round(this.xPosition);
    }

    public int getY() {
        return (int)Math.round(this.yPosition);
    }

    public void shoot(int playerX, int playerY) {
        if (((playerX - this.xPosition) / (playerY - this.yPosition)) > 1 ||
                ((playerX - this.xPosition) / (playerY - this.yPosition)) < -1) {
            return;
        } else {
            EnemyBulletSpawner.BulletList.add(new LinearBullet(this.xPosition, this.yPosition, playerX, playerY));
        }
    }

    public boolean readyToShoot () {return System.currentTimeMillis() - this.lastShotTime > minMillisBetweenShots;}

    public void move() {
        this.xPosition += this.deltaX;
        this.yPosition += this.deltaY;
    }

}
