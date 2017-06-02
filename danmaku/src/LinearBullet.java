import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class LinearBullet extends Bullet {

    private double slope;

    public LinearBullet(int xInitial, int yInitial, double slope) {
        super(xInitial, yInitial);

        this.slope = slope;
    }

    public LinearBullet(int xInitial, int yInitial, int xFinal, int yFinal) {
        super(xInitial, yInitial);
        this.slope = (yFinal - yInitial) / (xFinal - xInitial);
    }

    public void bulletMove() {
        super.setXPosition((int)(super.getXPosition() + slope));
        super.setYPosition(super.getYPosition() + 1);
    }


}
