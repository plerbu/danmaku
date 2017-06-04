import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class LinearBullet extends Bullet {

    private double slope;
    private double deltaX;
    private double deltaY;

    public LinearBullet(double xInitial, double yInitial, double slope) {
        super(xInitial, yInitial);

        this.slope = slope;
    }

    public LinearBullet(double xInitial, double yInitial, double xFinal, double yFinal) {
        super(xInitial, yInitial);
        this.slope = (xFinal - xInitial) / (yFinal - yInitial);
    }

    public void bulletMove() {
        super.setXPosition((super.getXPosition() + slope));
        super.setYPosition(super.getYPosition() + 1);
    }


}
