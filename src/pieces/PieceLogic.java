package pieces;

import java.util.List;

import util.Position;

public interface PieceLogic {
	boolean isMoveValid(Position oldPosition, Position newPosition);
	List<Position> getValidMoces();
}
