package day17;

import java.awt.Window.Type;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ref.Reference;

/*
 * �л� ���� ���α׷�
 * 
 * 1. ������ ���� �Է�
 * 2. �л� ���� �Է�
 * 3. ������ ���� ����
 * 4. �л� ���� ����
 * 5. ��� ���� ���� ( �л�, ������)
 * 6. ����
 * 
 * �޴� > 1
 *  = ������ ���� �Է� =
 *   �̸� :
 *   ���� :
 *   ���� : 
 *  �Է��� �������� ���ư�����.
 *  
 * �޴� > 2
 *  = �л� ���� �Է� =
 *   �̸� :
 *   ���� :
 *   ���� :
 * 
 * �ΰ� ���ļ� �� 10�� ������ �Է� ����. (�迭 �Ѱ�)
 * 
 * instance of ��ü�� ���õǾ� �ִ� ������.
 * 
 *
 */


public class Day17_01_Q implements CollegeManagementMenu{
	
	BufferedReader br;
	int count;
	Person arrPerson[];
	
	
	public Day17_01_Q(){
		br = new BufferedReader(new InputStreamReader(System.in));
		
		this.count = 0;
		arrPerson = new Person[10]; 
		
//		arrPerson[0] = new Student("�л�1", 15, "����Ʈ��");
//		arrPerson[1] = new Professor("����1", 16, "Ž��");
//		arrPerson[2] = new Student("�л�2", 17, "�̼���");
//		arrPerson[3] = new Professor("����2", 18, "����");
//		arrPerson[4] = new Professor("����3", 19, "����");
//		arrPerson[5] = new Student("�л�3", 20, "ȯ���");
//		arrPerson[6] = new Professor("����4", 21, "����");
		
	}
	
	/** ���� �޴�â ��� ��� */
	public void mainMenuPrint(){
		
		System.out.println("�л� ���� ���α׷�");
		System.out.println("1. ������ ���� �Է�");
		System.out.println("2. �л� ���� �Է�");
		System.out.println("3. ������ ���� ����");
		System.out.println("4. �л� ���� ����");
		System.out.println("5. ��� ���� ���� ( �л�, ������)");
		System.out.println("6. ����");
		
	}
	
	/** ����� �޴� �Է� ó�� ��� 
	 * @throws IOException 
	 * @throws NumberFormatException */
	public void userInputMenuProcessing() throws NumberFormatException, IOException{
		
		System.out.print("�޴� > ");
		
		int InputMenu = Integer.parseInt(br.readLine()); // ���ڿ� �Է½� ���� ó��
		
		switch (InputMenu) {
		case 1:	// 1. ������ ���� �Է� ��
			professorInputInfo();
			break;
		case 2: // 2. �л� ���� �Է� ��
			studentInputInfo();
			break;
		case 3: // 3. ������ ���� ����
			professorOutputInfo();
			break;
		case 4: // 4. �л� ���� ����
			studentOutputInfo();
			break;
		case 5: // 5. ��� ���� ���
			allOutputInfo();
			break;
		case 6: // 6. ����
			System.out.println("�ý����� �����մϴ�.");
			System.exit(0);
			break;
		default:
			System.out.println("------------------------------------");
			System.out.println("           �߸� �Է� �ϼ̽��ϴ�.");
			System.out.println("------------------------------------");
			break;
		}
		
	}
	
	
	/** ���α׷� ���� ��� 
	 * @throws IOException 
	 * @throws NumberFormatException */
	public void programStart() throws NumberFormatException, IOException{
	
		while(true){
			mainMenuPrint(); // ���� �޴�â ��� ��� 
			userInputMenuProcessing(); // ����� �޴� �Է� ó�� ���
		}
		
	}
	

	/** ������ ���� �Է� ��� 
	 * @throws IOException */
	@Override
	public void professorInputInfo() throws IOException {
		
		if(count < 10){
			String proName;
			int proAge;
			String proSubject;

			System.out.println("= ������ ���� �Է� =");
			System.out.print("�̸� : ");
			proName = br.readLine();
			System.out.print("���� : ");
			proAge = Integer.parseInt(br.readLine());
			System.out.print("���� : ");
			proSubject = br.readLine();

			arrPerson[count] = new Professor(proName, proAge, proSubject);
			
			count++;
		} else {
			System.out.println(" 10ȸ �� �ʰ� �ϼ̽��ϴ�. ");
		}
		
		
		
	}
	
	/** �л� ���� �Է� ��� */
	@Override
	public void studentInputInfo() throws IOException {
		
		if(count < 10){
			String stName;
			int stAge;
			String stMajor;

			System.out.println("= �л� ���� �Է� =");
			System.out.print("�̸� : ");
			stName = br.readLine();
			System.out.print("���� : ");
			stAge = Integer.parseInt(br.readLine());
			System.out.print("���� : ");
			stMajor = br.readLine();

			arrPerson[count] = new Student(stName, stAge, stMajor);
		
			count++;
		} else {
			System.out.println(" 10ȸ �� �ʰ� �ϼ̽��ϴ�. ");
		}
		
	}

	
	/** ������ ���� ���� ��� */
	@Override
	public void professorOutputInfo(){

		for(int i = 0; i < arrPerson.length; i++){	
			if( arrPerson[i] != null ){
				if( arrPerson[i] instanceof Professor ){
					arrPerson[i].getInfo();
					
				}
			}
		}
		
	}
	
	/** �л� ���� ���� ��� */
	@Override
	public void studentOutputInfo(){
		for(int i = 0; i < arrPerson.length; i++){	
			if( arrPerson[i] != null ){
				if( arrPerson[i] instanceof Student ){
					arrPerson[i].getInfo();
				}
			}
	
		}
	}
	
	/** ��� ���� ���� ��� */
	@Override
	public void allOutputInfo(){
		
		for(int i = 0; i < arrPerson.length; i++){	
			if( arrPerson[i] != null ){
				arrPerson[i].getInfo();
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Day17_01_Q hakProgram = new Day17_01_Q();
		hakProgram.programStart();
		
	}

	
	
}
