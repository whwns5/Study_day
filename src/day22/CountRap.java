package day22;

import java.util.*;

class Horse extends Thread{
	
	int name; // ���� �̸�
	int level; // ���
	static int count = 1; // ����
	
	public Horse() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public void run() {
		
		String temp = "";
		for(int i = 1 ; i < name ; i++){
			temp += "\t";
		}
		
		// TODO Auto-generated method stub
		for(int i = 0 ; i < 100 ; i ++){
			try {
				int second = (int)(Math.random() * 500);
				Thread.sleep(second);
				System.out.
				print("\r" + temp + i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		level = count;
		count ++;
	}
	
}

public class CountRap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("�� ������ ���� �޸��ǰ̴ϱ� ?");
		int user = sc.nextInt(); // ����Ű ���� ���� ������ �ʴ´�.
		
		Horse arr[] = new Horse[user];
		for(int i = 0 ; i < user ; i ++){
			arr[i] = new Horse();
			arr[i].name = i + 1;
		}
		
		for(int i = 0 ; i < user ; i ++){
			arr[i].start();
		}
		for(int i = 0 ; i < user ; i ++){
			try {
				arr[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println();
		for(int i = 0 ; i < user ; i ++){
			System.out.println(arr[i].name + "���� : " + arr[i].level);
		}
	}

}
