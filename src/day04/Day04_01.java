package day04;
/*
 * 2016_11_08
 * 
 * Day03 복습
 * 
 * javadoc 만들기
 *  프로젝트 선택 -> Export -> 자바파일 선택 -> javadoc 선택 -> finish
 */
public class Day04_01 {
	/**테스트 주석*/
	public int test(){
		return 0;
	}
	/** 프로그램 시작 메서드*/
	public static void main(String[] args){
		
		boolean bool = true; // 논리 자료형
		System.out.println("bool = " + bool);
		
		int in = 10;
		System.out.println("in = " + in);
		
		double dou = 10.234; // 기본 자료형
		System.out.println("dou = " + dou);
		
		String str = "홍길동"; // 레퍼런스 자료형
		System.out.println("str = " + str);
		
		
	}
}
