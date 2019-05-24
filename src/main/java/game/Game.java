package game;

import java.util.Scanner;

public class Game {
	private Board gameBoard;
	private Player thePlayer;
	private boolean state;
	private Display display;
	
	public Game() {
		gameBoard = new Board();
		thePlayer = new Player();
		state = false;
		display = new Display();
		display.showMessage();
	}
	
	public String getPlayerLocation() {
		return String.valueOf(thePlayer.getXLocation()) + "," + String.valueOf(thePlayer.getYLocation());
	}
	
	public void setPlayerLocation(int xLocation,int yLocation) {
		thePlayer.setLocation(xLocation,yLocation);
		gameBoard.setCell(xLocation, xLocation);
	}
	
	public void newDirection(Action action) {
		//System.out.println("player action is : " + action.toString());
		switch (action){
			case NORTH:
				setPlayerLocation(thePlayer.getXLocation(),thePlayer.getYLocation()+1);
				gameBoard.setCell(thePlayer.getXLocation(), thePlayer.getYLocation());
				//System.out.println(gameBoard.getCell(thePlayer.getXLocation(), thePlayer.getYLocation()).getYLocation());
				updatePlayerScore();
				display.setMessage("you found a " + getFeatureName() + " it " + getFeatureEffect() + " your new score is " + thePlayer.getScore());
				break;
			case EAST:
				setPlayerLocation(thePlayer.getXLocation()+1,thePlayer.getYLocation());
				gameBoard.setCell(thePlayer.getXLocation(), thePlayer.getYLocation());
				updatePlayerScore();
				display.setMessage("you found a " + getFeatureName() + " it " + getFeatureEffect() + " your new score is " + thePlayer.getScore());
				break;
			case SOUTH:
				setPlayerLocation(thePlayer.getXLocation()+1,thePlayer.getYLocation()-1);
				gameBoard.setCell(thePlayer.getXLocation(), thePlayer.getYLocation());
				updatePlayerScore();
				display.setMessage("you found a " + getFeatureName() + " it " + getFeatureEffect() + " your new score is " + thePlayer.getScore());
				break;
			case WEST:
				setPlayerLocation(thePlayer.getXLocation()-1,thePlayer.getYLocation());
				gameBoard.setCell(thePlayer.getXLocation(), thePlayer.getYLocation());
				updatePlayerScore();
				display.setMessage("you found a " + getFeatureName() + " it " + getFeatureEffect() + " your new score is " + thePlayer.getScore());
				break;
			default :
				break;
				//setPlayerLocation(thePlayer.getXLocation(),thePlayer.getYLocation());
				//System.out.println("not an applicable action");
		}
	}
	
	public void getPlayerAction() {
		System.out.println("What do you do?");
		Scanner s = new Scanner(System.in);
		Action playerAction = null;
		//System.out.println(Action.valueOf(input.toUpperCase()));
		boolean actionTaken = false;
		do {
			//try {
				String input = s.nextLine();
				playerAction = Action.valueOf(input.toUpperCase());
				
				actionTaken = true;
			//}catch(Exception e) {
				//e.printStackTrace();
			//}
		}while(!actionTaken);
		newDirection(playerAction);
		//s.close();
		//display.showMessage();
		if(getPlayerScore() > 2) {
			display.updateMessage("\r\n hey, you live, well done on not dying");
			state = true;
		}else if(getPlayerScore() < -2) {
			display.updateMessage("\r\n oh no you DIED");
			state = true;
			//throw new gameEndException();
		}
		display.showMessage();
	}
	
	public String getFeatureName() {
		return gameBoard.getCell(thePlayer.getXLocation(), thePlayer.getYLocation()).getName();
	}
	
	public String getFeatureType() {
		return gameBoard.getCell(thePlayer.getXLocation(), thePlayer.getYLocation()).getType().name().toLowerCase();
	}
	
	public String getFeatureEffect() {
		return gameBoard.getCell(thePlayer.getXLocation(), thePlayer.getYLocation()).getEffect();
	}
	
	public boolean getState() {
		return state;
	}
	
	public boolean displayGame() {
		return display.showMessage();
	}
	
	public void updatePlayerScore() {
		//System.out.println("updatePlayerScore called");
		if(getFeatureType().equals(FeatureTypes.GOOD.name().toLowerCase())) {
			thePlayer.incrementScore();
		}else if(getFeatureType().equals(FeatureTypes.BAD.name().toLowerCase())){
			thePlayer.decrementScore();
		}else if(getFeatureType().equals(FeatureTypes.OHDEARGODWHY.name().toLowerCase())){
			for(int i = 0;i < 10;i++) {
				thePlayer.decrementScore();
			}
		}else if(getFeatureType().equals(FeatureTypes.VERYGOOD.name().toLowerCase())){
			for(int i = 0;i < 2;i++) {
				thePlayer.incrementScore();
			}
		}
	}
	
	public int getPlayerScore() {
		return thePlayer.getScore();
	}
}
