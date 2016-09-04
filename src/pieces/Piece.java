package pieces;

import util.Position;

public abstract class Piece implements PieceLogic{
	private Position boardPosition;

	public void makeMove(Position newPosition){
		if(this.isMoveValid(this.boardPosition, newPosition)){
			this.boardPosition = newPosition;
		}
	}
}
