package day16;
/*
 * 
 * final + class : ��ӹ���
 * final + method : �������̵� ����
 * final + var : ��ӹ��� ����
 * final public static + var : ���
 */
class Super{
	final public static int A = 10;
	
	public void test1(){
		System.out.println("test1() �޼��� ȣ��� !");
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
		System.out.println("�����ǵ� test1() �޼ҵ� ȣ��� !");
	}
	
	public void test2(){
		System.out.println("test2() �޼��� ����� !");
	}
}

public class FinalTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
