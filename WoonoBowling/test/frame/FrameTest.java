package frame;

import frame.Frame;
import static game.BowlingGame.CURRENT;
import static game.BowlingGame.PREVIOUS;
import static game.BowlingGame.PREVIOUS2;
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
	}

	public void testCreateStrikeFrame() throws Exception {
		frame.setStrikeFrame();
		assertEquals(10, frame.getFrameScore());
		assertTrue(frame.isStrike());
	}

	public void testGetSymbols() throws Exception {
		game.roll(3);
		game.roll(7);
		assertEquals("3 /  ", game.getFrame(CURRENT).getSymbols());

		game.roll(4);
		game.roll(5);
		assertEquals("4 5  ", game.getFrame(CURRENT).getSymbols());

		game.roll(10);
		assertEquals("X    ", game.getFrame(CURRENT).getSymbols());
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
	
	public void testCalculateFrameScore() throws Exception {
		
		
	}
}
