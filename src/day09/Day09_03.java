package day09;
/*
 * 2016_11_15
 * 
 * 배열 -> 레퍼런스 자료형
 * 
 * 레퍼런스의 특징
 *  1. 대입이 가능하다
 *  2. 스왑이 가능하다
 *  3. 복사시 데이터가아닌 주소가 복사된다.
 */
public class Day09_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {10, 20, 30, 40, 50, 60, 70};
		//int arr[] = new int[6];
//		arr[0] = 10;
//		arr[1] = 20;
//		arr[2] = 30;
//		arr[3] = 40;
//		arr[4] = 50;
//		arr[5] = 60;
		
		
		/*for(int i = 0 ; i < arr.length ; i++){
			System.out.println(arr[i] + " ");
		}
		
		arr = new int[3]; // 레퍼런스 자료형이기 때문에 new로 객체를 생성하는 순간 데이터는 heep영역에 저장되므로 
		
		for(int i = 0 ; i < arr.length ; i++){	 
			System.out.println(arr[i] + " ");
	
		}*/
		
		/*int x[] = {10, 20, 30, 40};
		int y[] = {100, 200, 300};
		
		for(int i = 0 ; i < x.length ; i++){
			System.out.print(x[i] + " ");
		}
		System.out.println();
		for(int i = 0 ; i < y.length ; i++){
			System.out.print(y[i] + " ");
		}
		System.out.println();
		
		System.out.println("----------------------------------");
		
		int temp[] = x; // 배열은 대입이 가능하다.
		x = y;
		y = temp;
		
		for(int i = 0 ; i < x.length ; i++){
			System.out.print(x[i] + " ");
		}
		System.out.println();
		for(int i = 0 ; i < y.length ; i++){
			System.out.print(y[i] + " ");
		}*/
		
		int x[] = {10, 20, 30, 40, 50};
		
		for(int i = 0 ; i < x.length ; i++){
			System.out.print(x[i] + " "); // 10 20 30 40 50 
		}
		System.out.println();

		int y[] = x; // x의 heep영역 주소를 복사
		y[2] = 1004;
		
		for(int i = 0 ; i < y.length ; i++){
			System.out.print(y[i] + " "); // 10 20 1004 40 50 
		}
		System.out.println();
		
		for(int i = 0 ; i < x.length ; i++){
			System.out.print(x[i] + " "); // 10 20 1004 40 50 
		}								  // 레퍼런스의 특징
		System.out.println();
		
		
		
	}

}
