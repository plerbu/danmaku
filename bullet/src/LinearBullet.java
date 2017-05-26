public class LinearBullet extends Bullet {

    private int slope;

    public LinearBullet(int xInitial, int yInitial, int slope) {
        super(xInitial, yInitial);
        this.slope = slope;
    }

    public void bulletMove() {
        super.setXPosition(super.getXPosition() - 1);
        super.setYPosition(super.getYPosition() - slope);
    }
}
