package pieces;

import java.util.ArrayList;

import util.Position;

public class Rook implements Piece {

	private Player player;

	public Rook(Player player) {
		this.player = player;
	}
	
	public Player getPlayer(){
		return player;
	}

	@Override
	public ArrayList<Position> getMoves(Position origin) {
		// TODO Auto-generated method stub
		return null;
	}

}
