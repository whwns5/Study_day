package day11;

import java.io.IOException;

/*
 * 2016_11_17
 * 
 * 1. ����ڷκ��� ����
 * �Է¹޾� �ش��ϴ� ���� ����ϴ� ���α׷� �ۼ�
 */
public class Day11_02_Q {
	
	public static void gugu(int numDan){
		for(int i = 1 ; i < 10 ; i++){
			System.out.println(numDan + " * " + i + " = " + (numDan*i));
		}
		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.print("���� �Է��ϼ��� :");
		int numDan = System.in.read() - '0';
		
		gugu(numDan);
		
	}

}
