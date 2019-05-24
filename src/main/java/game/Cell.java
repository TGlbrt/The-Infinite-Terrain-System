package game;

public class Cell extends Feature{
	private int xLocation;
	private int yLocation;
	//private Feature feature;
	
	public Cell() {
		super();
		xLocation = 0;
		yLocation = 0;
	}
	
	public Cell(int xLocation,int yLocation) {
		super();
		this.xLocation = xLocation;
		this.yLocation = yLocation;
	}
	
	public int getXLocation() {
		return xLocation;
	}
	
	public int getYLocation() {
		return yLocation;
	}
	
}
