package roll;
import roll.Gutter;
import roll.Roll;
import roll.Spare;
import roll.Strike;
import junit.framework.TestCase;


public class RollTest extends TestCase {
	public void testStrike() throws Exception {
		Roll strike = new Strike();
		assertEquals('X', strike.getSymbol());
		assertEquals(10, strike.getPinDown());
	}
	
	public void testSpare() throws Exception {
		Roll spare = new Spare(3);
		assertEquals('/', spare.getSymbol());
		assertEquals(3, spare.getPinDown());
	}
	
	public void testGutter() throws Exception {
		Roll gutter = new Gutter();
		assertEquals('-', gutter.getSymbol());
		assertEquals(0, gutter.getPinDown());
	}
	
	public void testCreate() throws Exception {
		Roll roll1 = new Roll(7);
		assertEquals('7', roll1.getSymbol());
		assertEquals(7, roll1.getPinDown());
	}
}