package day03;
/*
 * 2011_11_07
 * 
 * ���� ���� ���� ������ ������ ��Ƽ�
 * ������ ����ϼ���.
 * 
 * ��� :
 * ���� : 000��
 */
public class Day03_01_Q {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int kor; // ���� ����
		int eng; // ���� ����
		int math; // ���� ����
		int sum; // ����
		
		kor = 85;
		eng = 75;
		math = 90;
		
		sum = kor + eng + math;
		
		System.out.println("���� : " + sum);
		System.out.println("���� : " + kor + eng + math + "��"); // ���ڿ��� ���� ���Ա� ������ �ڿ� ������ + �����ڰ� ���� �����ڷ� �۵�
		System.out.println(kor + eng + math + "��"); // int�� ������ ���� ���Ա� ������ + �����ڰ� ���� ���� �۵�
		System.out.println("���� : " + (kor + eng + math) + "��"); // ( ) �� �̿��Ͽ� �켱 ������ �ٲ��ش�.
	}

}
