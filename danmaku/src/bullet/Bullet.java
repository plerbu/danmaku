package bullet;

public abstract class Bullet {

	private int xPosition;
	private int yPosition;
	private int dingle;

	public Bullet(int xInitial, int yInitial) {
		this.xPosition = xInitial;
		this.yPosition = yInitial;
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

}