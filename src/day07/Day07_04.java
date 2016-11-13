package day07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 2016_11_11
 */
public class Day07_04 {
	public static void main(String[] args)throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("숫자 입력:");
		int user=Integer.parseInt(br.readLine());
		
		for(int i=2; i<user; i++){
			if(user%i==0){ //입력한 user의 값을 i로 나눠 나머지가 0이되면 참값이다. 
				System.out.println("입력한"+user+"의 값은 소수가 아니다");
				System.exit(0);/*반복문 수행중에 한번이라도 참값이 수행되면 출력후 종료된다. 예를들어 10을 입력하면 2,5 둘다 나머지가 0이지만 
                                                                  먼저수행한 2로인해 반복문 조건에대한 참값이 되므로 바로 종료가 된다.*/
         
			}
		}
		System.out.println("입력한"+user+"의 값은 소수이다");
	}
}
