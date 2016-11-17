package day11;

import java.io.IOException;

/*
 * 2016_11_17
 * 
 * 야구게임 해설
 * 
 * 1. 컴퓨터의 정보를 담을 수 있는 공간을 만듬.
 * 2. 중복되지 않는 난수 3개를 발생
 * 3. 사용자로부터 숫자 3개를 입력 받는다.
 * 4. 비교를 통한 비지니스 로직 구현
 * 5. 반복
 */
public class Day11_01 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		// 1. 컴퓨터의 정보를 담을 수 있는 공간을 만듬.
		int com[] = new int[3];
		int user[] = new int[3];
		int strike = 0;
		int ball = 0;
		
		// 2. 중복되지 않는 난수 3개를 발생
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
		System.out.println(" 숫자 야구 게임 v1.0 ");
		System.out.println("----------------------------");
		
		for(int count = 1 ; count <= 10 ; count++){
			
		
			
			// 3. 사용자로부터 숫자 3개를 입력 받는다.
			System.out.print(count + " 회차 번호입력 :");
			for(int i = 0 ; i < user.length ; i++){
				user[i] = System.in.read() - 48;
				
			}
			System.in.skip(2);
			
			for(int i = 0 ; i < user.length ; i++){
				System.out.print(user[i] + " ");
			}
			
			
			// 4. 비교를 통한 비지니스 로직 구현
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
			
			System.out.println(strike + "스트라이크\t" + ball + "볼");
			
			if(strike == 3){
				System.out.println("정답입니다! ~ 수고ㅎ");
				System.exit(0);
			}
		}
		
		System.out.println("모든 기회를 소진 하였습니다.");
		
	}

}
