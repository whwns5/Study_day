package day11;

import java.io.IOException;

/*
 * 2016_11_17
 * 
 * �߱����� �ؼ�
 * 
 * 1. ��ǻ���� ������ ���� �� �ִ� ������ ����.
 * 2. �ߺ����� �ʴ� ���� 3���� �߻�
 * 3. ����ڷκ��� ���� 3���� �Է� �޴´�.
 * 4. �񱳸� ���� �����Ͻ� ���� ����
 * 5. �ݺ�
 */
public class Day11_01 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		// 1. ��ǻ���� ������ ���� �� �ִ� ������ ����.
		int com[] = new int[3];
		int user[] = new int[3];
		int strike = 0;
		int ball = 0;
		
		// 2. �ߺ����� �ʴ� ���� 3���� �߻�
		for(int i = 0 ; i < com.length ; i++){
			com[i] = (int)(Math.random()*9+1);
			for(int j = 0 ; j < i ; j++){
				if( com[i] == com[j] ){
					i--;
					break;
				}
			}
		}
		
		for(int i = 0 ; i < com.length ; i++){
			System.out.print(com[i] + " ");
		}
		
		System.out.println("----------------------------");
		System.out.println(" ���� �߱� ���� v1.0 ");
		System.out.println("----------------------------");
		
		for(int count = 1 ; count <= 10 ; count++){
			
		
			
			// 3. ����ڷκ��� ���� 3���� �Է� �޴´�.
			System.out.print(count + " ȸ�� ��ȣ�Է� :");
			for(int i = 0 ; i < user.length ; i++){
				user[i] = System.in.read() - 48;
				
			}
			System.in.skip(2);
			
			for(int i = 0 ; i < user.length ; i++){
				System.out.print(user[i] + " ");
			}
			
			
			// 4. �񱳸� ���� �����Ͻ� ���� ����
			for(int i = 0 ; i < user.length ; i++){
				for(int j = 0 ; j < com.length ; j++){
					if(user[i] == com[j]){
						if(i == j){
							strike++;
						} else {
							ball++;
						}
					}
				}
			}
			
			System.out.println(strike + "��Ʈ����ũ\t" + ball + "��");
			
			if(strike == 3){
				System.out.println("�����Դϴ�! ~ ����");
				System.exit(0);
			}
		}
		
		System.out.println("��� ��ȸ�� ���� �Ͽ����ϴ�.");
		
	}

}
