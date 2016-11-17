package day11;

import java.io.IOException;

/*
 * 2016_11_17
 * 
 * 1. 사용자로부터 단을
 * 입력받아 해당하는 단을 출력하는 프로그램 작성
 */
public class Day11_02_Q {
	
	public static void gugu(int numDan){
		for(int i = 1 ; i < 10 ; i++){
			System.out.println(numDan + " * " + i + " = " + (numDan*i));
		}
		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.print("단을 입력하세요 :");
		int numDan = System.in.read() - '0';
		
		gugu(numDan);
		
	}

}
