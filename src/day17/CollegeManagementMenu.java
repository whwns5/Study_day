package day17;

import java.io.IOException;

public interface CollegeManagementMenu{
	public void professorInputInfo() throws IOException;// 1. ������ ���� �Է�
	public void studentInputInfo() throws IOException; // 2. �л� ���� �Է�
	public void professorOutputInfo(); // 3. ������ ���� ����
	public void studentOutputInfo(); // 4. �л� ���� ����
	public void allOutputInfo(); // 5. ��� ���� ����
}
