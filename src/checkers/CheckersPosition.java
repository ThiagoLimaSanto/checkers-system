package checkers;

import boardgame.Position;

public class CheckersPosition {

    private Integer column;
    private Integer row;

    public CheckersPosition(Integer column, Integer row) {
        this.column = column;
        this.row = row;
    }

    public Integer getColumn() {
        return column;
    }

    public Integer getRow() {
        return row;
    }

    protected Position toPosition(){
        return new Position(8 - row, column - 1);
    }

    @Override
    public String toString() {
        return "" + column + row;
    }
}
