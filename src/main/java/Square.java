/**
 * Created by jamesjones on 7/11/16.
 */
public class Square {
    private final int rank;
    private final int file;
    private final int diagonal;
    private final Board board;

    public Piece getOccupier() {
        return occupier;
    }

    public void setOccupier(Piece occupier) {
        this.occupier = occupier;
    }

    public SquareCollection getRank() {
        return board.getRank(rank);
    }

    public SquareCollection getFile() {
        return board.getFile(file);
    }

    public SquareCollection getDiagonal() {
        return board.getDiagonal(diagonal);
    }

    public KnightMove getKnightMove() {
        return null;
    }

    private Piece occupier;
    public Square(Board board, int rank, int file, int diagonal) {
        this.rank = rank;
        this.file = file;
        this.diagonal = diagonal;
        this.board = board;
    }
}
