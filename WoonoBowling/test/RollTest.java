import junit.framework.TestCase;


public class RollTest extends TestCase {
	
	public void testStrike() throws Exception {
		Roll roll1 = Roll.generateStrike(1, 1);
		assertEquals('X', roll1.getScore());
	}
}
