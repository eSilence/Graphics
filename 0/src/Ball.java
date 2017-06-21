import java.awt.*;

public class Ball {
    private int x, y;
    private int dx, dy;
    private int radius;
    private Component container;
    private Color color;

    public Ball(int x, int y, int dx, int dy, int radius, Component container, Color color) {
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        this.radius = radius;
        this.container = container;
        this.color = color;
    }

   public void move() {
        x += dx;
        y += dy;
        if (x >= container.getWidth() - radius) {
            x = container.getWidth() - radius - 1;
            x = container.getWidth() - radius - 1;
            dx = -dx;
        }
        if (y >= container.getHeight() - radius) {
            y = container.getHeight() - radius - 1;
            dy = -dy;
        }
        if (x < radius) {
            x = radius;
            dx = -dx;
        }
        if (y < radius) {
            y = radius;
            dy = -dy;
        }
    }


    public void paint(Graphics g) {
        g.setColor(color);
        g.fillOval(x-radius, y-radius, 2*radius, 2*radius);
    }
}
