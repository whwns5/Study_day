package day05;

import java.io.IOException;
/*
 * 2016_11_09
 * 
 * 1. import java.io.IOException; -> System.in 클래스를 사용하기 위해 import
 * 2. public static void main(String[] args) throws IOException { -> 예외처리
 * 
 */
public class Day05_02 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		System.out.println("A");
		
		int a;
		a = System.in.read(); // 값을 하나만 입력 받으며 아스키코드 값으로 저장
		
		System.out.println("B");
		
		System.out.println(a);
		
		
	}

}
