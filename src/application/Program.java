package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import checkers.CheckersException;
import checkers.CheckersMatch;
import checkers.CheckersPiece;
import checkers.CheckersPosition;

public class Program {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        CheckersMatch chessMatch = new CheckersMatch();
        List<CheckersPiece> captured = new ArrayList<>();

        while (!chessMatch.isEndgame()) {
            try {
                Ui.clearScreen();
                Ui.printMatch(chessMatch, captured);

                System.out.println();

                System.out.print("Source: ");
                CheckersPosition source = Ui.readChessPosition(scan);

                boolean [][] possibleMoves = chessMatch.possibleMoves(source);
                Ui.clearScreen();

                Ui.printBoard(chessMatch.getPieces(), possibleMoves);

                System.out.println();

                System.out.print("Target: ");
                CheckersPosition target = Ui.readChessPosition(scan);

                CheckersPiece capturedPiece = chessMatch.performChessMovie(source, target);
                
                if (capturedPiece != null) {
                    captured.add(capturedPiece);
                }
            } catch (CheckersException e) {
                System.out.println(e.getMessage());
                scan.nextLine();
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                scan.nextLine();
            }
        }
    }
}
