package day06;

import java.io.IOException;

/*
 * 2016_11_10
 */
public class Day06_02 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.print("ù��°��:");
		int num1=System.in.read()-48; //System.in.read�� 1�ڸ����� �ԷµǴ� ���
		System.in.skip(2);
		
		System.out.print("�ι�°��:");
		int num2=System.in.read()-'0'; //���������� �� �Է��� �ԷµȰ��� �Ѿ�� �׵ڿ� ���Ͱ� 2���� ���õȴ�.
		
		
		if(num1 > num2){
			System.out.println("num1�� ũ�� �� ���� :"+num1);
		} else {
			System.out.println("num2�� ũ�� �� ����:"+num2);
		}
	}

}
