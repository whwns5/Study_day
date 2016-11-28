package day18;

public class ExcepTest2 {
	public static void main(String[] args){
		
		System.out.println("프로그램의 시작 !");
		
		
		try{
			String fruit[] = {"사과" , "딸기" , "포도" , "키위"};
			
			for(int i = 0 ; i <= 4 ; i++){
				System.out.println(fruit[i]);
			}
		}catch (Exception e){
			System.out.println("잘못된 첨자를 선택하셨습니다.");
		}
		
		
		System.out.println("프로그램의 끝 !");
		
	}
}
