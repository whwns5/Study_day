package day06;

import java.io.IOException;
/*
 * 2016_11_10
 */
public class Day06_05 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("1.¥�� 2.«�� 3.������ 4.�Ⱥ�ä");
		System.out.print("�޴��� �Է��ϼ��� :");
		int menu = System.in.read() - 48;
		
		switch (menu) {
		case 1:
			System.out.println("¥�� ����!");
			break;
		case 2:
			System.out.println("«�� ����!");
			break;
		case 3:
			System.out.println("������ ����!");
			break;
		case 4:
			System.out.println("�Ⱥ�ä ����!");
			break;
		default:
			System.out.println("�߸��� �޴��� �����ϼ̽��ϴ�.");
			break;
		}
	}

}
