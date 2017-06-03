/**
 * Created by blerpu on 6/3/17.
 */

import java.util.ArrayList;

public class PlayerBulletList {

    public static ArrayList<Bullet> BulletList;

    public PlayerBulletList() {
        BulletList = new ArrayList<Bullet>();
    }

    public void shootBullet(Player p) {
        BulletList.add(new PlayerBullet(p.getX(), p.getY()));
    }
}
