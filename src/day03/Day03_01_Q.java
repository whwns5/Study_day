package day03;
/*
 * 2011_11_07
 * 
 * 국어 영어 수학 점수를 변수에 담아서
 * 총점을 출력하세요.
 * 
 * 결과 :
 * 총점 : 000점
 */
public class Day03_01_Q {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int kor; // 국어 점수
		int eng; // 영어 점수
		int math; // 수학 점수
		int sum; // 총점
		
		kor = 85;
		eng = 75;
		math = 90;
		
		sum = kor + eng + math;
		
		System.out.println("총점 : " + sum);
		System.out.println("총점 : " + kor + eng + math + "점"); // 문자열이 먼저 나왔기 때문에 뒤에 나오는 + 연산자가 연결 연산자로 작동
		System.out.println(kor + eng + math + "점"); // int형 변수가 먼저 나왔기 때문에 + 연산자가 덧샘 으로 작동
		System.out.println("총점 : " + (kor + eng + math) + "점"); // ( ) 를 이용하여 우선 순위를 바꿔준다.
	}

}
