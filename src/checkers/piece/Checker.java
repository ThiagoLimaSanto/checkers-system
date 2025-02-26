package checkers.piece;

import boardgame.Board;
import boardgame.Position;
import checkers.CheckersPiece;
import checkers.Color;

public class Checker extends CheckersPiece {

    public Checker(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "C";
    }

    @Override
    public boolean[][] possibleMove() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p = new Position(0, 0);
        Position p2 = new Position(0, 0);

        p.setValues(position.getRow() - 1, position.getColumn() - 1);
        while (getBoard().positionExists(p)) {
            p2.setRow(p.getRow() - 1);
            p2.setColumn(p.getColumn() - 1);
            if (isThereOpponentPiece(p) && getBoard().positionExists(p2)) {
                p.setRow(p.getRow() - 1);
                p.setColumn(p.getColumn() - 1);
            }
            if (getBoard().thereIsAPiece(p)) {
                break;
            }
            mat[p.getRow()][p.getColumn()] = true;
            p.setRow(p.getRow() - 1);
            p.setColumn(p.getColumn() - 1);
        }

        p.setValues(position.getRow() - 1, position.getColumn() + 1);
        while (getBoard().positionExists(p)) {
            p2.setRow(p.getRow() - 1);
            p2.setColumn(p.getColumn() + 1);
            if (isThereOpponentPiece(p) && getBoard().positionExists(p2)) {
                p.setRow(p.getRow() - 1);
                p.setColumn(p.getColumn() + 1);
            }
            if (getBoard().thereIsAPiece(p)) {
                break;
            }
            mat[p.getRow()][p.getColumn()] = true;
            p.setRow(p.getRow() - 1);
            p.setColumn(p.getColumn() + 1);
        }

        p.setValues(position.getRow() + 1, position.getColumn() - 1);
        while (getBoard().positionExists(p)) {
            p2.setRow(p.getRow() + 1);
            p2.setColumn(p.getColumn() - 1);
            if (isThereOpponentPiece(p) && getBoard().positionExists(p2)) {
                p.setRow(p.getRow() + 1);
                p.setColumn(p.getColumn() - 1);
            }
            if (getBoard().thereIsAPiece(p)) {
                break;
            }
            mat[p.getRow()][p.getColumn()] = true;
            p.setRow(p.getRow() + 1);
            p.setColumn(p.getColumn() - 1);
        }

        p.setValues(position.getRow() + 1, position.getColumn() + 1);
        while (getBoard().positionExists(p)) {
            p2.setRow(p.getRow() + 1);
            p2.setColumn(p.getColumn() + 1);
            if (isThereOpponentPiece(p) && getBoard().positionExists(p2)) {
                p.setRow(p.getRow() + 1);
                p.setColumn(p.getColumn() + 1);
            }
            if (getBoard().thereIsAPiece(p)) {
                break;
            }
            mat[p.getRow()][p.getColumn()] = true;
            p.setRow(p.getRow() + 1);
            p.setColumn(p.getColumn() + 1);
        }
        return mat;
    }
}
