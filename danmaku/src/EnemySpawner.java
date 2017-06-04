/**
 * Created by blerpu on 6/2/17.
 */
import java.util.ArrayList;

public class EnemySpawner {

    public static ArrayList<Enemy> EnemyList;

    public static long lastSpawnTime = 0;
    public static long minMillisBetweenSpawns = 2000;

    public EnemySpawner() {
        EnemyList = new ArrayList<Enemy>();
    }

    public void addEnemy(int xInitialRange, int yInitialRange, double deltaXRange, double deltaYRange) {
        int xInitial = (int)(Math.random() * xInitialRange);
        int yInitial = (int)(Math.random() * yInitialRange);
        double deltaX = (Math.random() * deltaXRange) - 1;
        double deltaY = (Math.random() * deltaYRange) ;
        EnemyList.add(new Enemy(xInitial, yInitial, deltaX, deltaY));
    }

    public void shootEnemyBullets(int playerX, int playerY) {
        for (Enemy enemy : EnemyList) {
            if (!enemy.readyToShoot()) return;
            enemy.shoot(playerX, playerY);
            enemy.lastShotTime = System.currentTimeMillis();
        }
    }

    public void moveEnemies() {
        for (Enemy enemy : EnemyList) {
            enemy.move();
        }
    }

    public boolean readyToSpawn() {return System.currentTimeMillis() - lastSpawnTime > minMillisBetweenSpawns;}

}
