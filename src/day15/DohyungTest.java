package day15;

// pm
abstract class Dohyung{
	
	public void getInfo(){
		System.out.println("������ ���� ���ϱ� v1.0");
	}
	
	abstract public void area(int i, int j);
}

// �Ѹ� -- �簢��
class Rect extends Dohyung{

	@Override
	public void area(int i, int j) {
		// TODO Auto-generated method stub
		int result = i * j;
		System.out.println("�簢���� ���� : " + result); 
	}
	
	
}

// ��ġ -- �ﰢ��
class Triangle extends Dohyung{
	
	@Override
	public void area(int x, int y) {
		// TODO Auto-generated method stub
		int result = x * y / 2;
		System.out.println("�ﰢ���� ���� : " + result);
	}
	
}

// ����� -- ��
abstract class Circle extends Dohyung{

	abstract public void area(int i);
	
}

// ����� -- �λ��
class Circle2 extends Circle{
	
	public void area(int i){
		double result = i * i * Math.PI;
		System.out.println("���� ���� : " + result);
	}
	
	public void area(int i , int j){
		
	}

}

public class DohyungTest {
	
	public void goArea(int i , int j){
//		System.out.println("���� = " + i + "/���� = " + j + "�� ���� ������ ����");
		
//		Rect r = new Rect();
//		r.area(i, j);
//		
//		Triangle t = new Triangle();
//		t.area(i, j);
//		
//		Circle2 c = new Circle2();
//		c.area(i);
//		
//		//Dohyung d = new Dohyung();
//		//�߻�Ŭ�����δ� ��ü�� ���� �� ����.
//		
//		Dohyung d2 = new Rect();
//		d2.area(i, j);
//		
//		Dohyung d3 = new Triangle();
//		d3.area(5, 5);
//		d3.getInfo();
//		
		Dohyung d4 = new Circle2();
	
		Circle d5 = (Circle) d4; // ���۷��� �̱� ������ d5�� d4�� ���� ��ü�� �ǹ��Ѵ�. �ּҰ� ����.

		
	//	Circle2 d6 = (Circle2) d4;
		
	//	d5.area(i);
		
	//	d6.area(i);
		
		//d4.area(i, j);
	}
	
	
	public static void main(String[] args){
		DohyungTest dt = new DohyungTest();
		dt.goArea(10, 20);
	}
	
}
