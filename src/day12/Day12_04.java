package day12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 
 * ��� ���� ��� �Ͻ� �̴ϱ�? 5
 * ����� : 6
 * 12
 * ����� : 17
 * 20
 * ����� : 9
 *  :
 *  :
 *  �ϱ��� ���� �Է�
 *  1�� ���� :
 *    :
 *    :
 *  n�� ���� :
 *  
 *  ����:
 *  �Է��� ��:
 */
public class Day12_04 {
	
	/** ����ȭ�� ��� ��� */
	public static void mainPrint(){
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("\t\t\t\t���� ���߱� ���� v1.0\t\t\t\t");
		System.out.println("--------------------------------------------------------------------------------");
	}
	
	/** ����� ���� ���� �Է� ��� 
	 * @param br 
	 * @throws IOException 
	 * @throws NumberFormatException */
	public static String[][] userInputCount(BufferedReader br) throws NumberFormatException, IOException{
		
		int inputCount;
		
		System.out.print("�� ���� ���� ��� �Ͻǰ̴ϱ� ? ");
		inputCount = Integer.parseInt(br.readLine());
		
		//System.out.println(inputCount);
		
		String arrNum[][] = new String[2][inputCount];
		
		return arrNum; 
	}
	
	/** ���� ���� �Է� ��� */
	public static void inputBeforeNum(BufferedReader br, String[][] arrNum) throws IOException{
		
		for(int i = 0 ; i < arrNum[0].length; i++){
			if(i % 2 == 0){ //Ȧ �� ��° �ϰ�� ����� �Է�
				System.out.print("����� : ");
				arrNum[0][i] = br.readLine();
			} else if (i % 2 == 1) { // ¦ �� ��° �ϰ�� ��ǻ�� �Է�
				arrNum[0][i] =  Integer.toString((int)(Math.random()*99+1));
				System.out.println("��ǻ�� : " + arrNum[0][i]);
			}
		}
	}

	/** ��� ���� �Է� ��� 
	 * @throws IOException */
	public static void inputAfterNum(BufferedReader br, String[][] arrNum) throws IOException{
		
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("�ϱ��� ���� �Է� >>");
		for(int i = 0 ; i < arrNum[0].length ; i++){
			System.out.print( (i+1) + "��° ���� : ");
			arrNum[1][i] = br.readLine();
		}
	}

	/** ��� ó�� ��� */
	public static void resultProcess(String[][] arrNum){

		for(int i = 0 ; i < arrNum[0].length ; i++){
			if( !(arrNum[0][i].equals(arrNum[1][i])) ){
				arrNum[1][i] = "[" + arrNum[1][i] + "]";
				
			}
		}
	}
	
	/** ��� ��� ��� */
	public static void resultPrint(String[][] arrNum){
		
		System.out.print("����\t:\t");
		for(int i = 0 ; i < arrNum[0].length ; i++){
			System.out.print(arrNum[0][i] + "\t");
		}
		System.out.println();
		
		System.out.print("�Է��� ��:\t");
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
