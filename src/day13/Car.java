package day13;

public class Car {
	
	String name; // ���̸�
	String color; // ������
	int wheel; // ������
	String carOwner; // �����̸�
	
	public void carForwardMovement(){
		System.out.println(color + " ������ " + name + " �� ���� �մϴ�.");
	}
	
	public void carBackwardMovement(){
		System.out.println(color + " ������ " + name + " �� ���� �մϴ�.");
	}
	
	public void getInfo(){
		System.out.println("���̸� : " + name);
		System.out.println("������ : " + color);
		System.out.println("������ : " + wheel);
		System.out.println("�����̸� : " + carOwner);
	}
	

}
