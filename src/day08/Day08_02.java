package day08;

import java.io.IOException;

/*
 * 2016_11_14
 * 
 * 
 */
public class Day08_02 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		while(true){
			
			int num = 0;
			
			do{
				System.out.print("���ڸ� �Է� :");
				num = System.in.read();
				System.in.skip(2);
			}while( !(num >= 48 & num <= 57) );

			if(num == '0'){
				System.out.println("���α׷��� ���� �մϴ�.");
				System.exit(0);
			}
			System.out.println("�Է��� ���� :" + (char) num);
		}
	
	}

}
