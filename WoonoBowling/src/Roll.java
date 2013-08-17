
public class Roll {
	private char score;

	Roll() {
		this.score = ' ';
	}
	
	private Roll(char score) {
		this.score = score;
	}
	
	public static Roll generateStrike() {
		return new Roll('X');
	}


	public static Roll generateSpare() {
		return new Roll('/');
	}

	public static Roll generateGutter() {
		return new Roll('-');
	}

	public char getScore() {
		return this.score;
	}

	public static Roll pinDown(int pinDown) {
		char score = (char)(pinDown + 48);
		return new Roll(score);
	}

	public int getIntScore() {
		if (score == ' ')
			return 0;
		else 
			return (int)(score - 48);
	}

	public boolean isStrike() {
		if (this.score == 'X')
			return true;
		else
			return false;
	}
}
