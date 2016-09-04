package core;

import core.ChessBoard;

public abstract class Piece implements PieceLogic {

	protected ChessBoard board;
	protected boolean enemy;
	protected Position pos;

	public void makeMove(final Position target){
		if(target.x >=8 || target.x < 0 || target.y >=8 || target.y < 0) throw new ArrayIndexOutOfBoundsException("Invalid x,y: "+target.x+","+target.y);
		board.setPiece(pos, null); //empty the previous position
		if(board.getPiece(target).isEnemy()){
			//enemy piece has been eaten
		}
		board.setPiece(target, this);
		pos.x = target.x;
		pos.y = target.y;
		//move it there
	}

	public boolean isEnemy() {
		return enemy;
	}

}
