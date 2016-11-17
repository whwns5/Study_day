package day11;

import java.io.IOException;

/*
 * 2016_11_17
 * 
 * ��Ģ ���� �����
 * 
 * ù��° �� : 3				--> main
 * �ι�° �� : 5				--> main
 * ������ (+, -, *, /) : +	--> main
 * 		����					--> cal
 * 3+5=8 					--> main
 * 
 * 
 */
public class Day11_02_Q2 {
	
	public static int cal(int firstNum, int secondNum, int oper){
		int result = 0;
		
		switch (oper) {
		case 43:		// 43 -> +
			result = firstNum + secondNum;
			break;
		case 45:		// 45 -> -
			result = firstNum - secondNum;
			break;
		case 42:		// 42 -> *
			result = firstNum * secondNum;
			break;
		case 47:		// 47 -> /
			result = firstNum / secondNum;
			break;
		default:
			break;
		}
		
		return result;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int firstNum;
		int secondNum;
		int oper;
		int result;
		
		System.out.print("ù��° �� �Է� : ");
		firstNum = System.in.read() - '0';
		System.in.skip(2);
		
		System.out.print("�ι�° �� �Է� : ");
		secondNum = System.in.read() - '0';
		System.in.skip(2);
		
		System.out.print("������ �Է� : ");
		oper = System.in.read();
		System.in.skip(2);
		
		
		
//		System.out.println("firstNum = " + firstNum);
//		System.out.println("secondNum = " + secondNum);
//		System.out.println("oper = " + oper);
		
		result = cal(firstNum, secondNum, oper);
		
		System.out.println(firstNum + " " + (char)oper + " " + secondNum + " = " + result);
		
		
	}

}
