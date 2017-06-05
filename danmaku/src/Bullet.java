import java.awt.*;
import javax.swing.ImageIcon;

public abstract class Bullet {

	private double xPosition;
	private double yPosition;
    private Image image;
    private int width, height;


	public Bullet(double xInitial, double yInitial) {
		this.xPosition = xInitial;
		this.yPosition = yInitial;
		ImageIcon bullet = new ImageIcon("bullet_one.png");
        image = bullet.getImage();
        width = image.getWidth(null);
        height = image.getHeight(null);
	}

	public void setXPosition(double x) {
		this.xPosition = x;
	}

	public void setYPosition(double y) {
		this.yPosition = y;
	}

	public int getXPosition() { return (int)(this.xPosition); }

	public double getXPositionDouble() {return this.xPosition;}

	public int getYPosition() { return (int)(this.yPosition);}

	public double getYPositionDouble() {return this.yPosition;}

	public String printPosition() {
	    return "(" + getXPosition() + ", " + getYPosition() + ")";
    }

    public abstract void bulletMove();

    public Image getImage() {return image;}

    public Rectangle getBounds() {
        return new Rectangle((int)xPosition, (int)yPosition, width, height);
    }
}