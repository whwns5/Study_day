package day13;

public class Maka {
	
	// 멤버 변수(값)
	String color;
	
	// 생성자(멤버 변수 초기화)
	public Maka(){
		color = "검정";
	}
	
	// 멤버 메소드(행위)
	public void makaWrite(){ // static 은 정적메모리 할당이기 때문에 사용x
		System.out.println(color + " 색상의 마커로 글을 씁니다.");
	}
	
	
}
