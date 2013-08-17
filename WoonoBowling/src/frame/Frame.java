package frame;
import java.util.ArrayList;

import roll.Strike;

import java.util.List;

import roll.Roll;

public class Frame {
	private List<Roll> Rolls = new ArrayList<Roll>();
	private int frameScore;
	
	public Frame() {
	}

	public void initialize() {
		Rolls.add(new Roll());
		Rolls.add(new Roll());
	}

	public int getSize() {
		return Rolls.size();
	}
	
	public void setStrike() {
		Rolls.add(new Strike());
		Rolls.add(new Roll());
		frameScore = 10;
	}

	public int getScore() {
		if ( Rolls.get(0).isStrike() )
			return frameScore;
		else
			return 0;
		}

	private boolean isStrike() {
		return false;
	}
}
