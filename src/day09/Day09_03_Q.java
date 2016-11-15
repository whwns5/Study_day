package day09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 2016_11_15
 * 
 * ����ڷ� ���� 5���� ������ �Է¹޾� �Է¹��� ������
 * ������������ �����Ͽ� ����Ͻÿ�.
 * 
 * Selection Sort
 * 1. �� ����ڿ� �� ����� ����
 * 2. �� ����ڴ� ó������ ����
 *    �� ����ڴ� �� ����� �������� ����
 * 3. �� ����ڰ� ������ ���� �񱳸� ���� ��
 *    �׶� �� ����ڴ� �������� �Ѿ��.
 */
public class Day09_03_Q {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int arr[] = new int[5];
		int temp = 0;
	
		System.out.print("5���� ���� �Է��ϼ��� :");
		for(int i = 0 ; i < arr.length; i++){
				arr[i] = Integer.parseInt(br.readLine());
		}

		for(int i = 0 ; i < arr.length ; i++){ // �� �����
			for(int j = i + 1 ; j < arr.length ; j++){ // �� �����
				if(arr[i] < arr[j]){
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
		System.out.println("-----�������� �����ϱ�---");
		for(int i = 0 ; i < arr.length ; i++){
			System.out.print(arr[i] + " ");
		}
	}

}
