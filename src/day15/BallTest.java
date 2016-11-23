package day15;

//공
class Ball {
	String ballName;

	public void getInfo() {
		System.out.println(" 공을 움직입니다. ");
	}
}

// 야구공
class BaseBall extends Ball {

	public BaseBall() {
		this.ballName = "야구공";
	}

	@Override
	public void getInfo() {
		System.out.println(this.ballName + " 을 방망이로 칩니다. ");
	}
}

// 축구공
class SoccerBall extends Ball {

	public SoccerBall() {
		this.ballName = "축구공";
	}

	@Override
	public void getInfo() {
		System.out.println(this.ballName + " 을 발로 찹니다. ");
	}

}

// 농구공
class BasketBall extends Ball {

	public BasketBall() {
		this.ballName = "농구공";
	}

	@Override
	public void getInfo() {
		System.out.println(this.ballName + " 을 손으로 던집니다 ");
	}

}

public class BallTest {
	public static void main(String[] args) {

		Ball arrBall[] = new Ball[3];
		arrBall[0] = new BaseBall();
		arrBall[1] = new BasketBall();
		arrBall[2] = new SoccerBall();

		for (int i = 0; i < arrBall.length; i++) {
			arrBall[i].getInfo();
		}
	}
}
