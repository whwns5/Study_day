package day14;

public class Tv {
	int rgb; // 색상
	int mi; // 명암
	int ri; // 밝기
	
	public Tv(){ // 기본 생성자
		rgb = 50;
		mi = 50;
		ri = 50;
	}
	
	public Tv(int rgb){ // 인자 생성자
		//this.Tv(); -> 생성자는 일반 메소드처럼 이름으로 호출 할 수 없다.
		this(); // 나의 기본 생성자를 호출
		this.rgb = rgb;
	}
	
	public Tv(int r, int m){
		this(r);
		mi = m;
	}
	
	public Tv(int r, int m, int ri){
		this(r, m);
		this.ri = ri;
	}
	
	public void getInfo(){
		System.out.println("색상 : " + rgb);
		System.out.println("명암 : " + mi);
		System.out.println("밝기 : " + ri);
		
	}
	
	public void getInfo(String title){
		System.out.println(title);
		this.getInfo();
	}
}
