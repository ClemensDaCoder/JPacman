package pacman.moving;

import pacman.Game;

public class RandomGhost extends AbstractGhost {
	
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
}