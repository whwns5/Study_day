package day05;
import java.io.*;
/*
 * 2016_11_09
 * 
 */

public class Day05_03 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		int first; //ù��° ��
		int second; //�ι�° ��
		int third; //����° ��
		
		System.out.print("ù��° �� :");
		first = System.in.read(); // ù��° �� �Է�
		//System.in.read(); // \n �� \r�� �޾� ������ ���
		//System.in.read();
		System.in.skip(2);
		
		System.out.print("�ι�° �� :");
		second = System.in.read(); // �ι�° �� �Է�
		//System.in.read();
		//System.in.read();
		System.in.skip(2);
		
		System.out.print("����° �� :");
		third = System.in.read(); // ����° �� �Է�
		//System.in.read();
		//System.in.read();
		System.in.skip(2);
		
		System.out.println(first + "/" + second + "/" + third); // ��� -> a�Է½� 97/13/10
																// ���� -> 97�� a�� �ƽ�Ű�ڵ�
																//		   13�� \n�� �ƽ�Ű�ڵ�
																//		   10�� \r�� �ƽ�Ű�ڵ�
		
		
		
		
		
	}

}
