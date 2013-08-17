
public class Roll {
	private char score;

	private Roll() {
		this.score = ' ';
	}
	
	private Roll(char score) {
		this.score = score;
	}
	
	public static Roll generateStrike(int frame, int roll) {
		return new Roll('X');
	}

	public char getScore() {
		return this.score;
		
	}
}
