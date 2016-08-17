import java.util.ArrayList;

/**
 * Created by jamesjones on 7/11/16.
 */
public class Board {
    private final ArrayList<SquareCollection> ranks;
    private final ArrayList<SquareCollection> files;
    private final ArrayList<SquareCollection> diagonals;

    public Board() {
        ArrayList<SquareCollection.Builder> rankBuilderList = makeBuilderList(Move.MoveTypes.RANK, 8);
        ArrayList<SquareCollection.Builder> fileBuilderList = makeBuilderList(Move.MoveTypes.FILE, 8);
        ArrayList<SquareCollection.Builder> diagnalBuilderList = makeBuilderList(Move.MoveTypes.DIAGNAL, 15);
        for(int rankInt = 0; rankInt < 7; rankInt++){
            for(int fileInt = 0; fileInt < 7; fileInt++){
                int diagInt = 7 - rankInt + fileInt;
                Square square = new Square(this, rankInt, fileInt, diagInt);
                rankBuilderList.get(rankInt).add(square);
                fileBuilderList.get(fileInt).add(square);
                rankBuilderList.get(diagInt).add(square);
            }
        }
        ranks = SquareCollection.Builder.buildCollection(rankBuilderList);
        files = SquareCollection.Builder.buildCollection(fileBuilderList);
        diagonals = SquareCollection.Builder.buildCollection(diagnalBuilderList);
    }

    private static ArrayList<SquareCollection.Builder> makeBuilderList(Move.MoveTypes moveType, int capacity){
        ArrayList<SquareCollection.Builder> builderList = new ArrayList<>();
        for(int i = 0; i < capacity; i++) {
            builderList.add(new SquareCollection.Builder(moveType));
        }
        return builderList;
    }

    public Square getSquare(int rank, int file){
        return ranks.get(rank).get(file);
    }

    public SquareCollection getRank(int rank) {
        return ranks.get(rank);
    }

    public SquareCollection getFile(int file) {
        return files.get(file);
    }

    public SquareCollection getDiagonal(int diagonal) {
        return diagonals.get(diagonal);
    }
}
