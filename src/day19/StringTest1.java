package day19;
/*
 * 2016_11_29
 */
public class StringTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "java";
		String str2 = "java"; // str2가 스택영역에 생성되기 전에 힙 영역의 스캔이 먼저 선수행되어 
							  // "java"라는 객체가 힙영역에 생성되어 있으면 같은 주소로 사용.
						
		String str3 = new String("java"); // new 키워드를 이용하여 생성하는 순간. 스캔을 할필요가 없으므로 새로운 "java"객채를 만들게 된다.
		
		System.out.println("str = " + str);
		System.out.println("str2 = " + str2);
		System.out.println("str3 = " + str3);

		
		if(str == str2){	
			System.out.println("str == str2 : 같다");
		} else {
			System.out.println("str == str2 : 같지 않다.");
		}
		
		String res = str==str3 ? "같다" : "같지않다";
		System.out.println("str == str3 :" + res);
		
		String res2 = str.equals(str2) ? "같다" : "같지않다";
		String res3 = str.equals(str3) ? "같다" : "같지않다";
		
		System.out.println("str==str2 : " + res2);
		System.out.println("str==str3 : " + res2);
	
		Object o = new Object();
		Object o2 = new Object();
		Object o3 = o;
		
		String res4 = o.equals(o2) ? "같다" : "같지않다";
		String res5 = o.equals(o3) ? "같다" : "같지않다";
		
		System.out.println("o == o2 : " + res4);
		System.out.println("o == o3 : " + res5 );
	}

}
