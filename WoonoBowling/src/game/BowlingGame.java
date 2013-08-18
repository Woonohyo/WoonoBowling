package game;

import java.util.ArrayList;
import java.util.List;

import frame.Frame;
import frame.LastFrame;

public class BowlingGame {
	private List<Frame> scoreBoard = new ArrayList<Frame>();
	private static int currentFrame = 0;
	private int numOfRoll = 0;

	public void initialize() {
		scoreBoard.add(new Frame());
		scoreBoard.add(new Frame());
		scoreBoard.add(new Frame());
		scoreBoard.add(new Frame());
		scoreBoard.add(new Frame());
		scoreBoard.add(new Frame());
		scoreBoard.add(new Frame());
		scoreBoard.add(new Frame());
		scoreBoard.add(new Frame());
		scoreBoard.add(new LastFrame());
	}

	public void roll(int pinDown) {
		numOfRoll = scoreBoard.get(currentFrame).getNumOfRoll();
		if (numOfRoll == 0)
			System.out.println("이번 프레임은 " + (currentFrame + 1) + "번째 프레임입니다.");
		System.out.print((numOfRoll + 1) + "번째 공을 굴립니다!...........");

		scoreBoard.get(currentFrame).addRoll(pinDown);
		if (scoreBoard.get(currentFrame).isStrike())
			goNextFrame();
		else if (scoreBoard.get(currentFrame).isDone())
			goNextFrame();
	}

	public void goNextFrame() {
		System.out.println("다음 프레임으로 넘어갑니다.\n");
		currentFrame++;
		printScoreBoard();
	}

	private void printScoreBoard() {
		for (int i = 0; i < 10; i++) {
			int frameNum = i + 1;
			String symbols = scoreBoard.get(i).getSymbols();
			int eachFrameScore = scoreBoard.get(i).getFrameScore();
			System.out.format("%2d frame: %3s  Frame Score: %3d\n", frameNum, symbols, eachFrameScore);
		}
		System.out.println("\n\n");
	}

	public int getCurrentFrameNum() {
		return currentFrame + 1;
	}

	public int getFrameScore(int frame) {
		return scoreBoard.get(frame - 1).getFrameScore();
	}

	public Frame getCurrentFrame() {
		return scoreBoard.get(currentFrame - 1);
	}
}
