package day06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
/*
 * 2016_11_10
 */
public class Day06_05_Q {
public static void main(String[] args)throws IOException{
		
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			/*System.in �� 1����Ʈ ���� �ԷµǹǷ� 2����Ʈ �Է��̰����� InputStreamReader ������Ʈ������ Ȯ��� 
	                    ���ڿ� �Է��� ������ BufferedReader������Ʈ�� �� Ȯ���� br������ ������ �ʱ�ȭ */ 
	    DecimalFormat bo=new DecimalFormat();
	    bo.applyLocalizedPattern("#.#####");
	
	    /* DecimalFormat bo=new DecimalFormat(); ��
	    bo.applyLocalizedPattern("#.#####");����   |
	                                         |   |�������������� (int a;ó�� �������� new decimalFormat
	    int a;  ����������������������������������������������������������|��������         �� �ҷ��ͼ� bo��� �̸����� �ʱ�ȭ)
	    a = 10; ����������������������������������������������������������������������������������
	    
	    DecimalFormat bo=new DecimalFormat("#.#####");��������������
	    int a = 10;     ������������������������������������������������������������������   
	    */ 
			int met; //�������� 
			int eng; //��������
			int kor; //��������
			
			int sum; //����
			double avg; //���
		
			System.out.print("��������:"); 
			met = Integer.parseInt(br.readLine()); //���������� �Է¹����� ���ڿ��� ���ڷ� �ٲ۵� met�����ȿ� ����
			System.out.print("��������:");
			eng = Integer.parseInt(br.readLine()); // ���� ����
			System.out.print("��������:");
			kor = Integer.parseInt(br.readLine()); // ���� ����
			
			sum = met+eng+kor; //���� ���ϱ�
			avg = sum/3.0;       //��� ���ϱ� , �ڷ������� ����Ҷ� ����ū �ڷ��������� �ٲ� ���ȴ�.
			System.out.println("����:"+sum+"\n���:"+bo.format(avg)); //������ ��� ���ϱ�
			System.out.println("����:"+sum+"\n���:"+bo.format(avg)); //������ ��� ���ϱ�
			bo.applyLocalizedPattern("#.####");
			System.out.println("����:"+sum+"\n���:"+bo.format(avg)); //������ ��� ���ϱ�
			
			bo.applyLocalizedPattern("#.#####");
			System.out.println("����:"+sum+"\n���:"+bo.format(avg)); //������ ��� ���ϱ�
			
			int ca=(int)avg/10;   //�Ǽ��� ����ġ������ ���� *95/10=9 ������ 5
			switch(ca){
			
			case 10: System.out.println("����:A");   
			break;
			case 9: System.out.println("����:A");   
			break;
			case 8:	System.out.println("����:B");
			break;      
			case 7:	System.out.println("����:C");
			break;      
			case 6:	System.out.println("����:D");
			break;      
			default:System.out.println("����:F");
			}
			
		}
}
