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
		assertEquals(1, game.getCurrentFrame());
		game.roll(10);
		assertEquals(10, game.getFrameScore(1));
		
		assertEquals(2, game.getCurrentFrame());
		game.roll(7);
		game.roll(3);
		assertEquals(10, game.getFrameScore(2));
		
		assertEquals(3, game.getCurrentFrame());
		game.roll(3);
		game.roll(5);
		assertEquals(8, game.getFrameScore(3));
	}
}
