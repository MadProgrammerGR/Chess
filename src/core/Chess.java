package core;

import java.util.ArrayList;

import pieces.*;
import util.Position;

public class Chess {

	private Piece[][] board; // [ x ] [ y ] 0,0 top left

	private Chess() {
		board = new Piece[8][8];

		for (int i = 0; i < 8; i++) {
			board[i][6] = new Pawn(Player.PLAYER_ONE);
		}

		board[0][7] = new Rook(Player.PLAYER_ONE);
		board[1][7] = new Knight(Player.PLAYER_ONE);
		board[2][7] = new Bishop(Player.PLAYER_ONE);
		board[3][7] = new Queen(Player.PLAYER_ONE);
		board[4][7] = new King(Player.PLAYER_ONE);
		board[5][7] = new Bishop(Player.PLAYER_ONE);
		board[6][7] = new Knight(Player.PLAYER_ONE);
		board[7][7] = new Rook(Player.PLAYER_ONE);

		for (int i = 0; i < 8; i++) {
			board[i][1] = new Pawn(Player.PLAYER_TWO);
		}

		board[0][0] = new Rook(Player.PLAYER_TWO);
		board[1][0] = new Knight(Player.PLAYER_TWO);
		board[2][0] = new Bishop(Player.PLAYER_TWO);
		board[3][0] = new Queen(Player.PLAYER_TWO);
		board[4][0] = new King(Player.PLAYER_TWO);
		board[5][0] = new Bishop(Player.PLAYER_TWO);
		board[6][0] = new Knight(Player.PLAYER_TWO);
		board[7][0] = new Rook(Player.PLAYER_TWO);
	}

	public void firstClick(int x, int y) {
		Position position = new Position(x, y);
		if (isOutOfBounds(position))
			throw new IllegalArgumentException("Invalid click x,y: " + position.toString());
		Piece piece = getPiece(position); // get the piece on that location
		if (piece == null)
			return; // user clicked empty square
		if (piece.getPlayer() == Player.PLAYER_TWO)
			return; // user clicked on enemy piece

		ArrayList<Position> moves = new ArrayList<Position>();
		moves = piece.getMoves(position);
		validateMoves(moves);
		// moves are ready for show at this moment
	}

	// finding unvalids and them removing them all together, to avoid remove()
	// inside the iteration
	private void validateMoves(ArrayList<Position> moves) {
		ArrayList<Position> unvalids = new ArrayList<Position>();
		for (Position move : moves) {
			// out of map is not a valid move
			if (isOutOfBounds(move)) {
				unvalids.add(move);
				continue;
			}
			Piece piece = getPiece(move);
			if (piece != null) { // cant move into an our piece
				if (piece.getPlayer() == Player.PLAYER_ONE) {
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
		// TODO .......
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
