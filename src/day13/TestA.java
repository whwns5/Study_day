package day13;
/*
 * 
 * �ش� ��ü�� ������ �ִ� getInfo ��� �޼��带 ȣ���ϸ�
 * �� ��� ��ü�� ����������� ����ϴ� ���α׷� �ۼ�.
 * 
 * ex) TestA t1 = new TestA();
 * 	   TestA t1 = new TestA();
 *     TestA t1 = new TestA();
 *     
 *     t1.getInfo();
 *     
 *     ���ݱ��� �� 3���� ��ü�� ����� �����ϴ�.
 */
public class TestA {
	
	static int count = 0;
	
	public TestA(){
		count += 1;
	}
	
	
	public static void getInfo(){
		System.out.println("���� ���� �� " + count + " ���� ��ü�� ����� �����ϴ�.");
	}
}
