package day05;
import java.io.*;
/*
 * 2016_11_09
 * 
 * Wrapper class
 *  - 보호화를 하기 위해 사용
 *   기본 자료형은 Stack 영역에 저장되기 때문에 몇 바이트로 구성되어 있는지 알 수 있지만, Wrapper class를 
 *   사용시 Heep영역에 저장되고 주소번지만 Stack에 저장되기 때문에 보호화가 가능.
 * 
 * BufferedReader를 활용하여 두 수를 입력받고 더하기를 수행하는 프로그램
 * 첫번째 수 :30
 * 두번째 수 : 50
 * 두수의 합 : 30 + 50 = 80
 * 
 */
public class Day05_04_Q {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br;
		
		String firstInput;
		String secondInput;
		int sum;
		
		br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("첫번째 수를 입력하세요 : ");
		firstInput = br.readLine();
		
		System.out.print("두번째 수를 입력하세요 : ");
		secondInput = br.readLine(); // Enter 키를 기준으로 처리하기 때문에 따로 Enter 
									 //	키를 처리해줄 필요가 없다.
		// sum = (int)firstInput + (int)secondInput; // 형변환 (캐스팅) 은 같은 자료형으로만 가능. 숫자면 숫자, 문자면 문자
		sum = Integer.parseInt(firstInput) + Integer.parseInt(secondInput);

		System.out.println(firstInput + " + " + secondInput + " = " + sum);
	}

}
