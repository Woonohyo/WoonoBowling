package roll;

public class Roll {
	protected char symbol;
	
	public Roll() {
		symbol = ' ';
	}

	public Roll(int pinDown) {
		this.symbol = (char)(pinDown + 48);
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
}
