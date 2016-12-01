package day21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 * 
 * 2016_12_01
 * 
 * �� ������ ���� �޸��ǰ̴ϱ�? 3
 * 
 *   O    O    O
 *   ~    ~    ~
 *  100  100  100
 *  
 *  1���� 3��
 *  2���� 2��
 *  3���� 1��
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

	private String horseName; // �� �̸�
	private int movementRange; // �̵� �Ÿ� ����
	private GameState gameState; // ���ӻ��� ��ü

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

	// ���� �޼ҵ�
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

	// �̵� �Ÿ� ���� ���
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
	
	/** ����� �Է� ��� */
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

	/** �� ���� ��� */
	public void horseCreateProcess(int userInputNum) {
		
		for (int i = 0; i < userInputNum; i++) { //����ڰ� �Է��� ���� ��ŭ
			arryHorse.add(new Horse((i + 1) + "�� ��", gmState)); // �� ArrayList��
																// �ش� ��ȣ�� ������ ��
																// �̸��� ���ӻ��� ��ü��
																// ���ڷ� �� ��ü��
																// �����Ͽ� �ִ´�.
		}

		for (int i = 0; i < arryHorse.size(); i++) { // �� ArrayList ������ ��ŭ
			new Thread(arryHorse.get(i)).start(); // ���ο� �� Thread �� �����Ͽ� �����Ѵ�.
		}

	}

	/** �� ���� ���� ��� ��� */
	public void horseRunStatePrint() {
		for (int i = 0; i < arryHorse.size(); i++) { // �� ArrayList ������ ��ŭ
			System.out.print(arryHorse.get(i).getHorseName() + "\t"); // �� ������ �̸��� ����Ѵ�.
		}
		System.out.println();

		while (Thread.activeCount() != 1) { // �� ��������� �������϶� �ݺ�.
			System.out.print("\r");
			for (int i = 0; i < arryHorse.size(); i++) { // �� ArrayList ������ ��ŭ
				System.out.print(arryHorse.get(i).getMovementRange() + "\t"); // �� ������ ���� �Ÿ� ���¸� ����Ѵ�.
			}
		}

		
	}
	
	/** ���� ��� ��� ��� */
	public void gameResultPrint(){
		System.out.println();

		ArrayList<String> horseGrade = gmState.getInfoGrade(); 
		for (int i = 0; i < horseGrade.size(); i++) {
			System.out.println((i + 1) + "�� : " + horseGrade.get(i));
		}
	}

	/** ���� ���� ��� */
	public void gameStart() {
		System.out.print("�� ������ ���� �޸��ǰ̴ϱ� ? ");

		int userInputNum = userInput(); // ����ڷκ��� ���� �Է� �ޱ�
		horseCreateProcess(userInputNum); // �� �����ϱ�
		horseRunStatePrint(); // �� ������� ����ϱ�
		gameResultPrint(); // ���� ��� ��� �ϱ�

	}

	public static void main(String[] args){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Day21_03_Q horseGame = new Day21_03_Q(br);
		horseGame.gameStart();

	}

}
