import junit.framework.TestCase;


public class FrameTest extends TestCase {
	
	public void testStrike() throws Exception {
		Frame frame = new Frame();
		frame.generateStrike();
		assertEquals(10, frame.getFrameScore());
	}
	
	public void testEmptyFrame() throws Exception {
		Frame frame = new Frame();
		frame.setEmpty();
		assertEquals(0, frame.getFrameScore());
	}
}
