package day08;

import java.io.IOException;

/*
 * 2016_11_4
 * 
 * tweetv1@naver.com
 * 
 * ���� : ����_����1_������
 * ���� : �ڵ� ����
 * ÷�� ���� : .java ����
 * 
 */
public class Day08_03_Q {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		int inputNum = 0;
		int randomNum;
		String tempStr = "";
		
		System.out.println("-------------------------------------------------------");
		System.out.println("\t\t�� ����  ����  ��  ���� ��");
		System.out.println("-------------------------------------------------------");
		System.out.println("1. ����\t\t2. ����\t\t 3. ��\t\t4. ����");
		System.out.println("-------------------------------------------------------");
		
		while(true){
			
			System.out.print("���� > ");
			inputNum = System.in.read() - '0';
			System.in.skip(2);
			
			if(inputNum == 4){
				System.out.println("������ ���� �ϼ̽��ϴ�.");
				System.exit(0);
			}else if( !(inputNum >= 0 && inputNum <= 9) ){
				
				System.out.println("\n�߸� �Է� �ϼ̽��ϴ�. ���� �޴��߿� �ش��ϴ� ��ȣ�� �Է��ϼ���.");
				System.out.println("-------------------------------------------------------");
				System.out.println("1. ����\t\t2. ����\t\t 3. ��\t\t4. ����");
				System.out.println("-------------------------------------------------------");
				continue;
			} 
			
			
			randomNum = (int)(Math.random()*3+1);
			
			switch (inputNum) {
			case 1:
				tempStr = "����";
				break;
			case 2:
				tempStr = "����";
				break;
			case 3:
				tempStr = "��";
				break;
			default:
				break;
			}
	
			System.out.println("����� : " + tempStr);
			
			switch (randomNum) {
			case 1:
				tempStr = "����";
				break;
			case 2:
				tempStr = "����";
				break;
			case 3:
				tempStr = "��";
				break;
			default:
				break;
			}
			
			System.out.println("��ǻ�� : " + tempStr);
			
			
			if(inputNum == randomNum){
				System.out.println("�����ϴ�.\n");
			} else if( (inputNum == 1 && randomNum == 2) || (inputNum == 2 && randomNum == 3) || (inputNum == 3 && randomNum == 1) ) {
				System.out.println("�����ϴ�.\n");
			} else if( (inputNum == 1 && randomNum == 3) || (inputNum == 2 && randomNum == 1) || (inputNum == 3 && randomNum == 2) ) {
				System.out.println("�̰���ϴ�.\n");
			} 
			
			
		}
	}

}
