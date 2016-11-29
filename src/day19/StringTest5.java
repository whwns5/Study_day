package day19;

import java.util.Scanner;

public class StringTest5 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		String titles[] = {"java를 공부한적이 없어요", "java 참 재미있어요!", 
				"Jsp 기초부터.." , "비타500 맛있게 먹는법" , "Java기초부터 중급까지.."
				,"jsp 첫걸음 .."	, "이력서 쓰는법" ,"자기소개서 작성법"};
		
		System.out.print("서제스트 키워드를 입력하세요 :");
		
		// String keyword = sc.next(); // 공백을 못받는다.
		String keyword = sc.nextLine();
		
		for(int i = 0 ; i < titles.length ; i++){
			if(titles[i].toLowerCase().startsWith(keyword.toLowerCase())){
				System.out.println(titles[i]);
			}
		}
	}
}

