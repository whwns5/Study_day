package day04;
/*
 * 2016_11_08
 * 
 * ���α׷�
 *  - ����ڿ� ��ǻ�Ͱ� ���� �ǻ������ �ϸ鼭 ����ڰ� ���ϴ� ��� ���� �����ϱ� ���� ����.
 */
public class Day04_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*���� ������*/
		int a = 30;
		int b = 20;
		
		int max;
		max = a > b ? a : b; // �ڹ��� ���� �����ڴ� ������ ���� ��ȯ�̴�.
		
		System.out.println("max = " + max);
		
		String result;
		result = a > b ? "A : " + a + "�� Ů�ϴ�." : "B : " + b + "Ů�ϴ�.";
		
		
		
		System.out.println(result);
	}

}
