package pacman.moving;

import pacman.Game;
import pacman.grid.Direction;
import pacman.grid.GridObject;
import pacman.grid.Position;

public abstract class MovingObject extends GridObject {

	private int speed = 1;

	private Direction currentDirection;

	public void move() {

		Position nextPosition = null;

		switch (currentDirection) {
		case LEFT:
			nextPosition = Position.nextLeft(getPosition());
			break;
		case RIGHT:
			nextPosition = Position.nextRight(getPosition());
			break;
		case UP:
			nextPosition = Position.nextUp(getPosition());
			break;
		case DOWN:
			nextPosition = Position.nextDown(getPosition());
			break;
		default:
			break;
		}

		// if position is valid grid position
		if (Position.isValidPosition(nextPosition)) {
			// TODO: check if object can move to position
			if (!Game.getInstance().getGridObjects().containsKey(nextPosition)) {
				// move to position
				setPosition(nextPosition);
			} else {
				//TODO:
				// gridObject is in the way - object cannot move to position
				//log event
			}
		} else {
			// TODO:
			// moving object wants to leave grid
			// log event
		}

	}

	public void setDirection(Direction direction) {
		this.currentDirection = direction;
	}

	public Direction getDirection() {
		return this.currentDirection;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getSpeed() {
		return speed;
	}

}