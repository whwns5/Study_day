package day09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 2016_11_15
 * 
 * 사용자로 부터 5개의 정수를 입력받아 입력받은 정수를
 * 내림차순으로 정렬하여 출력하시오.
 * 
 * Selection Sort
 * 1. 주 대상자와 비교 대상자 존재
 * 2. 주 대상자는 처음부터 시작
 *    비교 대상자는 주 대상자 다음부터 시작
 * 3. 비교 대상자가 마지막 까지 비교를 했을 때
 *    그때 주 대상자는 다음으로 넘어간다.
 */
public class Day09_03_Q {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int arr[] = new int[5];
		int temp = 0;
	
		System.out.print("5개의 수를 입력하세요 :");
		for(int i = 0 ; i < arr.length; i++){
				arr[i] = Integer.parseInt(br.readLine());
		}

		for(int i = 0 ; i < arr.length ; i++){ // 주 대상자
			for(int j = i + 1 ; j < arr.length ; j++){ // 비교 대상자
				if(arr[i] < arr[j]){
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
		System.out.println("-----내림차순 정렬하기---");
		for(int i = 0 ; i < arr.length ; i++){
			System.out.print(arr[i] + " ");
		}
	}

}
