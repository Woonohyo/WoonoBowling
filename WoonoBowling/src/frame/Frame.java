package frame;

import game.BowlingGame;
import roll.Strike;
import roll.Roll;

public class Frame {
	private Roll firstRoll = null;
	private Roll secondRoll = null;
	private int frameScore;
	private int totalScore;
	private int currentPin = 10;

	public Frame() {
	}

	public Frame(int pinDown) {
		if ( firstRoll != null ) {
			secondRoll = new Roll(pinDown);
			BowlingGame.goNextFrame();
		}
		
		else if ( firstRoll == null) {
			if ( pinDown == 10 )
				setStrike();
			else 
				firstRoll = new Roll(pinDown);
		}
	}

	public void setStrike() {
		firstRoll = new Strike();
		frameScore = 10;
	}

	public int getScore() {
		if (firstRoll.isStrike())
			return frameScore;
		else
			return 0;
	}

	public boolean isStrike() {
		if ( firstRoll.isStrike() )
			return true;
		else
			return false;
	}
}
