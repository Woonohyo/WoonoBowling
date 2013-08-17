package roll;

public class Roll {
	protected char symbol;
	protected int pinDown;
	
	public Roll() {
		symbol = ' ';
	}

	public Roll(int pinDown) {
		this.pinDown = pinDown;
		this.symbol = (char)(pinDown + '0');
	}

	public char getSymbol() {
		return symbol;
	}

	public boolean isStrike() {
		if ( symbol == 'X' )
			return true;
		else 
			return false;
	}

	public int getPinDown() {
		return pinDown;
	}
}
