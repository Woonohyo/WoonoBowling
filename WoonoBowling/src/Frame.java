import java.util.ArrayList;
import java.util.List;

import Roll.Roll;

public class Frame {
	private List<Roll> Rolls = new ArrayList<Roll>();
	
	Frame() {
	}

	public void initialize() {
		Rolls.add(new Roll());
		Rolls.add(new Roll());
	}

	public int getSize() {
		return Rolls.size();
	}
}
