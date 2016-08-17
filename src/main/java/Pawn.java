import java.util.HashMap;

/**
 * Created by jamesjones on 7/15/16.
 */
public class Pawn extends Piece {
    public Pawn(Square location, HashMap<Move.MoveTypes, Integer> validMoves, HashMap<Move.MoveTypes, Integer> validAttacks, Player side, Type type) {
        super(location, validMoves, validAttacks, side, type);
    }

    @Override
    public HashMap<Move.MoveTypes, Integer> getValidMoves() {
        return super.getValidMoves();
    }

    @Override
    public HashMap<Move.MoveTypes, Integer> getValidAttacks() {
        return super.getValidAttacks();
    }
}
