package day16;

public class NameLocalTest {
	
	String s = "###";	// 멤버 변수
	
	public void test1(){
		String ss = "!!!"; // 지역 변수
	
		System.out.println("s = " + s);
		System.out.println("ss = " + ss);
		
		class NameTest{
			String sss = "@@@";	// 멤버 변수
			
			public void test2(){
				System.out.println("sss = " + sss);
				System.out.println("s = " + s);
				
				System.out.println("ss = " + ss); // 8버전 이후 부터만 가능해졌다.
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
