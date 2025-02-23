package checkers.piece;

import boardgame.Board;
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
}
