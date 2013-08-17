import junit.framework.TestCase;

public class BowlingGameTest extends TestCase {

	private BowlingGame game;

	@Override
	protected void setUp() throws Exception {
		game = new BowlingGame();
	}

	public void testCreate() throws Exception {
		assertEquals(1, game.getCurrentFrame()); assertEquals(1, game.getCurrentRoll());
	}
	
	// 공을 던지는 메소드 Roll에 의해 프레임과 투구수가 제대로 작동하는지 테스트합니다.
	// 스트라이크, 스페어, 거터 등,
	// 각종 케이스에 대해서도 제대로 작동하는지 확인합니다.
	// 공을 굴리기 전에 현재 프레임과 투구수가 결정이 되어 있습니다.
	public void testRoll() throws Exception {
		assertEquals(1, game.getCurrentFrame()); assertEquals(1, game.getCurrentRoll());
		game.roll(10);

		assertEquals(2, game.getCurrentFrame()); assertEquals(1, game.getCurrentRoll());
		game.roll(7);
		assertEquals(2, game.getCurrentFrame()); assertEquals(2, game.getCurrentRoll());
		game.roll(3);

		assertEquals(3, game.getCurrentFrame()); assertEquals(1, game.getCurrentRoll());
		game.roll(0);
		assertEquals(3, game.getCurrentFrame()); assertEquals(2, game.getCurrentRoll());
		game.roll(0);

		assertEquals(4, game.getCurrentFrame()); assertEquals(1, game.getCurrentRoll());
		game.roll(3);
		assertEquals(4, game.getCurrentFrame()); assertEquals(2, game.getCurrentRoll());
		game.roll(0);

		assertEquals(5, game.getCurrentFrame()); assertEquals(1, game.getCurrentRoll());
		game.roll(0);
		assertEquals(5, game.getCurrentFrame()); assertEquals(2, game.getCurrentRoll());
		game.roll(10);
	}
}
