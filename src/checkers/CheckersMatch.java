package checkers;

import java.util.ArrayList;
import java.util.List;

import boardgame.Board;
import boardgame.Piece;

public class CheckersMatch {

    private List<Piece> piecesWhite = new ArrayList<>();
    private List<Piece> piecesBlack = new ArrayList<>();

    private boolean endgame;
    private Integer turn;
    private Color currentPlayer;
    private Board board;

    public CheckersMatch() {
        board = new Board(8, 8);
        turn = 1;
        currentPlayer = Color.WHITE;
        endgame = false;
        initialSetup();
    }

    public boolean isEndgame() {
        return endgame;
    }

    public Integer getTurn() {
        return turn;
    }

    public Color getCurrentPlayer() {
        return currentPlayer;
    }

    public CheckersPiece[][] getPieces() {
        CheckersPiece[][] mat = new CheckersPiece[board.getRows()][board.getColumns()];
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                mat[i][j] = (CheckersPiece) board.piece(i, j);
            }
        }
        return mat;
    }

    private void placeNewPiece(Integer column, Integer row, CheckersPiece piece) {
        board.placePiece(piece, new CheckersPosition(column, row).toPosition());
        if (piece.getColor() == Color.WHITE) {
            piecesWhite.add(piece);
        } else {
            piecesBlack.add(piece);
        }
    }

    private void initialSetup() {
        placeNewPiece(1, 1, new CheckersPiece(board, Color.WHITE));
        placeNewPiece(2, 7, new CheckersPiece(board, Color.BLACK));
    }
}
