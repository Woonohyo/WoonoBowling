package frame;

import java.util.ArrayList;
import java.util.List;

import roll.Spare;
import roll.Strike;
import roll.Roll;

public class Frame {
	private List<Roll> rolls = new ArrayList<Roll>();
	private int frameScore = 0;
	private int totalScore = 0;

	public Frame() {
	}

	public void addRoll(int pinDown) throws GameOverException {
		if (isSecondRoll()) {
			if (rolls.get(0).getPinDown() + pinDown == 10)
				setSpareFrame(pinDown);
			else setRegularFrame(pinDown);
		}
		
		else if (isFirstRollStrike(pinDown)) setStrikeFrame();
		else rolls.add(new Roll(pinDown));
	}
	
	private boolean isFirstRollStrike(int pinDown) {
		if (rolls.size() == 0 && pinDown == 10)
			return true;
		else
			return false;
	}

	protected boolean isSecondRoll() {
		if (rolls.size() == 1)
			return true;
		else
			return false;
	}

	public void setRegularFrame(int pinDown) {
		rolls.add(new Roll(pinDown));
		frameScore = rolls.get(0).getPinDown() + rolls.get(1).getPinDown();
		System.out.println("이번 프레임은 오픈 프레임입니다.");
	}

	public void setSpareFrame(int pinDown) {
		rolls.add(new Spare(pinDown));
		frameScore = 10;
		System.out.println("이번 프레임은 스페어입니다.");
	}

	public void setStrikeFrame() {
		rolls.add(new Strike());
		frameScore = 10;
		System.out.println("이번 프레임은 스트라이크입니다.");
	}

	public boolean isStrike() {
		if (rolls.get(0).isStrike())
			return true;
		else
			return false;
	}
	
	public int getFrameScore() {
		return frameScore;
	}

	public boolean isSpare() {
		if (rolls.size() == 1)
			return false;
		if (rolls.get(1).isSpare())
			return true;
		else
			return false;
	}

	public boolean isOpen() {
		if (isSpare() || isStrike())
			return false;
		else
			return true;
	}

	public boolean isDone() {
		if (rolls.size() == 2)
			return true;
		else
			return false;
	}


	public int getNumOfRoll() {
		return rolls.size();
	}

	public String getSymbols() {
		char first = ' ';
		char second = ' ';
		
		if (rolls.size() >= 1)
			first = rolls.get(0).getSymbol();
		if (rolls.size() == 2)
			second = rolls.get(1).getSymbol();

		String result = Character.toString(first) + " " + Character.toString(second) + "  ";
		return result;
	}

	public void setTotalNull() {
		this.totalScore = '\0';
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int bonusScore, int prevScore) {
		this.totalScore = frameScore + bonusScore + prevScore;
	}

	public int getFirstPinDown() {
		return rolls.get(0).getPinDown();
	}

	public int getSecondPinDown() {
		return rolls.get(1).getPinDown();
	}

	public void addPrevTotal(int prevTotal) {
		this.totalScore += prevTotal;
	}
}
