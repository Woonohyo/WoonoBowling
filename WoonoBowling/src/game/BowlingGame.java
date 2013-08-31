package game;

import java.util.ArrayList;
import java.util.List;

import frame.Frame;
import frame.Frame;
import frame.GameOverException;
import frame.LastFrame;

public class BowlingGame {
	public static int TOTAL_SCORE = 0;
	public static int CURRENT = 0;
	public static int PREVIOUS = 1;
	public static int PREVIOUS2 = 2;
	public static int PREVIOUS3 = 3;
	private List<Frame> scoreBoard = new ArrayList<Frame>();
	private static int currentFrame;
	private int numOfRoll;
	private Score score = new Score();


	public BowlingGame() {
		currentFrame = 0;
		numOfRoll = 0;
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

	public void roll(int pinDown) throws GameOverException {
		printStatus();
		scoreBoard.get(currentFrame).addRoll(pinDown);
		if (currentFrame < 9 && scoreBoard.get(currentFrame).isStrike())
			goNextFrame();
		if (currentFrame < 9 && scoreBoard.get(currentFrame).isDone())
			goNextFrame();
		if (currentFrame == 9 && scoreBoard.get(currentFrame).isDone())
			endGame();
	}

	private void printStatus() {
		numOfRoll = scoreBoard.get(currentFrame).getNumOfRoll();
		if (numOfRoll == 0)
			System.out.println("이번 프레임은 " + (currentFrame + 1) + "번째 프레임입니다.");
		System.out.print((numOfRoll + 1) + "번째 공을 굴립니다!...........");
	}

	private void endGame() {
		score.calcLastFrame(this);
		printScoreBoard();
		System.out.println("Game End");
	}

	public void goNextFrame() {
		System.out.println("다음 프레임으로 넘어갑니다.\n");
		score.calcTotalScore(this);
		printScoreBoard();
		currentFrame++;
	}

	public void printScoreBoard() {
		for (int i = 0; i < 10; i++) {
			int frameNum = i + 1;
			String symbols = scoreBoard.get(i).getSymbols();
			int eachFrameScore = scoreBoard.get(i).getFrameScore();
			int eachTotalScore = scoreBoard.get(i).getTotalScore();

			System.out.format("%2d frame: %6s  Frame Score: %3d  Total Score: %3d\n", frameNum,
					symbols, eachFrameScore, eachTotalScore);
		}
		System.out.println("\n\n");
	}

	public int getCurrentFrameNum() {
		return currentFrame + 1;
	}

	public int getFrameScore(int frame) {
		return scoreBoard.get(frame - 1).getFrameScore();
	}

	public Frame getFrame(int adjust) {
		int index = currentFrame - adjust;
		if (currentFrame - adjust < 0)
			return new Frame();
		return scoreBoard.get(index);
	}

}
