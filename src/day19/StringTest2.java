package day19;
/*
 * String 의 특징
 *  1. 원본불변의 법칙
 */
public class StringTest2 {
	public static void main(String[] args){
		
		String str = "Hello";
		
		System.out.println("str = " + str);
	
		str.concat(" Java");
		
		//System.out.println("str = " + str);
		System.out.println("str = " + str.concat(" Java"));
	
		str.substring(2, 4);
	
		//System.out.println("str = " + str);
		System.out.println("str = " + str.substring(2, 4));
		
		System.out.println("---------------------------------------");
		
		StringBuffer sb = new StringBuffer("Hello Java!");
		
		System.out.println("sb = " + sb);
		System.out.println("sb = " + sb.toString());
		
		// 삽입, 삭제, 연결
		sb.insert(6, "JSP!!");
		System.out.println("sb = " + sb);
		
		sb.append("Hi~~~");
		System.out.println("sb = " + sb);
		
		sb.delete(11, 15);
		System.out.println("sb = " + sb);
		
	}
}
