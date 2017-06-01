/**
 * Created by blerpu on 5/31/17.
 */

import javax.swing.JFrame;
import java.awt.EventQueue;

public class Application extends JFrame {

    public Application() {
        initUI();
    }

    private void initUI() {
        add(new Board());

        setSize(400,600);

        setTitle("Predator Quest");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Application ex = new Application();
                ex.setVisible(true);
            }
        });
    }

}
