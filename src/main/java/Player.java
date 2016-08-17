import java.util.ArrayList;

/**
 * Created by jamesjones on 7/15/16.
 */
public class Player {

    public static class Players{
        private Player black;
        private Player white;
        Players(){
            white = new Player(makePieces(), new ArrayList<>());
            black = new Player(makePieces(), new ArrayList<>());
            white.setOpponent(black);
            black.setOpponent(white);
        }
    }
    public Player(ArrayList<Piece> pieces, ArrayList<Piece> captured) {
        this.pieces = pieces;
        this.captured = captured;
    }

    private static ArrayList<Piece> makePieces(){

    }

    public static Players makePlayers(){
        return new Players();
    }

    private final ArrayList<Piece> pieces;
    private final ArrayList<Piece> captured;

    public void setOpponent(Player opponent) {
        this.opponent = opponent;
    }

    public Player getOpponent() {

        return opponent;
    }

    private Player opponent;

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    public ArrayList<Piece> getCaptured() {
        return captured;
    }
}
