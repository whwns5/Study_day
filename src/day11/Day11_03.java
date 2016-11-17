package day11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 2016_11_17
 */
public class Day11_03 {
	
	public static int cal(int num1, int num2, char oper){
		int result = 0;
		
		switch(oper){
		case '+' : result = num1 + num2; break;
		case '-' : result = num1 - num2; break;
		case '*' : result = num1 * num2; break;
		case '/' : result = num1 / num2; break;
		}
		
		return result;
	}

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("ù��° �� : ");
		int num1 = Integer.parseInt(br.readLine());
		
		System.out.print("�ι�° �� : ");
		int num2 = Integer.parseInt(br.readLine());
		
		System.out.print("������ (+, -, *, /) : ");
		char oper = (char)br.read();					// br.read() -> int ������ 1byte �޾Ƶ���
		
		int result = cal(num1, num2, oper);
		
		System.out.println(num1 + " " + oper + " " + num2 + " = " + result); 
		

	}

}
