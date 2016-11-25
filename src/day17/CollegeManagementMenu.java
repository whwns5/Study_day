package day17;

import java.io.IOException;

public interface CollegeManagementMenu{
	public void professorInputInfo() throws IOException;// 1. 선생님 정보 입력
	public void studentInputInfo() throws IOException; // 2. 학생 정보 입력
	public void professorOutputInfo(); // 3. 선생님 정보 보기
	public void studentOutputInfo(); // 4. 학생 정보 보기
	public void allOutputInfo(); // 5. 모든 정보 보기
}
