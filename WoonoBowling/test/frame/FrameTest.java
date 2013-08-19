package frame;

import frame.Frame;
import game.BowlingGame;
import junit.framework.TestCase;

public class FrameTest extends TestCase {
	private Frame frame;
	private BowlingGame game;
	private Frame lastFrame;

	@Override
	protected void setUp() throws Exception {
		frame = new Frame();
		lastFrame = new LastFrame();
		game = new BowlingGame();
		game.initialize();
	}

	public void testCreateStrikeFrame() throws Exception {
		frame.setStrikeFrame();
		assertEquals(10, frame.getFrameScore());
		assertTrue(frame.isStrike());
	}

	public void testGetSymbols() throws Exception {
		game.roll(3);
		game.roll(7);
		assertEquals("3 /", game.getCurrentFrame().getSymbols());

		game.roll(4);
		game.roll(5);
		assertEquals("4 5", game.getCurrentFrame().getSymbols());

		game.roll(10);
		assertEquals("X  ", game.getCurrentFrame().getSymbols());
	}
	
	public void testLastFrame() throws Exception {
		lastFrame.addRoll(10);
		lastFrame.addRoll(10);
		lastFrame.addRoll(10);
		assertEquals(30, lastFrame.getFrameScore());
		assertEquals("X X X", lastFrame.getSymbols());
		
	}
	
	public void testLastFrame2() throws Exception {
		lastFrame.addRoll(3);
		lastFrame.addRoll(6);
		assertEquals(9, lastFrame.getFrameScore());
		assertEquals("3 6  ", lastFrame.getSymbols());
	}
}
