package roll;


public class Spare extends Roll {
	public Spare(int pinDown) {
		symbol = '/';
		this.pinDown = pinDown;
		System.out.println(pinDown + "핀을 쓰러뜨렸습니다.");
	}
}
