package wall;

import elements.ElemRect;

public class HorizontalLine extends Line {

    public HorizontalLine(Grid grid, int x, int y, int len) {
       super(x, y, len);
        for (int i = 0; i < length; i++) {
            if (x+i < grid.getCountCellsLeft())
                elem[i] = new ElemRect(grid, x+i, y);
            else{
                length = i;
                break;
            }
        }
    }
}
