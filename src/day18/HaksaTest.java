package day18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Human{
	
	String name;
	int age;
	
	public void setInfo(BufferedReader br) throws IOException{
		System.out.print("이름 : ");
		name = br.readLine();
		System.out.print("나이 : ");
		age = Integer.parseInt(br.readLine());
	}
	
	public void getInfo(){
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
	}
}

class Teacher extends Human{
	
	String text; // 과목
	
	@Override
	public void setInfo(BufferedReader br) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("=== 선생님 정보 입력 ===");
		super.setInfo(br);
		System.out.print("과목 : ");
		text = br.readLine();
		
	}
	
	@Override
	public void getInfo() {
		// TODO Auto-generated method stub
		System.out.println("=== 선생 정보  ===");
		super.getInfo();
		System.out.println("과목 : " + text);
	}
	
}

class Student extends Human{
	
	String major; // 전공
	
	@Override
	public void setInfo(BufferedReader br) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("=== 학생 정보 입력 ===");
		super.setInfo(br);
		System.out.print("전공 : ");
		major = br.readLine();
		
	}
	
	@Override
	public void getInfo() {
		// TODO Auto-generated method stub
		System.out.println("=== 학생 정보 ===");
		super.getInfo();
		System.out.println("전공 : " + major); 
	}
	
}

public class HaksaTest {
	
	Human arr[];
	int count;
	
	public HaksaTest(){
		arr = new Human[10];
		count = 0;
	}
	
	/** 메노 출력 관련 메서드 */
	public void printMenu(){
		System.out.println("=== 학사관리 프로그램 v1.0 ===");
		System.out.println("1. 선생님 정보 입력");
		System.out.println("2. 학생 정보 입력");
		System.out.println("3. 선생님 정보 보기");
		System.out.println("4. 학생 정보 보기");
		System.out.println("5. 모든 정보 보기");
		System.out.println("6. 종료");
		System.out.println("-------------------------------");
	}
	
	/** 정보 입력 관련 메서드 */
	public void setHuman(BufferedReader br, int menu) throws IOException{
		if(count >= 10){
			System.out.println("더이상 입력 받으실 수 없습니다.");
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

	/** 정보 보기 관련 메서드 */
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
			
			System.out.print("메뉴 > ");
			int menu = Integer.parseInt(br.readLine());
			
			switch(menu){
			case 1: case 2: ht.setHuman(br, menu); break;
			case 3: case 4: case 5: ht.getHuman(menu); break;
			case 6: System.exit(0); break;
			default : System.out.println("잘못된 메뉴입니다.");
			}
		}
		
		
		
	}
	
	
}
