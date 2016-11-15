package day08;

import java.io.IOException;

/*
 * 2016_11_4
 * 
 * tweetv1@naver.com
 * 
 * 제목 : 오전_과제1_조준현
 * 본문 : 코드 내용
 * 첨부 파일 : .java 파일
 * 
 */
public class Day08_03_Q {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		int inputNum = 0;
		int randomNum;
		String tempStr = "";
		
		System.out.println("-------------------------------------------------------");
		System.out.println("\t\t♪ 가위  바위  보  게임 ♪");
		System.out.println("-------------------------------------------------------");
		System.out.println("1. 가위\t\t2. 바위\t\t 3. 보\t\t4. 종료");
		System.out.println("-------------------------------------------------------");
		
		while(true){
			
			System.out.print("선택 > ");
			inputNum = System.in.read() - '0';
			System.in.skip(2);
			
			if(inputNum == 4){
				System.out.println("게임을 종료 하셨습니다.");
				System.exit(0);
			}else if( !(inputNum >= 0 && inputNum <= 9) ){
				
				System.out.println("\n잘못 입력 하셨습니다. 다음 메뉴중에 해당하는 번호를 입력하세요.");
				System.out.println("-------------------------------------------------------");
				System.out.println("1. 가위\t\t2. 바위\t\t 3. 보\t\t4. 종료");
				System.out.println("-------------------------------------------------------");
				continue;
			} 
			
			
			randomNum = (int)(Math.random()*3+1);
			
			switch (inputNum) {
			case 1:
				tempStr = "가위";
				break;
			case 2:
				tempStr = "바위";
				break;
			case 3:
				tempStr = "보";
				break;
			default:
				break;
			}
	
			System.out.println("사용자 : " + tempStr);
			
			switch (randomNum) {
			case 1:
				tempStr = "가위";
				break;
			case 2:
				tempStr = "바위";
				break;
			case 3:
				tempStr = "보";
				break;
			default:
				break;
			}
			
			System.out.println("컴퓨터 : " + tempStr);
			
			
			if(inputNum == randomNum){
				System.out.println("비겼습니다.\n");
			} else if( (inputNum == 1 && randomNum == 2) || (inputNum == 2 && randomNum == 3) || (inputNum == 3 && randomNum == 1) ) {
				System.out.println("졌습니다.\n");
			} else if( (inputNum == 1 && randomNum == 3) || (inputNum == 2 && randomNum == 1) || (inputNum == 3 && randomNum == 2) ) {
				System.out.println("이겼습니다.\n");
			} 
			
			
		}
	}

}
