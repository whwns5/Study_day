package day05;
import java.io.*;
/*
 * 2016_11_09
 * 
 */

public class Day05_03 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		int first; //첫번째 수
		int second; //두번째 수
		int third; //세번째 수
		
		System.out.print("첫번째 수 :");
		first = System.in.read(); // 첫번째 수 입력
		//System.in.read(); // \n 와 \r을 받아 버리는 방법
		//System.in.read();
		System.in.skip(2);
		
		System.out.print("두번째 수 :");
		second = System.in.read(); // 두번째 수 입력
		//System.in.read();
		//System.in.read();
		System.in.skip(2);
		
		System.out.print("세번째 수 :");
		third = System.in.read(); // 세번째 수 입력
		//System.in.read();
		//System.in.read();
		System.in.skip(2);
		
		System.out.println(first + "/" + second + "/" + third); // 결과 -> a입력시 97/13/10
																// 이유 -> 97은 a의 아스키코드
																//		   13은 \n의 아스키코드
																//		   10은 \r의 아스키코드
		
		
		
		
		
	}

}
