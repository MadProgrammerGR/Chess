package pieces;

import java.util.ArrayList;

import util.Position;

public class Queen implements Piece {

	private Player player;

	public Queen(Player player) {
		this.player = player;
	}

	@Override
	public Player getPlayer() {
		return player;
	}

	@Override
	public ArrayList<Position> getMoves(Position origin) {
		// TODO Auto-generated method stub
		return null;
	}

}
