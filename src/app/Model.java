package app;

public class Model {
	private int asteroidCount;
	private Asteroid[] asteroids;
	private int playerCount;
	private Player[] players;
	
    public Model() {
    	asteroidCount=0;
		asteroids = new Asteroid[5];

		playerCount = 1; //start with one player
		players = new Player[2]; //allow support for 2 players?
		players[0] = new Player(10, 10);//initialize a player 1.
        
    }
    public void deleteAsteroids() {
    	
	}
	
	public void addAsteroids() {
    	if(asteroidCount < 5) {
    		asteroidCount++;
    	}
	}
	
	public Player[] getPlayers() {
		return players;
	}
	/**
	 * Gets all the displayable objects in the model for rendering to the view.
	 * @return - ModelObject array
	 */
	public ModelObject[] getObjectsInModel() {
		ModelObject objects[] = new ModelObject[asteroidCount+playerCount];
		for (int i = 0; i < playerCount; i++) {
			objects[i] = players[i];
		}
		for (int i = 0; i < asteroidCount; i++) {
			objects[i + playerCount] = asteroids[i];
		}
		return objects;
	}
}