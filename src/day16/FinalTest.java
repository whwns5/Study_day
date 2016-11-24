package day16;
/*
 * 
 * final + class : 상속방지
 * final + method : 오버라이딩 금지
 * final + var : 상속방지 변수
 * final public static + var : 상수
 */
class Super{
	final public static int A = 10;
	
	public void test1(){
		System.out.println("test1() 메서드 호출됨 !");
	}
	
	
}

class Sub extends Super{
	int b = 20;
	
	@Override
	public void test1() {
		// TODO Auto-generated method stub
		//System.out.println("a = " + a);
		//a = 20;
		//System.out.println("a = " + a);
		System.out.println("재정의된 test1() 메소드 호출됨 !");
	}
	
	public void test2(){
		System.out.println("test2() 메서드 수행됨 !");
	}
}

public class FinalTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
