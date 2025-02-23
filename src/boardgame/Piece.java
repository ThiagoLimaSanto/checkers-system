package boardgame;

public class Piece {
    
    private Position position;
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
}
