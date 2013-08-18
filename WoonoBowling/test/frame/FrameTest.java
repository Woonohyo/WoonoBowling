package frame;
import frame.Frame;
import junit.framework.TestCase;

public class FrameTest extends TestCase {
	private Frame frame;
	
	@Override
	protected void setUp() throws Exception {
		frame = new Frame();
	}
	
	public void testCreateStrikeFrame() throws Exception {
		frame.setStrike();
		assertEquals(10, frame.getScore());
	}
}
