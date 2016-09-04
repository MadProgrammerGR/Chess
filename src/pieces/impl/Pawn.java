package pieces.impl;

import java.util.List;

import pieces.AbstractPiece;
import pieces.PieceType;
import pieces.Player;
import util.Position;

public class Pawn extends AbstractPiece{

	public Pawn(Player player) {
		super(PieceType.PAWN, player);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isMoveValid(Position oldPosition, Position newPosition) {
		// TODO Auto-generated constructor stub
		return false;
	}

	@Override
	public List<Position> getValidMoces() {
		// TODO Auto-generated constructor stub
		return null;
	}

}
