package day19;

import java.util.Scanner;

public class StringTest5 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		String titles[] = {"java�� ���������� �����", "java �� ����־��!", 
				"Jsp ���ʺ���.." , "��Ÿ500 ���ְ� �Դ¹�" , "Java���ʺ��� �߱ޱ���.."
				,"jsp ù���� .."	, "�̷¼� ���¹�" ,"�ڱ�Ұ��� �ۼ���"};
		
		System.out.print("������Ʈ Ű���带 �Է��ϼ��� :");
		
		// String keyword = sc.next(); // ������ ���޴´�.
		String keyword = sc.nextLine();
		
		for(int i = 0 ; i < titles.length ; i++){
			if(titles[i].toLowerCase().startsWith(keyword.toLowerCase())){
				System.out.println(titles[i]);
			}
		}
	}
}

