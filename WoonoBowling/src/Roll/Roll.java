package Roll;

public class Roll {
	protected char symbol;
	
	public Roll() {
	}

	public Roll(int pinDown) {
		this.symbol = (char)(pinDown + 48);
	}

	public char getSymbol() {
		return symbol;
	}
}
