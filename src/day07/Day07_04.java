package day07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 2016_11_11
 */
public class Day07_04 {
	public static void main(String[] args)throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("���� �Է�:");
		int user=Integer.parseInt(br.readLine());
		
		for(int i=2; i<user; i++){
			if(user%i==0){ //�Է��� user�� ���� i�� ���� �������� 0�̵Ǹ� �����̴�. 
				System.out.println("�Է���"+user+"�� ���� �Ҽ��� �ƴϴ�");
				System.exit(0);/*�ݺ��� �����߿� �ѹ��̶� ������ ����Ǹ� ����� ����ȴ�. ������� 10�� �Է��ϸ� 2,5 �Ѵ� �������� 0������ 
                                                                  ���������� 2������ �ݺ��� ���ǿ����� ������ �ǹǷ� �ٷ� ���ᰡ �ȴ�.*/
         
			}
		}
		System.out.println("�Է���"+user+"�� ���� �Ҽ��̴�");
	}
}
