package day05;
import java.io.IOException;
/*
 * 2016_11_09
 * 
 * �� ���� �Է¹ް� ���ϱ⸦ �����ϴ� ���α׷�
 * ù��° �� :3
 * �ι�° �� : 5
 * �μ��� �� : 3 + 5 = 8
 * 
 */
public class Day05_03_Q {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		int first;
		int second;
		int sum;
		   /* 0 ~ 9 : 48 ~ 57
		    * A ~ Z : 65 ~ 90
		    * a ~ z : 97 ~ 122
		    * \n	: 13
		    * \r	: 10
		    */

		System.out.print("ù��° �� :");
		first = System.in.read();
		System.in.skip(2);
		first = first - 48;
		
		System.out.print("�ι�° �� :");
		second = System.in.read();
		System.in.skip(2);
		second = second - '0'; // '0' ���ڷ� -���ص�  �ƽ�Ű�ڵ� ���� 48�� �� �� �ִ�.
		
		sum = first + second;
		System.out.println(first + " + " + second + " = " + sum);
		
	

	}

}
