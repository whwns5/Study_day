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
		System.out.println("test1() �޼��� �����!");
	}
	
	public void test33(){
		System.out.println("�ߵ�");
	}
	
}

class Sub extends Super{
	int a = 100;
	int c = 30;
	
	
	public void test1(){
		super.test1();
		System.out.println("�����ǵ� test1() �޼��� �����!");
		System.out.println("c = " + c);
		
	}
	
	public void test2(){
		System.out.println("test2() �޼��� �����!");
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
		
		
		//int a[] = new int[3]; // 3���� ������ �ڷ��� �⺻���� 0���� �ʱ�ȭ �ȴ�.
//		Super arr[] = new Super[3]; // 3���� ������ ���۷����� �⺻���� NULL �̶� ������ �ʱ�ȭ �ȴ�.
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
//		Sub arr[] = new Sub[3]; // Sub ��ü�� �� �� �ִ� �迭 ����
		
//		Sub sb2 = new Sub();
//		sb2.test2();
//		sb2.test1();
//		System.out.println("sb2.c = " + sb2.c);
//		System.out.println("sb2.b = " + sb2.b);
//		System.out.println("sb2.a = " + sb2.a);
		
		
		
		 // ���� ���� �켱������ �ƺ� Ŭ������ �ִ� ������ ����. �޼ҵ�� �������̵��� �Ƶ� Ŭ������ �޼ҵ�� ����
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
