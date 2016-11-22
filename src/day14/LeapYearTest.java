package day14;

public class LeapYearTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeapYear ly1 = new LeapYear(2016);
		ly1.getInfo();
		
		System.out.println("-----------------------------------------");
		
		LeapYear ly2 = new LeapYear();
		ly2.getInfo(2016);
	}

}
