package elements;

import wall.Grid;
import java.awt.*;

abstract public class Element {
    int x, y;
    Grid grid;

    public Element(Grid grid, int x, int y) {
        this.grid = grid;
        this.x = x;
        this.y = y;
    }
    public int getXX(){
        return grid.getSizeCell() * x;
    }

    public int getYY(){
        return grid.getSizeCell() * y;
    }

    public abstract Element getElement();
    public abstract void draw(Graphics graphics);
    public abstract void clear(Graphics graphics);
}
