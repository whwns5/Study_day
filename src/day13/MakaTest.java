package day13;

public class MakaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("프로그램 시작");
		
		Maka m1 = new Maka();
		m1.color = "빨강";
		m1.makaWrite();
		
		Maka m2 = new Maka();
		m2.color = "파랑";
		m2.makaWrite();
		
							
		Maka m3 = new Maka(); // new Maka(); <- 가 곧 생성자 호출
		m3.makaWrite();
		
		System.out.println("프로그램 끝");
		
	}

}
