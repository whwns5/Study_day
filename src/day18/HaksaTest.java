package day18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Human{
	
	String name;
	int age;
	
	public void setInfo(BufferedReader br) throws IOException{
		System.out.print("�̸� : ");
		name = br.readLine();
		System.out.print("���� : ");
		age = Integer.parseInt(br.readLine());
	}
	
	public void getInfo(){
		System.out.println("�̸� : " + name);
		System.out.println("���� : " + age);
	}
}

class Teacher extends Human{
	
	String text; // ����
	
	@Override
	public void setInfo(BufferedReader br) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("=== ������ ���� �Է� ===");
		super.setInfo(br);
		System.out.print("���� : ");
		text = br.readLine();
		
	}
	
	@Override
	public void getInfo() {
		// TODO Auto-generated method stub
		System.out.println("=== ���� ����  ===");
		super.getInfo();
		System.out.println("���� : " + text);
	}
	
}

class Student extends Human{
	
	String major; // ����
	
	@Override
	public void setInfo(BufferedReader br) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("=== �л� ���� �Է� ===");
		super.setInfo(br);
		System.out.print("���� : ");
		major = br.readLine();
		
	}
	
	@Override
	public void getInfo() {
		// TODO Auto-generated method stub
		System.out.println("=== �л� ���� ===");
		super.getInfo();
		System.out.println("���� : " + major); 
	}
	
}

public class HaksaTest {
	
	Human arr[];
	int count;
	
	public HaksaTest(){
		arr = new Human[10];
		count = 0;
	}
	
	/** �޳� ��� ���� �޼��� */
	public void printMenu(){
		System.out.println("=== �л���� ���α׷� v1.0 ===");
		System.out.println("1. ������ ���� �Է�");
		System.out.println("2. �л� ���� �Է�");
		System.out.println("3. ������ ���� ����");
		System.out.println("4. �л� ���� ����");
		System.out.println("5. ��� ���� ����");
		System.out.println("6. ����");
		System.out.println("-------------------------------");
	}
	
	/** ���� �Է� ���� �޼��� */
	public void setHuman(BufferedReader br, int menu) throws IOException{
		if(count >= 10){
			System.out.println("���̻� �Է� ������ �� �����ϴ�.");
			return;
		} 
			
		if(menu == 1){
			arr[count] = new Teacher();
		} else if(menu == 2) {
			arr[count] = new Student();
		}
		
		arr[count].setInfo(br);
		count ++;	
		
		
	}

	/** ���� ���� ���� �޼��� */
	public void getHuman(int menu) {

		for (int i = 0; i < count; i++) {
			if (menu == 3) {
				if (arr[i] instanceof Teacher) {
					arr[i].getInfo();
				}
			} else if (menu == 4) {
				if (arr[i] instanceof Student) {
					arr[i].getInfo();
				}
			} else if (menu == 5) {
				arr[i].getInfo();
			}

		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HaksaTest ht = new HaksaTest();
		
		while(true){
			ht.printMenu();
			
			System.out.print("�޴� > ");
			int menu = Integer.parseInt(br.readLine());
			
			switch(menu){
			case 1: case 2: ht.setHuman(br, menu); break;
			case 3: case 4: case 5: ht.getHuman(menu); break;
			case 6: System.exit(0); break;
			default : System.out.println("�߸��� �޴��Դϴ�.");
			}
		}
		
		
		
	}
	
	
}
