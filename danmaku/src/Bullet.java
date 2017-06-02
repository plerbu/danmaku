import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public abstract class Bullet {

	private int xPosition;
	private int yPosition;
	private Image image;

	public Bullet(int xInitial, int yInitial) {
		this.xPosition = xInitial;
		this.yPosition = yInitial;
        ImageIcon bullet = new ImageIcon("bullet_one.png");
        image = bullet.getImage();
	}

	public void setXPosition(int x) {
		this.xPosition = x;
	}

	public void setYPosition(int y) {
		this.yPosition = y;
	}

	public int getXPosition() {
		return this.xPosition;
	}

	public int getYPosition() {
		return this.yPosition;
	}

	public String printPosition() {
	    return "(" + getXPosition() + ", " + getYPosition() + ")";
    }

    public abstract void bulletMove();

    public Image getImage() {return image;}

}