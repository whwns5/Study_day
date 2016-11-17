package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/*
 * 회문 알고리즘
 *  - 문자열을 뒤집어도 같은 문자열이 되는지 판별하는 알고리즘
 *  
 */
public class Palindrome {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String inputStr = "";
		String tempStr = "";
		
		
		System.out.print("문자열을 입력하세요 : ");
		inputStr = br.readLine();
		
		//String 객체의 문자열을 역순으로 다시 저장하는 알고리즘
//		for(int i = inputStr.length()-1 ; i >= 0 ; i--){		// 문자열을 역순으로 돌면서
//			tempStr += inputStr.charAt(i);
//		
//		}
		
//		System.out.println("뒤집어진 문자열      : " + tempStr);
//		
//		if( inputStr.equals(tempStr) ){				// 뒤집어진 문자열과 전 문자열을 비교하여 같으면 회문
//			System.out.println("회문 입니다.");
//		}else{
//			System.out.println("회문이 아닙니다.");
//		}
		
		StringBuffer tempStr2 = new StringBuffer(inputStr);
		
		tempStr2.reverse();
	
		
		
		System.out.println("뒤집어진 문자열      : " + tempStr2);
		
		if( inputStr.equals(tempStr2) ){				// 뒤집어진 문자열과 전 문자열을 비교하여 같으면 회문
			System.out.println("회문 입니다.");
		}else{
			System.out.println("회문이 아닙니다.");
		}
		
		
		
		
		
	}

}
