package day06;

import java.io.IOException;
/*
 * 2016_11_10
 */
public class Day06_04 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.print("�����Է�:");
		
		int user=System.in.read();
		
		if(user >= 48 && user <= 57){
			System.out.println(user + "�� ���� �����Դϴ�.");
			
		} else if( (user >= 65 && user <= 90) || (user >= 97 && user <= 122) ){
			System.out.println(user + "�� ���� �������Դϴ�.");
			
		} else {
			System.out.println(user + "�� ���� ��Ÿ�����Դϴ�.");
		}
	}

}
