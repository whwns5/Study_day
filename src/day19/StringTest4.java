package day19;

import java.io.*;

public class StringTest4 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.err.print("���ڿ� �Է� : ");
		String str = br.readLine();
		System.out.print("ã�� ���� : ");
		char user = (char) br.read();
		
		int count = 0;
		
		for(int i = 0 ; i < str.length() ; i++){
			if(str.charAt(i) == user){
				count++;
			}
		}
		
		System.out.println(user + " �� ���ڴ� �� " + count + " �� �Դϴ�.");
		
	}

}
