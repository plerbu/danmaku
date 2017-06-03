/**
 * Created by blerpu on 6/3/17.
 */

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class PlayerBullet extends LinearBullet {

    private Image image;

    public PlayerBullet(int xInitial, int yInitial) {
        super(xInitial, yInitial, -1);
        ImageIcon bullet = new ImageIcon("bullet_player.png");
        image = bullet.getImage();

    }

    public void bulletMove() {
        super.setYPosition(super.getYPosition() - 3);
    }

    public Image getImage() {return image;}
}
