import elements.ElemCircle;
import elements.ElemRect;
import elements.Element;
import wall.*;

import javax.swing.*;
import java.awt.*;

public class Main extends JPanel {
    static int width = 800, heigth =800;
//    static int sizeCell = 30;

    Wall wall;
    Element elem;
    Grid grid;
    Line line;

    public Main(){
        grid = new Grid(width-40, heigth-80);

      //  elem = new ElemCircle(grid, 4,6);
      //  line = new VerticalLine(grid, 0, 0, grid.getCountCellsDown());
        wall = new Wall(grid);
    }
    public void beginGame(Graphics g) {

        grid.draw(g);
        wall.draw(g);

    }

    @Override
    public void paint(Graphics g) {
       // g.drawRect(0,0,width-40, heigth-80);
        beginGame(g);
    }

    public static void main(String [] arv){
        JFrame frame = new JFrame("GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, heigth);
        frame.add(new Main());
        frame.setVisible(true);
    }
}
