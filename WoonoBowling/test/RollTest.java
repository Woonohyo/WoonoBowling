import junit.framework.TestCase;


public class RollTest extends TestCase {
	public void testStrike() throws Exception {
		Roll roll = Roll.generateStrike();
		assertEquals('X', roll.getScore());
	}
	
	public void testSpare() throws Exception {
		Roll roll = Roll.generateSpare();
		assertEquals('/', roll.getScore());
	}
	
	public void testGutter() throws Exception {
		Roll roll = Roll.generateGutter();
		assertEquals('-', roll.getScore());
	}
	
	public void testRegular() throws Exception {
		Roll roll = Roll.pinDown(8);
		assertEquals('8', roll.getScore());
	}
}
