package game;

import junit.framework.TestCase;

public class BowlingGameTest extends TestCase {
	private BowlingGame game;

	@Override
	protected void setUp() throws Exception {
		game = new BowlingGame();
		game.initialize();
	}

	public void testRoll() throws Exception {
		assertEquals(1, game.getCurrentFrameNum());
		game.roll(10);
		assertEquals(10, game.getFrameScore(1));

		assertEquals(2, game.getCurrentFrameNum());
		game.roll(7);
		game.roll(3);
		assertEquals(10, game.getFrameScore(2));

		assertEquals(3, game.getCurrentFrameNum());
		game.roll(3);
		game.roll(5);
		assertEquals(8, game.getFrameScore(3));

		assertEquals(4, game.getCurrentFrameNum());
		game.roll(0);
		game.roll(0);
		assertEquals(0, game.getFrameScore(4));

		assertEquals(5, game.getCurrentFrameNum());
		game.roll(0);
		game.roll(10);
		assertEquals(10, game.getFrameScore(5));

		assertEquals(6, game.getCurrentFrameNum());
		game.roll(0);
		game.roll(8);
		assertEquals(8, game.getFrameScore(6));
	}
}
