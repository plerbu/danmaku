import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.Rectangle;

public class LinearBullet extends Bullet {

    private double slope;
    private double deltaX;
    private double deltaY;
    private int width, height;
    private Image image;

    public LinearBullet(double xInitial, double yInitial, double slope) {
        super(xInitial, yInitial);

        this.slope = slope;



    }

    public LinearBullet(double xInitial, double yInitial, double xFinal, double yFinal) {
        super(xInitial, yInitial);
        double toSlope = (double)((int)xFinal - (int)xInitial) / ((int)yFinal - (int)yInitial);
        this.slope = toSlope;
    }

    public void bulletMove() {
        super.setXPosition((super.getXPositionDouble() + slope));
        super.setYPosition(super.getYPositionDouble() + 1);
    }

    public int getXPosition() { return (int)(super.getXPositionDouble()); }

    public int getYPosition() { return (int)(super.getYPositionDouble());}

}
