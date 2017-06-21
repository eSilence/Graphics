package wall;


import java.awt.*;

public class Wall {
    Line line[];
    int count;
    Grid grid;

    public Wall(Grid grid){
        this.grid = grid;
        count = 6;
        line = new Line[count];

        line[0] = new HorizontalLine(grid, 0, 0, grid.getCountCellsLeft());
        line[1] = new HorizontalLine(grid, 0, grid.getCountCellsDown(), grid.getCountCellsLeft());
        line[2] = new VerticalLine(grid, 0, 0, grid.getCountCellsDown());
        line[3] = new VerticalLine(grid, grid.getCountCellsLeft()-1, 0, grid.getCountCellsDown());
        line[4] = new VerticalLine(grid, 7,3,6);
        line[5] = new HorizontalLine(grid, 4,3,4);
    }

    public void draw(Graphics g){
        for(int i = 0; i < count; i++) {
            line[i].draw(g);
        }
    }

}
