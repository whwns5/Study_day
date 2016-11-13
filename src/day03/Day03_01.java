package day03;
/*
 * 2011_11_07
 * 
 * 상수(Constant)(고유하다) ex. 농구공, 야구공 ..
 *  - 항상 일정한 값을 유지하는 데이터
 * 변수(Variable) ex. 바구니
 *  - 특정 상황에 따라 변화하는 데이터
 *  - _ , $ 를 제외한 특수문자 사용 불가
 * 자료형 ex. 어떤 크기의 바구니에 담을지 명시
 * - 상수나 변수의 데이터 크기를 규정화 한 것.
 * 
 * 기본 자료형 
 * boolean	1 byte 
 * byte		1 byte -128 ~ 127 
 * char		2 byte 0 ~ 65535
 * short 	2 byte
 * int 		4 byte (기본자료형)
 * long 	8 byte
 * float 	4 byte
 * double 	8 byte (기본자료형)
 * 
 * 1 byte(데이터를 저장하는 최소 단위) = 8 bit(데이터를 표현하는 최소 단위)
 * 
 * 형 변환
 *  - 특정 자료형 값을 다른 자료형에 대입 하는 것.
 * byte-char-short-int-long
 * -------Promotion------->
 * <-------Casting---------
 * 
 * 형 변환 방법
 *  (자료형)식 ex) (byte)(a+b)
 */
public class Day03_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("1. 논리 자료형");
		boolean bool; //변수 선언 
		bool = true; //변수 초기화 // 1 byte
//		System.out.println("bool = "bool);	// Syntax 에러(문법 에러)
		System.out.println("bool = " + bool); // + -> 데이터와 데이터를 연결해주는 의미
		
		boolean bool2 = false; // 변수 선언과 동시에 초기화
		System.out.println("bool2 = " + bool2);
		
		
		System.out.println("2. 정수 자료형");
//		byte by = 128; // Type mismatch 에러. byte 의 범위는 -128 ~ 127
		byte by = 127; // 1 byte
		by++; // 간접 오버 플로우
		//by++;
		System.out.println("by = " + by);
		
		
		System.out.println("3. 문자 자료형");
		//char ch = 'A'; // 2 byte
		char ch = 'A' + 1; // 실제 char는 정수 데이터(정수 자료형)이기 때문 가능. 아스키코드
							/* 0 ~ 9 : 48 ~ 57
						    * A ~ Z : 65 ~ 90
						    * a ~ z : 97 ~ 122
						    * \n	: 13
						    * \r	: 10
						    */
		System.out.println("ch = " + ch);
		
		char ch2 = 'A' + 1;
//		System.out.println("ch2 = " + (ch2 + 1)); // 결과 67 -> 65 + 1 이 연산되면서 int로 인식하기 때문
		System.out.println("ch2 = " + (char)(ch2 + 1)); // 형변환을 통해 char로 지정한다.
		
		short sh = 1004; // 2 byte
		System.out.println("sh = " + sh);
		
		int in = 10004; // 4 byte
		System.out.println("in = " + in);
		
		byte a = 3;
		byte b = 4;
//		byte result = a + b; // Type mismatch 에러. a+b를 int로 인식하기 때문
//		int result = a + b;
		byte result = (byte) (a + b); // 형변환을 a+b를 byte로 형변환 하여 저장
		System.out.println("result = " + result);
		
//		long lo = 10004; // 10004를 int로 먼저 인식하지만 더큰 바구니인 long에 int를 넣기 때문 오류가 나지 않는다. 캐스팅 작업이 진행
		long lo = 10004L; // L를 붙이면 바로 long으로 인식한다. // 8 byte
		System.out.println("lo = " + lo);
		
		
		System.out.println("3. 실수 자료형");
//		float f1 = 3.123; // Type mismatch 에러. 3.123 을 먼저 설계되어 있는 double로 인식하기 때문에 
		float f1 = 3.123f; // 4 byte
		System.out.println("f1 = " + f1);
		
		double dou = 1.234; // 8 byte
		System.out.println("dou = " + dou);

	}
}
