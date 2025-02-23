package application;

import checkers.CheckersMatch;

public class Program {
    public static void main(String[] args) {
        CheckersMatch piece = new CheckersMatch();
        Ui.printBoard(piece.getPieces());
    }
}
