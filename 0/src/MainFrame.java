import javax.swing.*;

public class MainFrame extends JFrame {

    MainFrame(String s) {
        super(s);
        setSize(600, 600);
        JPanel panel = new MainPanel();
        add(panel);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new MainFrame("Graphics");
    }
}