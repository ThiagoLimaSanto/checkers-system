package checkers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import checkers.piece.Checker;
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
        Piece capturedPiece;
        CheckersPiece p = (CheckersPiece) board.removePiece(source);
        board.placePiece(p, target);
        int deltaX = (target.getRow() > source.getRow()) ? 1 : -1;
        int deltaY = (target.getColumn()) > source.getColumn() ? 1 : -1;
        int x = source.getRow() + deltaX;
        int y = source.getColumn() + deltaY;
        while (x != target.getRow() && y != target.getColumn()) {
            capturedPiece = board.piece(x, y);
            if (capturedPiece != null) {
                Piece aux = board.removePiece(new Position(x, y));
                piecesOnTheBoard.remove(aux);
                capturedPieces.add(aux);
                return aux;
            }
            x += deltaX;
            y += deltaY;
        }
        return null;
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
        placeNewPiece(3, 4, new Checker(board, Color.WHITE));
        placeNewPiece(4, 3, new PieceWhite(board, Color.WHITE));
        placeNewPiece(5, 4, new Checker(board, Color.BLACK));
    }
}