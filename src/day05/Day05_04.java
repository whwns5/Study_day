package day05;
import java.io.*;
/*
 * 2016_11_09
 * 
 */
public class Day05_04 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		String name;
		BufferedReader br;
		//InputStreamReader in;
		
		br = new BufferedReader(new InputStreamReader(System.in));
		// System.in (주 스트림) 은 1바이트만 입력 받을 수 있기 때문에 업그레이드가 필요.
		// InputStreamReader (보조 스트림) 주 스트림을 이용하여 2바이트 스트림으로 변형
		// BufferedReader 2바이트의 문자를 여러개를 받아 문자열로 받기 위해
		
		System.out.print("당신의 이름은 ? ");
		
		name = br.readLine();
		
		System.out.println("아 ~ 이름이 \"" + name + "\" 이군요");

	}

}
