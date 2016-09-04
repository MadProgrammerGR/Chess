package pieces.impl;

import java.util.List;

import pieces.AbstractPiece;
import pieces.PieceType;
import pieces.Player;
import util.Position;

public class Knight extends AbstractPiece{

	public Knight(Player player) {
		super(PieceType.KNIGHT, player);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isMoveValid(Position oldPosition, Position newPosition) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Position> getValidMoces() {
		// TODO Auto-generated method stub
		return null;
	}

}
