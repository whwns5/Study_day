package day16;

public class NameLocalTest {
	
	String s = "###";	// ��� ����
	
	public void test1(){
		String ss = "!!!"; // ���� ����
	
		System.out.println("s = " + s);
		System.out.println("ss = " + ss);
		
		class NameTest{
			String sss = "@@@";	// ��� ����
			
			public void test2(){
				System.out.println("sss = " + sss);
				System.out.println("s = " + s);
				
				System.out.println("ss = " + ss); // 8���� ���� ���͸� ����������.
			}
		}
		
		NameTest nt = new NameTest();
		nt.test2();
	}
	
	public void test3(){
		
	}
	
	public static void main(String[] args){
		NameLocalTest nlt = new NameLocalTest();
		
		nlt.test1();
		
		
	}
	
	
	
	
}
