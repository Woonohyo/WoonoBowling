import java.util.ArrayList;
import java.util.List;

public class Frame {
	private int frameScore;
	
	private List<Roll> Rolls = new ArrayList<Roll>();
	
	public Frame() {
		Rolls.add(0, new Roll());
		Rolls.add(1, new Roll());
	}
	
	public List<Roll> generateStrike() {
		Rolls.set(0, Roll.generateStrike());
		return Rolls;
	}

	public int getFrameScore() {
		if( Rolls.get(0).isStrike() )
			return frameScore = 10;
		else 
			this.frameScore = Rolls.get(0).getIntScore() + Rolls.get(1).getIntScore();
		return frameScore;
	}

	public void setEmpty() {
		this.frameScore = 0;
	}
}
