package core;

public class Square {

	private boolean occupied;
	public static final int BLACK = 0;
	public static final int WHITE = 1;
	private int color;
	
	public Square (int color) {
		this.color = color;
		this.occupied = false;
	}
	
	public boolean isOccupied(){
		return occupied;
	}
	
	public int getColor(){
		return color;
	}
	
}
