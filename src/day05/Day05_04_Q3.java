package day05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

/*
 * 2011_11_09
 * 
 * 사용자로 부터 반지름을 입력받아 원의 넓이를 구하기
 */
public class Day05_04_Q3 {
	
	final static double pi = Math.PI;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		 
		double rad; // 반지름
		double area; //원의 넒이
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		System.out.print("반지름을 입력하세요 : ");
		// rad = Integer.parseInt(br.readLine()); // Exception in thread "main" java.lang.NumberFormatException: For input string: "10.4"
												  // 수치 변환 애러가 난다.
		
		rad = Double.parseDouble(br.readLine());
		
		area = rad * rad * pi;
		System.out.println("반지름이 \'" + rad + "\'인 원의 넓이는 \'" + area + "\' 입니다.");
		
		System.out.printf("소수점 두자리 수 까지 표현 : %.2f \n", area); // prinf 를 이용하여 소수점 x자리 까지 표현가능
		
		//DecimalFormat df = new DecimalFormat("#.00");
		DecimalFormat df = new DecimalFormat();
		df.applyLocalizedPattern("#.00");	// # -> 값이 있으면 그 값을 채운고 값이 없으면 출력하지 않는다.
											// 0 -> 값이 있으면 그 값을 채우고 값이 없으면 0으로 채운다.
		
		
		
		String formatStr = df.format(area); // 패턴을 지정해둔 포맷으로 새로운 문자열을 만든다.
		
		

		
	}

}
