package day14;
/*
 * 
 * 윤년
 *  4년에 한번
 *  100년 x
 *  400년 윤년
 *  
 *  year(2016);
 *  getInfo();
 *   ->해당 년도는 윤년입니다.
 *   
 *  year();
 *  getInfo(2016);
 *   
 */
public class CatTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cat c1 = new Cat();
		
		c1.getInfo();
		
		System.out.println("==================================");
		
		Cat c2 = new Cat("드래곤");
		
		c2.getInfo();
	}

}
