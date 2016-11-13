package day07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 2016_11_11
 */
public class Day07_02 {
	public static void main(String[] args)throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("ù��°��:");
		int num1=Integer.parseInt(br.readLine()); //
		
		
		System.out.print("�ι�°��:");
		int num2=Integer.parseInt(br.readLine());
		
		
		System.out.print("������(+,-,*,/):");
		char oper=(char) br.read();
		
		int result=0;
		
		switch(oper){
		
		case '+':result=num1+num2;break;
		case '-':result=num1-num2;break;
		case '*':result=num1*num2;break;
		case '/':result=num1/num2;
		}
		
		System.out.println(""+num1+oper+num2+"="+result);

	}
}
