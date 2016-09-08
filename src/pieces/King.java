package pieces;

import java.util.ArrayList;

import util.Position;

public class King implements Piece {

	private Player player;

	public King(Player player) {
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
