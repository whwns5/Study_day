package day19;

import java.util.*;

/*
 * 2016_11_29
 * 
 * StringTokenizer 
 *  - 열거형 클래스
 *  
 *  - 커서라는 요소로 접근하여 사용.
 *  
 *   * while -> 열거형 클래스를 담당하는데 사용
 */
public class StringTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "사과,배,키위,포도,딸기";
		String str2 = "오늘은 화요일 점심 먹고 수업 참 졸렵죠~?";
		
		StringTokenizer st = new StringTokenizer(str, ",");
		StringTokenizer st2 = new StringTokenizer(str2); // 구분자를 안넣으면 공백으로 구분
		
		while(st.hasMoreTokens()){
			System.out.println(st.nextToken());
		}
		
		while(st2.hasMoreTokens()){
			System.out.println(st2.nextToken());
		}
		
		
	}

}
