package pieces;

public abstract class AbstractPiece implements Piece{
	private Player player;
	
	public AbstractPiece(Player player){
		this.player = player;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
}
