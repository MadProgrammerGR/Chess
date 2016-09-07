package core;

import java.util.ArrayList;

import pieces.*;
import util.Position;

public class Chess {

	private Piece[][] board; // [ x ] [ y ] 0,0 top left

	private Chess() {
		board = new Piece[8][8];

		for (int i = 0; i < 8; i++) {
			board[i][6] = new Piece(Player.PLAYER_ONE, PieceType.PAWN);
		}

		board[0][7] = new Piece(Player.PLAYER_ONE, PieceType.ROOK);
		board[1][7] = new Piece(Player.PLAYER_ONE, PieceType.KNIGHT);
		board[2][7] = new Piece(Player.PLAYER_ONE, PieceType.BISHOP);
		board[3][7] = new Piece(Player.PLAYER_ONE, PieceType.QUEEN);
		board[4][7] = new Piece(Player.PLAYER_ONE, PieceType.KING);
		board[5][7] = new Piece(Player.PLAYER_ONE, PieceType.BISHOP);
		board[6][7] = new Piece(Player.PLAYER_ONE, PieceType.KNIGHT);
		board[7][7] = new Piece(Player.PLAYER_ONE, PieceType.ROOK);

		for (int i = 0; i < 8; i++) {
			board[i][1] = new Piece(Player.PLAYER_TWO, PieceType.PAWN);
		}

		board[0][0] = new Piece(Player.PLAYER_TWO, PieceType.ROOK);
		board[1][0] = new Piece(Player.PLAYER_TWO, PieceType.KNIGHT);
		board[2][0] = new Piece(Player.PLAYER_TWO, PieceType.BISHOP);
		board[3][0] = new Piece(Player.PLAYER_TWO, PieceType.QUEEN);
		board[4][0] = new Piece(Player.PLAYER_TWO, PieceType.KING);
		board[5][0] = new Piece(Player.PLAYER_TWO, PieceType.BISHOP);
		board[6][0] = new Piece(Player.PLAYER_TWO, PieceType.KNIGHT);
		board[7][0] = new Piece(Player.PLAYER_TWO, PieceType.ROOK);
	}

	public void firstClick(int x, int y) {
		Position position = new Position(x, y);
		if (isOutOfBounds(position))
			throw new IllegalArgumentException("Invalid click x,y: " + position.toString());
		Piece piece = getPiece(position); // get the piece on that location
		if (piece == null)
			return; // user clicked empty square
		if (piece.player == Player.PLAYER_TWO)
			return; // user clicked on enemy piece

		ArrayList<Position> moves = new ArrayList<Position>();
		PieceType type = piece.type;
		switch (type) {
			case KING:
				moves = MovesManager.getMovesForKING(position);
				break;
			case QUEEN:
				moves = MovesManager.getMovesForQUEEN(position);
				break;
			case BISHOP:
				moves = MovesManager.getMovesForBISHOP(position);
				break;
			case ROOK:
				moves = MovesManager.getMovesForROOK(position);
				break;
			case PAWN:
				moves = MovesManager.getMovesForPAWN(position);
				break;
			case KNIGHT:
				moves = MovesManager.getMovesForKNIGHT(position);
				break;
		}

		validateMoves(moves);
		//moves are ready for show at this moment
	}

	//finding unvalids and them removing them all together, to avoid remove() inside the iteration
	private void validateMoves(ArrayList<Position> moves) {
		ArrayList<Position> unvalids = new ArrayList<Position>();
		for (Position move : moves) {
			// out of map is not a valid move
			if (isOutOfBounds(move)){
				unvalids.add(move);
				continue;
			}
			Piece piece = getPiece(move);
			if (piece != null) {
				if (piece.player == Player.PLAYER_ONE) { //cant move into an our piece, (could be on a single if? no cause cant access player if  piece is null)
					unvalids.add(move);
					continue;
				}
			}
		}
		moves.removeAll(unvalids);
	}

	public void secondClick(int x, int y) {
		Position position = new Position(x, y);
		if (isOutOfBounds(position))
			throw new IllegalArgumentException("Invalid click x,y: " + position.toString());
		//TODO .......
	}

	public void makeMove(final Position from, final Position to) {
		// if (isOutOfBounds(from) || isOutOfBounds(to))
		// throw new ArrayIndexOutOfBoundsException("Invalid From x,y: " +
		// from.toString()+" or To x,y: " + to.toString());
		/*
		 * AbstractPiece target = getPiece(to); if(target != null){ if
		 * (target.getPlayer() == Player.PLAYER_ONE) return;
		 * if(target.getPlayer() == Player.PLAYER_TWO){ //TODO update, an enemy
		 * piece has been eaten } }
		 */

		// move it there
		Piece piece = getPiece(from);
		setPiece(from, null);
		setPiece(to, piece);
	}

	public Piece getPiece(Position pos) {
		return board[pos.x][pos.y];
	}

	public void setPiece(Position pos, Piece piece) {
		board[pos.x][pos.y] = piece;
	}

	public static boolean isOutOfBounds(Position position) {
		return (position.x >= 8 || position.x < 0 || position.y >= 8 || position.y < 0);
	}

}
