package day05;
import java.io.*;
/*
 * 2016_11_09
 * 
 */
public class Day05_04 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		String name;
		BufferedReader br;
		//InputStreamReader in;
		
		br = new BufferedReader(new InputStreamReader(System.in));
		// System.in (�� ��Ʈ��) �� 1����Ʈ�� �Է� ���� �� �ֱ� ������ ���׷��̵尡 �ʿ�.
		// InputStreamReader (���� ��Ʈ��) �� ��Ʈ���� �̿��Ͽ� 2����Ʈ ��Ʈ������ ����
		// BufferedReader 2����Ʈ�� ���ڸ� �������� �޾� ���ڿ��� �ޱ� ����
		
		System.out.print("����� �̸��� ? ");
		
		name = br.readLine();
		
		System.out.println("�� ~ �̸��� \"" + name + "\" �̱���");

	}

}
