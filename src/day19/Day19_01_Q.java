package day19;

import java.util.Scanner;

public class Day19_01_Q {
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("어떤 동물 ? ");
		String inputAnimal = sc.nextLine(); // String 은 유일하게 new 를 사용하지 않고 객채를 생성할 수 있는 클래스

		System.out.println("입력한 동물 : " + inputAnimal);

		// if(inputAnimal == "강아지") -> 주소와 강아지를 비교 했기때문 x
		
		if (inputAnimal.equals("강아지")) {
			System.out.println("멍멍");
		} else if (inputAnimal.equals("고양이")) {
			System.out.println("야옹");
		} else if (inputAnimal.equals("오리")) {
			System.out.println("꽥꽥");
		}
		
		
		
		
	}
}
