package day06;

import java.io.IOException;
/*
 * 2016_11_10
 */
public class Day06_03 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("1.¥�� 2.«�� 3.������ 4.�Ⱥ�ä");
		
		System.out.print("�޴� ��ȣ�� �Է��ϼ��� :");
		
		int menu = System.in.read() - 48;
		
		if(menu==1){
			System.out.println("¥��");
		} else if(menu == 2) {
			System.out.println("«��");
		} else if(menu == 3) {
			System.out.println("������");
		} else {
			System.out.println("�Ⱥ�ä");
		}
	}

}
