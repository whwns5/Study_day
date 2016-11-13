package day06;

import java.io.IOException;
/*
 * 2016_11_10
 */
public class Day06_03 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("1.Â¥Àå 2.Â«»Í 3.ÅÁ¼öÀ° 4.ÆÈº¸Ã¤");
		
		System.out.print("¸Þ´º ¹øÈ£¸¦ ÀÔ·ÂÇÏ¼¼¿ä :");
		
		int menu = System.in.read() - 48;
		
		if(menu==1){
			System.out.println("Â¥Àå");
		} else if(menu == 2) {
			System.out.println("Â«»Í");
		} else if(menu == 3) {
			System.out.println("ÅÁ¼öÀ°");
		} else {
			System.out.println("ÆÈº¸Ã¤");
		}
	}

}
