import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by jamesjones on 7/11/16.
 */
public class KnightMove implements SpecialMove {
    private final Square rootSquare;
    @Override
    public Square getRootSquare() {
        return null;
    }

    public KnightMove(Square rootSquare) {
        this.rootSquare = rootSquare;
        SquareCollection rank = rootSquare.getRank();

    }

    @Override
    public ArrayList<Square> getValidMoves(Piece me) {
        return null;
    }
}
