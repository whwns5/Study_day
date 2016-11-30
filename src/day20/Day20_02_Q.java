package day20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/*
 * 
 * 숙박 예약 관리 프로그램
 * 
 * 101 201 301
 * 102 202 302
 * 103 203 303
 *  직접기술
 *  
 *  1. 방 예약
 *  2. 방 취소
 *  3. 예약 현황 보기
 *  4. 종료
 *  
 *  1. 예약할 방번호 : 101
 *   예약이 안되어 있는 방일 경우 -> 101호 예약됨.
 *   예약이 되어 있는 방일 경우 -> 101호는 이미 예약되어 있습니다.
 *  2. 예약 취소할 방번호 : 101
 *   예약이 안되어 있는 방일 경우 -> 예약되어 있는 방 x
 *   예약이 되어 있는 방일 경우 -> 예약이 취소 됨.
 *  3. 예약 현황 보기
 *    101
 *    102
 *    103
 *    
 *    *전제조건 - 호실의 순서는 보장되지 않음.
 */
public class Day20_02_Q {
	
	private BufferedReader br;
	private HashMap<Integer, String> hashStayCondition;

	public Day20_02_Q(){
		
	}
	
	public Day20_02_Q(BufferedReader br){
		
		this.br = br;
		hashStayCondition = new HashMap<Integer, String>();
		
		hashStayCondition.put(101, "빈방");
		hashStayCondition.put(102, "빈방");
		hashStayCondition.put(103, "빈방");
		
		hashStayCondition.put(201, "빈방");
		hashStayCondition.put(202, "빈방");
		hashStayCondition.put(203, "빈방");
		
		hashStayCondition.put(301, "빈방");
		hashStayCondition.put(302, "빈방");
		hashStayCondition.put(303, "빈방");
	}
	
	/** 숙박 시스템 처리 모듈 */
	public void roomProcess(){
		System.out.println("숙박 예약 관리 프로그램 v1.0");
		
		while(true){
			mainMenuPrint();
			int inputMenu = 0;
			try{
				inputMenu = userInputNum();
			}catch(IOException e){
				e.printStackTrace();
			}catch(NumberFormatException e){
				System.out.println("숫자만을 입력해 주세요.");
			}catch(Exception e){
				e.printStackTrace();
			}
			
			
			switch (inputMenu) {
			case 1: reserveRoom(); break;
			case 2: cancelRoom(); break;
			case 3: showRoom(); break;
			case 4: exitProgram(); break;
			default:
				System.out.println("잘못 입력하셨습니다. 해당 메뉴중 선택하여 주세요.");
				break;
			}
		}
		
	}
	
	/** 메인 메뉴 출력 모듈 */
	public void mainMenuPrint(){
		System.out.println("1. 방 예약하기");
		System.out.println("2. 방 취소하기");
		System.out.println("3. 예약현황보기");
		System.out.println("4. 종료");
		System.out.print("메뉴 > ");
	}
	
	/** 사용자 숫자 입력 모듈 
	 * @throws IOException 
	 * @throws NumberFormatException */
	public int userInputNum() throws NumberFormatException, IOException{
		int inputNum = Integer.parseInt(br.readLine());
		return inputNum;
	}
	
	/** 방 예약 처리 모듈 */
	public void reserveRoom(){
		System.out.print("예약할 방 번호 > ");
		int inputReserveNum = 0;
		
		try{
			inputReserveNum = userInputNum();
			
			if( hashStayCondition.get(inputReserveNum).equals("빈방") ){
				hashStayCondition.put(inputReserveNum, "예약됨");
				System.out.println(inputReserveNum + " 호 예약됨.");
			} else {
				System.out.println(inputReserveNum + " 호 는 이미 예약이 되어있습니다.");
			}
			
		}catch(IOException e){
			e.printStackTrace();
		}catch(NumberFormatException e){
			System.out.println("숫자만을 입력해 주세요.");
			reserveRoom();
		}catch(NullPointerException e){
			System.out.println("존재하는 호실을 입력하여 주세요.");
			reserveRoom();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/** 방 취소 처리 모듈 */
	public void cancelRoom(){
		System.out.print("취소할 방 번호 > ");
		int inputCancelNum = 0;
		try{
			inputCancelNum = userInputNum();
			
			if( hashStayCondition.get(inputCancelNum).equals("빈방") ){
				System.out.println(inputCancelNum + " 호 는 예약 상태의 방이 아닙니다.");
			} else {
				hashStayCondition.put(inputCancelNum, "빈방");
				System.out.println(inputCancelNum + " 호 취소됨.");
			}
			
		}catch(IOException e){
			e.printStackTrace();
		}catch(NumberFormatException e){
			System.out.println("숫자만을 입력해 주세요.");
			cancelRoom();
		}catch(NullPointerException e){
			System.out.println("존재하는 호실을 입력하여 주세요.");
			cancelRoom();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/** 예약 현황 출력 모듈 */
	public void showRoom(){
		Set<Integer> keySet = hashStayCondition.keySet();
		Iterator<Integer> keyIt = keySet.iterator();
		int cellCount = 0;
		
		while(keyIt.hasNext()){
			int hashKey = keyIt.next();
			if(cellCount == 3){
				System.out.println("");
				cellCount = 0;
			}
			System.out.print(hashKey + " 호 : ");
			System.out.print(hashStayCondition.get(hashKey) + "\t");
			cellCount++;
		}
		
		System.out.println();
	}
	
	/** 프로그램 종료 처리 모듈 */
	public void exitProgram(){
		System.out.println("프로그램을 종료 합니다.");
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.exit(0);
	}
	
	public static void main(String[] args){
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		
		Day20_02_Q stayProgram = new Day20_02_Q(br);
		stayProgram.roomProcess(); // 프로그램 시작

	}
}
