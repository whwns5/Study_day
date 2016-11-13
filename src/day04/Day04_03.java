package day04;
/*
 * 2016_11_08
 * 
 * 프로그램
 *  - 사용자와 컴퓨터가 서로 의사소통을 하면서 사용자가 원하는 결과 값을 도출하기 위한 도구.
 */
public class Day04_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*삼항 연산자*/
		int a = 30;
		int b = 20;
		
		int max;
		max = a > b ? a : b; // 자바의 삼항 연산자는 목적이 값의 반환이다.
		
		System.out.println("max = " + max);
		
		String result;
		result = a > b ? "A : " + a + "가 큽니다." : "B : " + b + "큽니다.";
		
		
		
		System.out.println(result);
	}

}
