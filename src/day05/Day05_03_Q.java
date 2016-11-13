package day05;
import java.io.IOException;
/*
 * 2016_11_09
 * 
 * 두 수를 입력받고 더하기를 수행하는 프로그램
 * 첫번째 수 :3
 * 두번째 수 : 5
 * 두수의 합 : 3 + 5 = 8
 * 
 */
public class Day05_03_Q {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		int first;
		int second;
		int sum;
		   /* 0 ~ 9 : 48 ~ 57
		    * A ~ Z : 65 ~ 90
		    * a ~ z : 97 ~ 122
		    * \n	: 13
		    * \r	: 10
		    */

		System.out.print("첫번째 수 :");
		first = System.in.read();
		System.in.skip(2);
		first = first - 48;
		
		System.out.print("두번째 수 :");
		second = System.in.read();
		System.in.skip(2);
		second = second - '0'; // '0' 문자로 -를해도  아스키코드 값인 48로 뺄 수 있다.
		
		sum = first + second;
		System.out.println(first + " + " + second + " = " + sum);
		
	

	}

}
