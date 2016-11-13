package day07;
/*
 * 2016_11_11
 */
public class Day07_03 {
	public static void main(String[] args){
		
		int sum=0;
		
		for(int i=1; i<=10; i++){
		System.out.println(i+"번째: 내이름은 홍길동");
		sum=sum+i;
		}
		System.out.println("1~10까지의 합"+sum);
	}
}
