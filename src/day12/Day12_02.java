package day12;

import java.io.IOException;
/*
 * 2016_11_18
 * 
 * 가위바위보 게임 v2 (강사용)
 */
public class Day12_02 {

	/** 메뉴출력 관련 메서드*/
	public static void printMenu(){
		System.out.println("=========================");
		System.out.println("| 가위 바위 보 게임 v2.0 |");
		System.out.println("-------------------------");
		System.out.println("1.가위 2.바위 3.보 4. 종료");
	}
	
	/** 사용자 값 입력관련 메서드 */
	public static int userInput() throws IOException{
		
		int user = 0;
		do{
			System.out.print("메뉴 : ");
			user = System.in.read() - 48;
			System.in.skip(2);
		}while( !(user >= 1 && user <= 4));
		
		return user;
		
	}
	
	/** 승패관련 메서드*/
	public static void gameResult(int user){
		
		
		
		int com = (int)(Math.random()*3+1);
		
		System.out.println("사용자 : " + user);
		System.out.println("컴퓨터 : " + com);
		
		if(user == com){
			System.out.println("비겼음");
		}else if((user + 1) % 3 == com % 3){
			System.out.println("컴퓨터 승!");
		}else {
			System.out.println("사용자 승!");
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		while(true){
			printMenu();
			int menu = userInput();
			if(menu == 4){
				System.out.println("즐거운 하루 되세요.");
				System.exit(0);
			}
			gameResult(menu);
		}
		
		
	}

}
