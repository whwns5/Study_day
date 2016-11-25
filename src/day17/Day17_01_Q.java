package day17;

import java.awt.Window.Type;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ref.Reference;

/*
 * 학사 관리 프로그램
 * 
 * 1. 선생님 정보 입력
 * 2. 학생 정보 입력
 * 3. 선생님 정보 보기
 * 4. 학생 정보 보기
 * 5. 모든 정보 보기 ( 학생, 선생님)
 * 6. 종료
 * 
 * 메뉴 > 1
 *  = 선생님 정보 입력 =
 *   이름 :
 *   나이 :
 *   과목 : 
 *  입력후 메인으로 돌아가진다.
 *  
 * 메뉴 > 2
 *  = 학생 정보 입력 =
 *   이름 :
 *   나이 :
 *   전공 :
 * 
 * 두개 합쳐서 총 10개 까지만 입력 가능. (배열 한개)
 * 
 * instance of 객체와 관련되어 있는 연산자.
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
		
//		arrPerson[0] = new Student("학생1", 15, "소프트과");
//		arrPerson[1] = new Professor("교수1", 16, "탐구");
//		arrPerson[2] = new Student("학생2", 17, "미술과");
//		arrPerson[3] = new Professor("교수2", 18, "과학");
//		arrPerson[4] = new Professor("교수3", 19, "진리");
//		arrPerson[5] = new Student("학생3", 20, "환경과");
//		arrPerson[6] = new Professor("교수4", 21, "프툼");
		
	}
	
	/** 메인 메뉴창 출력 모듈 */
	public void mainMenuPrint(){
		
		System.out.println("학사 관리 프로그램");
		System.out.println("1. 선생님 정보 입력");
		System.out.println("2. 학생 정보 입력");
		System.out.println("3. 선생님 정보 보기");
		System.out.println("4. 학생 정보 보기");
		System.out.println("5. 모든 정보 보기 ( 학생, 선생님)");
		System.out.println("6. 종료");
		
	}
	
	/** 사용자 메뉴 입력 처리 모듈 
	 * @throws IOException 
	 * @throws NumberFormatException */
	public void userInputMenuProcessing() throws NumberFormatException, IOException{
		
		System.out.print("메뉴 > ");
		
		int InputMenu = Integer.parseInt(br.readLine()); // 숫자외 입력시 예외 처리
		
		switch (InputMenu) {
		case 1:	// 1. 선생님 정보 입력 시
			professorInputInfo();
			break;
		case 2: // 2. 학생 정보 입력 시
			studentInputInfo();
			break;
		case 3: // 3. 선생님 정보 보기
			professorOutputInfo();
			break;
		case 4: // 4. 학생 정보 보기
			studentOutputInfo();
			break;
		case 5: // 5. 모든 정보 출력
			allOutputInfo();
			break;
		case 6: // 6. 종료
			System.out.println("시스템을 종료합니다.");
			System.exit(0);
			break;
		default:
			System.out.println("------------------------------------");
			System.out.println("           잘못 입력 하셨습니다.");
			System.out.println("------------------------------------");
			break;
		}
		
	}
	
	
	/** 프로그램 시작 모듈 
	 * @throws IOException 
	 * @throws NumberFormatException */
	public void programStart() throws NumberFormatException, IOException{
	
		while(true){
			mainMenuPrint(); // 메인 메뉴창 출력 모듈 
			userInputMenuProcessing(); // 사용자 메뉴 입력 처리 모듈
		}
		
	}
	

	/** 선생님 정보 입력 모듈 
	 * @throws IOException */
	@Override
	public void professorInputInfo() throws IOException {
		
		if(count < 10){
			String proName;
			int proAge;
			String proSubject;

			System.out.println("= 선생님 정보 입력 =");
			System.out.print("이름 : ");
			proName = br.readLine();
			System.out.print("나이 : ");
			proAge = Integer.parseInt(br.readLine());
			System.out.print("과목 : ");
			proSubject = br.readLine();

			arrPerson[count] = new Professor(proName, proAge, proSubject);
			
			count++;
		} else {
			System.out.println(" 10회 를 초과 하셨습니다. ");
		}
		
		
		
	}
	
	/** 학생 정보 입력 모듈 */
	@Override
	public void studentInputInfo() throws IOException {
		
		if(count < 10){
			String stName;
			int stAge;
			String stMajor;

			System.out.println("= 학생 정보 입력 =");
			System.out.print("이름 : ");
			stName = br.readLine();
			System.out.print("나이 : ");
			stAge = Integer.parseInt(br.readLine());
			System.out.print("전공 : ");
			stMajor = br.readLine();

			arrPerson[count] = new Student(stName, stAge, stMajor);
		
			count++;
		} else {
			System.out.println(" 10회 를 초과 하셨습니다. ");
		}
		
	}

	
	/** 선생님 정보 보기 모듈 */
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
	
	/** 학생 정보 보기 모듈 */
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
	
	/** 모든 정보 보기 모듈 */
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
