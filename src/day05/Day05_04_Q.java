package day05;
import java.io.*;
/*
 * 2016_11_09
 * 
 * Wrapper class
 *  - ��ȣȭ�� �ϱ� ���� ���
 *   �⺻ �ڷ����� Stack ������ ����Ǳ� ������ �� ����Ʈ�� �����Ǿ� �ִ��� �� �� ������, Wrapper class�� 
 *   ���� Heep������ ����ǰ� �ּҹ����� Stack�� ����Ǳ� ������ ��ȣȭ�� ����.
 * 
 * BufferedReader�� Ȱ���Ͽ� �� ���� �Է¹ް� ���ϱ⸦ �����ϴ� ���α׷�
 * ù��° �� :30
 * �ι�° �� : 50
 * �μ��� �� : 30 + 50 = 80
 * 
 */
public class Day05_04_Q {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br;
		
		String firstInput;
		String secondInput;
		int sum;
		
		br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("ù��° ���� �Է��ϼ��� : ");
		firstInput = br.readLine();
		
		System.out.print("�ι�° ���� �Է��ϼ��� : ");
		secondInput = br.readLine(); // Enter Ű�� �������� ó���ϱ� ������ ���� Enter 
									 //	Ű�� ó������ �ʿ䰡 ����.
		// sum = (int)firstInput + (int)secondInput; // ����ȯ (ĳ����) �� ���� �ڷ������θ� ����. ���ڸ� ����, ���ڸ� ����
		sum = Integer.parseInt(firstInput) + Integer.parseInt(secondInput);

		System.out.println(firstInput + " + " + secondInput + " = " + sum);
	}

}
