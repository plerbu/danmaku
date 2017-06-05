/**
 * Created by blerpu on 6/2/17.
 */
import java.util.ArrayList;
import java.util.TimerTask;
import java.util.Timer;

// public class EnemyBulletSpawner extends TimerTask{

public class EnemyBulletSpawner {

    public static ArrayList<Bullet> BulletList;

    public EnemyBulletSpawner() {
        BulletList = new ArrayList<Bullet>();

        // Bullet Testing
        // BulletList.add(new LinearBullet(0, 0, 200, 300));
    }

    public void addBullet(double xRange, double yRange, double slopeRange) {
            double xPosition = (int)(Math.random() * xRange);
            double yPosition = (int)(Math.random() * yRange);
            double slope = (int)(Math.random() * slopeRange);
            BulletList.add(new LinearBullet(xPosition, yPosition, slope));
    }

}
