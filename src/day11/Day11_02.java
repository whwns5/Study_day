package day11;
/*
 * Method
 * 
 * 프로그램의 유연성을 위하여 반복되어 사용되는
 * 내용을 묶어 특정이름을 관리하는 것.
 * 
 * 접근제한자 [지정예약어] 반환타입 메소드명 (매개변수들)
 *  지정예약어
 *   - static -> 프로그램의 시작부터 메모리에 생성.
 *  반환타입
 *   - void -> 반환값이 없다.
 *   
 * 1. Call by name
 *  	ex) Math.random(), System.in.read(), xLine()..
 * 2. Call by reference
 *      ex) refTest(int arr[])
 * 3. Call by value
 * 	     원본에 대한 훼손이 없다.
 * 	    ex) getSum(int a, int b), valueTest(int a, int b)
 */
public class Day11_02 {

	// Call by name
	public static void xLine(){

		System.out.println("-------------------------------");
	
	}
	
	// Call by value
	public static int getSum(int a, int b){
		int sum = a + b;
		return sum; // 메서드를 종료하는 보조 제어문
	}
	
	// Call by value
	public static void valueTest(int a, int b){
		int temp = a;
		a = b;
		b = temp;
		System.out.println("a = " + a + ", b = " + b); 
	}
	
	// Call by reference
	public static void refTest(int arr[]){
		
		arr[2] = 1004;
		for(int i = 0 ; i < arr.length ; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		xLine();
//		System.out.println("이름 : 홍길동");
//		xLine();
//		System.out.println("나이 : 20살");
//		xLine();
//		System.out.println("주소 : 서울");
//		xLine();
		
//		int a = 10;
//		int b = 20;
		
		// Call by value
		//int sum = getSum(a, b);
		//System.out.println("a = " + a + ", b = " + b);
		//System.out.println(sum);
		
		// Call by value
//		System.out.println("a = " + a + ", b = " + b);
//		valueTest(a, b);
//		System.out.println("a = " + a + ", b = " + b);
		
		int arr[] = {10, 20, 30, 40, 50};
		
		for(int i = 0; i < arr.length ; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		refTest(arr);
		
		for(int i = 0; i < arr.length ; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();

		
	}

}
