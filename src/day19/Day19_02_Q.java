package day19;

import java.util.Scanner;

/*
 * 2016_11_29
 * 
 * ���ڿ��� �Է¹ٵ� ������ ������ ����ȸ�� ����ϱ�
 * 
 * ���ڿ� �Է� : hello~java!
 * ã�� ���� : a
 * a�� ���ڴ� �� 2���Դϴ�.
 * 
 */
public class Day19_02_Q {
	public static void main(String[] args){
		
		
		Scanner sc = new Scanner(System.in);
		int count = 0;
		
		System.out.print("���ڿ��� �Է��ϼ��� : ");
		String inputStr = sc.nextLine();
		
		System.out.println("�Է��� ���ڿ� : " + inputStr);
		
		System.out.print("ã�� ���ڸ� �Է��ϼ��� : ");
		String findStr = sc.nextLine();
		
		System.out.println("ã�� ���ڿ� : " + findStr);
		
		for(int i = 0 ; i <= inputStr.length() - findStr.length(); i++){
			String temp = inputStr.substring(i, i + findStr.length());
			if(temp.equals(findStr)){
				count++;
			}
		}
		
		
		System.out.println(findStr + " �� ���ڴ� �� " + count + " �� �Դϴ�.");
		
	}
}
