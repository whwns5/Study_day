package day16;

class NoName{
	int a = 10;
	
	public NoName(){
		getInfo();
	}
	
	public void getInfo(){
		
	}
}

//public class NoNameTest extends NoName{
public class NoNameTest{
	
//	@Override
//	public void getInfo() {
//		// TODO Auto-generated method stub
//		System.out.println("새롭게 정의된 getInfo()");
//	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//NoNameTest nnt = new NoNameTest();
		
		new NoName(){
			@Override
			public void getInfo() {
				// TODO Auto-generated method stub
				System.out.println("재정의 됬음 ~");
				System.out.println("a = " + a);
			}
		}; // NoName 클래스를 상속받은 이름없는 객체
		
		
	}

}
