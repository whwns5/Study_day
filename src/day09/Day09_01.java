package day09;

import java.io.IOException;

import org.omg.Messaging.SyncScopeHelper;

/*
 * 2016_11_15
 * 
 * 
 */
public class Day09_01 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		while(true){
			
			System.out.println("=====================");
			System.out.println("|���� ���� �� ���� v1.0|");
			System.out.println("---------------------");
			System.out.println("1.���� 2.���� 3.�� 4.����");
			System.out.println("=====================");
			
			int user = 0;
			
			do{
				System.out.print("�޴� >");
				user = System.in.read() - 48;
				System.in.skip(2); // 2����Ʈ�� ������.	
			}while( !(user >= 1 && user <= 4) );
			
			if(user == 4){
				System.out.println("���� �Ϸ� �Ǽ���~");
				System.exit(0);
			}
			
			System.out.println("����� : " + user);
			
			int com = (int)(Math.random()*3+1);
			System.out.println("��ǻ�� : " + com);
			
//			switch(user-com){
//				case -2: 
//				case 1:
//					System.out.println("����� ��!");
//					break;
//				case -1:
//				case 2:
//					System.out.println("��ǻ�� ��!");
//					break;
//				case 0:
//					System.out.println("�����!");
//					break;	
//			}
			
			if(user == com){
				System.out.println("����� !");
			}else if( (user + 1) % 3 == com % 3){
				System.out.println("��ǻ�� ��!");
			}else if( (com + 1 ) % 3 == user % 3){
				System.out.println("����� ��!");
			}
			
			
		}
		
		
		
	}

}
