import java.util.ArrayList;

/**
 * Created by jamesjones on 7/11/16.
 */
public interface ValidMove extends Move {
    ArrayList<Square> getValidMoves(Piece me);
}
