import junit.framework.TestCase;


public class RollTest extends TestCase {
	public void testStrike() throws Exception {
		Roll strike = new Strike();
		assertEquals('X', strike.getSymbol());
	}
}
