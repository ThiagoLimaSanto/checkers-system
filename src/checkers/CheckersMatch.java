package checkers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import checkers.piece.PieceBlack;
import checkers.piece.PieceWhite;

public class CheckersMatch {

    private List<CheckersPiece> piecesOnTheBoard = new ArrayList<>();
    private List<Piece> capturedPieces = new ArrayList<>();

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

    public boolean getEndgame() {
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

    public boolean[][] possibleMoves(CheckersPosition sourcePosition) {
        Position position = sourcePosition.toPosition();
        validateSourcePosition(position);
        return board.piece(position).possibleMove();
    }

    public CheckersPiece performChessMovie(CheckersPosition sourcePosition, CheckersPosition targetPostion) {
        Position source = sourcePosition.toPosition();
        Position target = targetPostion.toPosition();
        validateSourcePosition(source);
        validateTargetPosition(source, target);
        Piece capturedPiece = makeMove(source, target);
        if (isEndgame(currentPlayer)) {
            endgame = true;
        } else {
            nextTurn();
        }
        return (CheckersPiece) capturedPiece;
    }

    private void validateTargetPosition(Position source, Position target) {
        if (!board.piece(source).possibleMove(target)) {
            throw new CheckersException("The chosen piece can't move to target position");
        }
    }

    private Piece makeMove(Position source, Position target) {
        CheckersPiece p = (CheckersPiece) board.removePiece(source);
        CheckersPiece capturedPiece = (CheckersPiece) board
                .removePiece((target.getRow() + source.getRow()) / 2,
                        (target.getColumn() + source.getColumn()) / 2);
        board.placePiece(p, target);
        if (capturedPiece != null) {
            piecesOnTheBoard.remove(capturedPiece);
            capturedPieces.add(capturedPiece);
        }
        return capturedPiece;
    }

    private void validateSourcePosition(Position position) {
        if (!board.thereIsAPiece(position)) {
            throw new CheckersException("There is no piece on source position");
        }
        if (currentPlayer != ((CheckersPiece) board.piece(position)).getColor()) {
            throw new CheckersException("The chosen piece is not yours");
        }
        if (!board.piece(position).isThereAnyPossibleMove()) {
            throw new CheckersException("There is no possible moves for the chosen piece");
        }
    }

    private boolean isEndgame(Color color) {
        List<CheckersPiece> list = piecesOnTheBoard.parallelStream().filter(x -> x.getColor() == opponent(color))
                .collect(Collectors.toList());
        if (list.isEmpty()) {
            return true;
        }
        return false;
    }

    private void nextTurn() {
        turn++;
        currentPlayer = (currentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE;
    }

    private Color opponent(Color color) {
        return (color == Color.WHITE) ? Color.BLACK : Color.WHITE;
    }

    private void placeNewPiece(Integer column, Integer row, CheckersPiece piece) {
        board.placePiece(piece, new CheckersPosition(column, row).toPosition());
        piecesOnTheBoard.add(piece);
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