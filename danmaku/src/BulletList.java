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

}
