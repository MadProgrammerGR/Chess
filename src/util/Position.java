package util;

public class Position {
	public int x;
	public int y;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public boolean isOutOfBounds() {
		return (x >= 8 || x < 0 || y >= 8 || y < 0);
	}

	public boolean equals(Position other) {
		return x == other.x && y == other.y;
	}

	@Override
	public String toString() {
		return "[" + x + "," + y + "]";
	}

}
