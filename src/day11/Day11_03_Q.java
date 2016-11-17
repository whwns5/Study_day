package day11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 2016_11_17
 * 
 * ����ڷκ��� 5���� ���� �Է� �ް�
 * ����
 * 
 * ����
 * main(){ 
 * 
 *  1. arrInput 
 *  2. arrSort
 * 	3. arrPrint
 * }
 * 
 *  * Selection Sort
 * 1. �� ����ڿ� �� ����� ����
 * 2. �� ����ڴ� ó������ ����
 *    �� ����ڴ� �� ����� �������� ����
 * 3. �� ����ڰ� ������ ���� �񱳸� ���� ��
 *    �׶� �� ����ڴ� �������� �Ѿ��.
 */
public class Day11_03_Q {
	
	public static void arrInput(int inputNum[]) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int i = 0 ; i < inputNum.length ; i++){
			System.out.print((i+1) + "��° �� �Է� : ");
			inputNum[i] = Integer.parseInt(br.readLine());
		}
	}
	
	public static void arrSort(int inputNum[]){
		for(int i = 0 ; i < inputNum.length; i++){
			for(int j = i + 1 ; j < inputNum.length ; j++){
				if( inputNum[i] > inputNum[j] ){
					int temp = inputNum[i];
					inputNum[i] = inputNum[j];
					inputNum[j] = temp;
				}
			}
		}
	}
	
	public static void arrPrint(int inputNum[]){
		System.out.print("���� ���� ���� ��� : ");
		for(int i = 0 ; i < inputNum.length ; i++){
			System.out.print(inputNum[i] + " ");
		}
	}

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		int inputNum[] = new int[5];
		arrInput(inputNum);
		arrSort(inputNum);
		arrPrint(inputNum);	
	}

}
