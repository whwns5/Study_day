package day21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 * 
 * 2016_12_01
 * 
 * 몇 마리의 말을 달리실겁니까? 3
 * 
 *   O    O    O
 *   ~    ~    ~
 *  100  100  100
 *  
 *  1번말 3등
 *  2번말 2등
 *  3번말 1등
 *  
 */

class GameState {
	private ArrayList<String> hourseGrade;

	public GameState() {
		hourseGrade = new ArrayList<String>();
	}

	synchronized public void inputGrade(String horseName) {
		hourseGrade.add(horseName);
	}

	public ArrayList<String> getInfoGrade() {
		return hourseGrade;
	}
}

class Horse implements Runnable {

	private String horseName; // 말 이름
	private int movementRange; // 이동 거리 상태
	private GameState gameState; // 게임상태 객체

	public Horse() {
		this.movementRange = 0;
	}

	public Horse(String horseName) {
		this();
		this.horseName = horseName;
	}

	public Horse(String horseName, GameState gameState) {
		this(horseName);
		this.gameState = gameState;
	}

	
	public String getHorseName() {
		return this.horseName;
	}

	// 주행 메소드
	public void horseRun() {
		while (true) {
			this.movementRange += (int) (Math.random() * 10 + 1);
			if (this.movementRange > 100) {
				this.movementRange = 100;
				this.gameState.inputGrade(this.horseName);
				break;
			}

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// 이동 거리 상태 출력
	public int getMovementRange() {
		return this.movementRange;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.horseRun();
	}

}

public class Day21_03_Q {

	private BufferedReader br;
	private ArrayList<Horse> arryHorse;
	private GameState gmState;

	public Day21_03_Q() {
		this.arryHorse = new ArrayList<Horse>();
		this.gmState = new GameState();
	}

	public Day21_03_Q(BufferedReader br) {
		this();
		this.br = br;
	}
	
	/** 사용자 입력 모듈 */
	public int userInput(){
		int userInputNum = 0;
		try {
			userInputNum = Integer.parseInt(br.readLine());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userInputNum;
	}

	/** 말 생성 모듈 */
	public void horseCreateProcess(int userInputNum) {
		
		for (int i = 0; i < userInputNum; i++) { //사용자가 입력한 숫자 만큼
			arryHorse.add(new Horse((i + 1) + "번 마", gmState)); // 말 ArrayList에
																// 해당 번호를 가지는 말
																// 이름과 게임상태 객체를
																// 인자로 말 객체를
																// 생성하여 넣는다.
		}

		for (int i = 0; i < arryHorse.size(); i++) { // 말 ArrayList 사이즈 만큼
			new Thread(arryHorse.get(i)).start(); // 새로운 말 Thread 를 생성하여 가동한다.
		}

	}

	/** 말 주행 상태 출력 모듈 */
	public void horseRunStatePrint() {
		for (int i = 0; i < arryHorse.size(); i++) { // 말 ArrayList 사이즈 만큼
			System.out.print(arryHorse.get(i).getHorseName() + "\t"); // 각 말들의 이름을 출력한다.
		}
		System.out.println();

		while (Thread.activeCount() != 1) { // 말 스레드들이 진행중일때 반복.
			System.out.print("\r");
			for (int i = 0; i < arryHorse.size(); i++) { // 말 ArrayList 사이즈 만큼
				System.out.print(arryHorse.get(i).getMovementRange() + "\t"); // 각 말들의 주행 거리 상태를 출력한다.
			}
		}

		
	}
	
	/** 게임 결과 출력 모듈 */
	public void gameResultPrint(){
		System.out.println();

		ArrayList<String> horseGrade = gmState.getInfoGrade(); 
		for (int i = 0; i < horseGrade.size(); i++) {
			System.out.println((i + 1) + "등 : " + horseGrade.get(i));
		}
	}

	/** 게임 시작 모듈 */
	public void gameStart() {
		System.out.print("몇 마리의 말을 달리실겁니까 ? ");

		int userInputNum = userInput(); // 사용자로부터 숫자 입력 받기
		horseCreateProcess(userInputNum); // 말 생성하기
		horseRunStatePrint(); // 말 주행상태 출력하기
		gameResultPrint(); // 게임 결과 출력 하기

	}

	public static void main(String[] args){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Day21_03_Q horseGame = new Day21_03_Q(br);
		horseGame.gameStart();

	}

}
