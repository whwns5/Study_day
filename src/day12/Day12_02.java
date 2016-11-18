package day12;

import java.io.IOException;
/*
 * 2016_11_18
 * 
 * ���������� ���� v2 (�����)
 */
public class Day12_02 {

	/** �޴���� ���� �޼���*/
	public static void printMenu(){
		System.out.println("=========================");
		System.out.println("| ���� ���� �� ���� v2.0 |");
		System.out.println("-------------------------");
		System.out.println("1.���� 2.���� 3.�� 4. ����");
	}
	
	/** ����� �� �Է°��� �޼��� */
	public static int userInput() throws IOException{
		
		int user = 0;
		do{
			System.out.print("�޴� : ");
			user = System.in.read() - 48;
			System.in.skip(2);
		}while( !(user >= 1 && user <= 4));
		
		return user;
		
	}
	
	/** ���а��� �޼���*/
	public static void gameResult(int user){
		
		
		
		int com = (int)(Math.random()*3+1);
		
		System.out.println("����� : " + user);
		System.out.println("��ǻ�� : " + com);
		
		if(user == com){
			System.out.println("�����");
		}else if((user + 1) % 3 == com % 3){
			System.out.println("��ǻ�� ��!");
		}else {
			System.out.println("����� ��!");
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		while(true){
			printMenu();
			int menu = userInput();
			if(menu == 4){
				System.out.println("��ſ� �Ϸ� �Ǽ���.");
				System.exit(0);
			}
			gameResult(menu);
		}
		
		
	}

}
