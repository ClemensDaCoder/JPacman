package pacman;
import java.util.HashMap;

import pacman.bonus.BonusObject;
import pacman.grid.GridObject;
import pacman.grid.Position;
import pacman.grid.Wall;
import pacman.moving.MovingObject;

public class Game {
	
	private static Game instance = null;

	private HashMap<Position, MovingObject> movingObjects;
	
	private HashMap<Position, GridObject> gridObjects;
	
	private Integer score;
	
	private HashMap<Position, BonusObject> bonusObjects;
	
	private Game() {
		score = 0;
		init();
	}
	
	private void init() {
		//create maze at first
		initMaze();
		//set pacman to his start position
		initPacman();
		//place fruit(s) random in maze
		initFruits(1);
		//fill remaining positions of maze with pellets
		initPellets();
		//place ghost(s) random in maze
		initGhosts(2);
	}
	
	private void initMaze() {
		//TODO: fill Hashmap gridObjects with WallObjects
		for (int i = 1; i < 27; i ++)
		{
		gridObjects.put(new Position('a',i), new Wall());
		gridObjects.put(new Position('z',i), new Wall());
		}

		for(char i = 'a'; i <= 'z'; i ++)
		{
			gridObjects.put(new Position(i, 1), new Wall());
			gridObjects.put(new Position(i, 26), new Wall());
		}
	}
	
	private void initFruits(int numberOfFruits) {
		//TODO place fruits in random positions
	}
	
	private void initPellets() {
		//TODO place pellets
	}
	
	private void initGhosts(int numberOfGhosts) {
		//TODO place ghosts
	}
	
	private void initPacman() {
		//TODO set pacman
		
	}
	
	public static Game getInstance() {
		if (instance == null) {
			instance = new Game();
		}
		return instance;
	}



	public void startGame() {
	}

	public void nextMove() {
		while (hasRemainingBonusObjects()) {
			//TODO: new input etc
		}
	}

	public void endGame() {
		
	}

	public void nextLevel() {
		init();
	}

	private boolean hasRemainingBonusObjects() {
		return !bonusObjects.isEmpty();
	}
	
	public HashMap<Position, GridObject> getGridObjects() {
		return gridObjects;
	}	
	
	public HashMap<Position, MovingObject> getMovingObjects() {
		return movingObjects;
	}
	
	public HashMap<Position, BonusObject> getBonusObjects() {
		return bonusObjects;
	}
	
	public void increaseScore(int value) {
		score += value;
	}
	
	public int getScore() {
		return score;
	}
	
}