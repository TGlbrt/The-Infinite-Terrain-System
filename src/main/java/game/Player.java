package game;

public class Player {
	private int xLocation;
	private int yLocation;
	private int score;
	
	
	public Player() {
		this.xLocation = 0;
		this.yLocation = 0;
		score = 0;
	}
	
	public int getXLocation() {
		return xLocation;
	}
	
	public int getYLocation() {
		return yLocation;
	}
	
	public void setLocation(int xLocation,int yLocation) {
		this.xLocation = xLocation;
		this.yLocation = yLocation;
	}
	
	public int getScore() {
		return score;
	}
	
	public void incrementScore() {
		score++;
	}
	
	public void decrementScore() {
		score--;
	}
	
}
