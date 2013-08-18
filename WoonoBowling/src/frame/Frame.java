package frame;

import java.util.ArrayList;
import java.util.List;

import game.BowlingGame;
import roll.Spare;
import roll.Strike;
import roll.Roll;

public class Frame {
	private List<Roll> rolls = new ArrayList<Roll>();
	private int frameScore;
	private int totalScore;

	public Frame() {
	}

	private boolean isFirstRollStrike (int pinDown) {
		if ( rolls.size() == 0 && pinDown == 10)
			return true;
		else return false;
	}

	private boolean isSecondRoll() {
		if ( rolls.size() == 1 )
			return true;
		else return false;
	}

	private void setRegularFrame(int pinDown) {
		rolls.add(new Roll(pinDown));
		frameScore = rolls.get(0).getPinDown() + rolls.get(1).getPinDown();
		System.out.println("이번 프레임은 오픈 프레임입니다.");
	}

	private void setSpareFrame(int pinDown) {
		rolls.add(new Spare(pinDown));
		frameScore = 10;
		System.out.println("이번 프레임은 스페어입니다.");
	}

	public void setStrikeFrame() {
		rolls.add(new Strike());
		frameScore = 10;
		System.out.println("이번 프레임은 스트라이크입니다.");
	}

	public int getFrameScore() {
		return frameScore;
	}

	public boolean isStrike() {
		if ( rolls.get(0).isStrike() )
			return true;
		else
			return false;
	}

	public boolean isDone() {
		if ( rolls.size() == 2)
			return true;
		else
			return false;
	}

	public void addRoll(int pinDown) {
		if ( isSecondRoll() ) {
			if ( rolls.get(0).getPinDown() + pinDown == 10 )
				setSpareFrame(pinDown);
			else setRegularFrame(pinDown);
		}
		
		else if ( isFirstRollStrike(pinDown) ) setStrikeFrame();
		else rolls.add(new Roll(pinDown));
	}

	public int getNumOfRoll() {
		return rolls.size();
	}

	public String getSymbols() {
		char first = rolls.get(0).getSymbol();
		char second = rolls.get(1).getSymbol();
		String result = Character.toString(first) + Character.toString(second);
		
		return result;
	}
}
