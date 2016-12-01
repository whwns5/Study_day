package day21;

class ThreadC extends Thread{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("++ ThreadC의 시작 ++");
		
		for(int i = 1 ; i <= 50 ; i++){
			System.out.println("++ ThreadC의 값 : " + i + " ++");
		}
		System.out.println("++ ThreadC의 끝 ++");
	}
}

public class ThreadTest5 {
	public static void main(String[] args){
		
		ThreadC tc = new ThreadC();
		tc.setDaemon(true); // 종속 스레드 -> main에 의해 파생된 스래드가 종속스래드가 되면 메인이 끝나고 메모리를 반환 할때 같이 종료된다.
		tc.start();
		
		System.out.println("== main의 시작 ==");
		
		for(int i = 1 ; i <= 10 ; i ++){
			System.out.println("== main의 값 : " + i + " ==");
		}
		
		System.out.println("== main의 끝 ==");
	}
}
