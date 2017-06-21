package wall;

import elements.Element;
import java.awt.*;

abstract public class Line {
    Element elem[];
    int x, y;
    int length;

    public Line(int x, int y, int length) {
        this.x = x;
        this.y = y;
        this.length = length;
        this.elem = new Element[length];
    }

    public void draw(Graphics g){
        for (int i = 0; i < length ; i++) {
            elem[i].draw(g);
        }
    }
}
