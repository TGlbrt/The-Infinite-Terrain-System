package game;

public class GameDriver {

	public static void main(String[] args) {
		Game theGame = new Game();
		do {
			theGame.getPlayerAction();
		}while(!theGame.getState());
	}

}
