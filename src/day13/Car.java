package day13;

public class Car {
	
	String name; // 차이름
	String color; // 차색상
	int wheel; // 바퀴수
	String carOwner; // 차주이름
	
	public void carForwardMovement(){
		System.out.println(color + " 색상의 " + name + " 가 전진 합니다.");
	}
	
	public void carBackwardMovement(){
		System.out.println(color + " 색상의 " + name + " 가 후진 합니다.");
	}
	
	public void getInfo(){
		System.out.println("차이름 : " + name);
		System.out.println("차색상 : " + color);
		System.out.println("바퀴수 : " + wheel);
		System.out.println("차주이름 : " + carOwner);
	}
	

}
