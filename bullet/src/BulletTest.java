/**
 * Created by blerpu on 5/26/17.
 */
import java.util.ArrayList;

public class BulletTest {

    public static void main(String[] args) {
        ArrayList<Bullet> BulletList = new ArrayList();
        LinearBullet a = new LinearBullet(0,0,2);
        BulletList.add(a);
        BulletList.get(0).bulletMove();
        BulletList.get(0).bulletMove();
        System.out.println(BulletList.get(0).printPosition());
    }
}
