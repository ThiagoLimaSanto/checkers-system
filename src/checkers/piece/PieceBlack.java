package checkers.piece;

import boardgame.Board;
import checkers.CheckersPiece;
import checkers.Color;

public class PieceBlack extends CheckersPiece{

    public PieceBlack(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "B";
    }
}
