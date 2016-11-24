package day16;
/*
 * 
 * 2016_11_24
 * 
 * Final 지정자 (modifier)
 *  Final 지정자 란?
 *   abstract 와 반대로 상속을 방지하는 것.
 *   
 *   			  abstract					    final
 *   
 *   클래스		상속받게할 목적			상속을 못받게 하는게 목적
 *   
 *   메소드		강제 오버라이딩이			      오버라이딩 방지
 *   				목적
 *   
 *   변수		    사용안함				         상수 지시
 *   								   	final public static
 *   
 * 
 * 인터페이스
 *  인터페이스 란 ?
 *   자바의 단일상속의 제약을 보완하기 위해 새롭게 제안한 다중상속 개념
 *  
 *  형식
 *   접근지정자 interface 인터페이스명 extends 인터페이스 {
 *   	추상메소드들;
 *   }
 *   
 *    *상속 관계
 *     Interface 인터페이스명 extends Interface
 *     Class 클래스명 extends Class
 *     Interface 인터페이스명 implements Class
 *     Class 클래스명 implements Interface
 *     
 *   
 *  활용 용도
 *   1. 메뉴판
 *   2. 기능 확장
 *   3. 부모입장으로 자식을 관리가 가능
 */
class cls1{
	int a = 10;
	
	public cls1(){
		
	}
	
	public void cls1Test(){
		System.out.println("cls1Test");
	}
}

interface Inter1{
	public void inter1Test();
}

interface Inter2 extends Inter1{
	public void inter2Test();
}

abstract class abs1{
	abstract public void abs1Test();
}


public class Day16_01 {

}
