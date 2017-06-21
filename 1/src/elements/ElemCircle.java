package elements;

import wall.Grid;

import java.awt.*;

public class ElemCircle extends Element{

    public ElemCircle(Grid grid, int x, int y) {
      super(grid, x, y);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Colors.clrWall);
        g.fillOval(getXX(), getYY(), grid.getSizeCell(), grid.getSizeCell());
    }

    @Override
    public void clear(Graphics g) {
        g.setColor(Colors.clrBack);
        g.fillOval(getXX(), getYY(), grid.getSizeCell(), grid.getSizeCell());
    }

    @Override
    public Element getElement  (){
        return this;
    }
}
