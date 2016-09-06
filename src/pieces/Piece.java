package pieces;

import java.util.ArrayList;

import util.Position;

public interface Piece {
	boolean isMoveValid(Position oldPosition, Position newPosition);
	ArrayList<Position> getValidMoves(Position origin);
}
