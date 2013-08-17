package frame;
import frame.Frame;
import junit.framework.TestCase;

public class FrameTest extends TestCase {
	private Frame frame;
	
	@Override
	protected void setUp() throws Exception {
		frame = new Frame();
	}
	
	public void testCreate() throws Exception {
		frame.initialize();
		assertEquals(2, frame.getSize());
	}
	
	public void testCreateStrikeFrame() throws Exception {
		frame.setStrike();
		assertEquals(2, frame.getSize());
		assertEquals(10, frame.getScore());
	}
}
