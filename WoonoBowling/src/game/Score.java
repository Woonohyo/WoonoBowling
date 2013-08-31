package game;

import frame.Frame;
import static game.BowlingGame.CURRENT;
import static game.BowlingGame.PREVIOUS;
import static game.BowlingGame.PREVIOUS2;
import static game.BowlingGame.PREVIOUS3;

public class Score {
	private final int NO_BONUS = 0;
	private final int NO_PREV = 0;

	public void calcTotalScore(BowlingGame game) {
		int currentFrame = game.getCurrentFrameNum();

		if (currentFrame == 1)
			if (!(isBonusScore(game.getFrame(CURRENT))))
				game.getFrame(CURRENT).setTotalScore(NO_BONUS, NO_PREV);

		if (currentFrame == 2) {
			calcPreviousFrame(game);
			calcCurrentFrame(game);
		}

		if (currentFrame == 10) {
			calcPreviousFrame2(game);
			calcPreviousFrame(game);
		}

		if (isElseFrame(currentFrame)) {
			calcPreviousFrame2(game);
			calcPreviousFrame(game);
			calcCurrentFrame(game);
		}
	}

	private boolean isElseFrame(int idx) {
		if (idx > 2 && idx < 10)
			return true;
		return false;
	}

	private void calcCurrentFrame(BowlingGame game) {
		Frame prev = game.getFrame(PREVIOUS);
		Frame current = game.getFrame(CURRENT);
		if (current.isOpen())
			current.setTotalScore(NO_BONUS, prev.getTotalScore());

	}

	private void calcPreviousFrame(BowlingGame game) {
		Frame prev2 = game.getFrame(PREVIOUS2);
		Frame prev = game.getFrame(PREVIOUS);
		Frame current = game.getFrame(CURRENT);

		if (prev.getTotalScore() > 0)
			return;
		
		if (prev.isSpare())
			prev.setTotalScore(addOneBonus(game, 0), prev2.getTotalScore());
		if (prev.isStrike() && !(current.isStrike()))
			prev.setTotalScore(current.getFrameScore(), prev2.getTotalScore());
	}

	private void calcPreviousFrame2(BowlingGame game) {
		Frame prev2 = game.getFrame(PREVIOUS2);
		Frame prev3 = game.getFrame(PREVIOUS3);

		if (prev2.getTotalScore() > 0)
			return;

		if (prev2.isStrike())
			prev2.setTotalScore(addTwoBonus(game), prev3.getTotalScore());
		else if (prev2.isSpare())
			prev2.setTotalScore(addOneBonus(game, 1), prev3.getTotalScore());
	}

	private int addOneBonus(BowlingGame game, int adjust) {
		return game.getFrame(CURRENT + adjust).getFirstPinDown();
	}

	private int addTwoBonus(BowlingGame game) {
		Frame prev = game.getFrame(PREVIOUS);
		Frame current = game.getFrame(CURRENT);
		int firstBonus = 0;
		int secondBonus = 0;

		firstBonus = prev.getFirstPinDown();

		if (prev.isStrike())
			secondBonus = current.getFirstPinDown();
		else
			secondBonus = prev.getSecondPinDown();

		return (firstBonus + secondBonus);
	}

	private boolean isBonusScore(Frame frame) {
		if (frame.isStrike())
			return true;

		if (frame.isSpare())
			return true;

		return false;
	}
}
