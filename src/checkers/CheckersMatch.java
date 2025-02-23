package checkers;

import java.util.ArrayList;
import java.util.List;

import boardgame.Board;
import boardgame.Piece;
import checkers.piece.PieceBlack;
import checkers.piece.PieceWhite;

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
        placeNewPiece(2, 1, new PieceWhite(board, Color.WHITE));
        placeNewPiece(4, 1, new PieceWhite(board, Color.WHITE));
        placeNewPiece(6, 1, new PieceWhite(board, Color.WHITE));
        placeNewPiece(8, 1, new PieceWhite(board, Color.WHITE));
        placeNewPiece(1, 2, new PieceWhite(board, Color.WHITE));
        placeNewPiece(3, 2, new PieceWhite(board, Color.WHITE));
        placeNewPiece(5, 2, new PieceWhite(board, Color.WHITE));
        placeNewPiece(7, 2, new PieceWhite(board, Color.WHITE));
        placeNewPiece(2, 3, new PieceWhite(board, Color.WHITE));
        placeNewPiece(4, 3, new PieceWhite(board, Color.WHITE));
        placeNewPiece(6, 3, new PieceWhite(board, Color.WHITE));
        placeNewPiece(8, 3, new PieceWhite(board, Color.WHITE));


        placeNewPiece(1, 8, new PieceBlack(board, Color.BLACK));
        placeNewPiece(3, 8, new PieceBlack(board, Color.BLACK));
        placeNewPiece(5, 8, new PieceBlack(board, Color.BLACK));
        placeNewPiece(7, 8, new PieceBlack(board, Color.BLACK));
        placeNewPiece(2, 7, new PieceBlack(board, Color.BLACK));
        placeNewPiece(4, 7, new PieceBlack(board, Color.BLACK));
        placeNewPiece(6, 7, new PieceBlack(board, Color.BLACK));
        placeNewPiece(8, 7, new PieceBlack(board, Color.BLACK));
        placeNewPiece(1, 6, new PieceBlack(board, Color.BLACK));
        placeNewPiece(3, 6, new PieceBlack(board, Color.BLACK));
        placeNewPiece(5, 6, new PieceBlack(board, Color.BLACK));
        placeNewPiece(7, 6, new PieceBlack(board, Color.BLACK));
    }
}
