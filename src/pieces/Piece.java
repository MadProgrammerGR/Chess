package pieces;

public class Piece {

	public PieceType type;
	public Player player;

	public Piece(Player player, PieceType type) {
		this.type = type;
		this.player = player;
	}

}
