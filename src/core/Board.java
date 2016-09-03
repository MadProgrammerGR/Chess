package core;

public class Board {

	private Square[][] board; // [ y ] [ x ]

	public Board() {
		this.board = new Square[8][8];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if ( (i + j) % 2 == 0) {
					board[i][j] = new Square(Square.WHITE);
				} else {
					board[i][j] = new Square(Square.BLACK);
				}
			}

		}
	}
	
	public boolean isPositionOccupied(int x, int y){
		return board[y][x].isOccupied();
	}

}
