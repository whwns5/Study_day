package day15;

// pm
abstract class Dohyung{
	
	public void getInfo(){
		System.out.println("도형의 넓이 구하기 v1.0");
	}
	
	abstract public void area(int i, int j);
}

// 둘리 -- 사각형
class Rect extends Dohyung{

	@Override
	public void area(int i, int j) {
		// TODO Auto-generated method stub
		int result = i * j;
		System.out.println("사각형의 넓이 : " + result); 
	}
	
	
}

// 또치 -- 삼각형
class Triangle extends Dohyung{
	
	@Override
	public void area(int x, int y) {
		// TODO Auto-generated method stub
		int result = x * y / 2;
		System.out.println("삼각형의 넓이 : " + result);
	}
	
}

// 도우너 -- 원
abstract class Circle extends Dohyung{

	abstract public void area(int i);
	
}

// 도우너 -- 부사수
class Circle2 extends Circle{
	
	public void area(int i){
		double result = i * i * Math.PI;
		System.out.println("원의 넓이 : " + result);
	}
	
	public void area(int i , int j){
		
	}

}

public class DohyungTest {
	
	public void goArea(int i , int j){
//		System.out.println("가로 = " + i + "/세로 = " + j + "인 각각 도형의 넓이");
		
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
//		//추상클래스로는 객체를 만들 수 없음.
//		
//		Dohyung d2 = new Rect();
//		d2.area(i, j);
//		
//		Dohyung d3 = new Triangle();
//		d3.area(5, 5);
//		d3.getInfo();
//		
		Dohyung d4 = new Circle2();
	
		Circle d5 = (Circle) d4; // 레퍼런스 이기 때문에 d5와 d4는 같은 객체를 의미한다. 주소가 같다.

		
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
