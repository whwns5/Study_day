package day05;
import java.io.*;
import java.text.DecimalFormat;
/*
 * 2016_11_09
 * 
 * ���� ���� ���� ������ ����ڷκ���
 * �Է¹޾� ������ ����� ����Ͻÿ�.
 */
public class Day05_04_Q2 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		int kor; // ��������
		int eng; // ��������
		int mat; // ��������
		int sum; // ����
		double avg; // ���
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("���� ������ �Է��ϼ��� :"); 
		kor = Integer.parseInt(br.readLine());		// ���� ���� �Է�
		
		System.out.print("���� ������ �Է��ϼ��� :"); 
		eng = Integer.parseInt(br.readLine());		// ���� ���� �Է�
		
		System.out.print("���� ������ �Է��ϼ��� :");
		mat = Integer.parseInt(br.readLine());		// ���� ���� �Է�
		
		sum = kor + eng + mat;	// ���� ���
		avg = sum/(double)3;	// ��� ���
		//avg = sum/3.0;	// ��� ���
		
		DecimalFormat df = new DecimalFormat("#.##");

		System.out.println("���� : " + sum + " ��� : " + df.format(avg));
		
		
		
	}

}
