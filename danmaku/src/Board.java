import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.awt.Rectangle;


public class Board extends JPanel implements ActionListener {

    private Timer timer;
    private Timer scoreTimer;
    private Player craft;
    private final int DELAY = 10;
    public static EnemyBulletSpawner list;
    public static PlayerBulletSpawner playerList;
    public static EnemySpawner enemyList;
    public static long lastRandomShotTime;
    public static long minMillisBetweenRandomShots = 100;
    public static int score;
    public JLabel scoreBoard;
    public static boolean ingame = true;

    public Board() {
        initBoard();
    }

    private void initBoard() {
        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        scoreBoard = new JLabel("SCORE: 0");
        scoreBoard.setForeground(Color.WHITE);
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
        shootEnemyBullets();
        checkCollisions();
        add(scoreBoard);
        Toolkit.getDefaultToolkit().sync();
        if (ingame == false) {
            score = 0;
            scoreBoard.setText("SCORE: " + score);
            ingame = true;
        }
    }

    public void shootEnemyBullets() {
        for (int i = 0; i < enemyList.EnemyList.size(); i++) {
            if (!enemyList.EnemyList.get(i).readyToShoot()) return;
            enemyList.EnemyList.get(i).shoot(craft.getX(), craft.getY());
            enemyList.EnemyList.get(i).lastShotTime = System.currentTimeMillis();
        }
    }

    public void checkCollisions() {
        Rectangle playerBounds = craft.getBounds();
        for (Bullet bullet : list.BulletList) {
            Rectangle bulletBounds = bullet.getBounds();
            if (bulletBounds.intersects(playerBounds)) {
                ingame = false;
            }
        }
        for (Bullet playerBullet : playerList.BulletList) {
            Rectangle playerBulletBounds = playerBullet.getBounds();
            for (Enemy enemy : enemyList.EnemyList) {
                Rectangle enemyBounds = enemy.getBounds();
                if (playerBulletBounds.intersects(enemyBounds)) {
                    score++;
                    enemy.setAlive(false);
                }
            }
        }
    }

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(craft.getHitboxImage(), (int)craft.getX() + 12, (int)craft.getY() + 12, this);
        g2d.drawImage(craft.getImage(), (int)craft.getX(), (int)craft.getY(), this);
        if (craft.isFocused()) {
            g2d.drawImage(craft.getHitboxImage(), (int)craft.getX() + 12, (int)craft.getY() + 12, this);
        }

    }

    private void addEnemies() {
        if (Board.enemyList.EnemyList.size() < 10 && enemyList.readyToSpawn()) {
            enemyList.addEnemy(300, 50, 1, 1);
            Board.enemyList.lastSpawnTime = System.currentTimeMillis();
        }
    }

    private void addRandomShots() {
        if (list.BulletList.size() < 50 && readyToRandomShot()) {
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
            if (enemyList.EnemyList.get(i).getX() > 300 || enemyList.EnemyList.get(i).getY() > 500 ||
                    !enemyList.EnemyList.get(i).isAlive()) {
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
        scoreBoard.setText("SCORE: " + score);
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