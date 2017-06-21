import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainFrame extends JFrame {
    private Ball ball;

    MainFrame(String s) {
        super(s);
        setSize(600, 600);
        ball = new Ball(50, 150, 2, 2, 10, this, Color.RED);

        JPanel panel = new MainPanel(ball);
        add(panel);
        this.addKeyListener(new KeyListener() {
            @Override   public void keyTyped(KeyEvent e) { }
            @Override   public void keyReleased(KeyEvent e) {}
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                ball.handleKeyEvent(key);
                repaint();
            }
        });

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
                new MainFrame("Graphics");
    }
}