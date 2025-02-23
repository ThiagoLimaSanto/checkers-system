package boardgame;

public abstract class Piece {
    
    protected Position position;
    private Board board;

    public Piece(){}

    public Piece(Board board) {
        this.position = null;
        this.board = board;
    }

    public Board getBoard(){
        return board;
    }

    public Position getPosition(){
        return position;
    }

    public void setPosition(Position position){
        this.position = position;
    }

    public abstract boolean[][] possibleMove();

    public boolean possibleMove(Position position) {
        return possibleMove()[position.getRow()][position.getColumn()];
    }

    public boolean isThereAnyPossibleMove() {
        boolean[][] mat = possibleMove();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                if (mat[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
