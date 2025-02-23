package checkers;

import boardgame.Position;

public class CheckersPosition {

    private Integer column;
    private Integer row;

    public CheckersPosition(Integer column, Integer row) {
        if (column < 1 || column > 8 || row < 1 || row > 8) {
            throw new CheckersException("Error instantiating chessPosition. Valid values are from a1 to h8");
        }
        this.column = column;
        this.row = row;
    }

    public Integer getColumn() {
        return column;
    }

    public Integer getRow() {
        return row;
    }

    public Position toPosition(){
        return new Position(8 - row, column - 1);
    }

    @Override
    public String toString() {
        return column + ", " + row;
    }
}
