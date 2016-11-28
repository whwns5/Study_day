package day18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 
 * 몇 개의 데이터를 입력하실 거에요? 3
 * 데이터 1 값 : 10
 * 데이터 2 값 : 20
 * 데이터 3 값 : 0
 * 
 * 출력하고 싶은 값이 몇번째에 있나요? 2
 * 선택한 값은 : 20
 * 
 * 
 */
public class Day18_01_Q {
	
	public static void main(String[] args){
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int arrNum[];
		
		try{
			System.out.print("몇 개의 데이터를 입력하실 거에요 ? ");
			int inputArrLength = Integer.parseInt(br.readLine());
			
			arrNum = new int[inputArrLength];
			
			for(int i = 0 ; i < arrNum.length ; i++){
				System.out.print("데이터 " + (i+1) + " 값 : ");
				arrNum[i] = Integer.parseInt(br.readLine());
			}
		
			System.out.print("출력 하고싶은 값이 몇 번째에 있나요 ? ");
			int printIndex = Integer.parseInt(br.readLine());
			
			System.out.println("선택한 값은 : " + arrNum[printIndex - 1]);
			
		}catch(IOException e){
			
			e.printStackTrace();
		}catch(NumberFormatException e){
			System.out.println("숫자를 입력해 주세요.");
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("번째 수를 재대로 입력하세요.");
		}catch(NegativeArraySizeException e){
			System.out.println("양수를 입력해 주세요.");
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		System.out.println("시스템종료");
		
		
		
		
	
	}
}
