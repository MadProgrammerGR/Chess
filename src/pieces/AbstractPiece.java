package pieces;

import java.util.ArrayList;

import util.Position;

public abstract class AbstractPiece implements Piece {
	protected Player player;
	protected PieceType type;

	public AbstractPiece(PieceType type, Player player) {
		this.type = type;
		this.player = player;
	}
	
	public boolean isMoveValid(Position oldPosition, Position newPosition) {
		ArrayList<Position> validMoves = getValidMoves(oldPosition);
		for (Position current : validMoves)
			if (current.equals(newPosition))
				return true;
		return false;
	}

	public PieceType getType() {
		return type;
	}

	public void setType(PieceType type) {
		this.type = type;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
}
