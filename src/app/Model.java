package app;

public class Model {
	private int maxAsteroidCount = 10;
	private ModelObject[] asteroids;
	private int playerCount;
	private Player[] players;
	
    public Model() {
		asteroids = new ModelObject[maxAsteroidCount];

		playerCount = 1; //start with one player
		players = new Player[2]; //allow support for 2 players?
		players[0] = new Player(100, 100, 50, 50);//initialize a player 1.
        
    }
    public void cleanModel() {
    	for (int i = 0; i < asteroids.length; i++) {
			if (asteroids[i] !=null && asteroids[i].doDelete()) {
				System.out.println("Deleted: " + asteroids[i].getX());
				asteroids[i] = null;
				
			}
		}
	}

	public void setupAsteroid(int width, int height) {
		for (int i = 0; i < 5; i++) {
			this.addObject(new Asteroid((int)(Math.random() * width), (int)(Math.random() * height)));
		}
	}
	
	public void addObject(ModelObject a) {
		for (int i = 0; i < asteroids.length; i++) {
			if (asteroids[i] == null) {
				asteroids[i] = a;
				System.out.println(asteroids[i].getX() + " " + a.getX() + " " + a.doDelete());
				break;
			}
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
		ModelObject objects[] = new ModelObject[maxAsteroidCount+playerCount];
		for (int i = 0; i < playerCount; i++) {
				objects[i] = players[i];
		}
		for (int i = 0; i < maxAsteroidCount; i++) {
			objects[i + playerCount] = asteroids[i];
		}
		return objects;
	}
}