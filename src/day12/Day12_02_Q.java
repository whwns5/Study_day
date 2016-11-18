package day12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 2016_11_18
 * 
 * 숫자 야구 게임 v2.0
 */
public class Day12_02_Q {
	
	/** 메뉴 화면 모듈 */
	public static void menuPrint(){
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("\t\t\t\t숫자 야구 게임 v2.0\t\t\t\t");
		System.out.println("--------------------------------------------------------------------------------");
	}
	
	/** 사용자 입력 모듈 
	 * @throws IOException */
	public static void inputUser(int[] arrInputUser) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("0~9 까지의 숫자 3개를 입력하세요 : ");
		for(int i = 0 ; i < arrInputUser.length; i++){
			arrInputUser[i] = br.read() - '0';
		}
	}
	
	/** 컴퓨터 난수 생성 모듈 */
	public static void createRandNum(int[] arrCreateCom){
		for(int i = 0 ; i < arrCreateCom.length ; i++){
			arrCreateCom[i] = (int)(Math.random()*10);
			for(int j = i - 1 ; j >= 0 ; j--){
				if( arrCreateCom[i] == arrCreateCom[j] ){
					i--;
					break;
				}
			}
		}
		
		System.out.print("난수 : ");
		for(int i = 0 ; i < arrCreateCom.length ; i++){
			System.out.print(arrCreateCom[i] + " ");
		}
		System.out.println();
	}
	
	/** 결과처리 모듈 */
	public static boolean resultProcess(int gameCount, int[] arrInputUser, int[] arrCreateCom, int[][][] arrGameData){
		
		boolean isClear = false;
		
		int arrSB[] = new int[2];

		for(int i = 0 ; i < arrInputUser.length ; i++){
			for(int j = 0 ; j < arrCreateCom.length ; j++){
				if( arrInputUser[i] == arrCreateCom[j] ) {	//두 수가 같을 경우
					if( i == j ) { //위치도 같을 경우
						arrSB[0]++;
						break;
					} else {
						arrSB[1]++;
						break;
					}
				}
			}
		}
		

		for( int i = 0 ; i < arrInputUser.length ; i++ ){
			arrGameData[gameCount][0][i] = arrInputUser[i];
		}
		
		for( int i = 0 ; i < arrSB.length ; i++ ){
			arrGameData[gameCount][1][i] = arrSB[i];
		}
		
		if(arrSB[0] == 3){ // 스트라이크가 3이면
			isClear = true;
		}
		
		resultPrint(gameCount, arrGameData);
		
		return isClear;
	}
	
	
	/** 결과출력 모듈 */
	public static void resultPrint(int gameCount, int[][][] arrGameData){
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("  회차\t 첫번째           두번째                세번째             스트라이크                볼");
		System.out.println("--------------------------------------------------------------------------------");
		for(int i = 0 ; i <= gameCount ; i++){
			System.out.print((i+1) + "회차  >>>  ");
			
			for(int j = 0 ; j < arrGameData[i].length ; j++){
				for(int k = 0 ; k < arrGameData[i][j].length ; k++){
					System.out.print(arrGameData[i][j][k] + "\t\t");
				}
			}
			System.out.println();
		}
		System.out.println("--------------------------------------------------------------------------------");
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		int arrInputUser[] = new int[3];
		int arrCreateCom[] = new int[3];
		int arrGameData[][][] = new int[10][2][];
		for(int i = 0 ; i < arrGameData.length ; i++){
			arrGameData[i][0] = new int[3];	// 사용자 입력 번호 배열
			arrGameData[i][1] = new int[2]; // 스트라이크 카운터
		}
		
		menuPrint();
		createRandNum(arrCreateCom);
		
		for(int gameCount = 0; gameCount < 10 ; gameCount++){
			inputUser(arrInputUser);
			if( resultProcess(gameCount, arrInputUser, arrCreateCom, arrGameData) ){ //클리어 됫다면
				System.out.println((gameCount+1) + "회차에 클리어 하셨습니다. !!");
				System.exit(0);
			}		
		}
		System.out.println("10회차 까지 기회를 모두 소모 하셨습니다.");
	}

}
