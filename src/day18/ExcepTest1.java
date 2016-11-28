package day18;

public class ExcepTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("프로그램의 시작");
		
		try{
			String str = null;
			
			System.out.println("str = " + str.toString());	
		}catch(NullPointerException e){
			
			System.out.println("비어있는 객체를 참조 하였습니다.");
			e.printStackTrace();
		}
		
		System.out.println("프로그램의 끝");
	}

}
