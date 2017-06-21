import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MainPanel extends JPanel {
    Ball ball;
    private Timer timer;
    ActionListener timerListener;

    public MainPanel(Ball _ball) {
        super();
        this.ball = _ball;
        //setBackground(Color.BLACK);

        timerListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ball.moveInDirection();
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