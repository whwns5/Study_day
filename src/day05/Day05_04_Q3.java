package day05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

/*
 * 2011_11_09
 * 
 * ����ڷ� ���� �������� �Է¹޾� ���� ���̸� ���ϱ�
 */
public class Day05_04_Q3 {
	
	final static double pi = Math.PI;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		 
		double rad; // ������
		double area; //���� ����
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		System.out.print("�������� �Է��ϼ��� : ");
		// rad = Integer.parseInt(br.readLine()); // Exception in thread "main" java.lang.NumberFormatException: For input string: "10.4"
												  // ��ġ ��ȯ �ַ��� ����.
		
		rad = Double.parseDouble(br.readLine());
		
		area = rad * rad * pi;
		System.out.println("�������� \'" + rad + "\'�� ���� ���̴� \'" + area + "\' �Դϴ�.");
		
		System.out.printf("�Ҽ��� ���ڸ� �� ���� ǥ�� : %.2f \n", area); // prinf �� �̿��Ͽ� �Ҽ��� x�ڸ� ���� ǥ������
		
		//DecimalFormat df = new DecimalFormat("#.00");
		DecimalFormat df = new DecimalFormat();
		df.applyLocalizedPattern("#.00");	// # -> ���� ������ �� ���� ä��� ���� ������ ������� �ʴ´�.
											// 0 -> ���� ������ �� ���� ä��� ���� ������ 0���� ä���.
		
		
		
		String formatStr = df.format(area); // ������ �����ص� �������� ���ο� ���ڿ��� �����.
		
		

		
	}

}
