package pacman.grid;

public abstract class GridObject {

	protected Position position;
	
	public Position getPosition() {
		return position;
	}
	
	public void setPosition(Position pos) {
		this.position = pos;
	}

}