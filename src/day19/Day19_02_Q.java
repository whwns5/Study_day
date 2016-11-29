package day19;

import java.util.Scanner;

/*
 * 2016_11_29
 * 
 * 문자열을 입력바도 선택한 문자의 출현회수 출력하기
 * 
 * 문자열 입력 : hello~java!
 * 찾을 문자 : a
 * a의 문자는 총 2개입니다.
 * 
 */
public class Day19_02_Q {
	public static void main(String[] args){
		
		
		Scanner sc = new Scanner(System.in);
		int count = 0;
		
		System.out.print("문자열을 입력하세요 : ");
		String inputStr = sc.nextLine();
		
		System.out.println("입력한 문자열 : " + inputStr);
		
		System.out.print("찾을 문자를 입력하세요 : ");
		String findStr = sc.nextLine();
		
		System.out.println("찾을 문자열 : " + findStr);
		
		for(int i = 0 ; i <= inputStr.length() - findStr.length(); i++){
			String temp = inputStr.substring(i, i + findStr.length());
			if(temp.equals(findStr)){
				count++;
			}
		}
		
		
		System.out.println(findStr + " 의 문자는 총 " + count + " 개 입니다.");
		
	}
}
