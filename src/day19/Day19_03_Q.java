package day19;

import java.util.Scanner;

/*
 * 2016_11_29
 * 
 * �������� ������ ������ �ִ� �迭�� �ϳ� ����.
 * 
 * ������Ʈ �˻� ����� ����
 * 
 * ������ �˻��� : java
 * java .. 
 * 
 */
public class Day19_03_Q {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		String str[] = new String[15];
		str[0] = "java is good";
		str[1] = "d does java";
		str[2] = "jsp is mine";
		str[3] = "�迭�̶� �׷���";
		str[4] = "�� ��� ����";
		str[5] = "�̸��� �ɾƺ���";
		str[6] = "������ �϶��δ�";
		str[7] = "���� ���� ���� �� �˾Ҵµ�";
		str[8] = "���� ���� �־���.";
		str[9] = "���д� ������ ��Ӵ�";
		str[10] = "star is real";
		str[11] = "lol";
		str[12] = "lol is diamond";
		str[13] = "�׻������";
		str[14] = "����� �Ͼ�";
		
		System.out.print("������ �˻��� : ");
		
		String searchStr = sc.nextLine();
		
		for(int i = 0 ; i < str.length ; i++){
			//if( str[i].indexOf(searchStr) != -1){
			if( str[i].indexOf(searchStr) == 0){
				System.out.println((i+1) + " ��° �� : " + str[i]);
			}
		}
		
	
		
	}

}
