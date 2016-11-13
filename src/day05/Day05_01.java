package day05;
/*
 * 2016_11_09
 * 
 * System.out.print("출력내용");
 * System.out.println("출력내용");
 * System.out.printf("문자서식",출력변수);
 */
public class Day05_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = "홍길동";
		int age = 20;
		
		System.out.println("이름 : " + name); // 개행이 포함되어 있다.
		System.out.println("나이 : " + age);
		
		System.out.print("이름 : " + name); // 개행이 포함되어 있지 않다.
		System.out.print("나이 : " + age);
		
		System.out.print("이름 : " + name + "\n"); // \n -> 개행 문자열 (제어 문자열)
		System.out.print("나\t이 : " + age + "\n"); // \t -> 탭 크기만큼 띠워쓰기
		System.out.print("이\r름 : " + name + "\n"); // \r -> 커서를 맨앞으로
		
		System.out.println("저의 이름은 \"홍길동\" 입니다."); // \" , \' -> 문자열안에 넣어 사용 가능
		
		
		System.out.printf("이름 : %s \n나이 : %d", name , age); // %s -> 문자열 형식  %d -> 숫자형 서식
		
		System.out.format("이름 : %s \n나이 : %d", name , age); // printf == format
		
		System.out.printf("실수 : %.2f", 3.123456); // %.2f -> 소수점 두자리수 까지 출력
	}

}
