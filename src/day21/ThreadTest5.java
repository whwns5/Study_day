package day21;

class ThreadC extends Thread{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("++ ThreadC�� ���� ++");
		
		for(int i = 1 ; i <= 50 ; i++){
			System.out.println("++ ThreadC�� �� : " + i + " ++");
		}
		System.out.println("++ ThreadC�� �� ++");
	}
}

public class ThreadTest5 {
	public static void main(String[] args){
		
		ThreadC tc = new ThreadC();
		tc.setDaemon(true); // ���� ������ -> main�� ���� �Ļ��� �����尡 ���ӽ����尡 �Ǹ� ������ ������ �޸𸮸� ��ȯ �Ҷ� ���� ����ȴ�.
		tc.start();
		
		System.out.println("== main�� ���� ==");
		
		for(int i = 1 ; i <= 10 ; i ++){
			System.out.println("== main�� �� : " + i + " ==");
		}
		
		System.out.println("== main�� �� ==");
	}
}
