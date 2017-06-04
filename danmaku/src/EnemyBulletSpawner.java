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

    public void addBullet(int xRange, int yRange, int slopeRange) {
            int xPosition = (int)(Math.random() * xRange);
            int yPosition = (int)(Math.random() * yRange);
            int slope = (int)(Math.random() * slopeRange);
            BulletList.add(new LinearBullet(xPosition, yPosition, slope));
    }

}
