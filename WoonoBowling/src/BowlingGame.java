import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BowlingGame {

	private int currentFrame;
	private int currentRoll;
	private int currentPin;
	private int totalRoll = 0;
	private Roll roll;
	private Frame frame;

	// 2차원 배열을 이용하면 너무 복잡할 것 같아서, ArrayList로 다시 구현합니다.
	private List<List<Roll>> Frames = new ArrayList<>();

	// 상단의 2차원 배열 (frame, roll)을 Key값으로 갖고, 스코어를 value로 갖는 hashmap입니다.
	private Map<Object, Character> scoreTable = new HashMap<Object, Character>();

	public BowlingGame() {
		currentFrame = 1;
		currentRoll = 1;
		currentPin = 10;
	}

	public int getCurrentFrame() {
		return currentFrame;
	}

	public int getCurrentRoll() {
		return currentRoll;
	}

	public void roll(int pinDown) {
		System.out.println(currentFrame + "프레임 " + currentRoll + "번째 투구");
		System.out.println("공을 굴립니다! 데구르르르....");
		totalRoll++;
		currentPin = currentPin - pinDown;

		System.out.println(pinDown + "핀을 쳤습니다!");

		if (currentRoll == 1 && pinDown == 10) {
			System.out.println("대단해요! 스트라이크입니다!");
			Frames.add(currentFrame, frame.generateStrike());
			goNextFrame();
		}

		else if (currentRoll == 2 && currentPin == 0) {
			System.out.println("멋진 스페어처리군요.");
			putScoreTable('/');
			goNextFrame();
		}

		else if (currentRoll == 1 && pinDown == 0) {
			System.out.println("초구부터 거터라니ㅠ");
			putScoreTable('-');
			goNextRoll();
		}

		else if (currentRoll == 2 && pinDown == 0) {
			System.out.println("두번째가 거터라니. 슬프네요.");
			putScoreTable('-');
			goNextFrame();
		}

		else if (currentRoll == 2) {
			putScoreTable((char) pinDown);
			goNextFrame();
		}

		else {
			goNextRoll();
		}
	}

	private void goNextRoll() {
		currentRoll++;
		System.out.println("다음 공을 던질 준비를 합니다.");
		System.out.println("다음번에 " + currentPin
				+ "핀을 치면 스페어처리를 할 수 있어요! 힘내세요!\n");
	}

	private void goNextFrame() {
		currentFrame++;
		currentRoll = 1;
		currentPin = 10;
		System.out.println("수고했습니다! 다음 프레임으로 넘어갑니다!\n\n");
	}

	private void putScoreTable(char pinDown) {
	}

	public void getTable() {
	}
}