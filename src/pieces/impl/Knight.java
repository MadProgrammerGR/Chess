package pieces.impl;

import java.util.ArrayList;

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
	public ArrayList<Position> getValidMoves(Position origin) {
		ArrayList<Position> moves = new ArrayList<Position>();


		return moves;
	}

}
