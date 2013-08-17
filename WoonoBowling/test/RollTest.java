import Roll.Gutter;
import Roll.Roll;
import Roll.Spare;
import Roll.Strike;
import junit.framework.TestCase;


public class RollTest extends TestCase {
	public void testStrike() throws Exception {
		Roll strike = new Strike();
		assertEquals('X', strike.getSymbol());
	}
	
	public void testSpare() throws Exception {
		Roll spare = new Spare();
		assertEquals('/', spare.getSymbol());
	}
	
	public void testGutter() throws Exception {
		Roll gutter = new Gutter();
		assertEquals('-', gutter.getSymbol());
	}
	
	public void testRegularShot() throws Exception {
		Roll roll1 = new Roll(7);
		assertEquals('7', roll1.getSymbol());
		
	}
}
