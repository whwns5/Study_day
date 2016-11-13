package day06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 2016_11_10
 * 
 * 사용자로부터 수를 입력받아 홀수 인지 짝수 인지
 * 판별하는 프로그램
 */
public class Day06_04_Q {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int num;
		
		System.out.print("첫번째수:");

		num = Integer.parseInt(br.readLine()); 
		
		if(num%2 == 0){	// 2를 나눈 나머지를 구하여 0이 나올경우 짝수, 1이 나올경우 홀수
			System.out.println("짝수입니다");
		} else {
			System.out.println("홀수입니다");
		}
	}
}
