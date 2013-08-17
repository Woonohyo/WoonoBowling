import junit.framework.TestCase;


public class RollTest extends TestCase {
	public void testStrike() throws Exception {
		Roll roll = Roll.generateStrike(1, 1);
		assertEquals('X', roll.getScore());
	}
	
	public void testSpare() throws Exception {
		Roll roll = Roll.generateSpare(1, 2);
		assertEquals('/', roll.getScore());
	}
	
	public void testGutter() throws Exception {
		Roll roll = Roll.generateGutter(1, 1);
		assertEquals('-', roll.getScore());
	}
}
