package day19;

import java.util.Scanner;

public class Day19_01_Q {
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("� ���� ? ");
		String inputAnimal = sc.nextLine(); // String �� �����ϰ� new �� ������� �ʰ� ��ä�� ������ �� �ִ� Ŭ����

		System.out.println("�Է��� ���� : " + inputAnimal);

		// if(inputAnimal == "������") -> �ּҿ� �������� �� �߱⶧�� x
		
		if (inputAnimal.equals("������")) {
			System.out.println("�۸�");
		} else if (inputAnimal.equals("�����")) {
			System.out.println("�߿�");
		} else if (inputAnimal.equals("����")) {
			System.out.println("�в�");
		}
		
		
		
		
	}
}
