package pacman;
import java.util.HashMap;

import pacman.bonus.BonusObject;
import pacman.bonus.Cherry;
import pacman.bonus.Peach;
import pacman.grid.GridObject;
import pacman.grid.Position;
import pacman.grid.Wall;
import pacman.moving.MovingObject;
import pacman.moving.PacMan;
import pacman.bonus.Pellet;

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
		initFruits();
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
	
	private void initFruits() {
		//TODO place fruits in random positions
			Position pos = getrandvalidPosition();
			 while(gridObjects.containsKey(pos)){
				 pos = getrandvalidPosition();
			 }
			 bonusObjects.put(pos, new Peach());
			 pos = getrandvalidPosition();
			 while(gridObjects.containsKey(pos)){
				 pos = getrandvalidPosition();
			 }
			 bonusObjects.put(pos, new Cherry());
			//TODO place fruits in random positions
			 //TODO NUMBER !!!
		 
		
	}
	
	private void initPellets() {
		//Alle freien Felder mit Pellets belegen
		for(int i =1;i<27;i++){
			for(char j = 'a';j<='z';j++){
				Position p = new Position(j,i);
				if(!gridObjects.containsKey(p)){
					gridObjects.put(p, new Pellet());
				}
			}
		}
	}
	
	private void initGhosts(int numberOfGhosts) {
		int i = 0;
		while(i < numberOfGhosts){
			
		}
	}
	
	private void initPacman() {
		//PacMan an fixer Position platzieren
		Position p = new Position('h', 13);
		if(!gridObjects.containsKey(p)){
			gridObjects.put(p, new PacMan());
		}
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
	
	public Position getrandvalidPosition(){
		
		char x = (char)(Math.random()* (25 - 2) + 2);
		int y = (int) (Math.random()* (25 - 2) + 2);
			
		return new Position(x,y);
	}
	
}
