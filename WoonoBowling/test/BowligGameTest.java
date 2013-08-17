import junit.framework.TestCase;


public class BowligGameTest extends TestCase {
	
	private BowlingGame game;
	
	@Override
	protected void setUp() throws Exception {
		game = new BowlingGame();
	}
	
	public void testCreate() throws Exception {
		assertEquals(1, game.getCurrentFrame());
	}

}
