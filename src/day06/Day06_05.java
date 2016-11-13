package day06;

import java.io.IOException;
/*
 * 2016_11_10
 */
public class Day06_05 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("1.짜장 2.짬뽕 3.탕수육 4.팔보채");
		System.out.print("메뉴를 입력하세요 :");
		int menu = System.in.read() - 48;
		
		switch (menu) {
		case 1:
			System.out.println("짜장 선택!");
			break;
		case 2:
			System.out.println("짬뽕 선택!");
			break;
		case 3:
			System.out.println("탕수육 선택!");
			break;
		case 4:
			System.out.println("팔보채 선택!");
			break;
		default:
			System.out.println("잘못된 메뉴를 선택하셨습니다.");
			break;
		}
	}

}
