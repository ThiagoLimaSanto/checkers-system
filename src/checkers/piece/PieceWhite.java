package checkers.piece;

import boardgame.Board;
import boardgame.Position;
import checkers.CheckersPiece;
import checkers.Color;

public class PieceWhite extends CheckersPiece{

    public PieceWhite(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "W";
    }

    @Override
    public boolean[][] possibleMove() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p = new Position(0, 0);

        p.setValues(position.getRow() - 1, position.getColumn() - 1);
        if ((getBoard().positionExists(p) && !getBoard().thereIsAPiece(p))) {
            mat[p.getRow()][p.getColumn()] = true;
        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            p.setRow(p.getRow() - 1);
            p.setColumn(p.getColumn() - 1);
            if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
                getBoard();
                mat[p.getRow()][p.getColumn()] = true;
            }
        }

        p.setValues(position.getRow() - 1, position.getColumn() + 1);
        if ((getBoard().positionExists(p) && !getBoard().thereIsAPiece(p))) {
            mat[p.getRow()][p.getColumn()] = true;
        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            p.setRow(p.getRow() - 1);
            p.setColumn(p.getColumn() + 1);
            if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }
        }

        p.setValues(position.getRow() + 1, position.getColumn() - 1);
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            p.setRow(p.getRow() + 1);
            p.setColumn(p.getColumn() - 1);
            if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }
        }

        p.setValues(position.getRow() + 1, position.getColumn() + 1);
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            p.setRow(p.getRow() + 1);
            p.setColumn(p.getColumn() + 1);
            if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }
        }
        return mat;
    }
}
