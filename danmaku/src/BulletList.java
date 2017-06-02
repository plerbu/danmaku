/**
 * Created by blerpu on 6/2/17.
 */
import java.util.ArrayList;

public class BulletList {

    public static ArrayList<Bullet> BulletList;

    public BulletList() {
        BulletList = new ArrayList<Bullet>();
        BulletList.add(new LinearBullet(0,0,2));
        BulletList.add(new LinearBullet(2, 4,1));
    }

    public void fill(int xRange, int yRange, int slopeRange) {
            int xPosition = (int)(Math.random() * xRange);
            int yPosition = (int)(Math.random() * yRange);
            int slope = (int)(Math.random() * slopeRange);
            BulletList.add(new LinearBullet(xPosition, yPosition, slope));
    }

}
