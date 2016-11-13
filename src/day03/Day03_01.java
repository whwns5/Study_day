package day03;
/*
 * 2011_11_07
 * 
 * ���(Constant)(�����ϴ�) ex. �󱸰�, �߱��� ..
 *  - �׻� ������ ���� �����ϴ� ������
 * ����(Variable) ex. �ٱ���
 *  - Ư�� ��Ȳ�� ���� ��ȭ�ϴ� ������
 *  - _ , $ �� ������ Ư������ ��� �Ұ�
 * �ڷ��� ex. � ũ���� �ٱ��Ͽ� ������ ���
 * - ����� ������ ������ ũ�⸦ ����ȭ �� ��.
 * 
 * �⺻ �ڷ��� 
 * boolean	1 byte 
 * byte		1 byte -128 ~ 127 
 * char		2 byte 0 ~ 65535
 * short 	2 byte
 * int 		4 byte (�⺻�ڷ���)
 * long 	8 byte
 * float 	4 byte
 * double 	8 byte (�⺻�ڷ���)
 * 
 * 1 byte(�����͸� �����ϴ� �ּ� ����) = 8 bit(�����͸� ǥ���ϴ� �ּ� ����)
 * 
 * �� ��ȯ
 *  - Ư�� �ڷ��� ���� �ٸ� �ڷ����� ���� �ϴ� ��.
 * byte-char-short-int-long
 * -------Promotion------->
 * <-------Casting---------
 * 
 * �� ��ȯ ���
 *  (�ڷ���)�� ex) (byte)(a+b)
 */
public class Day03_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("1. �� �ڷ���");
		boolean bool; //���� ���� 
		bool = true; //���� �ʱ�ȭ // 1 byte
//		System.out.println("bool = "bool);	// Syntax ����(���� ����)
		System.out.println("bool = " + bool); // + -> �����Ϳ� �����͸� �������ִ� �ǹ�
		
		boolean bool2 = false; // ���� ����� ���ÿ� �ʱ�ȭ
		System.out.println("bool2 = " + bool2);
		
		
		System.out.println("2. ���� �ڷ���");
//		byte by = 128; // Type mismatch ����. byte �� ������ -128 ~ 127
		byte by = 127; // 1 byte
		by++; // ���� ���� �÷ο�
		//by++;
		System.out.println("by = " + by);
		
		
		System.out.println("3. ���� �ڷ���");
		//char ch = 'A'; // 2 byte
		char ch = 'A' + 1; // ���� char�� ���� ������(���� �ڷ���)�̱� ���� ����. �ƽ�Ű�ڵ�
							/* 0 ~ 9 : 48 ~ 57
						    * A ~ Z : 65 ~ 90
						    * a ~ z : 97 ~ 122
						    * \n	: 13
						    * \r	: 10
						    */
		System.out.println("ch = " + ch);
		
		char ch2 = 'A' + 1;
//		System.out.println("ch2 = " + (ch2 + 1)); // ��� 67 -> 65 + 1 �� ����Ǹ鼭 int�� �ν��ϱ� ����
		System.out.println("ch2 = " + (char)(ch2 + 1)); // ����ȯ�� ���� char�� �����Ѵ�.
		
		short sh = 1004; // 2 byte
		System.out.println("sh = " + sh);
		
		int in = 10004; // 4 byte
		System.out.println("in = " + in);
		
		byte a = 3;
		byte b = 4;
//		byte result = a + b; // Type mismatch ����. a+b�� int�� �ν��ϱ� ����
//		int result = a + b;
		byte result = (byte) (a + b); // ����ȯ�� a+b�� byte�� ����ȯ �Ͽ� ����
		System.out.println("result = " + result);
		
//		long lo = 10004; // 10004�� int�� ���� �ν������� ��ū �ٱ����� long�� int�� �ֱ� ���� ������ ���� �ʴ´�. ĳ���� �۾��� ����
		long lo = 10004L; // L�� ���̸� �ٷ� long���� �ν��Ѵ�. // 8 byte
		System.out.println("lo = " + lo);
		
		
		System.out.println("3. �Ǽ� �ڷ���");
//		float f1 = 3.123; // Type mismatch ����. 3.123 �� ���� ����Ǿ� �ִ� double�� �ν��ϱ� ������ 
		float f1 = 3.123f; // 4 byte
		System.out.println("f1 = " + f1);
		
		double dou = 1.234; // 8 byte
		System.out.println("dou = " + dou);

	}
}
