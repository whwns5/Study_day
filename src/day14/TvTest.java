package day14;

public class TvTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tv t1 = new Tv();
		t1.rgb = 30;
		t1.mi = 70;
		t1.ri = 40;
		
		t1.getInfo();
		
		System.out.println("-------------------------------------");
		
		Tv t2 = new Tv();
		t2.getInfo();
		
		System.out.println("-------------------------------------");
		
		Tv t3 = new Tv(70);
		t3.getInfo();
		
		System.out.println("-------------------------------------");
		
		Tv t4 = new Tv(20,20,20);
		t4.getInfo("==���� ������� ����Ʈ Ƽ����~==");
		
		System.out.println("-------------------------------------");
		
		
	}

}
