package day09;

/*
 * 2016_11_15
 * 
 * �迭 �̶�?
 * 
 * �ڷ����� ������ ���� ���� ���� ����������
 * ������ �� �ֵ��� �ϴ� �������� ����ü.
 * (������ �����͸� ������ �� �ִ� �ڷᱸ��)
 * 
 * 1. �����ϱ� 
 *  �ڷ��� �迭��[];
 *  �ڷ��� []�迭��;
 *  
 * 2. �޸� �����ϱ�
 *  �迭�� = new �ڷ���[����];
 *  
 * 3. �ʱ�ȭ �ϱ�
 *  �迭��[�ε���] = ��;
 */
public class Day09_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//�ڹٿ����� �迭���Ͱ� ��ü
		
		int arr[]; // 1.����(��û�Ű�)
		arr = new int[3]; // 2.����(�ǹ�����) 3���� ��
		arr[0] = 10; // 3.�ʱ�ȭ(����)
		arr[1] = 20;
		arr[2] = 30;

		System.out.println("arr[0] = " + arr[0]);
		//System.out.println("arr[3] = " + arr[3]); //  java.lang.ArrayIndexOutOfBoundsException: 3 ����
		System.out.println("arr[2] = " + arr[2]);
		System.out.println("arr�� ���� : " + arr.length); // �ڹٿ����� �迭�� ��ü �̱⶧���� ���� �����ڸ� �̿��� length �޼ҵ带 �̿�.
														 // .length -> �迭�� ���� ��ȯ
		
		// 1.���� �� 2.������ ���ÿ�
		double arr2[] = new double[5];
		arr2[0] = 10.1;
		arr2[1] = 20.2;
		arr2[2] = 30.3;
		
		System.out.println("arr2[0] = " + arr2[0]);
		System.out.println("arr2[1] = " + arr2[1]);
		System.out.println("arr2[4] = " + arr2[4]); // �ڹٿ����� �迭�� ���� ��ü�� �����Ǵ� ���� 
													// �ش��ϴ� �ڷ����� �⺻ ������ �ʱ�ȭ �ȴ�.
		System.out.println("arr2�� ���� : " + arr2.length);
		
		
		// 1.���� �� 2.���� �� 3.�ʱ�ȭ �� ���ÿ�
		int arr3[] = {10, 20, 30, 40, 50, 60, 70}; // �׽�Ʈ Ȥ�� ���� �ٲ��� �ʴ� �迭�϶� ����ϴ� ���� ��õ!
		
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
