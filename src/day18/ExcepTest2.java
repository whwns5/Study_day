package day18;

public class ExcepTest2 {
	public static void main(String[] args){
		
		System.out.println("���α׷��� ���� !");
		
		
		try{
			String fruit[] = {"���" , "����" , "����" , "Ű��"};
			
			for(int i = 0 ; i <= 4 ; i++){
				System.out.println(fruit[i]);
			}
		}catch (Exception e){
			System.out.println("�߸��� ÷�ڸ� �����ϼ̽��ϴ�.");
		}
		
		
		System.out.println("���α׷��� �� !");
		
	}
}
