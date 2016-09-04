package pieces.impl;

import java.util.ArrayList;

import pieces.AbstractPiece;
import pieces.PieceType;
import pieces.Player;
import util.Position;

public class Pawn extends AbstractPiece {

	public Pawn(Player player) {
		super(PieceType.PAWN, player);
	}

	@Override
	public ArrayList<Position> getValidMoves(final Position origin) {
		ArrayList<Position> moves = new ArrayList<Position>();

		Position current = origin;
		if (player == Player.PLAYER_ONE) {
			current.y--;
			while (!current.isOutOfBounds()) {
				moves.add(current);
				current.y--;
			}
		} else {
			current.y++;
			while (!current.isOutOfBounds()) {
				moves.add(current);
				current.y++;
			}
		}

		return moves;
	}

}
