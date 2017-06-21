import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MainPanel extends JPanel {
    Ball ball;
    private Timer timer;
    ActionListener timerListener;

    public MainPanel() {
        super();
        ball = new Ball(50, 150, 2, 2, 20, this, Color.RED);
        setBackground(Color.BLACK);

        timerListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ball.move();
                repaint();
            }
        };
        timer = new Timer(20, timerListener);
        timer.start();
    }



    public void paint(Graphics g) {
        super.paint(g);
        ball.paint(g);
    }
}