package game;
import junit.framework.TestCase;


public class BowlingGameTest extends TestCase {
	private BowlingGame game;
	
	@Override
	protected void setUp() throws Exception {
		game = new BowlingGame();
	}
	
	public void testRoll() throws Exception {
		assertEquals(1, game.getCurrentFrame());
		game.roll(10);
		assertEquals(10, game.getFrameScore(1));
		assertEquals(2, game.getCurrentFrame());
		
	}
}
