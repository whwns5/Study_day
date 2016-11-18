package day12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 2016_11_18
 * 
 * 가위바위보 게임 v2
 */
public class Day12_01_Q {
	
	/** 게임 시작 모듈 
	 * @throws IOException */
	public static int checkMenu(BufferedReader br) throws IOException{
		int menuState = 0;
		char chMenu;
		
		System.out.println("--------------------------------------");
		System.out.println("               가위 바위 보 게임            ");
		System.out.println("--------------------------------------");
		
		while(true){
			System.out.println("게임을 시작하시겠습니까?");
			System.out.println("  Y. 게임시작     N. 종료");
			System.out.print(">> ");
			chMenu = (char)br.read();
			br.skip(2);
			
			if( (chMenu == 'y' || chMenu == 'Y' || chMenu == 'n' || chMenu == 'N') ){
				break;
			} else {
				System.out.println("잘못 입력 하셨습니다. ");
			}
		}
		
		switch (chMenu) {
		case 'y':
		case 'Y':
			menuState = 1;
			break;
		case 'n':
		case 'N':
			System.out.println("게임을 종료합니다.");
			System.exit(0);
			break;
		default:
			break;

		}
		
		return menuState;
	}
	
	/** 사용자 입력 모듈
	 * @param br 
	 * @throws IOException */
	public static int inputUser(BufferedReader br) throws IOException{
		
		int inputMenu;
		
		//System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		//System.out.println();
		
		System.out.println("--------------------------------------");
		System.out.println("      다음 메뉴 중 하나를 입력하세요.     ");
		
		while(true){
			System.out.println("--------------------------------------");
			System.out.println("  1. 가위  2. 바위  3. 보  4. 처음으로  ");
			System.out.println("--------------------------------------");
			//System.out.println("\n\n");
			System.out.print(">> ");
			
			inputMenu = br.read() - '0';
			br.skip(2);
			
			if(inputMenu == 1 || inputMenu == 2 || inputMenu == 3 || inputMenu == 4){
				
				break;
			} else {
				System.out.println("잘못 입력하셨습니다. ");
			}
		}
		
		
		return inputMenu;
		
	}

	/** 컴퓨터 난수 생성 모듈 */
	public static int createRand(){
		int randNum;
		randNum = (int)(Math.random()*3+1);
		return randNum;
	}
	
	/** 승패 처리 모듈 */
	public static String gameProcess(int userNum, int comNum){
		String gameResult = "";
		
		switch (userNum-comNum) {
		case 2:
		case -1:
			gameResult = "lose";
			break;
		case 1:
		case -2:
			gameResult = "win";
			break;
		case 0:
			gameResult = "draw";
			break;
		default:
			System.out.println("승패 처리 모듈 에러");
			break;
		}
		
		return gameResult;
	}

	/** 결과 출력 모듈 */
	public static void resultPrint(int userNum, int comNum, String gameResult){
		StringBuffer resultString= new StringBuffer();
		resultString.append("유저 : ");
		
		switch (userNum) {
		case 1:
			resultString.append("가위");
			break;
		case 2:
			resultString.append("바위");
			break;
		case 3:
			resultString.append("보");
			break;
		default:
			break;
		}
		
		resultString.append("\n컴퓨터 : ");
		switch (comNum) {
		case 1:
			resultString.append("가위");
			break;
		case 2:
			resultString.append("바위");
			break;
		case 3:
			resultString.append("보");
			break;
		default:
			break;
		}
		
		resultString.append("\n결과 : ");
		resultString.append(gameResult);
		
		
		System.out.println(resultString);
		
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int menuState = 0;
		int userNum;
		int comNum;
		String gameResult;
		
		while(true){
			
			while(menuState == 0){
				menuState = checkMenu(br); // 0 -> 1단계 메뉴화면  , 1 - > 2단계 메뉴화면
			}
			
			userNum = inputUser(br);
			if(userNum == 4){
				menuState = 0;
			} else {
				comNum = createRand();
				gameResult = gameProcess(userNum, comNum);
				resultPrint(userNum, comNum, gameResult);
			}
		}
	}

}
