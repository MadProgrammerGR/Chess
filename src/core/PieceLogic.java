package core;

import java.util.ArrayList;

public interface PieceLogic {

	public boolean isMoveValid(Position newPos);
	public ArrayList<Position> getValidMoves();
	
}
