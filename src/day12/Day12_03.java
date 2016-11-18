package day12;

import java.io.IOException;

/*
 * 2016_11_18
 * 
 * ���� �߱� ���� v2.0 (�����)
 */
public class Day12_03 {

	/** ��ǻ�� ���� �߻����� �޼��� */
	public static int[] comNumber(){
		int com[] = new int[3];
		
		for( int i = 0 ; i < com.length ; i++ ){
			com[i] = (int)(Math.random()*9+1);
			for(int j = 0 ; j < i ; j++){
				if(com[i] == com[j]){
					i--;
					break;
				}
			}
			
		}
		
		for( int i = 0 ; i < com.length ; i++ ){
			System.out.print(com[i] + " ");
		}
		
		return com;
	}
	
	/** �޴� ��� ���� �޼��� */
	public static void menuPrint(){
		System.out.println("----------------------------------");
		System.out.println("          ���� �߱� ���� v2.0  ");
		System.out.println("----------------------------------");
	}
	
	/** ����ڷκ��� �� �Է¹ޱ�
	 * @throws IOException */
	public static int[] userNumber(int count) throws IOException{
		int user[] = new int[3];
		System.out.print(count + "ȸ�� �Է� : ");
		for(int i = 0 ; i < user.length ; i++){
			user[i] = System.in.read() - '0';
		}
		
		System.in.skip(2);
		return user;
	}
	
	/** ���Ӱ�� ���� �޼��� */
	public static void gameResult(int com[], int user[]){
		int strike = 0;
		int ball = 0;
		
		for(int i = 0 ; i < user.length ; i++){
			for(int j = 0 ; j < com.length ; j++){
				if( user[i] == com[j] && i == j){
					strike ++;
				} else if( user[i] == com[j] && i != j ){
					ball ++;
				}
			}
		}
		System.out.println(strike + "��Ʈ����ũ / " + ball + "��");
		if(strike == 3){
			System.out.println("������ϴ�.");
			System.exit(0);
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		int com[] = comNumber();
		menuPrint();
		
		for(int i = 1 ; i <= 10 ; i++){
			int user[] = userNumber(i);
			gameResult(com, user);
		}
		
		System.out.println("10���� ��ȸ�� ��� ���� �Ͽ����ϴ�.");
		System.out.println("Game Over");
		System.exit(0);
		
		
	}

}
