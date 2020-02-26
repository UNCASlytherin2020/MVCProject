package app;

public class Model {
	private int asteroidCount;
	private Asteroid[] asteroids;
	private Player player;
	
    public Model() {
    	asteroidCount=0;
    	asteroids = new Asteroid[5];
        
    }
    
    public void addAsteroids() {
    	if(asteroidCount < 5) {
    		asteroidCount++;
    	}
    }
}