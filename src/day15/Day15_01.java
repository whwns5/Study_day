package day15;
/*
 * 추상(abstract) 클래스 란 ?
 *  한 개 이상의 추상메소드를 가지는 클래스
 *  
 *  Method에 몸체(body) 없이 선언만 하는 것
 *  추상 메소드 앞에 abstract 란 modifier를 붙여줘야 한다.
 *   ex) abstract public void sub();
 *   
 * 추상(abstract)의 특징
 *  1. 추상메소드를 한개라도 가진 클래스는 역시 class 앞에 abstract 를 붙여
 *     주어 추상 클래스로 만들어야 한다.  
 *  2. 추상 클래스를 상속받은 클래스에서는 추상 메소드를 강제적으로 오버라이딩 
 *     해야한다. 그렇지 않을 경우 그 자식 클래스도 추상 클래스가 되어야 한다.
 *  3. 추상 클래스는 타입 선언은 할 수 있으니 new 해서 객체 생성은 할 수 없다.
 *  4. 반드시 상속을 통해서만 완성된다.
 *  5. 상속받은 자식 클래스로는 객체 생성이 가능하다.
 *  
 *  일반 클래스(concrete class)와 추상 클래스(abstract class)의 차이
 *   
 *       일반 클래스				추상 클래스
 *    (concrete class)		 (abstract class)
 *     - 멤버 변수		  	  - 멤버 변수
 *     - 클래스 변수			  - 클래스 변수
 *     - 생성자				  - 생성자
 *     - 일반 메소드			  - 일반 메소드
 *     - 클래스 메소드		  - 클래스 메소드
 *     - final 변수			  - final 변수
 *     						  - 추상 메소드
 */
public class Day15_01 {

}
