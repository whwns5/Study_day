package day09;
/*
 * 2016_11_15
 * 
 * �迭 -> ���۷��� �ڷ���
 * 
 * ���۷����� Ư¡
 *  1. ������ �����ϴ�
 *  2. ������ �����ϴ�
 *  3. ����� �����Ͱ��ƴ� �ּҰ� ����ȴ�.
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
		
		arr = new int[3]; // ���۷��� �ڷ����̱� ������ new�� ��ü�� �����ϴ� ���� �����ʹ� heep������ ����ǹǷ� 
		
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
		
		int temp[] = x; // �迭�� ������ �����ϴ�.
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

		int y[] = x; // x�� heep���� �ּҸ� ����
		y[2] = 1004;
		
		for(int i = 0 ; i < y.length ; i++){
			System.out.print(y[i] + " "); // 10 20 1004 40 50 
		}
		System.out.println();
		
		for(int i = 0 ; i < x.length ; i++){
			System.out.print(x[i] + " "); // 10 20 1004 40 50 
		}								  // ���۷����� Ư¡
		System.out.println();
		
		
		
	}

}
