package day19;

import java.io.InputStreamReader;
import java.util.*;
/*
 * 2016_11_29
 * 
 */

class YongException extends Exception{ // Exception 을 상속받으면 예외 클래스가 된다.
	
	public YongException() {
		// TODO Auto-generated constructor stub
		super("용 예외 : 미성년자 안됨 !!! ");
	}
}

public class UserExcepTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Scanner sc = new Scanner(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		
		try{
			System.out.print("너 몇살 ?");
			
			int age = sc.nextInt();
			
			if(age < 20){
				//System.out.println("미성년자는 입장 불가");
				throw new YongException();
			}
			
			System.out.println("성인 환영 !!");
			
		}catch(YongException e){
			System.out.println("공통 로직을 수행할 수 있음");
			e.printStackTrace();
		}
		
		
		System.out.println("프로그램 정상 종료");
		
	}

}
