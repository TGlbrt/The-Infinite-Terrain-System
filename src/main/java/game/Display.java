package game;

public class Display {
	private String message;
	
	public Display() {
		message = "this is the start of the game, right so your in a swamp that's pretty grey apparently maybe your already dead, who knows\r\n"
				+ "anyway you have a compass and you can go, \r\n north \r\n east \r\n south \r\n west \r\n \r\n choose your path i mean direction";
	}
	
	public boolean showMessage() {
		System.out.println(message + "\r\n");
		return true;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public void updateMessage(String update) {
		message += update;
	}
	
}
