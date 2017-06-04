import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Board extends JPanel implements ActionListener {

    private Timer timer;
    private Player craft;
    private final int DELAY = 10;
    public static EnemyBulletSpawner list;
    public static PlayerBulletSpawner playerList;
    public static EnemySpawner enemyList;
    public static long lastRandomShotTime;
    public static long minMillisBetweenRandomShots = 100;

    public Board() {
        initBoard();
    }

    private void initBoard() {
        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);

        craft = new Player();
        list = new EnemyBulletSpawner();
        playerList = new PlayerBulletSpawner();
        enemyList = new EnemySpawner();

        timer = new Timer(DELAY, this);
        timer.start();
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);
        drawPlayerBullets(g);
        drawBullets(g);
        addRandomShots();
        addEnemies();
        drawEnemies(g);
        enemyList.shootEnemyBullets(craft.getX(), craft.getY());

        Toolkit.getDefaultToolkit().sync();
    }

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(craft.getHitboxImage(), craft.getX() + 12, craft.getY() + 12, this);
        g2d.drawImage(craft.getImage(), craft.getX(), craft.getY(), this);
        if (craft.isFocused()) {
            g2d.drawImage(craft.getHitboxImage(), craft.getX() + 12, craft.getY() + 12, this);
        }

    }

    private void addEnemies() {
        if (Board.enemyList.EnemyList.size() < 10 && enemyList.readyToSpawn()) {
            enemyList.addEnemy(300, 50, 2, 1);
            Board.enemyList.lastSpawnTime = System.currentTimeMillis();
        }
    }

    private void addRandomShots() {
        if (list.BulletList.size() < 100 && readyToRandomShot()) {
            list.BulletList.add(new LinearBullet((Math.random() * 400) + 10, Math.random() * 200,
                    0));
            lastRandomShotTime = System.currentTimeMillis();
        }
    }

    private void drawEnemies(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        for (int i = 0; i < enemyList.EnemyList.size(); i++) {
            g2d.drawImage(enemyList.EnemyList.get(i).getImage(), enemyList.EnemyList.get(i).getX(),
                    enemyList.EnemyList.get(i).getY(), this);
            if (enemyList.EnemyList.get(i).getX() > 400 || enemyList.EnemyList.get(i).getY() > 600) {
                enemyList.EnemyList.remove(i);
            }
        }
        enemyList.moveEnemies();
    }

    private void drawBullets(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        for (int i = 0; i < list.BulletList.size(); i++) {
            g2d.drawImage(list.BulletList.get(i).getImage(), list.BulletList.get(i).getXPosition(),
                    list.BulletList.get(i).getYPosition(), this);
            list.BulletList.get(i).bulletMove();
            if (list.BulletList.get(i).getXPosition() > 400 || list.BulletList.get(i).getYPosition() > 600) {
                list.BulletList.remove(i);
            }

        }

    }

    private void drawPlayerBullets(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        if (craft.shooting) {
            playerList.shootBullet(craft);
        }
        for (int i = 0; i < playerList.BulletList.size(); i++) {
            g2d.drawImage(playerList.BulletList.get(i).getImage(), playerList.BulletList.get(i).getXPosition(),
                    playerList.BulletList.get(i).getYPosition(), this);
            playerList.BulletList.get(i).bulletMove();
            if (playerList.BulletList.get(i).getXPosition() > 400 || playerList.BulletList.get(i).getYPosition() > 600) {
                playerList.BulletList.remove(i);
            }
        }
    }

    public boolean readyToRandomShot() {return System.currentTimeMillis() - lastRandomShotTime > minMillisBetweenRandomShots;}

    @Override
    public void actionPerformed(ActionEvent e) {
        craft.move();
        repaint();
    }

    private class TAdapter extends KeyAdapter {
        @Override
        public void keyReleased(KeyEvent e) {
            craft.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            craft.keyPressed(e);
        }
    }
}