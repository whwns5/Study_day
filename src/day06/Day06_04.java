package day06;

import java.io.IOException;
/*
 * 2016_11_10
 */
public class Day06_04 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.print("문자입력:");
		
		int user=System.in.read();
		
		if(user >= 48 && user <= 57){
			System.out.println(user + "의 값은 숫자입니다.");
			
		} else if( (user >= 65 && user <= 90) || (user >= 97 && user <= 122) ){
			System.out.println(user + "의 값은 영문자입니다.");
			
		} else {
			System.out.println(user + "의 값은 기타문자입니다.");
		}
	}

}
