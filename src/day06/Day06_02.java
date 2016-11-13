package day06;

import java.io.IOException;

/*
 * 2016_11_10
 */
public class Day06_02 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.print("첫번째수:");
		int num1=System.in.read()-48; //System.in.read는 1자리수만 입력되는 기능
		System.in.skip(2);
		
		System.out.print("두번째수:");
		int num2=System.in.read()-'0'; //마지막꺼는 값 입력후 입력된값은 넘어가고 그뒤에 엔터값 2개는 무시된다.
		
		
		if(num1 > num2){
			System.out.println("num1이 크며 그 값은 :"+num1);
		} else {
			System.out.println("num2가 크며 그 값은:"+num2);
		}
	}

}
