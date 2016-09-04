package core;

import pieces.*;
import pieces.impl.*;
import util.Position;

public class ChessBoard {
	private AbstractPiece[][] board; // [ x ] [ y ] 0,0 top left

	ChessBoard() {
		board = new AbstractPiece[8][8];

		for (int i = 0; i < 8; i++)
			board[i][6] = new Pawn(Player.PLAYER_ONE);
		board[0][7] = new Rook(Player.PLAYER_ONE);
		board[1][7] = new Knight(Player.PLAYER_ONE);
		board[2][7] = new Bishop(Player.PLAYER_ONE);
		board[3][7] = new Queen(Player.PLAYER_ONE);
		board[4][7] = new King(Player.PLAYER_ONE);
		board[5][7] = new Bishop(Player.PLAYER_ONE);
		board[6][7] = new Knight(Player.PLAYER_ONE);
		board[7][7] = new Rook(Player.PLAYER_ONE);

		for (int i = 0; i < 8; i++)
			board[i][1] = new Pawn(Player.PLAYER_TWO);
		board[0][0] = new Rook(Player.PLAYER_TWO);
		board[1][0] = new Knight(Player.PLAYER_TWO);
		board[2][0] = new Bishop(Player.PLAYER_TWO);
		board[3][0] = new Queen(Player.PLAYER_TWO);
		board[4][0] = new King(Player.PLAYER_TWO);
		board[5][0] = new Bishop(Player.PLAYER_TWO);
		board[6][0] = new Knight(Player.PLAYER_TWO);
		board[7][0] = new Rook(Player.PLAYER_TWO);

	}

	public void makeMove(final Position from, final Position to) {
		if (to.x >= 8 || to.x < 0 || to.y >= 8 || to.y < 0)
			throw new ArrayIndexOutOfBoundsException("Invalid x,y: " + to.x + "," + to.y);

		AbstractPiece target = getPiece(to);
		if(target != null){
			if (target.getPlayer() == Player.PLAYER_ONE)		return;
			if(target.getPlayer() == Player.PLAYER_TWO){
				//TODO update, an enemy piece has been eaten
			}
		}
		//move it there
		setPiece(from, null); 
		AbstractPiece piece = getPiece(from);
		setPiece(to, piece);
	}

	public AbstractPiece getPiece(Position pos) {
		return board[pos.x][pos.y];
	}

	public void setPiece(Position pos, AbstractPiece piece) {
		board[pos.x][pos.y] = piece;
	}

}
