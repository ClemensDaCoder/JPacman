package pacman.grid;

public class Position {

	private int y;

	private char x;
	
	
	public Position(char x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public static Position nextRight(Position pos) {
		return new Position((char)(pos.x + 1), pos.y);
	}
	
	public static Position nextLeft(Position pos) {
		return new Position((char)(pos.x - 1), pos.y);
	}	
	
	public static Position nextUp(Position pos) {
		return new Position(pos.x, pos.y + 1);
	}
	
	public static Position nextDown(Position pos) {
		return new Position(pos.x, pos.y - 1);
	}
	
	public int getY() {
		return y;
	}
	
	public Character getX() {
		return x;
	}
	
	public static boolean isValidPosition(Position pos) {
		//TODO: check if position is valid
		return true;
	}

}