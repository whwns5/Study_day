package day06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 2016_11_10
 * 
 * ����ڷκ��� ���� �Է¹޾� Ȧ�� ���� ¦�� ����
 * �Ǻ��ϴ� ���α׷�
 */
public class Day06_04_Q {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int num;
		
		System.out.print("ù��°��:");

		num = Integer.parseInt(br.readLine()); 
		
		if(num%2 == 0){	// 2�� ���� �������� ���Ͽ� 0�� ���ð�� ¦��, 1�� ���ð�� Ȧ��
			System.out.println("¦���Դϴ�");
		} else {
			System.out.println("Ȧ���Դϴ�");
		}
	}
}
