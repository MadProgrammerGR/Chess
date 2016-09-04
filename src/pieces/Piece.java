package pieces;

import java.util.List;

import util.Position;

public interface Piece {
	boolean isMoveValid(Position oldPosition, Position newPosition);
	List<Position> getValidMoces();
}
