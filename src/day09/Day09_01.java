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
			System.out.println("|가위 바위 보 게임 v1.0|");
			System.out.println("---------------------");
			System.out.println("1.가위 2.바위 3.보 4.종료");
			System.out.println("=====================");
			
			int user = 0;
			
			do{
				System.out.print("메뉴 >");
				user = System.in.read() - 48;
				System.in.skip(2); // 2바이트를 날린다.	
			}while( !(user >= 1 && user <= 4) );
			
			if(user == 4){
				System.out.println("좋은 하루 되세요~");
				System.exit(0);
			}
			
			System.out.println("사용자 : " + user);
			
			int com = (int)(Math.random()*3+1);
			System.out.println("컴퓨터 : " + com);
			
//			switch(user-com){
//				case -2: 
//				case 1:
//					System.out.println("사용자 승!");
//					break;
//				case -1:
//				case 2:
//					System.out.println("컴퓨터 승!");
//					break;
//				case 0:
//					System.out.println("비겼음!");
//					break;	
//			}
			
			if(user == com){
				System.out.println("비겼음 !");
			}else if( (user + 1) % 3 == com % 3){
				System.out.println("컴퓨터 승!");
			}else if( (com + 1 ) % 3 == user % 3){
				System.out.println("사용자 승!");
			}
			
			
		}
		
		
		
	}

}
