package day15;

//��
class Ball {
	String ballName;

	public void getInfo() {
		System.out.println(" ���� �����Դϴ�. ");
	}
}

// �߱���
class BaseBall extends Ball {

	public BaseBall() {
		this.ballName = "�߱���";
	}

	@Override
	public void getInfo() {
		System.out.println(this.ballName + " �� ����̷� Ĩ�ϴ�. ");
	}
}

// �౸��
class SoccerBall extends Ball {

	public SoccerBall() {
		this.ballName = "�౸��";
	}

	@Override
	public void getInfo() {
		System.out.println(this.ballName + " �� �߷� ���ϴ�. ");
	}

}

// �󱸰�
class BasketBall extends Ball {

	public BasketBall() {
		this.ballName = "�󱸰�";
	}

	@Override
	public void getInfo() {
		System.out.println(this.ballName + " �� ������ �����ϴ� ");
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
