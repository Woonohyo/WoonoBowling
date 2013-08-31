package frame;

import java.util.ArrayList;
import java.util.List;
import roll.Roll;
import roll.Spare;
import roll.Strike;


public class LastFrame extends Frame {
	private List<Roll> rolls = new ArrayList<Roll>();
	private int frameScore = 0;
	private int totalScore = 0;
	private boolean isFrameDone = false;

	public LastFrame() {
	}

	public boolean isDone() {
		return isFrameDone;
	}

	public void addRoll(int pinDown) throws GameOverException {
		if ( isLastRoll() ) {
			if ( pinDown == 10 ) rolls.add(new Strike());
			else rolls.add(new Roll(pinDown));
			endThisFrame();
		}
		
		else if ( isSecondRoll() ) {
			if ( (rolls.get(0).getPinDown() + pinDown) < 10 && (rolls.get(0).isStrike() == false) ) {
				rolls.add(new Roll(pinDown));
				endThisFrame();
			}
			else if ( rolls.get(0).getPinDown() + pinDown == 10 )
				rolls.add(new Spare(pinDown));
			else if ( pinDown == 10 )
				rolls.add(new Strike());
		}
		
		else if ( pinDown == 10 ) rolls.add(new Strike());
		else rolls.add(new Roll(pinDown));
	}

	private void endThisFrame() throws GameOverException {
		for ( int i = 0; i < rolls.size(); i++ )
			frameScore += rolls.get(i).getPinDown();
		isFrameDone = true;
		//throw new GameOverException("게임이 종료되었습니다.");
	}

	private boolean isLastRoll() {
		if ( rolls.size() == 2 )
			return true;
		return false;
	}

	public String getSymbols() {
		char first = ' ';
		char second = ' ';
		char third = ' ';
		
		if (rolls.size() >= 1)
			first = rolls.get(0).getSymbol();
		if (rolls.size() >= 2)
			second = rolls.get(1).getSymbol();
		if (rolls.size() >= 3)
			third = rolls.get(2).getSymbol();

		String result = Character.toString(first) + " " + Character.toString(second) + " " + Character.toString(third);
		return result;
	}
	
	public int getFrameScore() {
		return frameScore;
	}
	
	protected boolean isSecondRoll() {
		if (rolls.size() == 1)
			return true;
		else
			return false;
	}
	
	public boolean isStrike() {
		if (rolls.get(0).isStrike())
			return true;
		else
			return false;
	}
	
	public int getNumOfRoll() {
		return rolls.size();
	}
	
}