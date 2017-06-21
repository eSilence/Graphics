import java.awt.*;
import java.awt.event.KeyEvent;

public class Ball {
    private int x, y;
    private int radius;
    private int dx, dy;
    private Component container;
    private Color color;
    Direction direction;

    public Ball(int x, int y, int dx, int dy, int radius, Component container, Color color) {
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        this.radius = radius;
        this.container = container;
        this.color = color;
    }

    public void moveInDirection(){
        if (direction == Direction.Up )   {
            y = y-dy;
            if (y < radius){
                y= radius;
                direction = Direction.Down ;
            }
        }
        if (direction == Direction.Down)  {
            y = y+dy;
            if (y > container.getHeight() - 2 * radius){
                y = container.getHeight() - 2 * radius - 1;
                direction = Direction.Up ;
            }
        }

        if (direction == Direction.Left)  x = x-dx;
        if (direction == Direction.Right)   x = x+dx;
    }
    void handleKeyEvent(int key){
        switch (key){
            case KeyEvent.VK_UP : {
                direction = Direction.Up;
                System.out.println("Up key pressed");
                break;
            }
            case KeyEvent.VK_DOWN : {
                direction = Direction.Down;
                System.out.println("Down key pressed");
                break;
            }
            case KeyEvent.VK_LEFT : {
                direction = Direction.Left;
                System.out.println("Left key pressed");
                break;
            }
            case KeyEvent.VK_RIGHT : {
                direction = Direction.Right;
                System.out.println("Right key pressed");
                break;
            }
        }
    }

//    public void move() {
//        x += dx;
//        y += dy;
//        if (x >= container.getWidth() - radius) {
//            x = container.getWidth() - radius - 1;
//            dx = -dx;
//        }
//        if (y >= container.getHeight() - radius) {
//            y = container.getHeight() - radius - 1;
//            dy = -dy;
//        }
//        if (x < radius) {
//            x = radius;
//            dx = -dx;
//        }
//        if (y < radius) {
//            y = radius;
//            dy = -dy;
//        }
//    }


    public void paint(Graphics g) {
        g.setColor(color);
        g.fillOval(x-radius, y-radius, 2*radius, 2*radius);
    }
}