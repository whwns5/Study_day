package day18;

public class ExcepTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("프로그램의 시작 !");
		
		
			for(int i = 0 ; i <= 5 ; i++){
				try{
					int r = 10 / (i-3);
					System.out.println("r = " + r);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		
		
		
		System.out.println("프로그램의 끝 !");
	}
	

}
