package day11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 2016_11_17
 * 
 * 사용자로부터 5가지 수를 입력 받고
 * 오름
 * 
 * 구조
 * main(){ 
 * 
 *  1. arrInput 
 *  2. arrSort
 * 	3. arrPrint
 * }
 * 
 *  * Selection Sort
 * 1. 주 대상자와 비교 대상자 존재
 * 2. 주 대상자는 처음부터 시작
 *    비교 대상자는 주 대상자 다음부터 시작
 * 3. 비교 대상자가 마지막 까지 비교를 했을 때
 *    그때 주 대상자는 다음으로 넘어간다.
 */
public class Day11_03_Q {
	
	public static void arrInput(int inputNum[]) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int i = 0 ; i < inputNum.length ; i++){
			System.out.print((i+1) + "번째 수 입력 : ");
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
		System.out.print("오름 차순 정렬 결과 : ");
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
