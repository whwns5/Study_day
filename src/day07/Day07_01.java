package day07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 2016_11_11
 */
public class Day07_01 {
	public static void main(String[] args)throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("��������:");
		int kor=Integer.parseInt(br.readLine());
		
		System.out.print("��������:");
		int eng=Integer.parseInt(br.readLine());
		
		System.out.print("��������:");
		int met=Integer.parseInt(br.readLine());
		
		int sum=kor+eng+met;
		double avg=sum/3.0;
		
		int levelValue=(int)(avg/10);
		
		
		char level='F';
		
		switch(levelValue){
		case 10:level='A';break;
		case 9:level='A';break;
		case 8:level='B';break;
		case 7:level='C';break;
		case 6:level='D';break;
		default:level='F';break;
		}
		System.out.println(levelValue);
		System.out.println("����:"+sum+"��");
		System.out.println("���:"+avg+"��");
		System.out.println("����:"+level+"��");
		
		
	}
}
