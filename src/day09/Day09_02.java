package day09;

/*
 * 2016_11_15
 * 
 * 배열 이란?
 * 
 * 자료형이 동일한 여러 개의 값을 연속적으로
 * 저장할 수 있도록 하는 기억공간의 집합체.
 * (동종의 데이터를 저장할 수 있는 자료구조)
 * 
 * 1. 선언하기 
 *  자료형 배열명[];
 *  자료형 []배열명;
 *  
 * 2. 메모리 생성하기
 *  배열명 = new 자료형[개수];
 *  
 * 3. 초기화 하기
 *  배열명[인덱스] = 값;
 */
public class Day09_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//자바에서는 배열부터가 객체
		
		int arr[]; // 1.선언(구청신고)
		arr = new int[3]; // 2.생성(건물짓기) 3개의 방
		arr[0] = 10; // 3.초기화(입주)
		arr[1] = 20;
		arr[2] = 30;

		System.out.println("arr[0] = " + arr[0]);
		//System.out.println("arr[3] = " + arr[3]); //  java.lang.ArrayIndexOutOfBoundsException: 3 에러
		System.out.println("arr[2] = " + arr[2]);
		System.out.println("arr의 길이 : " + arr.length); // 자바에서는 배열이 객체 이기때문에 접근 연산자를 이용해 length 메소드를 이용.
														 // .length -> 배열의 길이 반환
		
		// 1.선언 과 2.생성을 동시에
		double arr2[] = new double[5];
		arr2[0] = 10.1;
		arr2[1] = 20.2;
		arr2[2] = 30.3;
		
		System.out.println("arr2[0] = " + arr2[0]);
		System.out.println("arr2[1] = " + arr2[1]);
		System.out.println("arr2[4] = " + arr2[4]); // 자바에서는 배열에 대한 객체가 생성되는 순간 
													// 해당하는 자료형의 기본 값으로 초기화 된다.
		System.out.println("arr2의 길이 : " + arr2.length);
		
		
		// 1.선언 과 2.생성 과 3.초기화 를 동시에
		int arr3[] = {10, 20, 30, 40, 50, 60, 70}; // 테스트 혹은 절대 바뀌지 않는 배열일때 사용하는 것을 추천!
		
		System.out.println("arr3[0] = " + arr3[0]);
		
		for(int i = 0 ; i < arr3.length ; i++){
			System.out.println("arr3[" + i + "] = " + arr3[i]);
		}
		
		for (int i : arr3) {
			
		}
		
		for (int j : arr3) {
			System.out.println(j);
		}

	}

}
