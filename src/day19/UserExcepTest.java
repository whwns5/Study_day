package day19;

import java.io.InputStreamReader;
import java.util.*;
/*
 * 2016_11_29
 * 
 */

class YongException extends Exception{ // Exception �� ��ӹ����� ���� Ŭ������ �ȴ�.
	
	public YongException() {
		// TODO Auto-generated constructor stub
		super("�� ���� : �̼����� �ȵ� !!! ");
	}
}

public class UserExcepTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Scanner sc = new Scanner(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		
		try{
			System.out.print("�� ��� ?");
			
			int age = sc.nextInt();
			
			if(age < 20){
				//System.out.println("�̼����ڴ� ���� �Ұ�");
				throw new YongException();
			}
			
			System.out.println("���� ȯ�� !!");
			
		}catch(YongException e){
			System.out.println("���� ������ ������ �� ����");
			e.printStackTrace();
		}
		
		
		System.out.println("���α׷� ���� ����");
		
	}

}
