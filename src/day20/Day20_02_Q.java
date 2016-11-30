package day20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/*
 * 
 * ���� ���� ���� ���α׷�
 * 
 * 101 201 301
 * 102 202 302
 * 103 203 303
 *  �������
 *  
 *  1. �� ����
 *  2. �� ���
 *  3. ���� ��Ȳ ����
 *  4. ����
 *  
 *  1. ������ ���ȣ : 101
 *   ������ �ȵǾ� �ִ� ���� ��� -> 101ȣ �����.
 *   ������ �Ǿ� �ִ� ���� ��� -> 101ȣ�� �̹� ����Ǿ� �ֽ��ϴ�.
 *  2. ���� ����� ���ȣ : 101
 *   ������ �ȵǾ� �ִ� ���� ��� -> ����Ǿ� �ִ� �� x
 *   ������ �Ǿ� �ִ� ���� ��� -> ������ ��� ��.
 *  3. ���� ��Ȳ ����
 *    101
 *    102
 *    103
 *    
 *    *�������� - ȣ���� ������ ������� ����.
 */
public class Day20_02_Q {
	
	private BufferedReader br;
	private HashMap<Integer, String> hashStayCondition;

	public Day20_02_Q(){
		
	}
	
	public Day20_02_Q(BufferedReader br){
		
		this.br = br;
		hashStayCondition = new HashMap<Integer, String>();
		
		hashStayCondition.put(101, "���");
		hashStayCondition.put(102, "���");
		hashStayCondition.put(103, "���");
		
		hashStayCondition.put(201, "���");
		hashStayCondition.put(202, "���");
		hashStayCondition.put(203, "���");
		
		hashStayCondition.put(301, "���");
		hashStayCondition.put(302, "���");
		hashStayCondition.put(303, "���");
	}
	
	/** ���� �ý��� ó�� ��� */
	public void roomProcess(){
		System.out.println("���� ���� ���� ���α׷� v1.0");
		
		while(true){
			mainMenuPrint();
			int inputMenu = 0;
			try{
				inputMenu = userInputNum();
			}catch(IOException e){
				e.printStackTrace();
			}catch(NumberFormatException e){
				System.out.println("���ڸ��� �Է��� �ּ���.");
			}catch(Exception e){
				e.printStackTrace();
			}
			
			
			switch (inputMenu) {
			case 1: reserveRoom(); break;
			case 2: cancelRoom(); break;
			case 3: showRoom(); break;
			case 4: exitProgram(); break;
			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �ش� �޴��� �����Ͽ� �ּ���.");
				break;
			}
		}
		
	}
	
	/** ���� �޴� ��� ��� */
	public void mainMenuPrint(){
		System.out.println("1. �� �����ϱ�");
		System.out.println("2. �� ����ϱ�");
		System.out.println("3. ������Ȳ����");
		System.out.println("4. ����");
		System.out.print("�޴� > ");
	}
	
	/** ����� ���� �Է� ��� 
	 * @throws IOException 
	 * @throws NumberFormatException */
	public int userInputNum() throws NumberFormatException, IOException{
		int inputNum = Integer.parseInt(br.readLine());
		return inputNum;
	}
	
	/** �� ���� ó�� ��� */
	public void reserveRoom(){
		System.out.print("������ �� ��ȣ > ");
		int inputReserveNum = 0;
		
		try{
			inputReserveNum = userInputNum();
			
			if( hashStayCondition.get(inputReserveNum).equals("���") ){
				hashStayCondition.put(inputReserveNum, "�����");
				System.out.println(inputReserveNum + " ȣ �����.");
			} else {
				System.out.println(inputReserveNum + " ȣ �� �̹� ������ �Ǿ��ֽ��ϴ�.");
			}
			
		}catch(IOException e){
			e.printStackTrace();
		}catch(NumberFormatException e){
			System.out.println("���ڸ��� �Է��� �ּ���.");
			reserveRoom();
		}catch(NullPointerException e){
			System.out.println("�����ϴ� ȣ���� �Է��Ͽ� �ּ���.");
			reserveRoom();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/** �� ��� ó�� ��� */
	public void cancelRoom(){
		System.out.print("����� �� ��ȣ > ");
		int inputCancelNum = 0;
		try{
			inputCancelNum = userInputNum();
			
			if( hashStayCondition.get(inputCancelNum).equals("���") ){
				System.out.println(inputCancelNum + " ȣ �� ���� ������ ���� �ƴմϴ�.");
			} else {
				hashStayCondition.put(inputCancelNum, "���");
				System.out.println(inputCancelNum + " ȣ ��ҵ�.");
			}
			
		}catch(IOException e){
			e.printStackTrace();
		}catch(NumberFormatException e){
			System.out.println("���ڸ��� �Է��� �ּ���.");
			cancelRoom();
		}catch(NullPointerException e){
			System.out.println("�����ϴ� ȣ���� �Է��Ͽ� �ּ���.");
			cancelRoom();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/** ���� ��Ȳ ��� ��� */
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
			System.out.print(hashKey + " ȣ : ");
			System.out.print(hashStayCondition.get(hashKey) + "\t");
			cellCount++;
		}
		
		System.out.println();
	}
	
	/** ���α׷� ���� ó�� ��� */
	public void exitProgram(){
		System.out.println("���α׷��� ���� �մϴ�.");
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
		stayProgram.roomProcess(); // ���α׷� ����

	}
}
