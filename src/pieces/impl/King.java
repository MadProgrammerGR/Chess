package pieces.impl;

import java.util.ArrayList;

import pieces.AbstractPiece;
import pieces.PieceType;
import pieces.Player;
import util.Position;

public class King extends AbstractPiece{

	public King(Player player) {
		super(PieceType.KING, player);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<Position> getValidMoves(Position origin) {
		ArrayList<Position> moves = new ArrayList<Position>();
		
		origin.x--;
		if(!origin.isOutOfBounds())
			moves.add(origin);
		
		origin.x++;
		origin.y--;
		if(!origin.isOutOfBounds())
			moves.add(origin);
		
		origin.x++;
		origin.y++;
		if(!origin.isOutOfBounds())
			moves.add(origin);
		
		origin.x--;
		origin.y++;
		if(!origin.isOutOfBounds())
			moves.add(origin);
		
		return moves;
	}

}
