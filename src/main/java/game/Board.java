package game;

import java.util.HashMap;

public class Board {
	private HashMap<String,Cell> gameMap;
	
	
	public Board() {
		gameMap = new HashMap<String,Cell>();
		//populate the map with the starting cell
		gameMap.put("0,0", new Cell(0,0));
	}
	
	public Cell getCell(int xLocation, int yLocation) {
		return gameMap.get(String.valueOf(xLocation) + "," + String.valueOf(yLocation));
	}
	
	public void setCell(int xLocation,int yLocation) {
		gameMap.putIfAbsent(String.valueOf(xLocation) + "," + String.valueOf(yLocation), new Cell(xLocation,yLocation));
	}
	
}
