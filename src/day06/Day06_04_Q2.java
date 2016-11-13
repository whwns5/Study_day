package day06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
/*
 * 2016_11_10
 * 
 * ����ڷκ��� ����, ����, ���� ������ �Է¹޾� ����
 * �� ����� ����ϴ� ���α׷�
 */
public class Day06_04_Q2 {
	public static void main(String[] args)throws IOException{
		
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			/*System.in �� 1����Ʈ ���� �ԷµǹǷ� 2����Ʈ �Է��̰����� InputStreamReader ������Ʈ������ Ȯ��� 
	                    ���ڿ� �Է��� ������ BufferedReader������Ʈ�� �� Ȯ���� br������ ������ �ʱ�ȭ */ 
	    
	    DecimalFormat bo=new DecimalFormat("avg");
	    bo.applyLocalizedPattern("#.00");
	    
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
			
			                                       //������ �̿��� �������ɾ� �ش�������� �������
			if(avg>=90){                           //������ 90���� ũ�ų� ������ "���� A"���
				System.out.println("����:A");   
			}else if(avg>=80){                     //������ 80���� ũ�ų� ������ "���� B"���
				System.out.println("����:B");
			}else if(avg>=70){
				System.out.println("����:C");
			}else if(avg>=60){
				System.out.println("����:D");
			}else {
				System.out.println("����:F");
			}
			
		}
}
