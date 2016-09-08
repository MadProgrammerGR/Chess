package pieces;

import java.util.ArrayList;

import util.Position;

public interface Piece {

	public Player getPlayer();

	public ArrayList<Position> getMoves(Position origin);

}
