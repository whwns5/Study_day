package day18;

public class ExcepTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("���α׷��� ����");
		
		try{
			String str = null;
			
			System.out.println("str = " + str.toString());	
		}catch(NullPointerException e){
			
			System.out.println("����ִ� ��ü�� ���� �Ͽ����ϴ�.");
			e.printStackTrace();
		}
		
		System.out.println("���α׷��� ��");
	}

}