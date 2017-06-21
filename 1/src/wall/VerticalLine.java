package wall;

import elements.ElemRect;

public class VerticalLine extends Line {

    public VerticalLine(Grid grid, int x, int y, int len) {
        super(x, y, len);
        for (int i = 0; i < length; i++) {
            if (y+i <= grid.getCountCellsDown())
                elem[i] = new ElemRect(grid, x, y+i);
            else{
                length = i;
                break;
            }
        }
    }
}
