package game;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestGame {
	static Game game;
	
	@Before
	public void setup() {
		game = new Game();
	}
	
	@Test
	public void testCell() {
		Cell cell = new Cell(0,0);
		assertEquals("test cell error",0,cell.getXLocation());
	}
	
	
	@Test
	public void testBoard() {
		Board board = new Board();
		assertEquals("test Board error",0,board.getCell(0,0).getXLocation());
	}
	
	@Test
	public void testPlayer() {
		Player player = new Player();
		//a new player by default will have an x and y location of 0 
		assertEquals("test player error",0,player.getXLocation());
	}
	
	@Test
	public void testGame() {
		game = new Game();
		assertEquals("test game error","0,0",game.getPlayerLocation());
	}
	
	@Test
	public void testChangePlayerLocation() {
		game.setPlayerLocation(1,0);
		assertEquals("test change player location error","1,0",game.getPlayerLocation());
	}
	
	@Test
	public void testGoesPlayerDirection() {
		String oldDirection = game.getPlayerLocation();
		Action direction = Action.NORTH;
		//System.out.println(oldDirection);
		game.newDirection(direction);
		//System.out.println(game.getPlayerLocation());
		assertNotEquals("test player goes direction",oldDirection,game.getPlayerLocation());
	}
	
	@Test
	public void testGetPlayerInput() {
		//not an automated test
		String oldDirection = game.getPlayerLocation();
		game.getPlayerAction();
		assertNotEquals("test get player input error",oldDirection,game.getPlayerLocation());
	}
	
	@Test
	public void testEncounter() {
		assertNotEquals("test encounter error","",game.getFeatureType());
		assertNotEquals("test encounter error","",game.getFeatureEffect());
	}
	
	@Test
	public void startWinCondition() {
		assertEquals("test win condition at start error",false,game.getState());
	}
	
	@Test
	public void testDisplay() {
		assertEquals("test display at start error",true,game.displayGame());
	}
	
	@Test
	public void testPlayerScore() {
		int oldScore = game.getPlayerScore();
		//System.out.println("old score : " + oldScore);
		do {
			Action direction = Action.NORTH;
			game.newDirection(direction);
		}while(oldScore == game.getPlayerScore());
		
		//System.out.println("new score : " + game.getPlayerScore());
		assertNotEquals("test player score",oldScore,game.getPlayerScore());
	}
	
}
