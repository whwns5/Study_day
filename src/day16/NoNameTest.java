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
//		System.out.println("���Ӱ� ���ǵ� getInfo()");
//	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//NoNameTest nnt = new NoNameTest();
		
		new NoName(){
			@Override
			public void getInfo() {
				// TODO Auto-generated method stub
				System.out.println("������ ���� ~");
				System.out.println("a = " + a);
			}
		}; // NoName Ŭ������ ��ӹ��� �̸����� ��ü
		
		
	}

}
