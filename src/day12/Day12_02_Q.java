package day12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 2016_11_18
 * 
 * ���� �߱� ���� v2.0
 */
public class Day12_02_Q {
	
	/** �޴� ȭ�� ��� */
	public static void menuPrint(){
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("\t\t\t\t���� �߱� ���� v2.0\t\t\t\t");
		System.out.println("--------------------------------------------------------------------------------");
	}
	
	/** ����� �Է� ��� 
	 * @throws IOException */
	public static void inputUser(int[] arrInputUser) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("0~9 ������ ���� 3���� �Է��ϼ��� : ");
		for(int i = 0 ; i < arrInputUser.length; i++){
			arrInputUser[i] = br.read() - '0';
		}
	}
	
	/** ��ǻ�� ���� ���� ��� */
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
		
		System.out.print("���� : ");
		for(int i = 0 ; i < arrCreateCom.length ; i++){
			System.out.print(arrCreateCom[i] + " ");
		}
		System.out.println();
	}
	
	/** ���ó�� ��� */
	public static boolean resultProcess(int gameCount, int[] arrInputUser, int[] arrCreateCom, int[][][] arrGameData){
		
		boolean isClear = false;
		
		int arrSB[] = new int[2];

		for(int i = 0 ; i < arrInputUser.length ; i++){
			for(int j = 0 ; j < arrCreateCom.length ; j++){
				if( arrInputUser[i] == arrCreateCom[j] ) {	//�� ���� ���� ���
					if( i == j ) { //��ġ�� ���� ���
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
		
		if(arrSB[0] == 3){ // ��Ʈ����ũ�� 3�̸�
			isClear = true;
		}
		
		resultPrint(gameCount, arrGameData);
		
		return isClear;
	}
	
	
	/** ������ ��� */
	public static void resultPrint(int gameCount, int[][][] arrGameData){
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("  ȸ��\t ù��°           �ι�°                ����°             ��Ʈ����ũ                ��");
		System.out.println("--------------------------------------------------------------------------------");
		for(int i = 0 ; i <= gameCount ; i++){
			System.out.print((i+1) + "ȸ��  >>>  ");
			
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
			arrGameData[i][0] = new int[3];	// ����� �Է� ��ȣ �迭
			arrGameData[i][1] = new int[2]; // ��Ʈ����ũ ī����
		}
		
		menuPrint();
		createRandNum(arrCreateCom);
		
		for(int gameCount = 0; gameCount < 10 ; gameCount++){
			inputUser(arrInputUser);
			if( resultProcess(gameCount, arrInputUser, arrCreateCom, arrGameData) ){ //Ŭ���� �̴ٸ�
				System.out.println((gameCount+1) + "ȸ���� Ŭ���� �ϼ̽��ϴ�. !!");
				System.exit(0);
			}		
		}
		System.out.println("10ȸ�� ���� ��ȸ�� ��� �Ҹ� �ϼ̽��ϴ�.");
	}

}
