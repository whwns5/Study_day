package day12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 2016_11_18
 * 
 * 
 * 
 */
public class Day12_01 {
	
	
	/** �Է°��� �޼��� */
	public static void arrInput(int[] arr) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0 ; i < arr.length ; i++){
			System.out.print((i+1) + "��° ���� : ");
			arr[i] = Integer.parseInt(br.readLine());
		}
		
	}
	
	/** ���İ��� �޼��� */
	public static void arrSort(int[] arr){
		
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] < arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
	
	/** ��°��� �޼��� */
	public static void arrPrint(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		// 1. �����Ҵ�
		int arr[] = new int[5];
		// 2. �Է�
		arrInput(arr);
		// 3. ����
		arrSort(arr);
		// 4. ���
		arrPrint(arr);
	}
}
