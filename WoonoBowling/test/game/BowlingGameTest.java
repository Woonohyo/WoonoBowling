package game;

import frame.GameOverException;
import junit.framework.TestCase;

public class BowlingGameTest extends TestCase {
	private BowlingGame game;

	@Override
	protected void setUp() throws Exception {
		game = new BowlingGame();
	}

	public void testRoll() throws Exception {
		try {
		assertEquals(1, game.getCurrentFrameNum());
		game.roll(10);
		assertEquals(10, game.getFrameScore(1));
		} catch (GameOverException e) {
			System.out.println(e);
		}
	}

	public void testPerfectGame() throws Exception {
		try {
			game.roll(10);
		game.roll(10);
		game.roll(10);
		game.roll(10);
		game.roll(10);
		game.roll(10);
		game.roll(10);
		game.roll(10);
		game.roll(10);
		game.roll(10);
		game.roll(10);
		game.roll(10);
		assertEquals(300, game.getFrame(0).getTotalScore());
		} catch (GameOverException e) {
			System.out.println(e);
		}
	}

	public void testJavajigiExample() throws Exception {
		try { 
		game.roll(9);
		game.roll(1);
		game.roll(8);
		game.roll(0);
		game.roll(10);
		game.roll(10);
		game.roll(8);
		game.roll(0);
		game.roll(10);
		game.roll(8);
		game.roll(1);
		game.roll(9);
		game.roll(1);
		game.roll(8);
		game.roll(1);
		game.roll(10);
		game.roll(9);
		game.roll(1);
		assertEquals(155, game.getFrame(0).getTotalScore());
		} catch (GameOverException e) {
			System.out.println(e);
		}
	}
}
