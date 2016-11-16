package day10;
/*
 * 2016_11_16
 * 
 * []i -> 전역 변수 ( 뒤에 있는 모든 변수를 적용 )
 * i[] -> 지역 변수 ( 해당 변수만 적용 ) 
 * 
 * int []i,j,k -> i , j , k 모두 배열로 선언
 * int i[],j -> i는 배열 , j는 일반 변수
 * int []i[],j -> i는 2차원 배열 , j는 1차원 배열
 * int i[][],j -> i는 2차원 배열 , j는 일반 변수
 * int []i[],j[] -> i는 2차원 배열 , j는 2차원 배열
 */
public class Day10_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*int arr[][];
		
		arr = new int[3][2];
		
		arr[0][0] = 10;
		arr[0][1] = 20;
		//arr[0][2] = 30; //  java.lang.ArrayIndexOutOfBoundsException: 2
		arr[1][0] = 40;
		
		System.out.println("arr[0][1] = " + arr[0][1]);
		System.out.println("arr[2][0] = " + arr[2][0]);
		
		for(int i = 0 ; i < arr.length ; i++){
			for(int j = 0 ; j < arr[i].length ; j++){
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}*/
		
		double arr2[][] = new double[3][];
		
		arr2[0] = new double[7]; // 2차원 배열에서 각각 사이즈를 다르게 지정할 수 있다.
		arr2[1] = new double[3];
		arr2[2] = new double[5];
		
		for(int i = 0 ; i < arr2.length; i++){
			for(int j = 0 ; j < arr2[i].length; j++){
				System.out.print(arr2[i][j] + " ");
			}
			System.out.println();
		}
	}

}

