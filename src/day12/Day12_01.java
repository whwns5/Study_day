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
	
	
	/** 입력관련 메서드 */
	public static void arrInput(int[] arr) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0 ; i < arr.length ; i++){
			System.out.print((i+1) + "번째 점수 : ");
			arr[i] = Integer.parseInt(br.readLine());
		}
		
	}
	
	/** 정렬관련 메서드 */
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
	
	/** 출력관련 메서드 */
	public static void arrPrint(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		// 1. 공간할당
		int arr[] = new int[5];
		// 2. 입력
		arrInput(arr);
		// 3. 정렬
		arrSort(arr);
		// 4. 출력
		arrPrint(arr);
	}
}
