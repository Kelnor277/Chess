import java.io.PipedReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by jamesjones on 7/11/16.
 */
public class SquareCollection implements ValidMove{
    static class Builder{
        ArrayList<Square> squares;
        MoveTypes moveType;
        public Builder(MoveTypes moveType) {
            this.moveType = moveType;
            this.squares = new ArrayList<>();
        }
        Builder add(Square square){
            squares.add(square);
            return this;
        }
        static ArrayList<SquareCollection> buildCollection(ArrayList<Builder> builders){
            ArrayList<SquareCollection> collection = new ArrayList<>();
            for(Builder builder : builders){
                collection.add(new SquareCollection(builder));
            }
            return collection;
        }
    }
    private final ArrayList<Square> squares;
    private final MoveTypes moveType;
    @Override
    public ArrayList<Square> getValidMoves(Piece me) {
        int currentIndex = squares.indexOf(me.getSquare());
        if(currentIndex == -1){
            throw new RuntimeException("Start or target not in this collection.");
        }
        ArrayList<List<Square>> directions = new ArrayList<>();
        directions.add(squares.subList(currentIndex, squares.size() - 1));
        List<Square> reverse = squares.subList(currentIndex, 0);
        Collections.reverse(reverse);
        directions.add(reverse);
        ArrayList<Square> validSquares = new ArrayList<>();
        if(me.getType() == Piece.Type.NONE){
            throw new RuntimeException("No piece on start square");
        }
        Integer moveRange = me.getValidMoves().get(moveType);
        Integer attackRange = me.getValidAttacks().get(moveType);
        for(List<Square> direction : directions){
            Integer range = 1;
            for(Square walk : direction) {
                if (range <= attackRange && canAttack(walk, me)) {
                    validSquares.add(walk);
                    break;
                }
                if (range <= moveRange && !canMove(walk)) {
                    break;
                }
                validSquares.add(walk);
                range++;
            }
        }
        return validSquares;
    }

    private boolean canMove(Square target){
        if(target.getOccupier().getType() != Piece.Type.NONE){
            return false;
        }
        return true;
    }

    private boolean canAttack(Square target, Piece me){
        if(target.getOccupier().getType() != Piece.Type.NONE &&
                target.getOccupier().getSide() != me.getSide()){
            return true;
        }
        return false;
    }

    public Square get(int index) {
        return squares.get(index);
    }

    public Square get(Square root, int offset){
        contains(root);
        return squares.get(squares.indexOf(root) + offset);
    }

    private void contains(Square root) {
        if(!squares.contains(root)){
            throw new RuntimeException("Not a valid square.");
        }
    }

    private SquareCollection(Builder builder ) {
        this.squares = builder.squares;
        this.moveType = builder.moveType;
    }
}
