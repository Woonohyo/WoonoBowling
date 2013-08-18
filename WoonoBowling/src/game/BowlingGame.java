package game;


import java.util.ArrayList;
import java.util.List;

import frame.Frame;

public class BowlingGame {
	private List<Frame> scoreBoard = new ArrayList<Frame>();
	private static int currentFrame = 0;

	public void roll(int pinDown) {
		scoreBoard.add(currentFrame, new Frame(pinDown));
		if (scoreBoard.get(currentFrame).isStrike())
			goNextFrame();
	}

	private void goNextFrame() {
		System.out.println("다음 프레임으로 넘어갑니다.");
		currentFrame++;
	}

	public void calcScore() {
	}

	public int getCurrentFrame() {
		return currentFrame + 1;
	}
}
