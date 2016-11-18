package day12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 
 * 몇개의 수를 기억 하실 겁니까? 5
 * 사용자 : 6
 * 12
 * 사용자 : 17
 * 20
 * 사용자 : 9
 *  :
 *  :
 *  암기한 숫자 입력
 *  1번 숫자 :
 *    :
 *    :
 *  n번 숫자 :
 *  
 *  정답:
 *  입력한 답:
 */
public class Day12_04 {
	
	/** 시작화면 출력 모듈 */
	public static void mainPrint(){
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("\t\t\t\t숫자 맞추기 게임 v1.0\t\t\t\t");
		System.out.println("--------------------------------------------------------------------------------");
	}
	
	/** 사용자 숫자 갯수 입력 모듈 
	 * @param br 
	 * @throws IOException 
	 * @throws NumberFormatException */
	public static String[][] userInputCount(BufferedReader br) throws NumberFormatException, IOException{
		
		int inputCount;
		
		System.out.print("몇 개의 수를 기억 하실겁니까 ? ");
		inputCount = Integer.parseInt(br.readLine());
		
		//System.out.println(inputCount);
		
		String arrNum[][] = new String[2][inputCount];
		
		return arrNum; 
	}
	
	/** 문제 숫자 입력 모듈 */
	public static void inputBeforeNum(BufferedReader br, String[][] arrNum) throws IOException{
		
		for(int i = 0 ; i < arrNum[0].length; i++){
			if(i % 2 == 0){ //홀 수 번째 일경우 사용자 입력
				System.out.print("사용자 : ");
				arrNum[0][i] = br.readLine();
			} else if (i % 2 == 1) { // 짝 수 번째 일경우 컴퓨터 입력
				arrNum[0][i] =  Integer.toString((int)(Math.random()*99+1));
				System.out.println("컴퓨터 : " + arrNum[0][i]);
			}
		}
	}

	/** 답안 숫자 입력 모듈 
	 * @throws IOException */
	public static void inputAfterNum(BufferedReader br, String[][] arrNum) throws IOException{
		
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("암기한 숫자 입력 >>");
		for(int i = 0 ; i < arrNum[0].length ; i++){
			System.out.print( (i+1) + "번째 숫자 : ");
			arrNum[1][i] = br.readLine();
		}
	}

	/** 결과 처리 모듈 */
	public static void resultProcess(String[][] arrNum){

		for(int i = 0 ; i < arrNum[0].length ; i++){
			if( !(arrNum[0][i].equals(arrNum[1][i])) ){
				arrNum[1][i] = "[" + arrNum[1][i] + "]";
				
			}
		}
	}
	
	/** 결과 출력 모듈 */
	public static void resultPrint(String[][] arrNum){
		
		System.out.print("정답\t:\t");
		for(int i = 0 ; i < arrNum[0].length ; i++){
			System.out.print(arrNum[0][i] + "\t");
		}
		System.out.println();
		
		System.out.print("입력한 답:\t");
		for(int i = 0 ; i < arrNum[1].length ; i++){
			System.out.print(arrNum[1][i] + "\t");
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// TODO Auto-generated method stub
		mainPrint();
		String arrNum[][] = userInputCount(br);
		inputBeforeNum(br, arrNum);
		inputAfterNum(br, arrNum);
		resultProcess(arrNum);
		resultPrint(arrNum);
	}

}
