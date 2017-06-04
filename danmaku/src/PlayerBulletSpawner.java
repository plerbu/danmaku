/**
 * Created by blerpu on 6/3/17.
 */

import java.util.ArrayList;

public class PlayerBulletSpawner {

    public static ArrayList<Bullet> BulletList;

    public PlayerBulletSpawner() {
        BulletList = new ArrayList<Bullet>();
    }

    public void shootBullet(Player p) {
        if (!PlayerBullet.readyToShoot()) return;
        BulletList.add(new PlayerBullet(p.getX() + 12, p.getY()));
        PlayerBullet.lastShotTime = System.currentTimeMillis();
    }

    public void run() {

    }
}
