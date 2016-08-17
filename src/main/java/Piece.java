import java.util.HashMap;

/**
 * Created by jamesjones on 7/11/16.
 */
public class Piece {
    public enum Type{
        PAWN, KNIGHT, BISHOP, ROOK, QUEEN, KING, PHANTOM_PAWN, NONE
    }
    static class Factory{
        public Piece make(Type type, Square location, Player side){
            Piece piece;
            switch (type){
                case PAWN:
                    piece = getPiece(location, 0, 2, 0, 0, 0, 0, 0, side, type);
                    break;
                case KNIGHT:
                    piece = getPiece(location, 0, 0, 0, 1, 0 ,0, 0, side, type);
                    break;
                case BISHOP:
                    piece = getPiece(location, 15, 0, 0, 0, 15, 0, 0, side, type);
                    break;
                case ROOK:
                    piece = getPiece(location, 0, 8, 8, 0, 0, 8, 8, side, type);
                    break;
                case QUEEN:
                    piece = getPiece(location, 15, 8, 8, 0, 15, 8, 8, side, type);
                    break;
                case KING:
                    piece = getPiece(location, 1, 1, 1, 0, 1, 1, 1, side, type);
                    break;
                case PHANTOM_PAWN:
                    piece = getPiece(location, 0, 0, 0, 0, 0, 0, 0, side, type);
                    break;
                case NONE:
                    piece = getPiece(location, 0, 0, 0, 0, 0, 0, 0, side, type);
                    break;
                default:
                    throw new RuntimeException("NOT A DAMN PIECE TYPE NOOB");
            }
            return piece;
        }

        private Piece getPiece(Square location, Integer diagnalMove, Integer fileMove, Integer rankMove, Integer knight, Integer diagonalAttack, Integer fileAttack, Integer rankAttack, Player side, Type type) {
            HashMap<Move.MoveTypes, Integer> moveTypes = new HashMap<>();
            HashMap<Move.MoveTypes, Integer> attackTypes = new HashMap<>();
            moveTypes.put(Move.MoveTypes.DIAGNAL, diagnalMove);
            moveTypes.put(Move.MoveTypes.FILE, fileMove);
            moveTypes.put(Move.MoveTypes.RANK, rankMove);
            moveTypes.put(Move.MoveTypes.KNIGHT, knight);
            attackTypes.put(Move.MoveTypes.DIAGNAL, diagonalAttack);
            attackTypes.put(Move.MoveTypes.FILE, fileAttack);
            attackTypes.put(Move.MoveTypes.RANK, rankAttack);
            attackTypes.put(Move.MoveTypes.KNIGHT, knight);
            Piece piece;
            if(type == Type.PAWN){
                piece = new Pawn(location, moveTypes, attackTypes, side, type);
            }else {
                piece = new Piece(location, moveTypes, attackTypes, side, type);
            }
            location.setOccupier(piece);
            return piece;
        }
    }
    private SquareCollection rank;
    private SquareCollection file;
    private SquareCollection diagonal;
    private KnightMove knightMove;
    private Square square;
    private HashMap<Move.MoveTypes, Integer> validMoves;
    private HashMap<Move.MoveTypes, Integer> validAttacks;
    private final Player side;
    private final Type type;

    public SquareCollection getRank() {
        return rank;
    }

    public SquareCollection getFile() {
        return file;
    }

    public SquareCollection getDiagonal() {
        return diagonal;
    }

    public KnightMove getKnightMove() {
        return knightMove;
    }

    public Square getSquare() {
        return square;
    }

    public HashMap<Move.MoveTypes, Integer> getValidMoves() {
        return validMoves;
    }

    public HashMap<Move.MoveTypes, Integer> getValidAttacks() {
        return validAttacks;
    }

    public Player getSide() {
        return side;
    }

    public Type getType() {
        return type;
    }

    public void capture(){
        this.getSide().getCaptured().add(this);
        this.getSide().getPieces().remove(this);
        this.square = null;
    }

    public void Move(Square target){
        if(target.getOccupier().getSide() != this.side){

        }
        target.setOccupier(this);
    }

    Piece(Square location,
                  HashMap<Move.MoveTypes, Integer> validMoves,
                  HashMap<Move.MoveTypes, Integer> validAttacks,
                  Player side,
                  Type type) {
        this.diagonal = location.getDiagonal();
        this.rank = location.getRank();
        this.file = location.getFile();
        this.knightMove = location.getKnightMove();
        this.square = location;
        this.validMoves = validMoves;
        this.validAttacks = validAttacks;
        this.side = side;
        this.type = type;
    }
}
