package day13;
/*
 * 
 * 해당 객체가 가지고 있는 getInfo 라는 메서드를 호출하면
 * 총 몇개의 객체가 만들어졌는지 출력하는 프로그램 작성.
 * 
 * ex) TestA t1 = new TestA();
 * 	   TestA t1 = new TestA();
 *     TestA t1 = new TestA();
 *     
 *     t1.getInfo();
 *     
 *     지금까지 총 3개의 객체가 만들어 졌습니다.
 */
public class TestA {
	
	static int count = 0;
	
	public TestA(){
		count += 1;
	}
	
	
	public static void getInfo(){
		System.out.println("지금 까지 총 " + count + " 개의 객체가 만들어 졌습니다.");
	}
}
