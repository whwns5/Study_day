package day10;
/*
 * 2016_11_16
 * 
 * []i -> ���� ���� ( �ڿ� �ִ� ��� ������ ���� )
 * i[] -> ���� ���� ( �ش� ������ ���� ) 
 * 
 * int []i,j,k -> i , j , k ��� �迭�� ����
 * int i[],j -> i�� �迭 , j�� �Ϲ� ����
 * int []i[],j -> i�� 2���� �迭 , j�� 1���� �迭
 * int i[][],j -> i�� 2���� �迭 , j�� �Ϲ� ����
 * int []i[],j[] -> i�� 2���� �迭 , j�� 2���� �迭
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
		
		arr2[0] = new double[7]; // 2���� �迭���� ���� ����� �ٸ��� ������ �� �ִ�.
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

