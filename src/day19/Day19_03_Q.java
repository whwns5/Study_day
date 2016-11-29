package day19;

import java.util.Scanner;

/*
 * 2016_11_29
 * 
 * 여러개의 문장을 가지고 있는 배열을 하나 만듬.
 * 
 * 서제스트 검색 기능을 구현
 * 
 * 시작할 검색어 : java
 * java .. 
 * 
 */
public class Day19_03_Q {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		String str[] = new String[15];
		str[0] = "java is good";
		str[1] = "d does java";
		str[2] = "jsp is mine";
		str[3] = "배열이란 그런것";
		str[4] = "물 닿는 곳에";
		str[5] = "이르러 앉아보니";
		str[6] = "구름이 일때로다";
		str[7] = "맑은 것이 없는 줄 알았는데";
		str[8] = "맑은 것이 있었다.";
		str[9] = "실패는 성공의 어머니";
		str[10] = "star is real";
		str[11] = "lol";
		str[12] = "lol is diamond";
		str[13] = "그사람에게";
		str[14] = "대통령 하야";
		
		System.out.print("시작할 검색어 : ");
		
		String searchStr = sc.nextLine();
		
		for(int i = 0 ; i < str.length ; i++){
			//if( str[i].indexOf(searchStr) != -1){
			if( str[i].indexOf(searchStr) == 0){
				System.out.println((i+1) + " 번째 글 : " + str[i]);
			}
		}
		
	
		
	}

}
