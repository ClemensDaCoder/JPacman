package pacman.moving;

import pacman.Game;
import pacman.bonus.BonusObject;

public class PacMan extends MovingObject {

	public void eat() {
		// if there is something to eat - else nothing to do here
		if (Game.getInstance().getBonusObjects().containsKey(position)) {
			// eat it ... eat it...
			BonusObject bonusObject = Game.getInstance().getBonusObjects().get(position);
			// increase score by eating bonus object
			Game.getInstance().increaseScore(bonusObject.getValue());
			// remove bonus object from grid
			Game.getInstance().getBonusObjects().remove(position);
		}
	}

	@Override
	public void move() {
		super.move();
		eat();
	}

}