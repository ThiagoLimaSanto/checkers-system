package application;

import checkers.CheckersPiece;
import checkers.Color;

public class Ui {

    private static Integer aux = 0;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_GRAY_BACKGROUND = "\033[100m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    // https://stackoverflow.com/questions/2979383/java-clear-the-console
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void printBoard(CheckersPiece[][] pieces) {
        for (int i = 0; i < pieces.length; i++) {
            
            System.out.print((8 - i) + " ");
            for (int j = 0; j < pieces.length; j++) {
                paint();
                printPiece(pieces[i][j]);
            }
            aux++;
            System.out.println();
        }

        System.out.println("  12345678");
    }

    private static void printPiece(CheckersPiece piece) {
        if (piece == null) {
            System.out.print(" " + ANSI_RESET);
        } else {
            if (piece.getColor() == Color.WHITE) {
                System.out.print(ANSI_WHITE + piece + ANSI_RESET);
            } else {
                System.out.print(ANSI_YELLOW + piece + ANSI_RESET);
            }
        }
    }   

    private static void paint(){
        if (aux % 2 == 0) {
            System.out.print(ANSI_BLACK_BACKGROUND);
        }else{
            System.out.print(ANSI_WHITE_BACKGROUND);
        }
        aux++;
    }
}
