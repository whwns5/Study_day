package day12;

import java.io.IOException;

/*
 * 2016_11_18
 * 
 * 숫자 야구 게임 v2.0 (강사용)
 */
public class Day12_03 {

	/** 컴퓨터 난수 발생관련 메서드 */
	public static int[] comNumber(){
		int com[] = new int[3];
		
		for( int i = 0 ; i < com.length ; i++ ){
			com[i] = (int)(Math.random()*9+1);
			for(int j = 0 ; j < i ; j++){
				if(com[i] == com[j]){
					i--;
					break;
				}
			}
			
		}
		
		for( int i = 0 ; i < com.length ; i++ ){
			System.out.print(com[i] + " ");
		}
		
		return com;
	}
	
	/** 메뉴 출력 관련 메서드 */
	public static void menuPrint(){
		System.out.println("----------------------------------");
		System.out.println("          숫자 야구 게임 v2.0  ");
		System.out.println("----------------------------------");
	}
	
	/** 사용자로부터 값 입력받기
	 * @throws IOException */
	public static int[] userNumber(int count) throws IOException{
		int user[] = new int[3];
		System.out.print(count + "회차 입력 : ");
		for(int i = 0 ; i < user.length ; i++){
			user[i] = System.in.read() - '0';
		}
		
		System.in.skip(2);
		return user;
	}
	
	/** 게임결과 관련 메서드 */
	public static void gameResult(int com[], int user[]){
		int strike = 0;
		int ball = 0;
		
		for(int i = 0 ; i < user.length ; i++){
			for(int j = 0 ; j < com.length ; j++){
				if( user[i] == com[j] && i == j){
					strike ++;
				} else if( user[i] == com[j] && i != j ){
					ball ++;
				}
			}
		}
		System.out.println(strike + "스트라이크 / " + ball + "볼");
		if(strike == 3){
			System.out.println("맞췄습니다.");
			System.exit(0);
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		int com[] = comNumber();
		menuPrint();
		
		for(int i = 1 ; i <= 10 ; i++){
			int user[] = userNumber(i);
			gameResult(com, user);
		}
		
		System.out.println("10번의 기회를 모두 소진 하였습니다.");
		System.out.println("Game Over");
		System.exit(0);
		
		
	}

}
