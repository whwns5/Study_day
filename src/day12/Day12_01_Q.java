package day12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 2016_11_18
 * 
 * ���������� ���� v2
 */
public class Day12_01_Q {
	
	/** ���� ���� ��� 
	 * @throws IOException */
	public static int checkMenu(BufferedReader br) throws IOException{
		int menuState = 0;
		char chMenu;
		
		System.out.println("--------------------------------------");
		System.out.println("               ���� ���� �� ����            ");
		System.out.println("--------------------------------------");
		
		while(true){
			System.out.println("������ �����Ͻðڽ��ϱ�?");
			System.out.println("  Y. ���ӽ���     N. ����");
			System.out.print(">> ");
			chMenu = (char)br.read();
			br.skip(2);
			
			if( (chMenu == 'y' || chMenu == 'Y' || chMenu == 'n' || chMenu == 'N') ){
				break;
			} else {
				System.out.println("�߸� �Է� �ϼ̽��ϴ�. ");
			}
		}
		
		switch (chMenu) {
		case 'y':
		case 'Y':
			menuState = 1;
			break;
		case 'n':
		case 'N':
			System.out.println("������ �����մϴ�.");
			System.exit(0);
			break;
		default:
			break;

		}
		
		return menuState;
	}
	
	/** ����� �Է� ���
	 * @param br 
	 * @throws IOException */
	public static int inputUser(BufferedReader br) throws IOException{
		
		int inputMenu;
		
		//System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		//System.out.println();
		
		System.out.println("--------------------------------------");
		System.out.println("      ���� �޴� �� �ϳ��� �Է��ϼ���.     ");
		
		while(true){
			System.out.println("--------------------------------------");
			System.out.println("  1. ����  2. ����  3. ��  4. ó������  ");
			System.out.println("--------------------------------------");
			//System.out.println("\n\n");
			System.out.print(">> ");
			
			inputMenu = br.read() - '0';
			br.skip(2);
			
			if(inputMenu == 1 || inputMenu == 2 || inputMenu == 3 || inputMenu == 4){
				
				break;
			} else {
				System.out.println("�߸� �Է��ϼ̽��ϴ�. ");
			}
		}
		
		
		return inputMenu;
		
	}

	/** ��ǻ�� ���� ���� ��� */
	public static int createRand(){
		int randNum;
		randNum = (int)(Math.random()*3+1);
		return randNum;
	}
	
	/** ���� ó�� ��� */
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
			System.out.println("���� ó�� ��� ����");
			break;
		}
		
		return gameResult;
	}

	/** ��� ��� ��� */
	public static void resultPrint(int userNum, int comNum, String gameResult){
		StringBuffer resultString= new StringBuffer();
		resultString.append("���� : ");
		
		switch (userNum) {
		case 1:
			resultString.append("����");
			break;
		case 2:
			resultString.append("����");
			break;
		case 3:
			resultString.append("��");
			break;
		default:
			break;
		}
		
		resultString.append("\n��ǻ�� : ");
		switch (comNum) {
		case 1:
			resultString.append("����");
			break;
		case 2:
			resultString.append("����");
			break;
		case 3:
			resultString.append("��");
			break;
		default:
			break;
		}
		
		resultString.append("\n��� : ");
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
				menuState = checkMenu(br); // 0 -> 1�ܰ� �޴�ȭ��  , 1 - > 2�ܰ� �޴�ȭ��
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
