package day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 2016_11_16
 * 
 * 배열을 이용한 선택정렬(Selection Sort) 알고리즘
 */
public class Day10_01 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		/*
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int arr[] = new int[5];
		
		for(int i = 0 ; i < arr.length ; i++){
			System.out.print(i+1+"번째 점수 :");
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i = 0 ; i < arr.length - 1 ; i++){ // 주대상자 담당 for
			for(int j = i + 1 ; j < arr.length ; j++){ // 비교대상자 담당 for
				if(arr[i] < arr[j]){
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
		for(int i = 0 ; i < arr.length ; i++){
			System.out.print(arr[i] + " ");
		}
		*/
		int gameData[] = new int[3];
		
		for(int i = 0 ; i < gameData.length ; i++){   		// gameData[0][1] -> 컴퓨터 난수 번호 배열 (int comNum[])
			gameData[i] = (int)(Math.random()*10);
			for(int j = 0; j < i; j++){
				if(gameData[i] == gameData[j]){
					i--;
					break;
				}
			}		
		}
		
		for(int i = 0 ; i < gameData.length ; i++){
			System.out.print(gameData[i] + " ");
		}
		
		
		
		
	}

}
