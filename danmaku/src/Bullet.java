import java.awt.Image;
import javax.swing.ImageIcon;

public abstract class Bullet {

	private double xPosition;
	private double yPosition;
	private Image image;

	public Bullet(double xInitial, double yInitial) {
		this.xPosition = xInitial;
		this.yPosition = yInitial;
        ImageIcon bullet = new ImageIcon("bullet_one.png");
        image = bullet.getImage();
	}

	public void setXPosition(double x) {
		this.xPosition = x;
	}

	public void setYPosition(double y) {
		this.yPosition = y;
	}

	public int getXPosition() { return (int)Math.round(this.xPosition); }

	public int getYPosition() { return (int)Math.round(this.yPosition);}

	public String printPosition() {
	    return "(" + getXPosition() + ", " + getYPosition() + ")";
    }

    public abstract void bulletMove();

    public Image getImage() {return image;}

}