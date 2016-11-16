package day10;

import java.io.IOException;

/*
 * 2016_11_16
 * 
 * 숫자 야구 게임
 * 
 * 1. 숫자와 자릿수가 맞으면 -> 스트라이크
 * 2. 숫자는 O 자릿수 x -> 볼
 * 
 * 게임시작 버튼 모듈
 * 컴퓨터 난수 생성 모듈
 * 사용자 입력 모듈
 * 정답 비교 모듈
 */
public class Day10_02_Q {
	public static void main(String[] args) throws IOException{
		
		int inputNum[] = new int[3]; // 사용자 입력 번호
		int comNum[] = new int[3]; // 컴퓨터 난수 번호
		
		
		
		int ballCount; // 볼 카운트
		int strikeCount; // 스트라이크 카운트
		//int outCount; // 아웃 카운트
		int count = 0; // 회차 수
		
		// 컴퓨터 난수 생성 모듈
		for(int i = 0 ; i < comNum.length ; i++){
			comNum[i] = (int)(Math.random()*10);
			if(i > 0){		// 두번째 번호 부터 중복 체크 시작
				while(true){	// 난수 중복 체크
					int randCount = 0;
					for(int j = 0 ; j < i ; j++){	// 이전 입력된 데이터와 전체 비교
						if( comNum[i] == comNum[j] ){ // 현재 입력된 데이터와 이전에 입력된 데이터가 같을 경우 ( i -> 현재 입력 index , j -> 과거 입력 index)
							comNum[i] = (int)(Math.random()*10); // 현재 입력 데이터를 다시 생성한다.
							randCount = 1;
						} 
					}
					if(randCount == 0){ // randCount 가 증가하지 않은 경우. 중복 된 것이 없기 때문이므로 빠져나온다.
						break;
					}
				}
			}
			
		}
		
		// 컴퓨터 난수 생성 모듈 테스트
		System.out.print("컴퓨터 난수 생성 번호 : ");
		for(int i = 0 ; i < comNum.length ; i++){
			System.out.print(comNum[i] + " ");
		}
		System.out.println();
		
		while(true){	// 게임이 끝나기전 까지 반복한다.
			
			ballCount = 0;	// 새로운 회차 수가 시작 되기전 볼 카운트 초기화
			strikeCount = 0; // 새로운 회차 수가 시작 되기전 스트라이크 카운트 초기화
			//outCount = 0; // 새로운 회차 수가 시작 되기전 아웃 카운트 초기화
			
			count++;	 // 정답 비교후 회차 수 증가
			
			// 회차 수 경과 종료 모듈
			if(count == 11){
				System.out.println("10회차 까지 모두 실패 하였습니다.");
				System.exit(0);
			}
			
			// 사용자 입력 모듈
			System.out.println("0~9 숫자 중 3가지를 입력하세요. (중복 불가)");
			for(int i = 0 ; i < inputNum.length ; i++){
				System.out.print((i + 1) + "번째 수를 입력하세요 : ");
				inputNum[i]= System.in.read() - '0';
				System.in.skip(2);
			
				
				if(i > 0){		// 두번째 번호 부터 중복 체크 시작
					while(true){	// 사용자 입력 수 중복체크
						int inputCount = 0;
						for(int j = 0 ; j < i ; j++){	// 이전 입력된 데이터와 전체 비교
							if( inputNum[i] == inputNum[j] ){ // 현재 입력된 데이터와 이전에 입력된 데이터가 같을 경우 ( i -> 현재 입력 index , j -> 과거 입력 index)
								System.out.println("중복 된 수는 입력할 수 없습니다. 다시 입력해 주세요.");
								System.out.print((i + 1) + "번째 수를 입력하세요 : ");
								inputNum[i]= System.in.read() - '0'; // 현재 입력 데이터를 다시 입력 받도록 한다.
								System.in.skip(2); 
								inputCount = 1;
							} 
						}
						
						if(inputCount == 0){ // inputCount 가 증가하지 않은 경우. 중복 된 것이 없기 때문이므로 빠져나온다.
							break;
						}
					}
				}
			}

			// 컴퓨터 난수 생성 모듈 테스트
//			System.out.print("컴퓨터 난수 생성 번호 : \t");
//			for(int i = 0 ; i < comNum.length ; i++){
//				System.out.print(comNum[i] + " ");
//			}
//			System.out.println();
			
			// 사용자 입력 모듈 테스트
//			System.out.print("사용자 입력 번호 : \t");
//			for(int i = 0 ; i < inputNum.length ; i++){
//				System.out.print(inputNum[i] + " ");
//			}
			
			
			// 정답 비교 모듈
			for(int i = 0 ; i < comNum.length ; i++){		//컴퓨터 난수 배열과 사용자 입력 배열을 순차 비교한다.
				for(int j = 0 ; j < inputNum.length ; j++){
					if(comNum[i] == inputNum[j] && i == j){	// 컴퓨터 수와 사용자 수가 같고, 같은 자리에 있다면 -> 스트라이크
						strikeCount += 1;
						break;
					} else if(comNum[i] == inputNum[j] && i != j) { // 컴퓨터 수와 사용자 수가 같고, 다른 자리에 있다면 -> 볼
						ballCount += 1;
						break;
					}  												// 컴퓨터 수와 사용자 수가 다르다면 -> 아웃
					
				}
			}
			
			
			
			// 정답 비교 모듈 테스트
//			System.out.println();
//			System.out.println("strikeCount = " + strikeCount);
//			System.out.println("ballCount = " + ballCount);
			
			// 결과 출력 모듈
			System.out.println();
			System.out.println("-----------------------------------------------------------------");
			if(strikeCount == 3){
				System.out.print(count + "회차 -> 정답\n");
				System.exit(0);
			} else if(strikeCount != 0 || ballCount != 0){
				
				System.out.print(count + "회차 -> ");
				for(int i = 0 ; i < inputNum.length ; i++){
					System.out.print(inputNum[i] + " ");
				}
				System.out.println("스트라이크 : " + strikeCount + " 볼 : " + ballCount);
				
			} else if(strikeCount == 0 && ballCount == 0){
				
				System.out.print(count + "회차 -> ");
				for(int i = 0 ; i < inputNum.length ; i++){
					System.out.print(inputNum[i] + " ");
				}
				System.out.println("out");
				
			}
		}
		
		
		
	}
}
