package day06;

import java.io.IOException;
/*
 * 2016_11_10
 */
public class Day06_01 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.print("ù��°��:");
		int num1=System.in.read()-48;
		System.in.skip(2);
	
		System.out.print("�ι����:");
		int num2=System.in.read()-'0';
		System.in.skip(2);
		
		if(num2==0)
		{
			System.out.print("0���δ� ������ �����ϴ�.");
			System.exit(0); //0�� �Է��ϸ�  ����
		}
		
		System.out.println(num1+"/"+num2+"="+(num1/num2));
	}

}
