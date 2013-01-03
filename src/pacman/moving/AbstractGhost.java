package pacman.moving;
import java.awt.Color;

import pacman.Game;

public abstract class AbstractGhost extends MovingObject {

	private Color color;

	@Override
	public void move() {
		super.move();
		kill();
	}
	
	private void kill() {
		//kill kill kill!
		if (Game.getInstance().getMovingObjects().containsKey(position)) {
			MovingObject movingObject = Game.getInstance().getMovingObjects().get(position);
			if (movingObject instanceof PacMan) {
				//it's over now!
				Game.getInstance().endGame();
			}
		}
	}
	
	public Color getColor() {
		return color;
	}

}