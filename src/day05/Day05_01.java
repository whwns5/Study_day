package day05;
/*
 * 2016_11_09
 * 
 * System.out.print("��³���");
 * System.out.println("��³���");
 * System.out.printf("���ڼ���",��º���);
 */
public class Day05_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = "ȫ�浿";
		int age = 20;
		
		System.out.println("�̸� : " + name); // ������ ���ԵǾ� �ִ�.
		System.out.println("���� : " + age);
		
		System.out.print("�̸� : " + name); // ������ ���ԵǾ� ���� �ʴ�.
		System.out.print("���� : " + age);
		
		System.out.print("�̸� : " + name + "\n"); // \n -> ���� ���ڿ� (���� ���ڿ�)
		System.out.print("��\t�� : " + age + "\n"); // \t -> �� ũ�⸸ŭ �������
		System.out.print("��\r�� : " + name + "\n"); // \r -> Ŀ���� �Ǿ�����
		
		System.out.println("���� �̸��� \"ȫ�浿\" �Դϴ�."); // \" , \' -> ���ڿ��ȿ� �־� ��� ����
		
		
		System.out.printf("�̸� : %s \n���� : %d", name , age); // %s -> ���ڿ� ����  %d -> ������ ����
		
		System.out.format("�̸� : %s \n���� : %d", name , age); // printf == format
		
		System.out.printf("�Ǽ� : %.2f", 3.123456); // %.2f -> �Ҽ��� ���ڸ��� ���� ���
	}

}
