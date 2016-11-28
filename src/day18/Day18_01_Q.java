package day18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 
 * �� ���� �����͸� �Է��Ͻ� �ſ���? 3
 * ������ 1 �� : 10
 * ������ 2 �� : 20
 * ������ 3 �� : 0
 * 
 * ����ϰ� ���� ���� ���°�� �ֳ���? 2
 * ������ ���� : 20
 * 
 * 
 */
public class Day18_01_Q {
	
	public static void main(String[] args){
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int arrNum[];
		
		try{
			System.out.print("�� ���� �����͸� �Է��Ͻ� �ſ��� ? ");
			int inputArrLength = Integer.parseInt(br.readLine());
			
			arrNum = new int[inputArrLength];
			
			for(int i = 0 ; i < arrNum.length ; i++){
				System.out.print("������ " + (i+1) + " �� : ");
				arrNum[i] = Integer.parseInt(br.readLine());
			}
		
			System.out.print("��� �ϰ���� ���� �� ��°�� �ֳ��� ? ");
			int printIndex = Integer.parseInt(br.readLine());
			
			System.out.println("������ ���� : " + arrNum[printIndex - 1]);
			
		}catch(IOException e){
			
			e.printStackTrace();
		}catch(NumberFormatException e){
			System.out.println("���ڸ� �Է��� �ּ���.");
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("��° ���� ���� �Է��ϼ���.");
		}catch(NegativeArraySizeException e){
			System.out.println("����� �Է��� �ּ���.");
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		System.out.println("�ý�������");
		
		
		
		
	
	}
}
