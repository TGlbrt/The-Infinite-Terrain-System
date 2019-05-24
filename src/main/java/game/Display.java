package game;

public class Display {
	private String message;
	
	public Display() {
		message = "this is the start of the game";
	}
	
	public boolean showMessage() {
		System.out.println(message);
		return true;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public void updateMessage(String update) {
		message += update;
	}
	
}
