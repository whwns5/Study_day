package day15;
/*
 * 2016_11_23
 * 
 * 
 */
class Super{
	int a = 10;
	double b = 20.0;
	
	public void test1(){
		System.out.println("test1() 메서드 수행됨!");
	}
	
	public void test33(){
		System.out.println("발동");
	}
	
}

class Sub extends Super{
	int a = 100;
	int c = 30;
	
	
	public void test1(){
		super.test1();
		System.out.println("재정의된 test1() 메서드 수행됨!");
		System.out.println("c = " + c);
		
	}
	
	public void test2(){
		System.out.println("test2() 메서드 수행됨!");
	}
	
	public void test22(){
		System.out.println("c = " + c);
	}
	
}

public class InheriTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Super sp = new Super();
//		
//		System.out.println("sp.a = " + sp.a);
//		
//		System.out.println("sp.b = " + sp.b);
//		
//		sp.test1();
//		
		
		
		//int a[] = new int[3]; // 3개의 공간에 자료형 기본값인 0으로 초기화 된다.
//		Super arr[] = new Super[3]; // 3개의 공간에 레퍼런스형 기본값인 NULL 이란 값으로 초기화 된다.
//		arr[0] = new Super();
//		arr[1] = new Super();
//		arr[2] = new Super();
//		
//		arr[0].test1();
		
//		Sub sb = new Sub();
//		System.out.println("sb.a = " + sb.a);
//		System.out.println("sb.c = " + sb.c);
//		sb.test2();
//		sb.test1();
//		
//		Sub arr[] = new Sub[3]; // Sub 객체가 들어갈 수 있는 배열 선언
		
//		Sub sb2 = new Sub();
//		sb2.test2();
//		sb2.test1();
//		System.out.println("sb2.c = " + sb2.c);
//		System.out.println("sb2.b = " + sb2.b);
//		System.out.println("sb2.a = " + sb2.a);
		
		
		
		 // 값에 대한 우선순위는 아빠 클래스에 있는 것으로 접근. 메소드는 오버라이딩한 아들 클래스의 메소드로 접근
		//System.out.println("sp.c = " + (Sub) sp.);
		
		
		//System.out.println("sp.a = " + sp.a);
		//System.out.println("sp.b = " + sp.b);
		
		//sp.test1();
		
		
		
		
		
		//sp.test2();
//		int aaa = 1;
//		System.out.println( (short) aaa);
		
		Super sp = new Sub();
		
		//System.out.println("sp.c = " + sp.c);
		
		
		
		
		
//		int bbb = 2;
//		short bbb2 = (short) bbb;
//		System.out.println( bbb2 );
//		
//		Sub sbcast = (Sub) sp;
//		System.out.println( sbcast.c );
//		sbcast.test1();
//		
//		Sub sb22 = new Sub();
//		sb22.test33();
//		//System.out.println();
		
		
	
	}

}
