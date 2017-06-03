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
    private final int DELAY = 20;
    public EnemyBulletList list;
    public PlayerBulletList playerList;

    public Board() {
        initBoard();
    }

    private void initBoard() {
        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);

        craft = new Player();
        list = new EnemyBulletList();
        playerList = new PlayerBulletList();

        timer = new Timer(DELAY, this);
        timer.start();
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);
        drawPlayerBullets(g);
        drawBullets(g);

        Toolkit.getDefaultToolkit().sync();
    }

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(craft.getImage(), craft.getX(), craft.getY(), this);
        if (craft.isFocused()) {
            g2d.drawImage(craft.getHitboxImage(), craft.getX() + 8, craft.getY() + 8, this);
        }

    }

    private void drawBullets(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        /*
        // Bullet Filling Method
        if (list.EnemyBulletList.size() < 50) {
            list.fill(400, 2, 1);
        }
        */
        for (int i = 0; i < list.BulletList.size(); i++) {
            g2d.drawImage(list.BulletList.get(i).getImage(), list.BulletList.get(i).getXPosition(), list.BulletList.get(i).getYPosition(), this);
            list.BulletList.get(i).bulletMove();
            if (list.BulletList.get(i).getXPosition() > 400 || list.BulletList.get(i).getYPosition() > 600) {
                list.BulletList.remove(i);
            }
        }

    }

    private void drawPlayerBullets(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        while (craft.shooting) {
            playerList.shootBullet(craft);
            break;
        }
        for (int i = 0; i < playerList.BulletList.size(); i++) {
            g2d.drawImage(playerList.BulletList.get(i).getImage(), playerList.BulletList.get(i).getXPosition(), playerList.BulletList.get(i).getYPosition(), this);
            playerList.BulletList.get(i).bulletMove();
            if (playerList.BulletList.get(i).getXPosition() > 400 || playerList.BulletList.get(i).getYPosition() > 600) {
                playerList.BulletList.remove(i);
            }
        }
    }

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