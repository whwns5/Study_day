package day11;
/*
 * Method
 * 
 * ���α׷��� �������� ���Ͽ� �ݺ��Ǿ� ���Ǵ�
 * ������ ���� Ư���̸��� �����ϴ� ��.
 * 
 * ���������� [���������] ��ȯŸ�� �޼ҵ�� (�Ű�������)
 *  ���������
 *   - static -> ���α׷��� ���ۺ��� �޸𸮿� ����.
 *  ��ȯŸ��
 *   - void -> ��ȯ���� ����.
 *   
 * 1. Call by name
 *  	ex) Math.random(), System.in.read(), xLine()..
 * 2. Call by reference
 *      ex) refTest(int arr[])
 * 3. Call by value
 * 	     ������ ���� �Ѽ��� ����.
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
		return sum; // �޼��带 �����ϴ� ���� ���
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
//		System.out.println("�̸� : ȫ�浿");
//		xLine();
//		System.out.println("���� : 20��");
//		xLine();
//		System.out.println("�ּ� : ����");
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
