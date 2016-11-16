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
 * 
 * v0.2
 *  다차원 배열을 이용하여 구현
 */
public class Day10_02_Q2 {
	public static void main(String[] args) throws IOException{

		int count = 0; // 회차 수
		
		int gameData[][][] = new int[10][3][3]; // 게임 데이터를 가지고 있는 배열
												// 0행 배열 -> 사용자 입력 번호 배열 (int inputNum[])
												// 1행 배열 -> 컴퓨터 난수 번호 배열 (int comNum[])
												// 2행 배열 -> 회차 수, 스트라이크 카운트 (int strikeCount), 볼 카운트 (int ballCount)
		
		// 컴퓨터 난수 생성 모듈
		for(int i = 0 ; i < gameData[0][1].length ; i++){   		// gameData[0][1] -> 컴퓨터 난수 번호 배열 (int comNum[])
			gameData[0][1][i] = (int)(Math.random()*10);
			
			// 1. 컴퓨터 난수 중복 체크 모듈
			for(int j = 0 ; j < i ; j++){	// 이전 입력된 데이터와 전체 비교
				if( gameData[0][1][i] == gameData[0][1][j] ){ // 현재 입력된 데이터와 이전에 입력된 데이터가 같을 경우 ( i -> 현재 입력 index , j -> 과거 입력 index)
					i--;
					break;
				}
			}
			
			// 2. 컴퓨터 난수 중복 체크 모듈 
			/*if(i > 0){		// 두번째 번호 부터 중복 체크 시작
				while(true){	// 난수 중복 체크
					int randCount = 0;
					for(int j = 0 ; j < i ; j++){	// 이전 입력된 데이터와 전체 비교
						if( gameData[0][1][i] == gameData[0][1][j] ){ // 현재 입력된 데이터와 이전에 입력된 데이터가 같을 경우 ( i -> 현재 입력 index , j -> 과거 입력 index)
							gameData[0][1][i] = (int)(Math.random()*10); // 현재 입력 데이터를 다시 생성한다.
							randCount = 1;
						} 
					}
					if(randCount == 0){ // randCount 가 증가하지 않은 경우. 중복 된 것이 없기 때문이므로 빠져나온다.
						break;
					}
				}
				
			}*/
			for(int k = 1; k < gameData.length; k++){
				gameData[k][1] = gameData[0][1]; // 모든 회차 수에 동일한 컴퓨터 난수 번호 배열을 복사 한다.
			}
		}
		
		
		while(true){	// 게임이 끝나기전 까지 반복한다.
	
			// 회차 수 경과 종료 모듈
			if(count == 10){
				System.out.println("10회차 까지 모두 실패 하였습니다.");
				System.exit(0);
			}
			
			// 사용자 입력 모듈
			System.out.println("------------------------------------------------------------------------------------------");
			System.out.println("0~9 숫자 중 3가지를 입력하세요. (중복 불가)");
			for(int i = 0 ; i < gameData[count][0].length ; i++){	// gameData[0][1] -> 사용자 입력 번호 배열 (int inputNum[])
				System.out.print((i + 1) + "번째 수를 입력하세요 : ");	
				gameData[count][0][i]= System.in.read() - '0';
				System.in.skip(2);
				
				// 1. 사용자 입력 중복 체크 모듈
				for(int j = 0 ; j < i ; j++){
					if( gameData[count][0][i] == gameData[count][0][j] ){
						System.out.println("중복 된 수는 입력할 수 없습니다. 다시 입력해 주세요.");
						i--;
						break;
					}
				}
				
				// 2. 사용자 입력 중복 체크 모듈 
				/*if(i > 0){		// 두번째 번호 부터 중복 체크 시작
					while(true){	// 사용자 입력 수 중복체크
						int inputCount = 0;
						for(int j = 0 ; j < i ; j++){	// 이전 입력된 데이터와 전체 비교
							if( gameData[count][0][i] == gameData[count][0][j] ){ // 현재 입력된 데이터와 이전에 입력된 데이터가 같을 경우 ( i -> 현재 입력 index , j -> 과거 입력 index)
								System.out.println("중복 된 수는 입력할 수 없습니다. 다시 입력해 주세요.");
								System.out.print((i + 1) + "번째 수를 입력하세요 : ");
								gameData[count][0][i]= System.in.read() - '0'; // 현재 입력 데이터를 다시 입력 받도록 한다.
								System.in.skip(2); 
								inputCount = 1;
							} 
						}
						if(inputCount == 0){ // inputCount 가 증가하지 않은 경우. 중복 된 것이 없기 때문이므로 빠져나온다.
							break;
						}
					}
				}*/
			}
			
			// 결과 처리 모듈 ( 비교 )
			for(int i = 0 ; i < gameData[count][1].length ; i++){		//컴퓨터 난수 배열과 사용자 입력 배열을 순차 비교한다.
				for(int j = 0 ; j < gameData[count][0].length ; j++){
					if(gameData[count][1][i] == gameData[count][0][j] && i == j){	// 컴퓨터 수와 사용자 수가 같고, 같은 자리에 있다면 -> 스트라이크
						gameData[count][2][1] += 1;	// 스트라이크 카운트 (int strikeCount) 
						break;
					} else if(gameData[count][1][i] == gameData[count][0][j] && i != j) { // 컴퓨터 수와 사용자 수가 같고, 다른 자리에 있다면 -> 볼
						gameData[count][2][2] += 1; // 볼 카운트 (int ballCount) 
						break;
					}  											
				}
			}
			
			// 결과 처리 모듈 ( 회차수 입력 )
			gameData[count][2][0] = ++count; // 회차 수를 데이터에 저장하고 카운터를 증가

			// 결과 출력 모듈
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\nn\n\n\n\n\nn\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println("------------------------------------------------------------------------------------------");
			for(int i = 0 ; i < count ; i++){ // 카운터 만큼 출력
					System.out.print(gameData[i][2][0] + " 회차 >>>>>\t\t");
					
					if(gameData[i][2][1] == 3){				// 스트라이크 카운트 (int strikeCount)가 3일 경우
						System.out.println(" 정답");
						System.exit(0);
					} else if ( gameData[i][2][1] != 0 || gameData[i][2][2] != 0) { // 스트라이크 카운트 (int strikeCount) 또는 볼 카운트 (int ballCount)가 0이 아닌경우
						for(int j = 0 ; j < gameData[i][0].length; j++){
							System.out.print(gameData[i][0][j] + "\t");
						}
						System.out.println("\t스트라이크 :\t" + gameData[i][2][1] + "\t볼 :\t" + gameData[i][2][2]);
					} else if ( gameData[i][2][1] == 0 && gameData[i][2][2] == 0 ) { // 스트라이크 카운트 (int strikeCount)와 볼 카운트 (int ballCount)가 0인 경우
						for(int j = 0 ; j < gameData[i][0].length; j++){
							System.out.print(gameData[i][0][j] + "\t");
						}
						System.out.println("\tout");
					}
			}
		}
	}
}
