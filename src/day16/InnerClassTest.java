package day16;

class Outer{
	int a = 10;
	
	public void test1(){
		System.out.println("test1() �޼��� ȣ��� !");
	}
	
	// non-static ���� Ŭ����
	class Inner{
		int b = 20;
		
		public void test2(){
			System.out.println("test2() �޼��� ȣ��� !");
		}
	}
	
	static class SInner{
		int c = 30;
		
		public void test3(){
			System.out.println("test3() �޼��� ȣ��� !");
		}
		
		static public void test4(){
			System.out.println("test4() �޼��� ȣ��� !");
		}
	}
	
}

public class InnerClassTest {

	public static void main(String[] args) {
		
		Outer o = new Outer();
		System.out.println("o.a = " + o.a);
		o.test1();
		
	//	Outer.Inner oi = new Outer.Inner();
		Outer.Inner oi = o.new Inner();
		System.out.println("oi.b = " + oi.b);
		
		Outer.Inner oi2 = new Outer().new Inner();

		Outer.SInner os = new Outer.SInner();
		System.out.println("os.c = " + os.c);
		os.test3();
		
		Outer.SInner.test4();
		
		
		
		
		
	}
}
