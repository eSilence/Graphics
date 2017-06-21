package wall;

import java.awt.*;

public class Grid {
    int sizeCell;
    int countCellsDown, countCellsLeft;

    public Grid(int widthGrid, int heigthGrid) {
        sizeCell = 30;
        countCellsDown = heigthGrid / sizeCell;
        countCellsLeft = widthGrid / sizeCell;
    }

    public int getSizeCell() {
        return sizeCell;
    }

    public int getCountCellsDown() {
        return countCellsDown;
    }

    public int getCountCellsLeft() {
        return countCellsLeft;
    }

    public void draw(Graphics g){
        g.setColor(Color.black);
        for (int i = 1; i < countCellsLeft; i += 1)
            g.drawLine(i*sizeCell , 0, i*sizeCell, countCellsDown* sizeCell );
        for (int i = 1; i < countCellsDown; i += 1)
            g.drawLine(0, i*sizeCell, countCellsLeft  * sizeCell, i*sizeCell);
    }
}
