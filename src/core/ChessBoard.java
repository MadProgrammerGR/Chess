package core;

import coreTest.Pieces.King;

public class ChessBoard {
	private Piece[][] board; // [ x ] [ y ] 0,0 top left
	
	ChessBoard() {
		board = new Piece[8][8];

		for (int i = 0; i < 8; i++)
			board[i][6] = new Pawn(this, false, new Position(i,6));
		board[0][7] = new Rook(this, false, new Position(0,6));
		board[1][7] = new Knight(this, false, new Position(1,6));
		board[2][7] = new Bishop(this, false, new Position(2,6));
		board[3][7] = new Queen(this, false, new Position(3,6));
		board[4][7] = new King(this, false, new Position(4,6));
		board[5][7] = new Bishop(this, false, new Position(5,6));
		board[6][7] = new Knight(this, false, new Position(6,6));
		board[7][7] = new Rook(this, false, new Position(7,6));

		for (int i = 0; i < 8; i++)
			board[i][1] = new Pawn(this, true, new Position(i,6));
		board[0][0] = new Rook(this, true, new Position(0,6));
		board[1][0] = new Knight(this, true, new Position(1,6));
		board[2][0] = new Bishop(this, true, new Position(2,6));
		board[3][0] = new Queen(this, true, new Position(3,6));
		board[4][0] = new King(this, true, new Position(4,6));
		board[5][0] = new Bishop(this, true, new Position(5,6));
		board[6][0] = new Knight(this, true, new Position(6,6));
		board[7][0] = new Rook(this, true, new Position(7,6));

	}

	public Piece getPiece(Position pos) {
		return board[pos.x][pos.y];
	}

	public void setPiece(Position pos, Piece piece) {
		board[pos.x][pos.y] = piece;
	}

}
